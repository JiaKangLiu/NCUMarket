package com.newMedia.service.adminService.impl;

import com.newMedia.dao.NCUAdminDao;
import com.newMedia.dao.ProductDao;
import com.newMedia.dto.DoResult;
import com.newMedia.entity.Product;
import com.newMedia.service.adminService.AdminCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCheckServiceImpl implements AdminCheckService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private NCUAdminDao ncuAdminDao;

    @Override
    public List<Product> showProducts(int offset) {
        List<Product> products = productDao.queryNoChecked(10, offset);
        return products;
    }

    //    重要安全点
    @Override
    public DoResult checkProducts(int productId, int adminNum, boolean isPass, String sellerOpenid) {
        int count = ncuAdminDao.isAdmin(adminNum);
        if (count > 0) {
            if (isPass) {
                productDao.checkProduct(productId, 1);
                return new DoResult(true, "成功");
            } else {
                productDao.deleteProduct(productId, sellerOpenid);
                return new DoResult(true, "成功");
            }
        }
        return new DoResult(false, "失败!");
    }
}
