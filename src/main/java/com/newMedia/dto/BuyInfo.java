package com.newMedia.dto;

import com.newMedia.entity.Product;

public class BuyInfo {
    private Long sellerPhone;
    private int productId;
    private boolean state;
    private String error;

    public BuyInfo(Product product, Boolean state) {
        this.sellerPhone = product.getSellerPhone();
        this.productId = product.getId();
        this.state = state;
    }

    public BuyInfo(boolean state, String error) {
        this.state = state;
        this.error = error;
    }

    public Long getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(Long sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
