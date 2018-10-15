
package com.qianwenad.service.order.impl;

import com.qianwenad.model.order.OrderItem;
import com.qianwenad.service.order.OrderItemService;
import com.qianwenad.storage.order.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepo;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderItemRepo.deleteByPrimaryKey(id);
    }


    @Override
    public OrderItem findByPrimaryKey(Long id) {
        return orderItemRepo.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(OrderItem orderItem) {
        return orderItemRepo.updateByPrimaryKey(orderItem);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderItem orderItem) {
        return orderItemRepo.updateByPrimaryKeySelective(orderItem);
    }


    @Override
    public int create(OrderItem orderItem) {
        return orderItemRepo.insert(orderItem);
    }


    @Override
    public int createSelective(OrderItem orderItem) {
        return orderItemRepo.insertSelective(orderItem);
    }


    @Override
    public int selectCount(OrderItem orderItem) {
        return orderItemRepo.selectCount(orderItem);
    }


}
