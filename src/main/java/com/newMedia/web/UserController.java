package com.newMedia.web;

import com.newMedia.dto.AboutMe;
import com.newMedia.dto.DoResult;
import com.newMedia.dto.RProduct;
import com.newMedia.dto.WLogin;
import com.newMedia.entity.MineProduct;
import com.newMedia.service.AboutMeService;
import com.newMedia.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AboutMeService aboutMeService;
    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    @ResponseBody
    public DoResult<AboutMe> getUser(@PathVariable("userId") String userId, HttpSession httpSession) {
        System.out.println(httpSession.getId());
        WLogin wlogin = (WLogin) httpSession.getAttribute("WLogin");
        System.out.println(wlogin);
        try {
            String openId = wlogin.getOpenId();
            if (openId.equals(userId)) {
                AboutMe aboutMe = aboutMeService.getMyInfo(wlogin.getOpenId());
                return new DoResult<AboutMe>(true, aboutMe);
            } else {
                return new DoResult<AboutMe>(false, "无法获取个人信息");
            }
        } catch (Exception e) {
            return new DoResult<AboutMe>(false, "无法获取个人信息");
        }
    }

    @RequestMapping(value = "/pushed", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    @ResponseBody
    public DoResult<List<RProduct>> getAllMyPushedProducts(HttpSession httpSession) {
        WLogin wLogin = (WLogin) httpSession.getAttribute("WLogin");
        if (wLogin != null) {
            String openId = wLogin.getOpenId();
            List<RProduct> products = productInfoService.queryMyPush(openId);
            return new DoResult<List<RProduct>>(true, products);
        } else {
            return new DoResult<List<RProduct>>(false, "session为空，空指针");
        }
    }

    //    个人已售出商品
    @RequestMapping(value = "/sold", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    @ResponseBody
    public DoResult<List<MineProduct>> getAllMySoldProducts(HttpSession httpSession) {
        WLogin wLogin = (WLogin) httpSession.getAttribute("WLogin");
        if (wLogin != null) {
            String sellerId = wLogin.getOpenId();
            List<MineProduct> mineProducts = productInfoService.queryMySold(sellerId);
            return new DoResult<List<MineProduct>>(true, mineProducts);
        }
        return new DoResult<List<MineProduct>>(false, "获取购买信息错误");


    }

    //    个人已购买商品
    @RequestMapping(value = "/bought", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    @ResponseBody
    public DoResult<List<MineProduct>> getAllMyBoughtProducts(HttpSession httpSession) {
        WLogin wLogin = (WLogin) httpSession.getAttribute("WLogin");
        if (wLogin != null) {
            String sellerId = wLogin.getOpenId();
            List<MineProduct> rProducts = productInfoService.queryMyBought(sellerId);
            return new DoResult<List<MineProduct>>(true, rProducts);
        }
        return new DoResult<List<MineProduct>>(false, "获取购买信息错误");

    }
}
