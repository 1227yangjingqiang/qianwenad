
package com.qianwenad.service.refund;

import com.qianwenad.model.refund.Refund;

public interface RefundService {

    public int create(Refund refund);

    public int createSelective(Refund refund);

    public Refund findByPrimaryKey(Long id);

    public int updateByPrimaryKey(Refund refund);

    public int updateByPrimaryKeySelective(Refund refund);

    public int deleteByPrimaryKey(Long id);


    public int selectCount(Refund refund);

}