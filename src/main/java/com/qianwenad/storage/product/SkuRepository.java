package com.qianwenad.storage.product;

import com.qianwenad.model.product.Sku;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuRepository {

    int deleteByPrimaryKey(Long id);

    Sku selectByPrimaryKey(Long id);


    int updateByPrimaryKey(Sku sku);

    int updateByPrimaryKeySelective(Sku sku);

    int insert(Sku sku);

    int insertSelective(Sku sku);


    int selectCount(Sku sku);

    List<Sku> selectPage(@Param("sku") Sku sku, @Param("pageable") Pageable pageable);

}