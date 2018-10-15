
package com.qianwenad.service.payment;

import com.qianwenad.model.paymet.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public int createSelective(Payment payment);

    public Payment findByPrimaryKey(Long id);

    public int updateByPrimaryKey(Payment payment);

    public int updateByPrimaryKeySelective(Payment payment);

    public int deleteByPrimaryKey(Long id);


    public int selectCount(Payment payment);

}