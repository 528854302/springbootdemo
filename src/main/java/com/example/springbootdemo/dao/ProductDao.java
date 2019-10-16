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

    public int insertProduct(Product product) {
        String sql = "INSERT INTO product(pid,pname,level,price,category,pinfo,display,Image,time,sno) VALUES (?,?,?,?,?,?,?,?,?,?)";
        return template.update(sql,product.getpId(),product.getPname(),product.getLevel(),
                product.getPrice(),product.getCategory(),product.getPinfo(),product.getDisplay(),
                product.getImage(),product.getTime(),product.getUser().getSno());
    }

    public List<Product> findProductsByCondition(int start, int end) {
        String sql = "SELECT * FROM product LIMIT ?,?";
        return template.query(sql,new BeanPropertyRowMapper<Product>(Product.class),
               start,end);
    }
}
