package com.newMedia.entity;

import java.util.Date;

public class MineProduct {
    private int id;
    private String productTittle;
    private String productImgurl;
    private String productPrice;
    private int state;
    private Date time;
    private Long phone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTittle() {
        return productTittle;
    }

    public void setProductTittle(String productTittle) {
        this.productTittle = productTittle;
    }

    public String getProductImgurl() {
        return productImgurl;
    }

    public void setProductImgurl(String productImgurl) {
        this.productImgurl = productImgurl;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
