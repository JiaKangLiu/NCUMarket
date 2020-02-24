package com.newMedia.dto;

import com.newMedia.entity.Product;
import com.newMedia.entity.WUserAbs;

import java.util.Date;

public class RProduct {
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
    private String productImgurl;
    private WUserAbs seller;

    //商品展示详情页
    public RProduct(int id, String productTittle, int productImgcounts, String productInfo, int productPrice, int productStock, Date createTime, int state, int starCounts, WUserAbs seller, String productImgurl) {
        this.id = id;
        this.productTittle = productTittle;
        this.productImgcounts = productImgcounts;
        this.productInfo = productInfo;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.createTime = createTime;
        this.state = state;
        this.starCounts = starCounts;
        this.productImgurl = productImgurl;
        this.seller = seller;
    }

    //    用户页商品展示简介页
    public RProduct(int id, String productTittle, int productPrice, int starCounts, Long sellerPhone, Date createTime, String productImgurl, int state, int productStock) {
        this.id = id;
        this.productTittle = productTittle;
        this.productPrice = productPrice;
        this.state = state;
        this.starCounts = starCounts;
        this.sellerPhone = sellerPhone;
        this.productImgurl = productImgurl;
        this.createTime = createTime;
        this.productStock = productStock;
    }

    //    首页服务展示
    public RProduct(Product product) {
        this.id = product.getId();
        this.seller = product.getSeller();
        this.productTittle = product.getProductTittle();
        this.productPrice = product.getProductPrice();
        this.createTime = product.getCreateTime();
        this.productImgcounts = product.getProductImgcounts();
        this.productImgurl = product.getProductImgurl();
        this.starCounts = product.getStarCounts();
    }

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
        this.productImgurl = productImgurl;
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

    public void setSeller(WUserAbs seller) {
        this.seller = seller;
    }

}
