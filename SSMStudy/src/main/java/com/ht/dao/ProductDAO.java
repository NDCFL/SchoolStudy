package com.ht.dao;

import com.ht.pojo.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/13.
 */
@Repository
public interface ProductDAO extends BaseDAO<String,Product> {
}
