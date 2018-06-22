package edu.bupt.util;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/**
 * Created by 73681 on 2018/6/22.
 */
public class HttpClientUtil {
    /*
    * get请求
    * */
    public static InputStream get(String url, Map<String,Object> parms) throws Exception {

        //将url和queryString拼凑起来
        String urlWithQuery = url.indexOf('?') == -1 ? url+"?" : url;
        String queryString = "";

        if (parms != null){
            for (Map.Entry<String,Object> entry : parms.entrySet()){
                String key = entry.getKey();
                Object value = entry.getValue();
                queryString += key + "=" + value + ";";
            }
            urlWithQuery += queryString.substring(0,queryString.length()-1);
        }



        //创建httpclient实例，采用默认的参数配置
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //请求的参数配置，分别设置连接池获取连接的超时时间，连接上服务器的时间，服务器返回数据的时间
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(3000)
                .setConnectTimeout(3000)
                .setSocketTimeout(3000)
                .build();

        try {
            HttpGet get = new HttpGet(new URI(urlWithQuery));
            get.setConfig(config);

            //提交请求
            CloseableHttpResponse response = httpClient.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK){
                return response.getEntity().getContent();
            }else {
                throw new Exception("http请求不成功");
            }
        } catch (URISyntaxException e) {
            throw new Exception("http请求失败" + e.getMessage());
        }
    }
}
