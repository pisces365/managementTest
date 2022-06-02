package com.xiangliban.managementsystem.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/09/13:41
 * @Description:
 */
@Component
public class CrossInterceptor implements HandlerInterceptor {

    private static final String METHOD_OPTIONS = "OPTIONS";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        //跨域 Header
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Expose-Headers", "*");
        // 浏览器是会先发一次options请求，如果请求通过，则继续发送正式的post请求
        // 配置options的请求返回
        if (request.getMethod().equals(METHOD_OPTIONS)) {
            response.setStatus(HttpStatus.OK.value());
            response.getWriter().write("OPTIONS returns OK");
            return false;
        }
        return true;
    }
}
