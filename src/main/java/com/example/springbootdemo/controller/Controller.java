package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Product;
import com.example.springbootdemo.entity.User;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/*
页面跳转
 */
@org.springframework.stereotype.Controller
public class Controller {
//    @GetMapping("hello")
//    public String hello(@RequestParam(name = "name")String name, Model model){
//        model.addAttribute("name",name);
//        return "hello";
//    }

    //    跳转到主页
    @GetMapping("index")
    public String index(){
        return "index";
    }


    //    跳转到登录页面
    @GetMapping("login")
    public String login(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if ("username".equals(cookie.getName())){
                return "index";
            };
        }
        return "login";
    }

    //    跳转到首页
    @GetMapping("main")
    public String main(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if ("username".equals(cookie.getName())){
                return "index";
            };
        }
        return "login";
    }

    //    跳转到注册页面
    @GetMapping("/signup")
    public String signup(HttpServletRequest request, HttpServletResponse response){

        return "signup";
    }


    //
    @GetMapping("/toUploadProduct")
    public String toLoadUpProduct(HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            model.addAttribute("msg","请先登录后重试!");
            return "login";
        }

        return "uploadproduct";
    }




    @GetMapping("test")
    public String string(HttpServletRequest request) throws FileNotFoundException {

        String path = new File(ResourceUtils.getURL("classpath:").getPath())+"\\static\\pimage\\";
        System.out.println(path);

        return "test";
    }


}
