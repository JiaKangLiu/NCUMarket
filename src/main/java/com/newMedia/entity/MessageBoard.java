package com.newMedia.entity;

import java.util.Date;

public class MessageBoard {
    private String passengerId;
    private int productId;
    private String message;
    private WUserAbs passenger;
    private Date createTime;

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WUserAbs getPassenger() {
        return passenger;
    }

    public void setPassenger(WUserAbs passenger) {
        this.passenger = passenger;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
