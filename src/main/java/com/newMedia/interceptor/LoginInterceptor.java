package com.newMedia.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

//       请求到NCUAdmin
        if (request.getServletPath().startsWith("/NCUAdmin/")) {
            if (request.getSession().getAttribute("NCUAdmin") != null && request.getSession().getAttribute("WLogin") == null) {
                return true;
            }
        }
        //2、TODO 比如退出、首页等页面无需登录，即此处要放行 允许游客的请求

        //3、如果用户已经登录 放行
        if ((request.getSession().getAttribute("WLogin") != null)) {
            //更好的实现方式的使用cookie
            return true;
        }

        //4、非法请求 即这些请求需要登录后才能访问
        //重定向到登录页面
        response.sendRedirect("/NCUMarket/registry/createUser");
        return false;
    }
}
