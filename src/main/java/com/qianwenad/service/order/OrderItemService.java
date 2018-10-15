
package com.qianwenad.service.order;

import com.qianwenad.model.order.OrderItem;

public interface OrderItemService {

    public int create(OrderItem orderItem);

    public int createSelective(OrderItem orderItem);

    public OrderItem findByPrimaryKey(Long id);

    public int updateByPrimaryKey(OrderItem orderItem);

    public int updateByPrimaryKeySelective(OrderItem orderItem);

    public int deleteByPrimaryKey(Long id);


    public int selectCount(OrderItem orderItem);

}