package com.cqc.learning.utils;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http连接池以及工具类
 */
@Slf4j
public class HttpUtils {

    /**
     * HttpClient 连接池
     */
    private static PoolingHttpClientConnectionManager cm = null;

    static {
        // 初始化连接池
        cm = new PoolingHttpClientConnectionManager();
        // 整个连接池最大连接数
        cm.setMaxTotal(20);
        // 每路由最大连接数，默认值是2
        cm.setDefaultMaxPerRoute(5);
    }

    /**
     * 发送 HTTP GET请求
     * 不带请求参数和请求头
     */
    public static String httpGet(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);

        return doHttp(httpGet);
    }

    /**
     * 发送 HTTP GET请求
     * 带请求参数，不带请求头
     */
    public static String httpGet(String url, Map<String, Object> params) throws Exception {
        // 转换请求参数
        List<NameValuePair> pairs = covertParams2NVPS(params);

        // 装载请求地址和参数
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        ub.setParameters(pairs);

        HttpGet httpGet = new HttpGet(ub.build());

        return doHttp(httpGet);
    }

    /**
     * 发送 HTTP GET请求
     * 带请求参数和请求头
     */
    public static String httpGet(String url, Map<String, Object> headers, Map<String, Object> params) throws Exception {
        // 转换请求参数
        List<NameValuePair> pairs = covertParams2NVPS(params);

        // 装载请求地址和参数
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        ub.setParameters(pairs);

        HttpGet httpGet = new HttpGet(ub.build());
        // 设置请求头
        for (Map.Entry<String, Object> param : headers.entrySet())
        httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));

        return doHttp(httpGet);
    }

    /**
     * 发送 HTTP POST请求
     * 不带请求参数和请求头
     */
    public static String httpPost(String url) throws Exception {
        HttpPost httpPost = new HttpPost(url);

        return doHttp(httpPost);
    }

    /**
     * 发送 HTTP POST请求
     * 带请求参数，不带请求头
     */
    public static String httpPost(String url, Map<String, Object> params) throws Exception {
        // 转换请求参数
        List<NameValuePair> pairs = covertParams2NVPS(params);

        HttpPost httpPost = new HttpPost(url);
        // 设置请求参数
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, StandardCharsets.UTF_8.name()));

        return doHttp(httpPost);
    }

    /**
     * 发送 HTTP POST请求
     * 带请求参数和请求头
     */
    public static String httpPost(String url, Map<String, Object> headers, Map<String, Object> params) throws Exception {
        // 转换请求参数
        List<NameValuePair> pairs = covertParams2NVPS(params);

        HttpPost httpPost = new HttpPost(url);
        // 设置请求参数
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, StandardCharsets.UTF_8.name()));
        // 设置请求头
        for (Map.Entry<String, Object> param : headers.entrySet())
        httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));

        return doHttp(httpPost);
    }

    /**
     * 发送 HTTP POST请求，参数格式JSON
     * 请求参数是JSON格式，数据编码是UTF-8
     */
    public static String httpPostJson(String url, String param) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");
        // 设置请求参数
        httpPost.setEntity(new StringEntity(param, StandardCharsets.UTF_8.name()));

        return doHttp(httpPost);
    }

    /**
     * 发送 HTTP POST请求，参数格式XML
     * 请求参数是XML格式，数据编码是UTF-8
     */
    public static String httpPostXml(String url, String param) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/xml; charset=UTF-8");
        // 设置请求参数
        httpPost.setEntity(new StringEntity(param, StandardCharsets.UTF_8.name()));

        return doHttp(httpPost);
    }

    /**
     * 将Map键值对拼接成QueryString字符串，UTF-8编码
     */
    public static String getQueryStr(Map<String, Object> params) throws Exception {
        return URLEncodedUtils.format(covertParams2NVPS(params), StandardCharsets.UTF_8.name());
    }

    /**
     * 将JavaBean属性拼接成QueryString字符串，UTF-8编码
     */
    public static String getQueryStr(Object bean) throws Exception {
        // 将JavaBean转换为Map
        Map<String, Object> map = PropertyUtils.describe(bean);

        // 移除Map中键为“class”和值为空的项
        map = Maps.filterEntries(map, new Predicate<Map.Entry<String, Object>>() {
            public boolean apply(Map.Entry<String, Object> input) {
                // 返回false表示排除该项
                return !(input.getKey().equals("class") || input.getValue() == null);
            }
        });

        return URLEncodedUtils.format(covertParams2NVPS(map), StandardCharsets.UTF_8.name());
    }

    /**
     * 将表单字符串转换为JavaBean
     */
    public static <T> T parseNVPS2Bean(String queryStr, Class<T> clazz) throws Exception {
        // 将“表单字符串”形式的字符串解析成NameValuePair集合
        List<NameValuePair> list = URLEncodedUtils.parse(queryStr, StandardCharsets.UTF_8);
        Map<String, String> rsMap = new HashMap<String, String>();

        // 将NameValuePair集合中的参数装载到Map中
        for (NameValuePair nvp : list)
            rsMap.put(nvp.getName(), nvp.getValue());

        // 实例化JavaBean对象
        T t = clazz.newInstance();
        // 将Map键值对装载到JavaBean中
        BeanUtils.populate(t, rsMap);

        return t;
    }

    /**
     * 转换请求参数，将Map键值对拼接成QueryString字符串
     */
    public static String covertParams2QueryStr(Map<String, Object> params) {
        List<NameValuePair> pairs = covertParams2NVPS(params);

        return URLEncodedUtils.format(pairs, StandardCharsets.UTF_8.name());
    }

    /**
     * 转换请求参数,将Map键值转为List<NameValuePair>
     */
    public static List<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();

        for (Map.Entry<String, Object> param : params.entrySet())
        pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));

        return pairs;
    }

    /**
     * 发送 HTTP 请求
     */
    private static String doHttp(HttpRequestBase request) throws Exception {
        // 通过连接池获取连接对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        return doRequest(httpClient, request);
    }

    /**
     * 处理Http/Https请求，并返回请求结果
     * 注：默认请求编码方式 UTF-8
     */
    private static String doRequest(CloseableHttpClient httpClient, HttpRequestBase request) throws Exception {
        String result = null;
        CloseableHttpResponse response = null;

        try {
            // 获取请求结果
            response = httpClient.execute(request);
            // 解析请求结果
            HttpEntity entity = response.getEntity();
            // 转换结果
            result = EntityUtils.toString(entity, StandardCharsets.UTF_8.name());
            // 关闭IO流
            EntityUtils.consume(entity);
        } finally {
            if (null != response)
                response.close();
        }

        return result;
    }
}
