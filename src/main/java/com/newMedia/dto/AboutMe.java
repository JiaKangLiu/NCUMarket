package com.newMedia.dto;

import com.newMedia.entity.WUser;

public class AboutMe {
    private WUser wUser;
    private MyPs myPs;

    public AboutMe(WUser wUser, MyPs myPs) {
        this.wUser = wUser;
        this.myPs = myPs;
    }

    public WUser getwUser() {
        return wUser;
    }

    public void setwUser(WUser wUser) {
        this.wUser = wUser;
    }

    public MyPs getMyPs() {
        return myPs;
    }

    public void setMyPs(MyPs myPs) {
        this.myPs = myPs;
    }
}
