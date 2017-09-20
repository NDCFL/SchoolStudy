package com.ht.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
public class Orders implements Serializable{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List <OrdersItems> getOrdersItemsList() {
        return ordersItemsList;
    }

    public void setOrdersItemsList(List <OrdersItems> ordersItemsList) {
        this.ordersItemsList = ordersItemsList;
    }

    private  String id;
    private  String name;
    private BigDecimal price;
    private  String  userId;
    private Date createTime;
    private User user;
    private List<OrdersItems> ordersItemsList;


}
