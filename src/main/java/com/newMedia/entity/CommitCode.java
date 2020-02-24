package com.newMedia.entity;

import java.util.Date;

public class CommitCode {
    private int jsessionid;
    private String commitCode;
    private Boolean commitState;
    private Date commitTime;

    public int getJsessionid() {
        return jsessionid;
    }

    public void setJsessionid(int jsessionid) {
        this.jsessionid = jsessionid;
    }

    public String getCommitCode() {
        return commitCode;
    }

    public void setCommitCode(String commitCode) {
        this.commitCode = commitCode;
    }

    public Boolean getCommitState() {
        return commitState;
    }

    public void setCommitState(Boolean commitState) {
        this.commitState = commitState;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
