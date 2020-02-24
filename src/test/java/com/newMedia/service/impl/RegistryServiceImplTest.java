//package com.newMedia.service.impl;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import com.newMedia.service.RegistryService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
//public class RegistryServiceImplTest {
//    Logger logger= LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private RegistryService registryServiceImpl;
//    @Test
//    public void isEmailExisted() throws Exception {
//        try {
//        Boolean X=registryServiceImpl.isEmailExisted("922");
//        if(X){
//        logger.info("IsemailExisted={}","邮箱已经存在");}
//        else
//            logger.debug("Answer={}","邮箱未注册");
//        }
//        catch (Exception e){
//           logger.error(e.getMessage());  }
//    }
//
//    @Test
//    public void isPhoneExisted() throws Exception {
//    }
//
////    @Test
////    public void registryNewUser() throws Exception {
////        Registry registry=registryServiceImpl.registryNewUser("最帅陈昊",15079093293L,"123","964909479@qq.com","/head/handsome",1,"男");
////        logger.info("registry={}",registry.getState()+"-------"+registry.getStateInfo());
////    }
//
//}