package cn.ws.tools.http;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * http请求工具类
 * </p>
 *
 * @author shun
 * @since 2020-01-06
 */
public class HttpClientUtil{

    private static final int PORT= 80 ;
    private static final String UNKNOWN= "unKnown" ;
    private static final String F_F_F_F= "::ffff:" ;
    /**
     * 利用HttpClient进行get请求
     * @param url
     * @return
     */
    public static String doGet(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36 OPR/53.0.2907.68");
            response = httpClient.execute(httpGet);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "utf-8");
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @description 功能描述: post https请求，服务器双向证书验证
     * @param url 请求地址
     * @param s 参数xml
     * @return 请求失败返回null
     */
    public static String doPost(String url, String s) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);
        String body = null;
        try {
            httpPost.setEntity(new StringEntity(s, "utf8"));
            response = httpClient.execute(httpPost);
            body = EntityUtils.toString(response.getEntity(), "utf8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return body;
    }

    public static String doPostMap(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36 OPR/53.0.2907.68");
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String doPost(String url) {
        return doPostMap(url, null);
    }

    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultString;
    }

    public static byte[] doPostJsonByte(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        byte[] resultByte=null;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultByte=EntityUtils.toByteArray(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (resultByte != null)
        {
            return resultByte;
        }
        return null;
    }

    public static String doPostFormData(String url, Map<String,Object> map) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {

            HttpPost httpPost = new HttpPost(url);
            //创建 MultipartEntityBuilder,以此来构建我们的参数
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
            //设置字符编码，防止乱码
            ContentType contentType=ContentType.create("text/plain", Charset.forName("UTF-8"));
            //填充我们的文本内容，这里相当于input 框中的 name 与value
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if(value!=null){
                    entityBuilder.addPart(entry.getKey(), new StringBody(entry.getValue().toString(),contentType));
                }
            }
            //参数组装
            HttpEntity entity = entityBuilder.build();
            // 创建请求内容
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }
    public static byte[] post(String url, byte[] bytes, String contentType) throws IOException {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new ByteArrayEntity(bytes));
        if (contentType != null)
        {
            httpPost.setHeader("Content-type", contentType);
        }
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try {
            HttpEntity entityResponse = httpResponse.getEntity();
            int contentLength = (int) entityResponse.getContentLength();
            if (contentLength <= 0){
                throw new IOException("No response");
            }
            byte[] respBuffer = new byte[contentLength];
            if (entityResponse.getContent().read(respBuffer) != respBuffer.length)
            {
                throw new IOException("Read response buffer error");
            }
            return respBuffer;
        } finally {
            httpResponse.close();
        }
    }
}
