package com.newMedia.service;


import com.newMedia.dto.DoResult;
import com.newMedia.dto.ProductAbs;
import com.newMedia.dto.ProductDetail;
import com.newMedia.dto.RProduct;
import com.newMedia.entity.Buy;
import com.newMedia.entity.MineProduct;
import com.newMedia.entity.Product;

import java.util.List;

public interface ProductInfoService {
    //    首页service组合
    List<Product> indexProduct(int categoryId, int offset);

    //    添加product
    DoResult<ProductAbs> addProduct(String productTittle, int productImgcounts, String productInfo, int productPrice, int productStock, Long sellerPhone, int categoryId, String sellerOpenid, String productImgurl, String formId);

    //    通过categoryId和时间获取products
    List<RProduct> getProductsByCategoryIdandTime(int categoryId, int pageSize, int offset);

    //    通过categord和热度获取products
    List<RProduct> getProductsByCategoryIdandstar(int categoryId, int pageSize, int offset);

    //    通过热度获取products
    List<RProduct> queryAllByStar(int pageSize, int offset);

    //    通过productId 获取Product信息
    ProductDetail getProductBypid(int pid);

    //    通过获取全部product中最新时间
    List<RProduct> queryAllByTime(int pageSize, int offset);

    //    获取我发布的商品
    List<RProduct> queryMyPush(String sellerOpenid);

    //    获取我卖出的商品
    List<MineProduct> queryMySold(String sellerOpenid);

    //
    List<MineProduct> queryMyBought(String buyerOpenid);

    //    删除商品
    DoResult deleteProduct(int productId, String userOpenid);

    //    上下架商品
    DoResult changeState(int productId, String userOpenid);

    //    getBuyInfoByOpenidandUid
    DoResult<Buy> getBuyInfoByOpenidandUid(int pid, String userId);
    
    //	  queryBySearch通过关键词搜索返回相应商品
    List<RProduct> queryBySearch(String keyWord);
}

