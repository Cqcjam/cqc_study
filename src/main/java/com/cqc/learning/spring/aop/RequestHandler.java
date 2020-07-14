
package com.cqc.learning.spring.aop;

import com.alibaba.fastjson.JSON;
import com.cqc.learning.utils.NetworkUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 打印controller层的请求方法和参数
 * 打印controller层抛出异常后的方法、参数和错误堆栈信息
 */
@Slf4j
@Aspect
@Component
public class RequestHandler {

    private static ExecutorService requestLogExecutor = 
            new ThreadPoolExecutor(5, 10, 1800L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
    
    private static ExecutorService alarmMailExecutor = 
            new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

    /**
     * 切面 controller
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) ||" +
              "@annotation(org.springframework.web.bind.annotation.GetMapping) ||" +
              "@annotation(org.springframework.web.bind.annotation.PostMapping)" +
              "@annotation(org.springframework.web.bind.annotation.PutMapping)" +
              "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void pointCut() {}
    
    /**
     * 切面环绕
     * @param joinPoint
     */
    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Object[] args = joinPoint.getArgs();
        try {
            // 获取HttpServletRequest
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            // 获取ip
            HttpServletRequest httpServletRequest = sra.getRequest();
            String ip = NetworkUtils.getIpAddress(httpServletRequest);
            String url = httpServletRequest.getRequestURI();
            String methodType = httpServletRequest.getMethod();
            List<Object> param = filterParams(args);
            String params = JSON.toJSONString(param);
            log.info("request url = [{}], params = [{}]", url, params);
            if (!HttpMethod.GET.name().equals(methodType)) {
                log.info("request url = [{}], params = [{}]", url, params);
            }
        } catch (Exception e) {
            log.error("error occur when handle, e->", e);
        }
        return joinPoint.proceed();
    }

    /**
     * 切面异常
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void AfterThrowing(JoinPoint joinPoint, Exception e) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if (sra == null) {
            return;
        }
        HttpServletRequest httpServletRequest = sra.getRequest();
        String url = httpServletRequest.getRequestURI();
        String methodType = httpServletRequest.getMethod();
        List<Object> args = filterParams(joinPoint.getArgs());
        String arg = JSON.toJSONString(args);
        log.error("request error, url = [{}], mparams = [{}]", url, arg);
       /* if (!AppConst.PROD.equals(appTemplate.getEnv())) {
            return;
        }*/
        // TODO send mail
    }
    
    private static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
    
    /**
     * 过滤参数
     * @param args
     * @return
     */
    private List<Object> filterParams(Object[] args) {
        List<Object> params = new ArrayList<>();
        if (args != null) {
            for (Object arg : args) {
                if (arg != null &&
                        !(arg instanceof HttpServletRequest
                         || arg instanceof HttpServletResponse
                         || arg instanceof HttpSession)) {
                    params.add(arg);
                }
            }
        }
        return params;
    }
    
    
}
