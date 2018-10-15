package com.qianwenad.storage.order;

import com.qianwenad.model.order.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository {

    int deleteByPrimaryKey(Long id);

    OrderItem selectByPrimaryKey(Long id);


    int updateByPrimaryKey(OrderItem orderItem);

    int updateByPrimaryKeySelective(OrderItem orderItem);

    int insert(OrderItem orderItem);

    int insertSelective(OrderItem orderItem);


    int selectCount(OrderItem orderItem);

    List<OrderItem> selectPage(@Param("orderItem") OrderItem orderItem, @Param("pageable") Pageable pageable);

}