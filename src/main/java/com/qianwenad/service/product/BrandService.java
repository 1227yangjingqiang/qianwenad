package com.qianwenad.service.product;

import com.qianwenad.model.product.Brand;

/**
 * Created with IntelliJ IDEA.
 * Author andy.yang
 * Date: 2018/10/11
 * Time: 10:10
 * Description:
 */
public interface BrandService {
    int create(Brand brand);

    int createSelective(Brand brand);

    Brand findByPrimaryKey(Long id);

    int updateByPrimaryKey(Brand brand);

    int updateByPrimaryKeySelective(Brand brand);

    int deleteByPrimaryKey(Long id);


    int selectCount(Brand Brand);
}
