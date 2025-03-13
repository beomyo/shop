package com.article.sys.controller;

import com.article.sys.bean.User;
import com.article.sys.bean.UserAddress;
import com.article.sys.service.IShoppingLoginService;
import com.article.sys.service.IUserService;
import com.article.sys.util.LayuiData;
import com.article.sys.util.SYS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IShoppingLoginService loginService;

    @Autowired
    private IUserService userService;

    @PostMapping("updateBasic")
    @ResponseBody
    public int updateBasic(@RequestBody User userUpdate, HttpSession session) {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser == null) return 0;
        currentUser.setImgurl(userUpdate.getImgurl());
        currentUser.setNickname(userUpdate.getNickname());
        currentUser.setTel(userUpdate.getTel());
        return userService.updateBasic(currentUser);
    }

    @PostMapping("updateAvatar")
    @ResponseBody
    public int updateAvatar(@RequestParam String imgurl, HttpSession session) {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser != null) {
            return userService.updateAvatar(currentUser.getId(), imgurl);
        }
        return 0;
    }

    @GetMapping("getAddresses")
    @ResponseBody
    public LayuiData getAddresses(HttpSession session) {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser != null) {
            List<UserAddress> addresses = userService.getUserAddresses(currentUser.getId());
            return new LayuiData(addresses.size(), addresses);
        }
        return new LayuiData();
    }

    // 在 UserController.java 中添加
    @PostMapping("deleteAddress")
    @ResponseBody
    public int deleteAddress(@RequestParam Integer id, HttpSession session) {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser != null) {
            return userService.deleteAddress(id, currentUser.getId());
        }
        return 0;
    }

    // 修改 addAddress 方法，添加地址数量检查
    @PostMapping("addAddress")
    @ResponseBody
    public int addAddress(@RequestBody UserAddress address, HttpSession session) {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser != null) {
            List<UserAddress> existingAddresses = userService.getUserAddresses(currentUser.getId());
            if (existingAddresses.size() >= 6) {
                return -2; // 表示达到地址上限
            }
            address.setUserid(currentUser.getId());
            // 如果设为默认地址，先取消其他默认地址
            if (address.getIsdefault() == 1) {
                userService.clearDefaultAddress(currentUser.getId());
            }
            return userService.addAddress(address);
        }
        return 0;
    }

    // 修改 updateAddress 方法，确保默认地址唯一性
    @PostMapping("updateAddress")
    @ResponseBody
    public int updateAddress(@RequestBody UserAddress address, HttpSession session) {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser != null) {
            address.setUserid(currentUser.getId());
            if (address.getIsdefault() == 1) {
                userService.clearDefaultAddress(currentUser.getId());
            }
            return userService.updateAddress(address);
        }
        return 0;
    }

    @PostMapping("updatePassword")
    @ResponseBody
    public int updatePassword(@RequestBody Map<String, String> passwordData, HttpSession session) {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser == null) return 0;
        String oldPassword = passwordData.get("oldPassword");
        String newPassword = passwordData.get("newPassword");
        return userService.updatePassword(currentUser.getId(), oldPassword, newPassword);
    }
}