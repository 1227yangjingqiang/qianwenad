package com.qianwenad.controller.product;

import com.qianwenad.common.ApiResponse;
import com.qianwenad.service.product.ProductService;
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
@RequestMapping("/product")
public class ProductRestApiController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(productService.findByPrimaryKey(id)), HttpStatus.OK);
    }
}
