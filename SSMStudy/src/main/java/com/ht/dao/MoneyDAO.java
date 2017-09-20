package com.ht.dao;

import com.ht.pojo.Money;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */
@Repository
public interface MoneyDAO extends BaseDAO<String,Money> {

    double allMoney(String id);
    List<Money> findPageList(String id);
    void saleMoney(@Param("id") String id,@Param("money") double money);
}
