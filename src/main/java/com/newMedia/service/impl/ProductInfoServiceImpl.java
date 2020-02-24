package com.newMedia.service.impl;

import com.newMedia.dao.BuyDao;
import com.newMedia.dao.MessageBoardDao;
import com.newMedia.dao.ProductDao;
import com.newMedia.dto.DoResult;
import com.newMedia.dto.ProductAbs;
import com.newMedia.dto.ProductDetail;
import com.newMedia.dto.RProduct;
import com.newMedia.entity.*;
import com.newMedia.service.ProductInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductDao productDao;

    @Autowired
    private MessageBoardDao messageBoardDao;

    @Autowired
    private BuyDao buyDao;

    //获取特定分类全部商品，首页显示10条
    public List<Product> indexProduct(int categoryId, int offset) {
        List<Product> products = productDao.getProductsByCategoryIdandTime(categoryId, 10, offset);
        return products;
    }


    /*
     *创建Product,返回商品简介
     */
    public DoResult<ProductAbs> addProduct(String productTittle, int productImgcounts, String productInfo, int productPrice, int productStock, Long sellerPhone, int categoryId, String sellerOpenid, String productImgurl, String formId) {
        try {
            int id = productDao.addProduct(productTittle, productImgcounts, productInfo, productPrice, productStock, sellerPhone, categoryId, sellerOpenid, productImgurl, formId);
            Product product = productDao.getProductByPId(id);
            ProductAbs productAbs = new ProductAbs(product);
            return new DoResult<ProductAbs>(true, productAbs);
        } catch (Exception e) {
            logger.error("error={}", e.getMessage());
            return new DoResult<ProductAbs>(false, "添加商品失败");
        }
    }

    //    通过分类Id和时间获取信息
    public List<RProduct> getProductsByCategoryIdandTime(int categoryId, int pageSize, int offset) {
        List<Product> products = productDao.getProductsByCategoryIdandTime(categoryId, pageSize, offset);
        List<RProduct> rProducts = new ArrayList<RProduct>();
        for (Product product : products) {
            rProducts.add(new RProduct(product));
        }
        return rProducts;
    }

    //    通过分类Id和热度获取信息
    public List<RProduct> getProductsByCategoryIdandstar(int categoryId, int pageSize, int offset) {
        List<Product> products = productDao.getProductsByCategoryIdandstar(categoryId, pageSize, offset);
        List<RProduct> rProducts = new ArrayList<RProduct>();
        for (Product product : products) {
            rProducts.add(new RProduct(product));
        }
        return rProducts;
    }

    //    获取全部类目中最热产品
    public List<RProduct> queryAllByStar(int pageSize, int offset) {
        List<Product> products = productDao.queryAllByStar(pageSize, offset);
        List<RProduct> rProducts = new ArrayList<RProduct>();
        for (Product product : products) {
            rProducts.add(new RProduct(product));
        }
        return rProducts;
    }


    //    获取productDetail获取用户信息
    public ProductDetail getProductBypid(int pid) {
        try {
            Product product = productDao.getProductByPId(pid);
            int id = pid;
            String sellerOpenid = product.getSellerOpenid();
            String productTittle = product.getProductTittle();
            int productImgcounts = product.getProductImgcounts();
            String productImgurl = product.getProductImgurl();
            String productInfo = product.getProductInfo();
            int productPrice = product.getProductPrice();
            int productStock = product.getProductStock();
            Date createTime = product.getCreateTime();
            int state = product.getState();
            int starCounts = product.getStarCounts();
            WUserAbs seller = product.getSeller();
            RProduct rProduct = new RProduct(id, productTittle, productImgcounts, productInfo, productPrice, productStock, createTime, state, starCounts, seller, productImgurl);
            List<MessageBoard> messageBoards = messageBoardDao.getMessagesByProductId(id);
            return new ProductDetail(rProduct, messageBoards);
        } catch (Exception e) {
            logger.error("getProductById={}", e.getMessage());
        }
        return null;
    }

    public List<RProduct> queryAllByTime(int pageSize, int offset) {
        List<Product> products = productDao.queryAllByTime(pageSize, offset);
        List<RProduct> rProducts = new ArrayList<RProduct>();
        for (Product product : products) {
            rProducts.add(new RProduct(product));
        }
        return rProducts;
    }

    //    获取我发布的商品
    public List<RProduct> queryMyPush(String sellerOpenid) {
        List<Product> products = productDao.getProductsBySellerOpenid(sellerOpenid);
        List<RProduct> rProducts = new ArrayList<RProduct>();
        for (Product product : products) {
            int id = product.getId();
            String productTittle = product.getProductTittle();
            int productPrice = product.getProductPrice();
            int state = product.getState();
            int starCounts = product.getStarCounts();
            Long sellerPhone = product.getSellerPhone();
            String productImgurl = product.getProductImgurl();
            Date createTime = product.getCreateTime();
            int productStock = product.getProductStock();
            rProducts.add(new RProduct(id, productTittle, productPrice, starCounts, sellerPhone, createTime, productImgurl, state, productStock));
        }
        return rProducts;
    }


    //    获取我卖出的商品
    public List<MineProduct> queryMySold(String sellerOpenid) {
        List<MineProduct> mineProducts = buyDao.getSoldProductsByOpenid(sellerOpenid);
        return mineProducts;
    }

    //    获取我买到的商品
    public List<MineProduct> queryMyBought(String buyerOpenid) {
        List<MineProduct> mineProducts = buyDao.getBoughtProductsByOpenid(buyerOpenid);
        return mineProducts;
    }

    public DoResult deleteProduct(int productId, String userOpenid) {
        try {
            int changeCount = productDao.deleteProduct(productId, userOpenid);
            if (changeCount > 0) {
                return new DoResult(true, "删除成功");
            } else {
                return new DoResult(false, "删除失败");
            }
        } catch (Exception e) {
            logger.error("删除product错误", e.getMessage());
            return new DoResult(false, "删除失败");
        }

    }
    
    //	  queryBySearch通过关键词搜索返回相应商品
    public List<RProduct> queryBySearch(String keyWord){
  	List<Product> products = new ArrayList<Product>();
  	products = productDao.queryBySearch(keyWord);
  	System.out.println(products.size());
    List<RProduct> rProducts = new ArrayList<RProduct>();
    for (Product product : products) {
        rProducts.add(new RProduct(product));
    }
    return rProducts;
}

    public DoResult changeState(int productId, String userOpenid) {
        int state = productDao.queryProductStateById(productId);
        if (state == 1) {
            productDao.changeProductState(productId, 2, userOpenid);
        } else if (state == 2) {
            productDao.changeProductState(productId, 1, userOpenid);
        } else {
            return new DoResult(false, "失败");
        }
        return new DoResult(true, "成功");
    }

    @Override
    public DoResult<Buy> getBuyInfoByOpenidandUid(int pid, String userId) {
        Buy buy = buyDao.getBuyInfoByOpenidandUid(pid, userId);
        if (buy != null) {
            return new DoResult<Buy>(true, buy);
        }
        return new DoResult<Buy>(false, "错误");
    }

}

