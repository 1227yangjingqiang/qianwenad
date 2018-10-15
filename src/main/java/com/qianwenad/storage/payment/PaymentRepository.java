package com.qianwenad.storage.payment;

import com.qianwenad.model.paymet.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository {

    int deleteByPrimaryKey(Long id);

    Payment selectByPrimaryKey(Long id);


    int updateByPrimaryKey(Payment payment);

    int updateByPrimaryKeySelective(Payment payment);

    int insert(Payment payment);

    int insertSelective(Payment payment);


    int selectCount(Payment payment);

    List<Payment> selectPage(@Param("payment") Payment payment, @Param("pageable") Pageable pageable);

}