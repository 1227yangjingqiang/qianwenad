
package com.qianwenad.service.product.impl;

import com.qianwenad.model.product.Category;
import com.qianwenad.service.product.CategoryService;
import com.qianwenad.storage.product.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return categoryRepo.deleteByPrimaryKey(id);
    }


    @Override
    public Category findByPrimaryKey(Long id) {
        return categoryRepo.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(Category category) {
        return categoryRepo.updateByPrimaryKey(category);
    }

    @Override
    public int updateByPrimaryKeySelective(Category category) {
        return categoryRepo.updateByPrimaryKeySelective(category);
    }


    @Override
    public int create(Category category) {
        return categoryRepo.insert(category);
    }


    @Override
    public int createSelective(Category category) {
        return categoryRepo.insertSelective(category);
    }


    @Override
    public int selectCount(Category category) {
        return categoryRepo.selectCount(category);
    }


}
