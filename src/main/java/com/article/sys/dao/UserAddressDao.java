package com.article.sys.dao;

import com.article.sys.bean.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAddressDao {
    List<UserAddress> getAddressesByUserId(@Param("userid") Integer userid);
    int updateAddress(@Param("address") UserAddress address);
    int addAddress(@Param("address") UserAddress address);
    int deleteAddress(@Param("id") Integer id, @Param("userid") Integer userid);
    void clearDefaultAddress(@Param("userid") Integer userid);
}