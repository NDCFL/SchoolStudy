package com.ht.serviceimpl;

import com.ht.dao.DealDAO;
import com.ht.pojo.Deal;
import com.ht.service.DealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Service
public class DealServiceimpl implements DealService {
    @Resource
    private DealDAO dealDAO;
    public Deal queryById(String id) {
        return dealDAO.queryById(id);
    }

    public void update(Deal deal) {
        dealDAO.update(deal);
    }

    public void add(Deal deal) {
        dealDAO.add(deal);
    }

    public void delete(String id) {
        dealDAO.delete(id);
    }

    public List<Deal> pagelist() {
        return dealDAO.pagelist();
    }

    @Override
    public int count() {
        return 0;
    }

    public List <Deal> findpagelist(String id) {
        return dealDAO.findpagelist(id);
    }
}
