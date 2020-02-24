package com.newMedia.service.impl;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.newMedia.Utils.FormatUtil;
import com.newMedia.Utils.GetSessionUtils;
import com.newMedia.dao.SessionDao;
import com.newMedia.dao.WUserDao;
import com.newMedia.dto.WLogin;
import com.newMedia.exception.userException.UserException;
import com.newMedia.service.WRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

@Service
public class WRegistryServiceImpl implements WRegistryService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WUserDao wUserDao;
    private SessionDao sessionDao;

    //注册
    public WLogin registryNewUser(String code, String nickName, String avatarUrl, int gender, String city) throws UserException, Exception {
        String res = GetSessionUtils.getSession(code);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(res);
        String Code = HtmlUtils.htmlEscape(code);
        String NickName = HtmlUtils.htmlEscape(nickName);
        String AvatarUrl = HtmlUtils.htmlEscape(avatarUrl);
        String City = HtmlUtils.htmlEscape(city);
        try {
            //如果errorCode存在则执行return,反之被捕获
            String errorCode = jsonObject.get("errcode").toString();
            return new WLogin(errorCode, false, "获取失败");
        } catch (Exception e) {
            logger.error("Noerroe={}", e.getMessage());
        }
        String sessionKey = jsonObject.get("session_key").getAsString();
        String openId = jsonObject.get("openid").getAsString();
        try {
            int changecount = wUserDao.addUser(openId, NickName, AvatarUrl, gender, FormatUtil.getCityName(City));
        } catch (Exception e) {
            return new WLogin(openId, sessionKey, false);
        }
        return new WLogin(openId, sessionKey, true);
    }
}
