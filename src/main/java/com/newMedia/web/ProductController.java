package com.newMedia.web;

import com.newMedia.dto.BuyInfo;
import com.newMedia.dto.DoResult;
import com.newMedia.dto.ProductDetail;
import com.newMedia.dto.RProduct;
import com.newMedia.dto.WLogin;
import com.newMedia.entity.MessageBoard;
import com.newMedia.service.BuyPService;
import com.newMedia.service.MessageBoardService;
import com.newMedia.service.ProductInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private MessageBoardService messageBoardService;
    @Autowired
    private BuyPService buyPService;

    //    创建商品
    @RequestMapping(value = "/createProduct", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public DoResult createProduct(HttpSession httpSession, @RequestParam("productTittle") String productTittle, @RequestParam("productImgcounts") int productImgcounts, @RequestParam("productInfo") String productInfo, @RequestParam("productPrice") int productPrice, @RequestParam("productStock") int productStock, @RequestParam("sellerPhone") Long sellerPhone, @RequestParam("categoryId") int categoryId, @RequestParam("productImgurl") String productImgurl, @RequestParam("formId") String formId) {
        WLogin wLogin;
        wLogin = (WLogin) httpSession.getAttribute("WLogin");
        if (wLogin != null) {
            String openId = wLogin.getOpenId();
            return productInfoService.addProduct(productTittle, productImgcounts, productInfo, productPrice, productStock, sellerPhone, categoryId, openId, productImgurl, formId);
        } else {
            return new DoResult(false, "非法创建");
        }
    }

    //获取产品详情
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DoResult<ProductDetail> getProductById(@PathVariable("pid") int pid) {
        ProductDetail productDetail = productInfoService.getProductBypid(pid);
        return new DoResult<ProductDetail>(true, productDetail);
    }

    //    新建留言
    @RequestMapping(value = "/{pid}/createMessage", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public DoResult<List<MessageBoard>> createMessage(HttpSession httpSession, @PathVariable("pid") int pid, @RequestParam("nowTime") Date nowTime, @RequestParam("message") String message, @RequestParam("formId") String formId, @RequestParam("Respondent") String respondent) {
        WLogin wLogin = (WLogin) httpSession.getAttribute("WLogin");
        if (wLogin != null) {
            System.out.println(wLogin + httpSession.getId());
            String passengerId = wLogin.getOpenId();
            List<MessageBoard> messageBoards = messageBoardService.createMessage(passengerId, pid, message, nowTime, formId, respondent);
            return new DoResult<List<MessageBoard>>(true, messageBoards);
        } else {
            return new DoResult<List<MessageBoard>>(false, "空指针");
        }
    }

    //    购买商品
    @RequestMapping(value = "/{pid}/buy", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public DoResult<BuyInfo> buyProductById(HttpSession httpSession, @PathVariable("pid") int pid, @RequestParam("buyerPhone") Long buyerPhone, @RequestParam("buyerMessage") String buyerMessage, @RequestParam("receiveMethod") int receiveMethod, @RequestParam("payMethod") int payMethod) {
        WLogin wLogin = (WLogin) httpSession.getAttribute("WLogin");
        if (wLogin != null) {
            logger.debug(wLogin.getOpenId() + "购买商品:" + pid);
            System.out.println("购买断点一号----------");
            String buyerOpenid = wLogin.getOpenId();
            try {
                BuyInfo buyInfo = buyPService.buyProduct(pid, buyerPhone, buyerOpenid, buyerMessage, receiveMethod, payMethod);
                if (buyInfo.isState()) {
                    logger.debug(wLogin.getOpenId() + "购买商品:" + pid + "成功");
                    return new DoResult<BuyInfo>(true, buyInfo);
                } else {
                    logger.debug(wLogin.getOpenId() + "购买商品:" + pid + "失败");
                    return new DoResult<BuyInfo>(false, buyInfo);
                }
            } catch (Exception e) {
                logger.debug(wLogin.getOpenId() + "购买商品:" + pid + "失败" + e.getMessage());
                return new DoResult<BuyInfo>(false, "购买商品失败");
            }
        } else {
            return new DoResult<BuyInfo>(false, "购买商品失败");
        }
    }

    //    商品
    @RequestMapping(value = "/{pid}/delete", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public DoResult deleteProductById(HttpSession httpSession, @PathVariable("pid") int pid) {
        WLogin wLogin = (WLogin) httpSession.getAttribute("WLogin");
        if (wLogin != null) {
            String userOpenid = wLogin.getOpenId();
            try {
                return productInfoService.deleteProduct(pid, userOpenid);
            } catch (Exception e) {
                logger.error("删除商品错误={}", e.getMessage());
                return new DoResult(false, "删除商品失败");
            }
        } else {
            return new DoResult(false, "删除商品失败");
        }
    }


    //
    @RequestMapping(value = "/{pid}/changeS", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public DoResult changeStateById(HttpSession httpSession, @PathVariable("pid") int pid) {
        WLogin wLogin = (WLogin) httpSession.getAttribute("WLogin");
        if (wLogin != null) {
            String userOpenid = wLogin.getOpenId();
            try {
                return productInfoService.changeState(pid, userOpenid);
            } catch (Exception e) {
                logger.error("改变商品错误={}", e.getMessage());
                return new DoResult(false, "改变商品失败");
            }
        } else {
            return new DoResult(false, "改变商品失败");
        }
    }

    //
    @RequestMapping(value = "/{pid}/oInfo", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public DoResult getOInfo(HttpSession httpSession, @PathVariable("pid") int pid) {
        WLogin wLogin = (WLogin) httpSession.getAttribute("WLogin");
        if (wLogin != null) {
            String userOpenid = wLogin.getOpenId();
            try {
                return productInfoService.getBuyInfoByOpenidandUid(pid, userOpenid);
            } catch (Exception e) {
                logger.error("查看商品订单错误={}", e.getMessage());
                return new DoResult(false, "查看商品订单错误");
            }
        } else {
            return new DoResult(false, "查看商品订单错误");
        }
    }
    
    //queryBySearch
    @RequestMapping(value = "/queryBySearch",method = RequestMethod.GET, produces = "application/json;charset=utf8")
    @ResponseBody
    public List<RProduct> queryBySearch(String keyWord) {
    	List<RProduct> rProducts = new ArrayList<RProduct>();
    	rProducts = productInfoService.queryBySearch(keyWord);
    	System.out.println(rProducts.size());
    	return rProducts;
    }
}
