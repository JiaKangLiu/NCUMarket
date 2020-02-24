package com.newMedia.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class NCUAdminDaoTest {
    @Autowired
    NCUAdminDao ncuAdminDao;

    @Test
    public void pass() {
        System.out.println(ncuAdminDao.isPwdCorrect(1114031, "123456"));
    }

}
