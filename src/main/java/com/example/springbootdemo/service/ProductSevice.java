package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.ProductDao;
import com.example.springbootdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSevice {
    @Autowired
    ProductDao productDao;

    public List<Product> findProduct(){
        return productDao.findProduct();
    }
}
