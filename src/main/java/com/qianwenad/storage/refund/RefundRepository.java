package com.qianwenad.storage.refund;

import com.qianwenad.model.refund.Refund;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefundRepository {

    int deleteByPrimaryKey(Long id);

    Refund selectByPrimaryKey(Long id);


    int updateByPrimaryKey(Refund refund);

    int updateByPrimaryKeySelective(Refund refund);

    int insert(Refund refund);

    int insertSelective(Refund refund);


    int selectCount(Refund refund);

    List<Refund> selectPage(@Param("refund") Refund refund, @Param("pageable") Pageable pageable);

}