package com.ht.serviceimpl;

import com.ht.dao.MoneyDAO;
import com.ht.pojo.Money;
import com.ht.service.MoneyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */
@Service
public class MoneyServiceimpl implements MoneyService{
    @Resource
    protected MoneyDAO moneyDAO;
    public Money queryById(String id) {
        return moneyDAO.queryById(id);
    }

    public void update(Money money) {
        moneyDAO.update(money);
    }

    public void add(Money money) {
        moneyDAO.add(money);
    }

    public void delete(String id) {
        moneyDAO.delete(id);
    }

    public List<Money> pagelist() {
        return moneyDAO.pagelist();
    }

    public double allMoney(String id) {
        return moneyDAO.allMoney(id);
    }

    public List <Money> findPageList(String id) {
        return moneyDAO.findPageList(id);
    }

    public void saleMoney(String id, double money) {
        moneyDAO.saleMoney(id,money);
    }
    @Override
    public int count() {
        return 0;
    }
}
