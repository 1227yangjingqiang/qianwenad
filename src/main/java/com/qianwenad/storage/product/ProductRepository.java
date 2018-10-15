package com.qianwenad.storage.product;

import com.qianwenad.model.product.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    int deleteByPrimaryKey(Long id);

    Product selectByPrimaryKey(Long id);


    int updateByPrimaryKey(Product product);

    int updateByPrimaryKeySelective(Product product);

    int insert(Product product);

    int insertSelective(Product product);


    int selectCount(Product product);

    List<Product> selectPage(@Param("product") Product product, @Param("pageable") Pageable pageable);

}