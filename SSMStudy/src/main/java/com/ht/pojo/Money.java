package com.ht.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/16.
 */
public class Money implements Serializable {
    private String moneyId;
    private Double money;
    private String playId;
    private Plays plays;

    public String getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(String moneyId) {
        this.moneyId = moneyId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public Plays getPlays() {
        return plays;
    }

    public void setPlays(Plays plays) {
        this.plays = plays;
    }
}
