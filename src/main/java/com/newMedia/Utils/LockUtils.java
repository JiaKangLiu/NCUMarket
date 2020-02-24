package com.newMedia.Utils;

import org.springframework.util.DigestUtils;

public class LockUtils {

    public static String getMd5(String password) {
        String salt = "zqpzkhu^ASDAOA=3zkwq239=@!$^@&@JUC[]";
        String base = password + "/" + salt;
        String md5psw = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5psw;
    }
}
