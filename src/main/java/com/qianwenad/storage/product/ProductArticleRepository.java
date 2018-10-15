package com.qianwenad.storage.product;

import com.qianwenad.model.product.ProductArticle;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductArticleRepository {

    int deleteByPrimaryKey(Long id);

    ProductArticle selectByPrimaryKey(Long id);


    int updateByPrimaryKey(ProductArticle productArticle);

    int updateByPrimaryKeySelective(ProductArticle productArticle);

    int insert(ProductArticle productArticle);

    int insertSelective(ProductArticle productArticle);


    int selectCount(ProductArticle productArticle);

    List<ProductArticle> selectPage(@Param("productArticle") ProductArticle productArticle, @Param("pageable") Pageable pageable);

}