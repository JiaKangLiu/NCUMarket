package com.newMedia.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetSessionUtils {
    private static final String APPID = "wx43b59e6f8bc5f69c";
    private static final String APPSECRET = "4402282a629d5a594168935c1ead31f3";

    public static String getSession(String code) {
        String url = "https://www.qingbaobao.xyz/sns/jscode2session?appid=" + APPID + "&secret=" + APPSECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String result = "";
        BufferedReader in = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            inputStream = conn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf8");
            in = new BufferedReader(inputStreamReader);
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {

            }
        }
        return result;
    }
}
