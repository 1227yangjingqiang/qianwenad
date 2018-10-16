package com.qianwenad.controller.product;

import com.qianwenad.common.ApiResponse;
import com.qianwenad.service.product.CategoryService;
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
@RequestMapping("/category")
public class CategoryRestApiController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(categoryService.findByPrimaryKey(id)), HttpStatus.OK);
    }

}
