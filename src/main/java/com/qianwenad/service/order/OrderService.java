
package com.qianwenad.service.order;

import com.qianwenad.model.order.Order;

public interface OrderService {

    public int create(Order order);

    public int createSelective(Order order);

    public Order findByPrimaryKey(Long id);

    public int updateByPrimaryKey(Order order);

    public int updateByPrimaryKeySelective(Order order);

    public int deleteByPrimaryKey(Long id);

    public int selectCount(Order order);

}