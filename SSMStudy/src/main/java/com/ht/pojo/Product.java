package com.ht.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/9/13.
 */
public class Product implements Serializable {

    private String id;
    private String name;
    private BigDecimal price;

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
}
