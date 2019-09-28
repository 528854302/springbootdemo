package com.example.springbootdemo.controller;

import com.example.springbootdemo.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

//    跳转到登录页面
    @GetMapping("login")
    public String login(){
        return "login";
    }

//    验证用户身份信息
    @RequestMapping(value = "checkUser",method = RequestMethod.POST)
    public String check(String username,String password){
        User user=new User();
        user.setUserName(username);
        user.setPassword(password);
        if (userService.findUser(user).size()>0){
            return "loginsuccess";
        }
        return "failed";
    }
}
