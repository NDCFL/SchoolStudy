package com.ht.serviceimpl;

import com.ht.dao.PlaysDAO;
import com.ht.pojo.Plays;
import com.ht.service.PlaysService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Service
public class PlaysServiceimpl implements PlaysService {
    @Resource
    private PlaysDAO playsDAO;
    public Plays queryById(String id) {
        return playsDAO.queryById(id);
    }

    public void update(Plays plays) {
        playsDAO.update(plays);
    }

    public void add(Plays plays) {
        playsDAO.add(plays);
    }

    public void delete(String id) {
        playsDAO.delete(id);
    }

    public List<Plays> pagelist() {
        return playsDAO.pagelist();
    }
    @Override
    public int count() {
        return 0;
    }
    public Plays findplays(String playAccount) {
        return playsDAO.findplays(playAccount);
    }
}
