package com.newMedia.web;


import com.newMedia.dto.DoResult;
import com.newMedia.dto.NCUAdmin;
import com.newMedia.entity.Product;
import com.newMedia.service.adminService.AdminCheckService;
import com.newMedia.service.adminService.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/NCUAdmin")
public class NCUAdminController {


    @Autowired
    private AdminCheckService adminCheckService;
    @Autowired
    private AdminLoginService adminLoginService;

    //    登陆界面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }


    //    验证登录界面
    @RequestMapping(value = "/confirmLogin", method = RequestMethod.POST)
    public String confirmLogin(@RequestParam("adminNum") int adminNum, @RequestParam("password") String password, HttpSession httpSession, Model model) {
        try {

            Boolean isAdmin = adminLoginService.isPasswordCorrect(adminNum, password);
            if (isAdmin) {
                NCUAdmin ncuAdmin = new NCUAdmin(adminNum, password);
                httpSession.setAttribute("NCUAdmin", ncuAdmin);
                List<Product> products = adminCheckService.showProducts(0);
                model.addAttribute("products", products);
                System.out.println("index");
                return "/index";
            } else
                return "/login";
        } catch (Exception e) {
            return "/login";
        }
    }

    @RequestMapping(value = "/check/{pid}", method = RequestMethod.POST)
    @ResponseBody
    public DoResult checkProduct(@PathVariable("pid") int pid, @RequestParam("isPass") boolean isPass, @RequestParam("sellerOpenid") String sellerOpenid, HttpSession httpSession) {
        try {
            NCUAdmin ncuAdmin = (NCUAdmin) httpSession.getAttribute("NCUAdmin");
            int adminNum = ncuAdmin.getAdminNum();
            return adminCheckService.checkProducts(pid, adminNum, isPass, sellerOpenid);
        } catch (Exception e) {
            return new DoResult(false, "失败");
        }
    }

}
