
package com.qianwenad.service.refund.impl;

import com.qianwenad.model.refund.Refund;
import com.qianwenad.service.refund.RefundService;
import com.qianwenad.storage.refund.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundRepository refundRepo;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return refundRepo.deleteByPrimaryKey(id);
    }


    @Override
    public Refund findByPrimaryKey(Long id) {
        return refundRepo.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(Refund refund) {
        return refundRepo.updateByPrimaryKey(refund);
    }


    @Override
    public int updateByPrimaryKeySelective(Refund refund) {
        return refundRepo.updateByPrimaryKeySelective(refund);
    }


    @Override
    public int create(Refund refund) {
        return refundRepo.insert(refund);
    }


    @Override
    public int createSelective(Refund refund) {
        return refundRepo.insertSelective(refund);
    }

    @Override
    public int selectCount(Refund refund) {
        return refundRepo.selectCount(refund);
    }


}
