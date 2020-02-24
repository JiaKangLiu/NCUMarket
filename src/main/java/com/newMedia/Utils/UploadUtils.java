package com.newMedia.Utils;

import com.newMedia.dto.Uptoken;
import com.qiniu.util.Auth;

public class UploadUtils {


    public static Uptoken getUpToken() {
        final String accessKey = "FwxgG8AIKu7G-j8nzbYGQUMBV_NmRFLOxHZcYuVs";
        final String secretKey = "BP9gKGUSs4bM9fN4Q3nVqQ583V90hRs7pQUwU9Hi";
        final String bucket = "newmedia";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        Uptoken rupToken = new Uptoken(upToken);
        return rupToken;
    }
}
