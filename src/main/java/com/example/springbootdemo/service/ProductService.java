package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.ProductDao;
import com.example.springbootdemo.entity.PageBean;
import com.example.springbootdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.StartDocument;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public List<Product> listProduct(){
        return productDao.listProduct();
    }

    public int addProduct(Product product) {
        return productDao.insertProduct(product);
    }

    public List<Product> lunboProduct(int lunboProductNum) {
        int productNum = listProduct().size();
        if (productNum<lunboProductNum){
            return productDao.findProductsByCondition(0,productNum);
        }
        int start = new Random().nextInt(productNum)-lunboProductNum;
        if (start<0){
            start=0;
        }
        int end = start+lunboProductNum;
        return productDao.findProductsByCondition(start,end);
    }

    public List<Product> queryProductByPage(PageBean<Product> pageBean) {
        return productDao.queryProductByPage(pageBean);
    }

    public List<Product> findProductByPid(String pid) {
        return productDao.findProductByPid(pid);
    }
}
