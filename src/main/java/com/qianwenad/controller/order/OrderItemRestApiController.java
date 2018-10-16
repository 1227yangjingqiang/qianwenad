package com.qianwenad.controller.order;

import com.qianwenad.common.ApiResponse;
import com.qianwenad.service.order.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderItemRestApiController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getOrderItemById(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(orderItemService.findByPrimaryKey(id)), HttpStatus.OK);
    }

}
