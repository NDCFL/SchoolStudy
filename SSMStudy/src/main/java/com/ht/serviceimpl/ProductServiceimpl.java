package com.ht.serviceimpl;

import com.ht.dao.ProductDAO;
import com.ht.pojo.Product;
import com.ht.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
@Service
public class ProductServiceimpl implements ProductService {
    @Resource
    private ProductDAO productDAO;
    @Override
    public Product queryById(String id) {
        return productDAO.queryById(id);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void add(Product product) {
        productDAO.add(product);
    }

    @Override
    public void delete(String id) {
        productDAO.delete(id);
    }

    @Override
    public List<Product> pagelist() {
        return productDAO.pagelist();
    }
    @Override
    public int count() {
        return 0;
    }
}
