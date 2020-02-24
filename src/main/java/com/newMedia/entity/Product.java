package com.newMedia.entity;

import java.util.Date;

public class Product {
    private int id;
    private int categoryId;
    private String productTittle;
    private int productImgcounts;
    private String productInfo;
    private int productPrice;
    private int productStock;
    private Date createTime;
    private int state;
    private Long sellerPhone;
    private String sellerOpenid;
    private int starCounts;
    private String formId;
    private String productImgurl;
    private WUserAbs seller;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductTittle() {
        return productTittle;
    }

    public void setProductTittle(String productTittle) {
        this.productTittle = productTittle;
    }

    public int getProductImgcounts() {
        return productImgcounts;
    }

    public void setProductImgcounts(int productImgcounts) {
        this.productImgcounts = productImgcounts;
    }

    public String getProductImgurl() {
        return productImgurl;
    }

    public void setProductImgurl(String productImgurl) {
        this.productImgurl = "http://oued771p9.bkt.clouddn.com/" + productImgurl;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(Long sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getSellerOpenid() {
        return sellerOpenid;
    }

    public void setSellerOpenid(String sellerOpenid) {
        this.sellerOpenid = sellerOpenid;
    }

    public int getStarCounts() {
        return starCounts;
    }

    public void setStarCounts(int starCounts) {
        this.starCounts = starCounts;
    }

    public WUserAbs getSeller() {
        return seller;
    }

    public void setSeller(WUserAbs sellers) {
        this.seller = sellers;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", productTittle='" + productTittle + '\'' +
                ", productImg=" + productImgurl +
                ", productInfo='" + productInfo + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                ", createTime=" + createTime +
                ", state=" + state +
                ", sellerPhone=" + sellerPhone +
                ", sellerOpenid='" + sellerOpenid + '\'' +
                ", seller=" + seller +
                '}';
    }
}
