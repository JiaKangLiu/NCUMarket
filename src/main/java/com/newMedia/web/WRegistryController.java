package com.newMedia.web;

import com.newMedia.dto.DoResult;
import com.newMedia.dto.WLogin;
import com.newMedia.service.WRegistryService;
import com.newMedia.service.WeChatLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/registry")
public class WRegistryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WRegistryService wRegistryService;
    @Autowired
    private WeChatLoginService weChatLoginService;

    //    注册
    @RequestMapping(value = "/createUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DoResult<WLogin> Registry(HttpSession httpSession, HttpServletRequest request, @RequestParam("code") String code, @RequestParam("nickName") String nickName, @RequestParam("avatarUrl") String avatarUrl, @RequestParam("gender") int gender, @RequestParam("city") String city) {
        try {
            WLogin wLogin = wRegistryService.registryNewUser(code, nickName, avatarUrl, gender, city);
            httpSession.setMaxInactiveInterval(7200);
            String mysession = request.getSession().getId();
            weChatLoginService.savaSession(mysession, wLogin.getSessionId(), wLogin.getOpenId());
            wLogin.setSessionId(mysession);
            httpSession.setAttribute("WLogin", wLogin);
            logger.info("用户登录成功:" + wLogin.getOpenId() + "sessionId为:" + mysession);
            return new DoResult<WLogin>(true, wLogin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Registry={}", e.getMessage());
            logger.info("用户登录失败:" + nickName);
            return new DoResult<WLogin>(false, "失败！");
        }
    }

}
