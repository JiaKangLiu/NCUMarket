package com.newMedia.dto;

import org.springframework.web.multipart.MultipartFile;


public class ServiceForm {
    private int id;
    private int categoryId;
    private int catId;
    private String serviceTittle;
    private String serviceInfo;
    private String userInfo;
    private int servicePrice;
    private int serviceStock;
    private MultipartFile serviceImg;

    public ServiceForm(int id, int categoryId, int catId, String serviceTittle, String serviceInfo, String userInfo, int servicePrice, int serviceStock, MultipartFile serviceImg) {
        this.id = id;
        this.categoryId = categoryId;
        this.catId = catId;
        this.serviceTittle = serviceTittle;
        this.serviceInfo = serviceInfo;
        this.userInfo = userInfo;
        this.servicePrice = servicePrice;
        this.serviceStock = serviceStock;
        this.serviceImg = serviceImg;
    }


    public ServiceForm() {
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

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getServiceTittle() {
        return serviceTittle;
    }

    public void setServiceTittle(String serviceTittle) {
        this.serviceTittle = serviceTittle;
    }

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getServiceStock() {
        return serviceStock;
    }

    public void setServiceStock(int serviceStock) {
        this.serviceStock = serviceStock;
    }

    public MultipartFile getServiceImg() {
        return serviceImg;
    }

    public void setServiceImg(MultipartFile serviceImg) {
        this.serviceImg = serviceImg;
    }

    @Override
    public String toString() {
        return "ServiceForm{" +
                "categoryId=" + categoryId +
                ", catId=" + catId +
                ", serviceTittle='" + serviceTittle + '\'' +
                ", serviceInfo='" + serviceInfo + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", servicePrice=" + servicePrice +
                ", serviceStock=" + serviceStock +
                '}';
    }
}
