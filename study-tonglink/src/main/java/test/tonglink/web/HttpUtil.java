package test.tonglink.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dell on 2018/8/6.
 * @author dell
 */
@Slf4j
public class HttpUtil {

    private RequestConfig requestConfig;

    private CloseableHttpClient httpClient;

    {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1.2"},
                    null, new HostnameVerifier(){
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }

            });

            requestConfig = RequestConfig.custom().setConnectTimeout(2000).setConnectionRequestTimeout(2000)
                    .setSocketTimeout(2000).build();
            httpClient = HttpClientBuilder.create()
                    .setMaxConnTotal(30).setMaxConnPerRoute(30).setDefaultRequestConfig(requestConfig)
                    .setSSLSocketFactory(sslsf).build();
        }catch (Exception e){}
    }

    private String contentType;

    private String accept;

    private HttpUtil(String accept, String contentType){
        this.accept = accept;
        this.contentType = contentType;
    }
    private HttpUtil(String contentType){
        this.accept = contentType;
        this.contentType = contentType;
    }
    private HttpUtil(){
        this.accept = "application/json";
        this.contentType = "application/json";
    }

    public static HttpUtil getInstance(String accept, String contentType){
        if (StringUtils.isEmpty(contentType)){
            return new HttpUtil();
        }else if (StringUtils.isEmpty(accept)){
            return new HttpUtil(contentType);
        }else{
            return new HttpUtil(accept,contentType);
        }
    }
    public static HttpUtil getInstance(String contentType){
        return getInstance(null,contentType);
    }

    public static HttpUtil getInstance(){
        return getInstance(null,null);
    }

    /**
     * get请求
     * @return
     */
    public HttpResult doGet(String url) throws Exception{
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", accept);
        httpGet.setHeader("Content-Type", contentType);
        return getResponseToString(httpGet);
    }

    /**
     * get请求
     * @return
     */
    public HttpResult doGet(String url,Header[] headers) throws Exception{
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeaders(headers);
        return getResponseToString(httpGet);
    }


    /**
     * put
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public HttpResult doPut(String url,String params) throws Exception{
        HttpPut httpPut = new HttpPut(url);
        httpPut.setHeader("Accept", accept);
        httpPut.setHeader("Content-Type", contentType);
        String charSet = "UTF-8";
        if (!StringUtils.isEmpty(params)) {
            StringEntity reqEntity = new StringEntity(params, charSet);
            httpPut.setEntity(reqEntity);
        }
        return getResponseToString(httpPut);
    }

    /**
     * put
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public HttpResult doPut(String url,String params,Header[] headers) throws Exception{
        HttpPut httpPut = new HttpPut(url);
        httpPut.setHeaders(headers);
        String charSet = "UTF-8";
        if (!StringUtils.isEmpty(params)) {
            StringEntity reqEntity = new StringEntity(params, charSet);
            httpPut.setEntity(reqEntity);
        }
        return getResponseToString(httpPut);
    }


    private HttpResult getResponseToString(HttpUriRequest httpRequest) throws Exception{
        CloseableHttpResponse response = null;
        HttpResult httpResult = new HttpResult();
        try {
            response = httpClient.execute(httpRequest);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            httpResult.setStatus(state);
            if (state == HttpStatus.SC_OK || state == HttpStatus.SC_CREATED) {
                httpResult.setSuccess(true);
            }else{
                httpResult.setSuccess(false);
            }
            HttpEntity entity = response.getEntity();
            StringBuilder sb = new StringBuilder();
            if (entity != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                String text;
                while ((text = bufferedReader.readLine()) != null) {
                    sb = sb.append(text).append("\n");
                }
            }
            EntityUtils.consume(entity);
            httpResult.setResponseString(sb.toString());
            return httpResult;
        }catch (Exception e){
            log.error("****",e);
            throw new Exception("http请求失败："+httpRequest.getURI());
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                log.error("****",e);
            }
        }
    }


    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public HttpResult doPost(String url, String params) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", accept);
        httpPost.setHeader("Content-Type", contentType);
        String charSet = "UTF-8";
        if (!StringUtils.isEmpty(params)) {
            StringEntity reqEntity = new StringEntity(params, charSet);
            httpPost.setEntity(reqEntity);
        }
        return getResponseToString(httpPost);
    }

    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public HttpResult doPost(String url, String params,Header[] headers) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        String charSet = "UTF-8";
        if (!StringUtils.isEmpty(params)) {
            StringEntity reqEntity = new StringEntity(params, charSet);
            httpPost.setEntity(reqEntity);
        }
        return getResponseToString(httpPost);
    }


    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param httpEntity
     * @return
     */
    public HttpResult doPost(String url, HttpEntity httpEntity) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", accept);
        httpPost.setHeader("Content-Type", contentType);
        httpPost.setEntity(httpEntity);
        return getResponseToString(httpPost);
    }
    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param httpEntity
     * @return
     */
    public HttpResult doPost(String url, HttpEntity httpEntity, Header[] headers) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", accept);
        httpPost.setHeader("Content-Type", contentType);
        httpPost.setHeaders(headers);
        httpPost.setEntity(httpEntity);
        return getResponseToString(httpPost);
    }

    /**
     * delete
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResult doDelete(String url) throws Exception{
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.setHeader("Accept", accept);
        httpDelete.setHeader("Content-Type", contentType);
        return getResponseToString(httpDelete);
    }

    /**
     * delete
     * @param url
     * @param headers
     * @return
     * @throws Exception
     */
    public HttpResult doDelete(String url,Header[] headers) throws Exception{
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.setHeaders(headers);
        return getResponseToString(httpDelete);
    }

}
