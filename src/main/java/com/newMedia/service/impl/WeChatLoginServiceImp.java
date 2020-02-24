package com.newMedia.service.impl;

import com.newMedia.dao.SessionDao;
import com.newMedia.service.WeChatLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeChatLoginServiceImp implements WeChatLoginService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SessionDao sessionDao;

    //保存session
    public int savaSession(String jsessionid, String sessionId, String openId) {
        int x = sessionDao.createJSession(jsessionid, sessionId, openId);
        return x;
    }
}
