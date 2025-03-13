package com.article.sys.dao;

import com.article.sys.bean.User;
import com.article.sys.bean.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    User getUserByUsername(@Param("username") String username);

    int doRegister(@Param("nickname") String nickname, @Param("username") String username,
                   @Param("tel") String tel, @Param("password") String password);

    User doIflogin(@Param("username") String username);
    User getUserById(@Param("Id") int  id);

    int updateUser(@Param("user") User user);

    int updateAvatar(@Param("userId") Integer userId, @Param("imgurl") String imgurl);

    int updatePassword(@Param("userId") Integer userId, @Param("newPassword") String newPassword);

    int Logintime(@Param("username") String username);
    List<UserAddress> getAddressesByUserId(@Param("userid") Integer userid);
}