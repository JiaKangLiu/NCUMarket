package com.newMedia.service;

import com.newMedia.dto.BuyInfo;

public interface BuyPService {
    //    购买商品
    BuyInfo buyProduct(int productId, Long buyerPhone, String buyerOpenid, String buyerMessage, int receiveMethod, int payMethod);

    //    给商品添加评价 TODO
    int addComment();
//    获取当前已购买的商品


}
