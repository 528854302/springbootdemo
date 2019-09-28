package com.example.springbootdemo.service;

import com.example.springbootdemo.User;
import com.example.springbootdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public List<User> findUser(User user){
        return userDao.findUser(user.getUserName(),user.getPassword());
    }
}
