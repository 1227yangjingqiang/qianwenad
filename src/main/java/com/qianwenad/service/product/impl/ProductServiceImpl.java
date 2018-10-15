
package com.qianwenad.service.product.impl;

import com.qianwenad.model.product.Product;
import com.qianwenad.service.product.ProductService;
import com.qianwenad.storage.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productRepo.deleteByPrimaryKey(id);
    }


    @Override
    public Product findByPrimaryKey(Long id) {
        return productRepo.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Product product) {
        return productRepo.updateByPrimaryKey(product);
    }


    @Override
    public int updateByPrimaryKeySelective(Product product) {
        return productRepo.updateByPrimaryKeySelective(product);
    }


    @Override
    public int create(Product product) {
        return productRepo.insert(product);
    }


    @Override
    public int createSelective(Product product) {
        return productRepo.insertSelective(product);
    }


    @Override
    public int selectCount(Product product) {
        return productRepo.selectCount(product);
    }


}
