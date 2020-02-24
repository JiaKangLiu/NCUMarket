//package com.newMedia.dao;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
//public class createServiceCodeDaoTest {
//    @Autowired
//    private CreateServiceCodeDao CreateServiceCodeDao;
//    @Test
//    public void queryTimeByuserId() throws Exception {
//        boolean x=CreateServiceCodeDao. queryCodeByuserId(1,"2000");
//        System.out.println(x);
//        Boolean y=CreateServiceCodeDao.queryCodeByuserId(2,"30");
//        if(y==null)
//        System.out.println("FALSE");
//    }
//
//    @Test
//    public void createCommitCode() throws Exception {
//        boolean x=CreateServiceCodeDao.createCommitCode(1,"2000");
//        System.out.println(x);
//    }
//
//}