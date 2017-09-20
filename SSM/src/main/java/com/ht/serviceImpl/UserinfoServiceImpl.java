package com.ht.serviceImpl;

import com.ht.mapping.UserinfoPO;
import com.ht.dao.UserinfoDAO;
import com.ht.service.UserinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/userinfoService")
public class UserinfoServiceImpl implements UserinfoService {

    @Resource
    private UserinfoDAO userinfoDAO;


    //查询用户列表
    @Override
    public List <UserinfoPO> getuserList(UserinfoPO userinfoPO) {
        List<UserinfoPO> userlist=userinfoDAO.userList(userinfoPO);
        return userlist;
    }

    @Override
    public String getaddUser(UserinfoPO po) {
        int i=userinfoDAO.addUser(po);
        String message="";
        if(i>0){
            message="添加成功";
        }else{
            message="添加失败";
        }
        return message;
    }

    @Override
    public String getUpdateUser(UserinfoPO po) {
        int i=userinfoDAO.updateUser(po);
        String message="";
        if(i>0){
            message="修改成功";
        }else{
            message="修改失败";
        }
        return message;
    }

    @Override
    public int getDeleteUser(int userid) {
        return userinfoDAO.deleteUser(userid);
    }

    @Override
    public List <UserinfoPO> getUserById(UserinfoPO po) {
        List<UserinfoPO> updateid=userinfoDAO.updateUserId(po);
        return updateid;
    }
}
