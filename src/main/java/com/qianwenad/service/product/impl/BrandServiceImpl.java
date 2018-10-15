package com.qianwenad.service.product.impl;

import com.qianwenad.model.product.Brand;
import com.qianwenad.service.product.BrandService;
import com.qianwenad.storage.product.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Author: andy.yang
 * Date: 2018/10/11
 * Time: 10:10
 * Description:
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandStorage;

    public int create(Brand brand) {
        return brandStorage.insert(brand);
    }

    public int createSelective(Brand brand) {
        return brandStorage.insertSelective(brand);
    }

    public Brand findByPrimaryKey(Long id) {
        return brandStorage.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(Brand brand) {
        return brandStorage.updateByPrimaryKey(brand);
    }

    public int updateByPrimaryKeySelective(Brand brand) {
        return brandStorage.updateByPrimaryKeySelective(brand);
    }

    public int deleteByPrimaryKey(Long id) {
        return brandStorage.deleteByPrimaryKey(id);
    }

    public int selectCount(Brand brand) {
        return brandStorage.selectCount(brand);
    }
}
