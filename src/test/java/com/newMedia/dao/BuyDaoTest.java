package com.newMedia.dao;

import com.newMedia.entity.Buy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class BuyDaoTest {
    @Autowired
    private BuyDao buyDao;

    @Test
    public void getBuyDetailByProductId() throws Exception {
        Buy b = buyDao.getBuyDetailByProductId(1);
        if (b == null) {
            System.out.println("不存在");
        }
    }

    @Test
    public void addBuy() throws Exception {
    }

    @Test
    public void getBuyCountsByOpenid() throws Exception {
    }

    @Test
    public void getBuysInfoByOpenid() throws Exception {
    }

}