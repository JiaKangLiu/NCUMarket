package com.newMedia.dao;

import com.newMedia.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ProductDaoTest {
    @Autowired
    ProductDao productDao;

    @Test
    public void getProductsByCategoryId() throws Exception {
    }

    @Test
    public void addProduct() throws Exception {
        for (int i = 0; i < 3; i++) {
            int x = productDao.addProduct("一号商品", 1, "本社区一号产品", 1000, 2000, 13237081526L, 1, "oqhDx0EQIqPUt1wWI2UNRM0L5PD0", "333", "123");
            System.out.println("我是当前id" + x);
        }
    }

    @Test
    public void changeProductState() throws Exception {
    }

    @Test
    public void getProductsBySellerOpenid() throws Exception {
        List<Product> products = productDao.getProductsBySellerOpenid("oqhDx0EQIqPUt1wWI2UNRM0L5PD0");
        for (Product product : products) {
            System.out.println(product);
        }

    }

    @Test
    public void deleteProduct() throws Exception {
    }

    @Test
    public void getPCountsBySellerIdandState() throws Exception {
    }

    @Test
    public void getPCountsBySellerId() throws Exception {

    }

    @Test
    public void getProductsBySellerIdandState() throws Exception {
        List<Product> products = productDao.getProductsBySellerIdandState("oqhDx0EQIqPUt1wWI2UNRM0L5PD0", 1);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void getProductByPId() throws Exception {
    }

}