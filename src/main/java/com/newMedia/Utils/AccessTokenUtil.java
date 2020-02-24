package com.newMedia.Utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.newMedia.dto.AccessToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class AccessTokenUtil {
    private static final String APPID = "wx43b59e6f8bc5f69c";
    private static final String APPSECRET = "4402282a629d5a594168935c1ead31f3";
    private static AccessToken accessToken = AccessToken.getMyAccessToken();

    public static String getAccessToken() {
        long nowTime = System.currentTimeMillis() / 1000;
        if (nowTime > accessToken.getOverTime()) {
            return getNewAccessToken();
        } else {
            return accessToken.getAccessToken();
        }
    }


    //    获取新accessToken
    private static String getNewAccessToken() {
        String url = "https://www.qingbaobao.xyz/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader in = null;
        String result = "";
        try {
//            创建url
            URL realUrl = new URL(url);
//            开启连接
            URLConnection connection = realUrl.openConnection();
//            连接
            connection.connect();
//            将headerFileds加入map映射中
            Map<String, List<String>> map = connection.getHeaderFields();
//            输入流输出流
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf8");
            in = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
            }
        }
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(result);
        String accessToken = jsonObject.get("access_token").getAsString();
        String expires_in = jsonObject.get("expires_in").getAsString();
        int lastTime = Integer.valueOf(expires_in) - 500;
        long time = System.currentTimeMillis() / 1000 + lastTime;
        AccessTokenUtil.accessToken.setOverTime(time);
        AccessTokenUtil.accessToken.setAccessToken(accessToken);
        return accessToken;
    }


}
