package com.ht.serviceimpl;

import com.ht.dao.UserDAO;
import com.ht.pojo.User;
import com.ht.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
@Service
public class UserServiceTest implements UserService{
    @Resource
    private UserDAO userDAO;
    @Override
    public User queryById(String id) {
        return userDAO.queryById(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(String id) {
        userDAO.delete(id);
    }

    @Override
    public List<User> pagelist() {
        return userDAO.pagelist();
    }
    @Override
    public int count() {
        return 0;
    }
}
