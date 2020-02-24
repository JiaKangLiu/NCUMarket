package com.newMedia.service.impl;

import com.newMedia.dao.BuyDao;
import com.newMedia.dao.ProductDao;
import com.newMedia.dto.BuyInfo;
import com.newMedia.entity.Product;
import com.newMedia.service.BuyPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyServiceImpl implements BuyPService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BuyDao buyDao;

    @Transactional
    public BuyInfo buyProduct(int productId, Long buyerPhone, String buyerOpenid, String buyerMessage, int receiveMethod, int payMethod) {
//        1.查询product的state是否为1
        Product product = productDao.getProductByPId(productId);
        int state = product.getState();
        String sellerOpenid = product.getSellerOpenid();

        if (sellerOpenid.equals(buyerOpenid)) {
            return new BuyInfo(false, "不可购买自己发布商品");

        } else if (product.getProductStock() < 1) {
            return new BuyInfo(false, "该商品已售空");

        } else {
            if (state == 1) {
                //        2.添加

                int changes = productDao.buyProductState(productId, 3, buyerOpenid);
                if (changes > 0) {
                    int changeCount = buyDao.addBuy(productId, buyerPhone, buyerOpenid, buyerMessage, receiveMethod, payMethod);
                    if (changeCount > 0) {
                        return new BuyInfo(product, true);
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return new BuyInfo(false, "购买失败");
    }

    public int addComment() {
        return 0;
    }
}
