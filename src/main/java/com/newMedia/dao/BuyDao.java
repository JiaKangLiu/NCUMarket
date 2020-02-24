package com.newMedia.dao;

import com.newMedia.entity.Buy;
import com.newMedia.entity.MineProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuyDao {
    //    获取订单详情
    Buy getBuyDetailByProductId(int productId);

    //    添加订单信息
    int addBuy(@Param("productId") int productId, @Param("buyerPhone") Long buyerPhone, @Param("buyerOpenid") String buyerOpenid, @Param("buyerMessage") String buyerMessage, @Param("receiveMethod") int receiveMethod, @Param("payMethod") int payMethod);

    //    获取该用户购买订单总数
    int getBuyCountsByOpenid(String buyerOpenid);

    //    获取订单列表
    List<Buy> getBuysInfoByOpenid(String buyerOpenid);

    //    获取我购买的订单
    List<MineProduct> getBoughtProductsByOpenid(String buyerOpenid);

    //    获取我已售的订单
    List<MineProduct> getSoldProductsByOpenid(String sellerOpenId);

    //    13.获取订单详情页
    Buy getBuyInfoByOpenidandUid(@Param("pid") int pid, @Param("userId") String userId);
}
