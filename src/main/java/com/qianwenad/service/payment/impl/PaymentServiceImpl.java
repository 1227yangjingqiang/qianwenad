
package com.qianwenad.service.payment.impl;

import com.qianwenad.model.paymet.Payment;
import com.qianwenad.service.payment.PaymentService;
import com.qianwenad.storage.payment.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return paymentRepo.deleteByPrimaryKey(id);
    }


    @Override
    public Payment findByPrimaryKey(Long id) {
        return paymentRepo.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Payment payment) {
        return paymentRepo.updateByPrimaryKey(payment);
    }


    @Override
    public int updateByPrimaryKeySelective(Payment payment) {
        return paymentRepo.updateByPrimaryKeySelective(payment);
    }


    @Override
    public int create(Payment payment) {
        return paymentRepo.insert(payment);
    }


    @Override
    public int createSelective(Payment payment) {
        return paymentRepo.insertSelective(payment);
    }


    @Override
    public int selectCount(Payment payment) {
        return paymentRepo.selectCount(payment);
    }


}
