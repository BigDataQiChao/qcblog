package com.qcblog.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtils {

    public static String getHtml(String url,String charset) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        CloseableHttpResponse response = client.execute(httpGet);
        //返回实体
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity, charset);
        response.close();
        client.close();
        return html;
    }
}
