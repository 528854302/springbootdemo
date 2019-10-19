package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Product;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.dao.UserDao;
import com.sun.org.apache.bcel.internal.generic.LUSHR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> findSellerByProduct(Product product) {
        return userDao.findSellerByPid(product.getSno());
    }

    public List<User> findUser(User user){
        return userDao.findUser(user.getSno(),user.getPassword());
    }


    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
