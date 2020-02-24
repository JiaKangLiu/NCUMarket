package com.newMedia.service.adminService;

import com.newMedia.dto.DoResult;
import com.newMedia.entity.Product;

import java.util.List;

public interface AdminCheckService {
    //    查看前10条待审核内容
    List<Product> showProducts(int offset);

    //    审核内容
    DoResult checkProducts(int productId, int adminNum, boolean isPass, String sellerOpenid);
}
