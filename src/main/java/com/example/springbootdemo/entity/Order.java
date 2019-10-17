package com.example.springbootdemo.entity;

import java.util.Date;

public class Order {
    private String id;
    private Date time;
//    订单状态1表示未付款，2表示待发货，3表示待买家确认收货，4订单交易完成
    private Integer state;
    private User user;
    private Product product;
//    订单价格总计
    private float total;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
