package com.article.sys.service.impl;

import com.article.sys.bean.User;
import com.article.sys.dao.UserDao;
import com.article.sys.service.IShoppingLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IShoppingLoginServce implements IShoppingLoginService {
    @Autowired
    UserDao userDao;
    @Override
    public User dologin(User user) {
        User user_data=userDao.getUserByUsername(user.getUsername());
        if(user_data!=null&&user.getPassword().equals(user_data.getPassword())){
            return user_data;
        }
        return null;
    }

    @Override
    public int doregister(String nickname, String username, String tel, String password) {
        return userDao.doRegister(nickname,username,tel,password);
    }

    @Override
    public User iflogin(String username) {
        return userDao.doIflogin(username);
    }

    @Override
    public void Logintime(String username) {
       userDao.Logintime(username);
    }
    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
