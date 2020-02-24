package com.newMedia.dto;

public class NCUAdmin {
    private int adminNum;
    private String password;

    public NCUAdmin(int adminNum, String password) {
        this.adminNum = adminNum;
        this.password = password;
    }

    public int getAdminNum() {
        return adminNum;
    }

    public void setAdminNum(int adminNum) {
        this.adminNum = adminNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
