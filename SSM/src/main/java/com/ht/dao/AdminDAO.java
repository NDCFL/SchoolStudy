package com.ht.dao;


import com.ht.mapping.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO {
    public void save(Admin admin);
    public Admin getByPhone(String phone);
}
