
package com.qianwenad.service.product.impl;

import com.qianwenad.model.product.Sku;
import com.qianwenad.service.product.SkuService;
import com.qianwenad.storage.product.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuRepository skuRepo;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return skuRepo.deleteByPrimaryKey(id);
    }


    @Override
    public Sku findByPrimaryKey(Long id) {
        return skuRepo.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Sku sku) {
        return skuRepo.updateByPrimaryKey(sku);
    }


    @Override
    public int updateByPrimaryKeySelective(Sku sku) {
        return skuRepo.updateByPrimaryKeySelective(sku);
    }


    @Override
    public int create(Sku sku) {
        return skuRepo.insert(sku);
    }


    @Override
    public int createSelective(Sku sku) {
        return skuRepo.insertSelective(sku);
    }


    @Override
    public int selectCount(Sku sku) {
        return skuRepo.selectCount(sku);
    }


}
