package com.qianwenad.storage.product;

import com.qianwenad.model.product.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    int deleteByPrimaryKey(Long id);

    Category selectByPrimaryKey(Long id);


    int updateByPrimaryKey(Category category);

    int updateByPrimaryKeySelective(Category category);

    int insert(Category category);

    int insertSelective(Category category);


    int selectCount(Category category);

    List<Category> selectPage(@Param("category") Category category, @Param("pageable") Pageable pageable);

}