package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Product;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.ProductService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    //@ResponseBody可以将list转为json
    @GetMapping("/product")
    public @ResponseBody List<Product> listProduct(){
        List<Product> products = productService.listProduct();
        return products;
    }
    //发布商品
    @RequestMapping("/uploadProduct")
    public String uploadProduct(
            @RequestParam("img") MultipartFile img,
            String pname,
            String level,
            String price,
            String category,
            String pinfo,
            String sno,
            Model model,HttpServletRequest request) throws IOException {

        if (pname==null || price==null || img==null){
            model.addAttribute("msg","请输入完整信息");
            return "uploadproduct";
        }
        String path = new File(ResourceUtils.getURL("classpath:").getPath()).toString()+"\\static\\pimage\\";
        String originalImgname=img.getOriginalFilename();
        String imgType = originalImgname.substring(originalImgname.lastIndexOf("."));
        String imgName="pimg"+new Date().getTime()+imgType;
        if (!imgType.equalsIgnoreCase(".jpg") && !imgType.equalsIgnoreCase(".png")){
            model.addAttribute("msg","请重试,图片格式必须为.jpg或.png");
            return "uploadproduct";
        }
        File uploadImg = new File(path+imgName );
        img.transferTo(uploadImg);

        //上传数据库
        Product product=new Product();
        Long pid = new Date().getTime()+new Random().nextInt(1000);
        product.setpId(pid.toString() );
        product.setCategory(Integer.parseInt(category));
        product.setPname(pname);
        product.setDisplay(1);
        product.setLevel(Integer.parseInt(level));
        product.setPinfo(pinfo);
        product.setTime(new Date());
        product.setImage("pimage/"+imgName);
        product.setPrice(Float.parseFloat(price));
        User user=new User();
        user.setSno(sno);
        product.setUser(user);
        if (productService.addProduct(product)>0){
            model.addAttribute("msg","添加商品成功");
            return "info";
        }else {
            model.addAttribute("msg","添加商品操作失败，请重试");
            return "info";
        }
    }





}
