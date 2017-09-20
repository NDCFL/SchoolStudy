package com.ht.serviceimpl;

import com.ht.dao.PropDAO;
import com.ht.pojo.Prop;
import com.ht.service.PropService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Service
public class PropServiceimpl implements PropService {
    @Resource
    private PropDAO propDAO;
    public Prop queryById(String id) {
        return propDAO.queryById(id);
    }

    public void update(Prop prop) {
        propDAO.update(prop);
    }

    public void add(Prop prop) {
        propDAO.add(prop);
    }

    public void delete(String id) {
        propDAO.delete(id);
    }

    public List<Prop> pagelist() {
        return propDAO.pagelist();
    }
    @Override
    public int count() {
        return 0;
    }
}
