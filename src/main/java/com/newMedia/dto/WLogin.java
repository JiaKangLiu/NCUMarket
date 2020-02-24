package com.newMedia.dto;

//登录相关数据
public class WLogin {
    private String openId;
    private String sessionId;
    private boolean success;
    private String error;


    /*
     *登录成功
     */
    public WLogin(String openId, String sessionId, boolean success) {
        this.openId = openId;
        this.sessionId = sessionId;
        this.success = success;
    }


//登录失败

    public WLogin(String openId, boolean success, String error) {
        this.openId = openId;
        this.success = success;
        this.error = error;
    }

    public WLogin() {
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "WLogin{" +
                "openId='" + openId +
                '}';
    }
}
