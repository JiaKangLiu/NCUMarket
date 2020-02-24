package com.newMedia.dao;

import com.newMedia.entity.Category;

import java.util.List;

public interface CategoryDao {
    //    获取所有的category
    List<Category> queryAll();
}
