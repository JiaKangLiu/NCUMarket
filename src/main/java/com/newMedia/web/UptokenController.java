package com.newMedia.web;

import com.newMedia.Utils.UploadUtils;
import com.newMedia.dto.Uptoken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/upToken")
public class UptokenController {

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json;charset=utf8")
    @ResponseBody
    public Uptoken getUpToken() {
        return UploadUtils.getUpToken();
    }
}
