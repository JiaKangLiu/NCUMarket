package com.newMedia.service.adminService.impl;

import com.newMedia.dao.NCUAdminDao;
import com.newMedia.service.adminService.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private NCUAdminDao ncuAdminDao;

    @Override
    public Boolean isPasswordCorrect(int adminNum, String password) {

        int count = ncuAdminDao.isPwdCorrect(adminNum, password);
        if (count == 1) {
            return true;
        } else
            return false;
    }
}
