package com.cqc.learning.java.http;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HttpUtils
 * @Description HTTP工具类
 */
public class HttpUtils {
    public static String POST = "post";

    private static final String CHARSET = "UTF-8";
    private static String contentType = "application/json";
    private static String charset = "utf-8";

    /**
     * 连接超时
     */
    private static final int CONNECT_TIMEOUT = 1000;

    /**
     * 请求超时
     */
    private static final int SO_TIMEOUT = 1000;

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private HttpUtils() {
    }

    /*public static String doPostWithXMLString(String protocal, String url, Map<String, String> requestMap,
                                             String xmlCharset) throws Exception {
        String msg;
        try {
            msg = XmlUtils.mapToXml(requestMap);

        } catch (Exception e) {
            logger.error("请求对象转XML出现异常：" + e.getMessage(), e);
            throw new BaseCommonException("0TE111006001");
        }
        logger.info("请求对象信息为：{}", msg);
        String resp = doPostWithXML(protocal, url, msg, xmlCharset);
        return resp;
    }*/

    /**
     * 通过XML对象发送POST请求
     **/
    /*public static String doPostWithXMLObject(String protocal, String url, Object object, String xmlCharset)
            throws Exception {
        String msg;
        try {
            msg = XmlUtils.object2XML1(object, "utf-8");

        } catch (Exception e) {
            logger.error("请求对象转XML出现异常：" + e.getMessage(), e);
            throw new BaseCommonException("0TE111006001");
        }
        logger.info("请求对象信息为：" + msg);
        String resp = doPostWithXML(protocal, url, msg, xmlCharset);
        return resp;
    }*/

    public static String doPostWithXML(String protocal, String url, String xml, String xmlCharset) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse resp = null;
        String rtnValue = null;
        try {
            if (protocal.equals("http")) {
                httpClient = HttpClients.createDefault();
            } else {
                // 获取https安全客户端
                httpClient = HttpUtils.getHttpsClient();
            }

            HttpPost httpPost = new HttpPost(url);

            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SO_TIMEOUT)
                    .setConnectTimeout(CONNECT_TIMEOUT).build();// 设置请求和传输超时时间
            httpPost.setConfig(requestConfig);

            httpPost.setEntity(new StringEntity(xml, xmlCharset));
            httpPost.setHeader("Content-type", "text/xml");

            resp = httpClient.execute(httpPost);
            rtnValue = EntityUtils.toString(resp.getEntity(), xmlCharset);

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("0TE111004003");
        } finally {
            if (null != resp) {
                resp.close();
            }
            if (null != httpClient) {
                httpClient.close();
            }
        }

        return rtnValue;
    }

    /**
     * Post请求
     *
     * @param url
     * @param paraMap
     * @param socketTimeout
     * @param connectTimeout
     * @return
     * @throws Exception
     */
    public static String doPost(String url, Map<String, Object> paraMap, String socketTimeout, String connectTimeout)
            throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse resp = null;
        String rtnValue = null;
        try {
            if (url.startsWith("https")) {
                // 获取https安全客户端
                httpClient = HttpUtils.getHttpsClient();
            } else {
                httpClient = HttpClients.createDefault();
            }

            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            if (null != paraMap && paraMap.size() > 0) {
                for (Map.Entry<String, Object> entry : paraMap.entrySet()) {
                    list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
            }

            int socketTimeoutInt = SO_TIMEOUT;
            int connectTimeoutInt = CONNECT_TIMEOUT;
            /*if (StringUtil.checkString(socketTimeout)) {
                socketTimeoutInt = Integer.parseInt(socketTimeout);
            }

            int connectTimeoutInt = CONNECT_TIMEOUT;
            if (StringUtil.checkString(connectTimeout)) {
                connectTimeoutInt = Integer.parseInt(connectTimeout);
            }*/

            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeoutInt)
                    .setConnectTimeout(connectTimeoutInt).build();
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new UrlEncodedFormEntity(list, CHARSET));
            resp = httpClient.execute(httpPost);
            rtnValue = EntityUtils.toString(resp.getEntity(), CHARSET);

        } finally {
            if (null != resp) {
                resp.close();
            }
            if (null != httpClient) {
                httpClient.close();
            }
        }

        return rtnValue;
    }

    /**
     * @param @return
     * @param @throws SanxiaPayBizException
     * @return HttpClient
     * @throws @Method: getHttpsClient
     * @Description: https 单向验证
     */
    public static CloseableHttpClient getHttpsClient() throws Exception {
        try {
            TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
                        throws CertificateException {
                }
                @Override
                public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
                        throws CertificateException {
                }
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }};
            SSLContext sslContext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            sslContext.init(new KeyManager[0], trustManagers, new SecureRandom());
            SSLContext.setDefault(sslContext);
            sslContext.init(null, trustManagers, null);
            SSLConnectionSocketFactory connectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            HttpClientBuilder clientBuilder = HttpClients.custom().setSSLSocketFactory(connectionSocketFactory);
            clientBuilder.setRedirectStrategy(new LaxRedirectStrategy());
            CloseableHttpClient httpClient = clientBuilder.build();
            return httpClient;
        } catch (Exception e) {
            throw new Exception("http client 远程连接失败", e);
        }
    }

    public static String post(Map<String, Object> msgs, String url)
            throws ClientProtocolException, UnknownHostException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost request = new HttpPost(url);
            List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
            if (null != msgs) {
                for (Map.Entry<String, Object> entry : msgs.entrySet()) {
                    valuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
            }
            request.setEntity(new UrlEncodedFormEntity(valuePairs, CHARSET));
            CloseableHttpResponse resp = httpClient.execute(request);
            return EntityUtils.toString(resp.getEntity(), CHARSET);
        } finally {
            httpClient.close();
        }
    }

    public static String get(Map<String, Object> msgs, String url)
            throws ClientProtocolException, UnknownHostException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
            if (null != msgs) {
                for (Map.Entry<String, Object> entry : msgs.entrySet()) {
                    valuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
            }
            // EntityUtils.toString(new UrlEncodedFormEntity(valuePairs),
            // CHARSET);
            url = url + "?" + URLEncodedUtils.format(valuePairs, CHARSET);
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse resp = httpClient.execute(request);
            return EntityUtils.toString(resp.getEntity(), CHARSET);
        } finally {
            httpClient.close();
        }
    }

    public static String yunpayYeePayGet(Map<String, Object> msgs, String url)
            throws ClientProtocolException, UnknownHostException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
            if (null != msgs) {
                for (Map.Entry<String, Object> entry : msgs.entrySet()) {
                    valuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
            }
            // EntityUtils.toString(new UrlEncodedFormEntity(valuePairs),
            // CHARSET);
            url = url + "&" + URLEncodedUtils.format(valuePairs, CHARSET);
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse resp = httpClient.execute(request);
            return EntityUtils.toString(resp.getEntity(), CHARSET);
        } finally {
            httpClient.close();
        }
    }

    // 与亚银http通讯
    public static String postWithYaYin(String request, String requestUrl) throws Exception {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(requestUrl);
        String resp = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StringRequestEntity requestEntity;
            requestEntity = new StringRequestEntity(request, contentType, charset);
            postMethod.setRequestEntity(requestEntity);

            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(120000);
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(120000);
            int statusCode = httpClient.executeMethod(postMethod);
            /* 判断返回码 */
            if (statusCode != HttpStatus.SC_OK) {
                logger.info("url[" + requestUrl + "]请求异常,statusCode[" + statusCode + "],参数[" + request + "].");
            }
//			resp = postMethod.getResponseBodyAsString();
            BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream()));
            while ((resp = reader.readLine()) != null) {
                stringBuffer.append(resp);
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("0TE111004003");
        } catch (HttpException e) {
            throw new RuntimeException("0TE111004003");
        } catch (IOException e) {
            throw new Exception("响应报文转换异常");
        } finally {
            // 释放连接
            postMethod.releaseConnection();
        }
    }

    public static String postString(Map<String, String> msgs, String url) throws ClientProtocolException, UnknownHostException, IOException {
        logger.info("请求银联的地址：" + url);
        logger.info("请求银联的报文:" + msgs);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost request = new HttpPost(url);
            List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
            if (null != msgs) {
                for (Map.Entry<String, String> entry : msgs.entrySet()) {
                    valuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
            }
            request.setEntity(new UrlEncodedFormEntity(valuePairs, CHARSET));
            CloseableHttpResponse resp = httpClient.execute(request);
            return EntityUtils.toString(resp.getEntity(), CHARSET);
        } finally {
            httpClient.close();
        }
    }
}
