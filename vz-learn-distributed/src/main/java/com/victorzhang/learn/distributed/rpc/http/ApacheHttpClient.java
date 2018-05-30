package com.victorzhang.learn.distributed.rpc.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Apache HttpClient工具类
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 19:26:05
 */
public class ApacheHttpClient {

    public static void main(String[] args) throws Exception {
        String url = "http://www.baidu.com";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);

        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        byte[] bytes = EntityUtils.toByteArray(entity);
        String result = new String(bytes, "UTF8");

        System.out.println(result);
    }
}
