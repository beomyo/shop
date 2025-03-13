package com.article.sys.service;

import com.article.sys.bean.User;
import com.article.sys.bean.UserAddress;

import java.util.List;

public interface IUserService {
    int updateBasic(User user);
    int updateAvatar(Integer userId, String imgurl);
    List<UserAddress> getUserAddresses(Integer userId);
    int updateAddress(UserAddress address);
    int addAddress(UserAddress address);
    int updatePassword(Integer userId, String oldPassword, String newPassword);
    User getUserById(int id);
    int deleteAddress(Integer id, Integer userId);
    void clearDefaultAddress(Integer userId);

}