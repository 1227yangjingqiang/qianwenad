
package com.qianwenad.service.product;

import com.qianwenad.model.product.Sku;

public interface SkuService {

    public int create(Sku sku);

    public int createSelective(Sku sku);

    public Sku findByPrimaryKey(Long id);

    public int updateByPrimaryKey(Sku sku);

    public int updateByPrimaryKeySelective(Sku sku);

    public int deleteByPrimaryKey(Long id);


    public int selectCount(Sku sku);

}