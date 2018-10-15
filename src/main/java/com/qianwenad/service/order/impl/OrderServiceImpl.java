
package com.qianwenad.service.order.impl;

import com.qianwenad.model.order.Order;
import com.qianwenad.service.order.OrderService;
import com.qianwenad.storage.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderRepo.deleteByPrimaryKey(id);
    }


    @Override
    public Order findByPrimaryKey(Long id) {
        return orderRepo.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(Order order) {
        return orderRepo.updateByPrimaryKey(order);
    }


    @Override
    public int updateByPrimaryKeySelective(Order order) {
        return orderRepo.updateByPrimaryKeySelective(order);
    }


    @Override
    public int create(Order order) {
        return orderRepo.insert(order);
    }


    @Override
    public int createSelective(Order order) {
        return orderRepo.insertSelective(order);
    }

    @Override
    public int selectCount(Order order) {
        return orderRepo.selectCount(order);
    }


}
