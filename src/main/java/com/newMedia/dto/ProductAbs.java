package com.newMedia.dto;

import com.newMedia.entity.Product;

public class ProductAbs {
    private int id;
    private String productTittle;

    public ProductAbs(Product product) {
        this.id = product.getId();
        this.productTittle = product.getProductTittle();
    }

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
}
