package com.ht.serviceImpl;

import com.ht.mapping.Admin;
import com.ht.common.CommonBusiness;
import com.ht.dao.AdminDAO;
import com.ht.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService{

    /**
     * @Resource此注解默认按照名称注入，如果没有名称，再按照类型注入
     *
     * @Autowired注解默认按类型注入
     *
     * 如果把注解放在属性上，则破坏了类的封装性，因为使用了Java反射，没有用set方法
     */
    @Resource
    private AdminDAO adminDAO;

    @Resource
    private CommonBusiness commonBusiness;


    public void save(Admin admin) {
        //TODO 调用dao保存到数据库
        commonBusiness.log();
        adminDAO.save(admin);
    }

    public Admin getByPhone(String phone){
        return adminDAO.getByPhone(phone);
    }
}
