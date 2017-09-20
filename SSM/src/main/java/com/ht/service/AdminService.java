package com.ht.service;


import com.ht.mapping.Admin;

public interface AdminService {
    public void save(Admin admin);
    public Admin getByPhone(String phone);
}
