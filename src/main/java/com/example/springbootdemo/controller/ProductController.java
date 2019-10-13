package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Product;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.ProductSevice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductSevice productSevice;

    //@ResponseBody可以将list转为json
    @GetMapping("/product")
    public @ResponseBody List<Product> listProduct(){
        List<Product> products = productSevice.listProduct();
        return products;
    }




}
