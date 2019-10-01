package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserService userService;

//    验证用户身份信息
    @RequestMapping(value = "checkUser",method = RequestMethod.POST)
    public String check(String username, String password, Model model){


        User user=new User();
        user.setUserName(username);
        user.setPassword(password);
        if (userService.findUser(user).size()>0){
            return "index";
        }
        model.addAttribute("msg", "用户名或密码错误请重试！");
        return "login";
    }
}
