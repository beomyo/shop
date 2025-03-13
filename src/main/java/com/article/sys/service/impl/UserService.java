package com.article.sys.service.impl;

import com.article.sys.bean.User;
import com.article.sys.bean.UserAddress;
import com.article.sys.dao.UserDao;
import com.article.sys.dao.UserAddressDao;
import com.article.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public int updateBasic(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int updateAvatar(Integer userId, String imgurl) {
        return userDao.updateAvatar(userId, imgurl);
    }

    @Override
    public List<UserAddress> getUserAddresses(Integer userId) {
        return userAddressDao.getAddressesByUserId(userId);
    }

    @Override
    public int updateAddress(UserAddress address) {
        return userAddressDao.updateAddress(address);
    }

    @Override
    public int addAddress(UserAddress address) {
        return userAddressDao.addAddress(address);
    }

    @Override
    public int updatePassword(Integer userId, String oldPassword, String newPassword) {
        User user = userDao.getUserById(userId);
        if (user != null && user.getPassword().equals(oldPassword)) {
            return userDao.updatePassword(userId, newPassword);
        }
        return -1;
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
    @Override
    public int deleteAddress(Integer id, Integer userId) {
        return userAddressDao.deleteAddress(id, userId);
    }

    @Override
    public void clearDefaultAddress(Integer userId) {
        userAddressDao.clearDefaultAddress(userId);
    }

}