package com.ht.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/15.
 */
public class Deal implements Serializable {
    private String dealId;
    private String dealBill;
    private String playId;
    private double dealPrice;
    private Plays plays;
    private Prop prop;

    public Plays getPlays() {
        return plays;
    }

    public void setPlays(Plays plays) {
        this.plays = plays;
    }

    public Prop getProp() {
        return prop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(double dealPrice) {
        this.dealPrice = dealPrice;
    }

    private String propId;
    private Date dealCreatetime;

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealBill() {
        return dealBill;
    }

    public void setDealBill(String dealBill) {
        this.dealBill = dealBill;
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }

    public Date getDealCreatetime() {
        return dealCreatetime;
    }

    public void setDealCreatetime(Date dealCreatetime) {
        this.dealCreatetime = dealCreatetime;
    }
}
