package com.ht.service;

import com.ht.mapping.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 使用Spring与Junit集成的测试，此测试框架可以导入spring的配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ImportResource(value = {"/WEB-INF/config/spring-context.xml", "/WEB-INF/config/spring-mybatis.xml"})
public class AdminServiceTest {

    @Resource
    private AdminService adminService;

    @Test
    public void testSave() {
        Admin admin = new Admin();
        admin.setPhone("18888888888");
        admin.setPassword("123456");
        adminService.save(admin);
    }
}
