package com.baidu.mylibrary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Project: MyDemo
 * Author: wm
 * Data:   16-5-27
 */
public final class HttpTools {

    private HttpTools(){

    }

    public static byte[] doGet(String url){
        byte[] ret = null;

        // 技巧： 方法永远只有一个return
        //        优先检查参数

        if (url != null) {

            HttpURLConnection conn = null;
            InputStream stream = null;
            try {
                URL u = new URL(url);
                conn = (HttpURLConnection) u.openConnection();

                conn.setRequestMethod("GET");

                conn.setConnectTimeout(3000);

                conn.connect();
                if (conn.getResponseCode() ==200) {
                     stream = conn.getInputStream();

                    ByteArrayOutputStream bos = new ByteArrayOutputStream();

                    byte[] buf = new byte[1024];

                    int len;

                    while(true){
                        len = stream.read(buf);
                        if(len == -1){
                            break;
                        }
                        bos.write(buf,0,len);
                    }
                    ret = bos.toByteArray();
                    bos.close();
                    buf = null;
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
                if(stream !=null){
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }


        return  ret;
    }
}
