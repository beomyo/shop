package com.article.sys.controller;

import com.article.sys.bean.User;
import com.article.sys.bean.UserAddress;
import com.article.sys.service.IShoppingLoginService;
import com.article.sys.util.LayuiData;
import com.article.sys.util.SYS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    IShoppingLoginService loginService;


    @RequestMapping("shopping/dologin")
    @ResponseBody
    public String shoppingLogin(User user, HttpSession session) {
        User u = loginService.dologin(user);
        if (u != null) {
            loginService.Logintime(user.getUsername());
            session.setAttribute(SYS.SHOPPING_LOGIN_USER, u);

            // 判断是否为管理员
            if ("admin".equals(u.getUsername())) {
                return "admin"; // 返回admin表示需要跳转到管理员页面
            }
            return "success";
        }
        return "fail";
    }

    @RequestMapping("shopping/logout")
    @ResponseBody
    public int logout(HttpSession session) {
        //执行登录业务
        session.removeAttribute(SYS.SHOPPING_LOGIN_USER);
        return 1;
    }

    @RequestMapping("shopping/doregister")
    @ResponseBody
    public int doregister(String nickname, String username, String tel, String password) {
        User u= loginService.getUserByUsername(username);
        if(u==null){
            return loginService.doregister(nickname, username, tel, password);

        }else return -1;


    }

    @RequestMapping("shopping/iflogin")
    @ResponseBody
    public User iflogin(HttpSession session) {
        User u = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (u != null) {
            String username = u.getUsername();
            return loginService.iflogin(username);
        } else return null;


    }


}
