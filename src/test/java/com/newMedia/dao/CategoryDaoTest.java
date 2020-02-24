package com.newMedia.dao;

import com.newMedia.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class CategoryDaoTest {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void queryAll() throws Exception {
        List<Category> list = categoryDao.queryAll();
        for (Category category : list) {
            System.out.println(category);
        }
    }

}