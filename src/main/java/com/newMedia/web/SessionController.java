package com.newMedia.web;

import com.newMedia.dto.DoResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    @RequestMapping(value = "/checkSession", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DoResult checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("WLogin") != null) {
            return new DoResult(true, "成功");
        } else
            return new DoResult(false, "无连接");
    }
}
