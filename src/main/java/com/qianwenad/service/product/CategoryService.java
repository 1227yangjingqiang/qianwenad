package com.qianwenad.service.product;

import com.qianwenad.model.product.Category;

public interface CategoryService {

    public int create(Category category);

    public int createSelective(Category category);

    public Category findByPrimaryKey(Long id);

    public int updateByPrimaryKey(Category category);

    public int updateByPrimaryKeySelective(Category category);

    public int deleteByPrimaryKey(Long id);


    public int selectCount(Category category);

}