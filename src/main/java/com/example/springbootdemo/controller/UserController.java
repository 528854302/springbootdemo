package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

//    验证用户身份信息
    @RequestMapping(value = "checkUser",method = RequestMethod.POST)
    public String check(String sno, String password,Model model,
                        HttpServletRequest request,
            HttpServletResponse response, boolean isRememberMe){
        User user=new User();
        user.setSno(sno);
        user.setPassword(password);
        List<User> users = userService.findUser(user);
        if (users.size()>0){
            if (isRememberMe){
                Cookie cookie = new Cookie("username",users.get(0).getSno());
                cookie.setMaxAge(60*60*6);
                response.addCookie(cookie);
            }
            request.getSession().setAttribute("user",users.get(0));

            return "index";
        }
        model.addAttribute("msg", "用户名或密码错误请重试！");
        return "login";
    }

    //    退出登录
    @RequestMapping(value = "logout")
    public String logout( HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if ("username".equals(cookie.getName())){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            };
        }
        request.getSession().removeAttribute("user");
        return "/login";
    }

//    注册
    @GetMapping("/signupUser")
    public String signupUser( HttpServletRequest request,HttpServletResponse response){

        return "index";
    }


}
