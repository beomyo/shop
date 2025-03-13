package com.article.sys.interceptor;

import com.article.sys.bean.User;
import com.article.sys.util.SYS;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingLoginInterceptor implements HandlerInterceptor {
    //在Handler处理之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检查请求是否有登陆状态
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        //判断是否存在登陆数据
        if(user!=null){
            return true;
        }else{
            String path = request.getContextPath();
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            System.out.println("拦截器判定为未登录");
            response.sendRedirect(basePath+"shopping/login");
            return false;
        }

    }

    //在Handler处理之后立即执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //一个请求结束spring框架访问后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
