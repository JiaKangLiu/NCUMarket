package com.newMedia.service;

public interface WeChatLoginService {
    //// 获取session
//WLogin Login(String code);
// 储存session
    int savaSession(String jsessionid, String sessionId, String openId);
}
