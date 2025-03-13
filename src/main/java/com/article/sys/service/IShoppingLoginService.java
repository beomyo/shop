package com.article.sys.service;

import com.article.sys.bean.User;

public interface IShoppingLoginService {
    User dologin(User user);
    int doregister(String nickname, String username, String tel, String password);
    User iflogin(String username);

    void Logintime(String username);

    User getUserByUsername(String username);
}