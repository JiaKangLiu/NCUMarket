package com.newMedia.web;

import com.newMedia.dto.RProduct;
import com.newMedia.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class WCategoryController {

    //通过category获取services
    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<RProduct> getServicesByCategoryId(@PathVariable("categoryId") int categoryId, @RequestParam("offset") int offset, @RequestParam("sort") int sort) {

//        当sort为0时按照时间排序，当sort为1时按照热度排序，当category<0时获取全部商品
        List<RProduct> rProducts;
        if (categoryId > 0) {
            if (sort < 1) {
                rProducts = productInfoService.getProductsByCategoryIdandTime(categoryId, 10, offset);
            } else {
                rProducts = productInfoService.getProductsByCategoryIdandstar(categoryId, 10, offset);
            }
        } else {
            if (sort < 1) {
                rProducts = productInfoService.queryAllByTime(10, offset);
            } else {
                rProducts = productInfoService.queryAllByStar(10, offset);
            }
        }
        return rProducts;
    }
}
