package com.newMedia.dao;

import com.newMedia.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    //    1.通过分类Id获取products
    List<Product> getProductsByCategoryIdandTime(@Param("categoryId") int categoryId, @Param("pageSize") int pageSize, @Param("offset") int offset);

    //  通过分类与浏览量查询
    List<Product> getProductsByCategoryIdandstar(@Param("categoryId") int categoryId, @Param("pageSize") int pageSize, @Param("offset") int offset);

    //    2.添加商品，返回id
    int addProduct(@Param("productTittle") String productTittle, @Param("productImgcounts") int productImgcounts, @Param("productInfo") String productInfo, @Param("productPrice") int productPrice, @Param("productStock") int productStock, @Param("sellerPhone") Long sellerPhone, @Param("categoryId") int categoryId, @Param("sellerOpenid") String sellerOpenid, @Param("productImgurl") String productImgurl, @Param("formId") String formId);

    //    3.
    int buyProductState(@Param("id") int id, @Param("state") int state, @Param("userOpenid") String userOpenid);

    //    3.上下架,购买，返回成功否
    int changeProductState(@Param("id") int id, @Param("state") int state, @Param("userOpenid") String userOpenid);

    //    4.通过sellerOpenid获取用户全部订单
    List<Product> getProductsBySellerOpenid(String sellerOpenid);

    //    5.删除商品
    int deleteProduct(@Param("productId") int productId, @Param("sellerOpenid") String sellerOpenid);

    //    6.通过用户Id,state获取products,传入state，表示已售出和未售出
    int getPCountsBySellerIdandState(@Param("sellerId") String sellerId, @Param("state") int state);

    //    7.用户Id获取products总数
    int getPCountsBySellerId(String sellerId);

    //    8.通过用户Id获取商品列表
    List<Product> getProductsBySellerIdandState(@Param("sellerId") String sellerId, @Param("state") int state);

    //    9.通过商品id获取商品信息
    Product getProductByPId(int productId);

    //    10.queryAllByTime
    List<Product> queryAllByTime(@Param("pageSize") int pageSize, @Param("offset") int offset);

    //    11.queryAllByStar
    List<Product> queryAllByStar(@Param("pageSize") int pageSize, @Param("offset") int offset);

    //    12.查看状态
    int queryProductStateById(int pid);

    //    13.管理员查看数据库待审核内容
    List<Product> queryNoChecked(@Param("pageSize") int pageSize, @Param("offset") int offset);

    //    14.CheckProduct检查产品信息
    int checkProduct(@Param("pid") int pid, @Param("state") int state);

    //	  15.queryBySearch通过关键词搜索返回相应商品
    List<Product> queryBySearch(@Param("keyWord")String keyWord);
}