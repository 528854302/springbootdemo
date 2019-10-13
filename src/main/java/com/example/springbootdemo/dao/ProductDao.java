package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    JdbcTemplate template;
    public List<Product> listProduct(){
        String sql="SELECT * FROM product";
        return template.query(sql,new BeanPropertyRowMapper<Product>(Product.class));
    }
}
