package com.ht.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */
public class Page<T> implements Serializable {
    private int totalCount;
    private List<T> Result;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List <T> getResult() {
        return Result;
    }

    public void setResult(List <T> result) {
        Result = result;
    }
}
