package com.newMedia.dto;

public class PithilyUserInfo {
    private String userName;
    private String userHead;
    private int serviceCounts;
    private int starCounts;
    private int fanCounts;


    public PithilyUserInfo(String userName, String userHead, int serviceCounts, int starCounts, int fanCounts) {
        this.userName = userName;
        this.userHead = userHead;
        this.serviceCounts = serviceCounts;
        this.starCounts = starCounts;
        this.fanCounts = fanCounts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public int getserviceCounts() {
        return serviceCounts;
    }

    public void setserviceCounts(int serviceCounts) {
        this.serviceCounts = serviceCounts;
    }

    public int getStarCounts() {
        return starCounts;
    }

    public void setStarCounts(int starCounts) {
        this.starCounts = starCounts;
    }

    public int getFanCounts() {
        return fanCounts;
    }

    public void setFanCounts(int fanCounts) {
        this.fanCounts = fanCounts;
    }

}
