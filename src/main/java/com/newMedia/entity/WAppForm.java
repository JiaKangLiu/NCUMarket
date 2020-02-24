package com.newMedia.entity;

import java.util.Date;

public class WAppForm {
    private String openId;
    private String formId;
    private boolean used;
    private Date createdAt;

    public WAppForm() {
    }

    public WAppForm(String openId, String formId) {
        this.openId = openId;
        this.formId = formId;
    }

    public WAppForm(String openId, String formId, boolean used, Date createdAt) {
        this.openId = openId;
        this.formId = formId;
        this.used = used;
        this.createdAt = createdAt;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
