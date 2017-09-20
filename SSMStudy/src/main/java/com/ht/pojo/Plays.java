package com.ht.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/15.
 */
public class Plays implements Serializable{
    private String playId;
    private String playNickname;
    private String playAccount;
    private String playPassword;
    private int playIsVip;

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public String getPlayNickname() {
        return playNickname;
    }

    public void setPlayNickname(String playNickname) {
        this.playNickname = playNickname;
    }

    public String getPlayAccount() {
        return playAccount;
    }

    public void setPlayAccount(String playAccount) {
        this.playAccount = playAccount;
    }

    public String getPlayPassword() {
        return playPassword;
    }

    public void setPlayPassword(String playPassword) {
        this.playPassword = playPassword;
    }

    public int getPlayIsVip() {
        return playIsVip;
    }

    public void setPlayIsVip(int playIsVip) {
        this.playIsVip = playIsVip;
    }
}
