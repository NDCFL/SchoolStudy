package com.ht.service;

import com.ht.pojo.Money;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */
public interface MoneyService extends  BaseService<String,Money> {
    double allMoney(String id);
    List<Money> findPageList(String id);
    void saleMoney(String id, double money);
}
