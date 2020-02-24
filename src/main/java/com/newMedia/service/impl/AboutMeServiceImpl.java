package com.newMedia.service.impl;

import com.newMedia.dao.BuyDao;
import com.newMedia.dao.ProductDao;
import com.newMedia.dao.WUserDao;
import com.newMedia.dto.AboutMe;
import com.newMedia.dto.MyPs;
import com.newMedia.entity.WUser;
import com.newMedia.service.AboutMeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutMeServiceImpl implements AboutMeService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WUserDao wUserDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BuyDao buyDao;

    public AboutMe getMyInfo(String openId) {
        try {
            WUser wUser = wUserDao.getUserInfo(openId);
            int pushCount = productDao.getPCountsBySellerId(openId);
            int soldCount = productDao.getPCountsBySellerIdandState(openId, 3);
            int boughtCount = buyDao.getBuyCountsByOpenid(openId);
            int sellingCount = productDao.getPCountsBySellerIdandState(openId, 1);
            MyPs myPs = new MyPs(soldCount, pushCount, boughtCount, sellingCount);
            AboutMe aboutMe = new AboutMe(wUser, myPs);
            return aboutMe;
        } catch (Exception e) {
            logger.error("获取aboutme错误={}", e.getMessage());
            return new AboutMe(null, null);
        }
    }
}
