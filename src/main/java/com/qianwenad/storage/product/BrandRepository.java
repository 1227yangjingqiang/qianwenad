package com.qianwenad.storage.product;

import com.qianwenad.model.product.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author andy.yang
 * Date: 2018/10/11
 * Time: 10:34
 * Description:
 */
@Repository
public interface BrandRepository {
    int deleteByPrimaryKey(Long id);

    Brand selectByPrimaryKey(Long id);


    int updateByPrimaryKey(Brand brand);

    int updateByPrimaryKeySelective(Brand brand);

    int insert(Brand brand);

    int insertSelective(Brand brand);


    int selectCount(Brand brand);

    List<Brand> selectPage(@Param("brand") Brand brand, @Param("pageable") Pageable pageable);

}
