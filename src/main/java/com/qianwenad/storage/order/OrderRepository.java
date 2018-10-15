package com.qianwenad.storage.order;

import com.qianwenad.model.order.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {

    int deleteByPrimaryKey(Long id);

    Order selectByPrimaryKey(Long id);


    int updateByPrimaryKey(Order order);

    int updateByPrimaryKeySelective(Order order);

    int insert(Order order);

    int insertSelective(Order order);


    int selectCount(Order order);

    List<Order> selectPage(@Param("order") Order order, @Param("pageable") Pageable pageable);

}