package com.example.springbootdemo.entity;

import java.util.Date;

public class Product {
    private String pId;
    private String pname;
//    商品新旧程度
    private int level;
    private float price;
//    商品分类 1表示数码电子，2表示服饰鞋包，3表示二手图书，4表示生活百货，5表示水果生鲜，6表示其他
    private int category;
    private String pinfo;
    //是否下架 1表示上架 0表示下架
    private int display;
    private String image;
    private String sno;
//    发布用户学号
    private Date time;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
