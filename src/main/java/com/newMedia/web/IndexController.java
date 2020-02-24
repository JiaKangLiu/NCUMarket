package com.newMedia.web;

import com.newMedia.dto.DoResult;
import com.newMedia.dto.Index;
import com.newMedia.service.WIndexInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WIndexInfoService wIndexInfoService;

    // 主页
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DoResult<Index> viewIndex(Model model, HttpSession httpSession) {
        try {
            Index index = wIndexInfoService.getIndex();
            return new DoResult<Index>(true, index);
        } catch (Exception e) {
            logger.error("首页错误={}", e.getMessage());
            return new DoResult<Index>(false, "首页获取失败");
        }
    }


}
