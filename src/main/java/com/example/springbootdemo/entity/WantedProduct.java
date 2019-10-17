package com.example.springbootdemo.entity;

import java.util.Date;

public class WantedProduct {
    private String id;
//    发布时间
    private Date time;
    private String pname;
    private String info;
    private float price;
//    发布者是否已购得该商品
    private int isbought;
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIsbought() {
        return isbought;
    }

    public void setIsbought(int isbought) {
        this.isbought = isbought;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
