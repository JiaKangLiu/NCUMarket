package com.newMedia.Utils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SendWXMessage {
    public static void sendWMessage(String tempId, int productId, String openId, String formId, String keyword1, String keyword2, String keyword3, String keyword4) {
        String accessToken = AccessTokenUtil.getAccessToken();
//        1.打开url
        String url = "https://www.qingbaobao.xyz/cgi-bin/message/wxopen/template/send?access_token=" + accessToken;

        try {
            URL realUrl = new URL(url);
//       建立连接
            URLConnection connection = realUrl.openConnection();
//            开始写入iii
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();
//            写入
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf8");
            String temp_1 = "{\n" +
                    "  \"touser\":\"" + openId + "\",  \n" +
                    "  \"template_id\": \"" + tempId + "\", \n" +
                    "  \"page\": \"pages/product/product?id=" + productId + "\",          \n" +
                    "  \"form_id\": \"" + formId + "\",         \n" +
                    "  \"data\": {\n" +
                    "      \"keyword1\": {\n" +
                    "          \"value\": \"" + keyword1 + "\", \n" +
                    "          \"color\": \"#173177\"\n" +
                    "      }, \n" +
                    "      \"keyword2\": {\n" +
                    "          \"value\": \"" + keyword2 + "\", \n" +
                    "          \"color\": \"#173177\"\n" +
                    "      }, \n" +
                    "      \"keyword3\": {\n" +
                    "          \"value\": \"" + keyword3 + "\", \n" +
                    "          \"color\": \"#173177\"\n" +
                    "      } , \n" +
                    "      \"keyword4\": {\n" +
                    "          \"value\": \"" + keyword4 + "\", \n" +
                    "          \"color\": \"#173177\"\n" +
                    "      } \n" +
                    "  },\n" +
                    "  \"emphasis_keyword\": \"" + keyword1 + "\" \n" +
                    "}";
            System.out.println(temp_1);
            out.write(temp_1);
            out.flush();
            connection.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
