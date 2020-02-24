package com.newMedia.service.impl;

import com.newMedia.dao.CategoryDao;
import com.newMedia.dao.ProductDao;
import com.newMedia.dto.Index;
import com.newMedia.dto.RProduct;
import com.newMedia.entity.Category;
import com.newMedia.entity.Product;
import com.newMedia.service.WIndexInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WIndexInfoServiceImpl implements WIndexInfoService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;

    public Index getIndex() {
        List<Category> categories = categoryDao.queryAll();
        List<Product> products = productDao.queryAllByTime(10, 0);
        List<RProduct> rProducts = new ArrayList<RProduct>();
        for (Product product : products) {
            rProducts.add(new RProduct(product));
        }
        return new Index(rProducts, categories);
    }
}
