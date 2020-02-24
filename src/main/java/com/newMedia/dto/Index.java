package com.newMedia.dto;

import com.newMedia.entity.Category;

import java.util.List;

public class Index {
    private List<RProduct> rProducts;
    private List<Category> categories;

    public Index(List<RProduct> rProducts, List<Category> categories) {
        this.rProducts = rProducts;
        this.categories = categories;
    }

    public List<RProduct> getrProducts() {
        return rProducts;
    }

    public void setrProducts(List<RProduct> rProducts) {
        this.rProducts = rProducts;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
