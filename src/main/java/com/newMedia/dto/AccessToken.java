package com.newMedia.dto;

public class AccessToken {
    private static AccessToken MyAccessToken = new AccessToken(0, "");
    private long overTime;
    private String accessToken;

    private AccessToken(long overTime, String accessToken) {
        this.overTime = overTime;
        this.accessToken = accessToken;
    }

    public static AccessToken getMyAccessToken() {
        return MyAccessToken;
    }

    public long getOverTime() {
        return overTime;
    }

    public void setOverTime(long overTime) {
        this.overTime = overTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
