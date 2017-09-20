package com.ht.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/15.
 */
public class Prop implements Serializable{
    private String propId;
    private String propName;
    private double propPrice;
    private String propSkill;
    private int propGenre;

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public double getPropPrice() {
        return propPrice;
    }

    public void setPropPrice(double propPrice) {
        this.propPrice = propPrice;
    }

    public String getPropSkill() {
        return propSkill;
    }

    public void setPropSkill(String propSkill) {
        this.propSkill = propSkill;
    }

    public int getPropGenre() {
        return propGenre;
    }

    public void setPropGenre(int propGenre) {
        this.propGenre = propGenre;
    }
}
