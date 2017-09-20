package com.ht.dao;

import com.ht.pojo.Deal;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Repository
public interface DealDAO extends  BaseDAO<String,Deal> {

    List<Deal> findpagelist(String id);
}
