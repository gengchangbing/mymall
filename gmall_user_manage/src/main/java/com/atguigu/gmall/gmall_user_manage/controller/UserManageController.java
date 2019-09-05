package com.atguigu.gmall.gmall_user_manage.controller;

import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManageController {

    @Autowired
    UserManageService userManageService;
    @PostMapping("addUser")
    public  String addUser(UserInfo userInfo){

        userManageService.addUser(userInfo);
        return "success";

    }

    @GetMapping("AllUser")
    public List<UserInfo> getAllUser(){

        List<UserInfo> userImfolistAll = userManageService.getUserImfolistAll();
              return userImfolistAll;
    }

    @GetMapping("userInfo")
   public  UserInfo getUser(String id){

     UserInfo userInfo=userManageService.getuserInfo(id);
        return  userInfo;
   }

   @PostMapping("delUser")
   public String deleteUserInfo(String id ){

       userManageService.delUser(id);
       return "success";
   }

   public String updateUser(UserInfo userInfo){

       userManageService.updateUser(userInfo);
       return  "success";
   }

   public  String updateUserName(String name,UserInfo userInfo){

       userManageService.updateUserByName(name,userInfo);
       return "success";

   }

}
