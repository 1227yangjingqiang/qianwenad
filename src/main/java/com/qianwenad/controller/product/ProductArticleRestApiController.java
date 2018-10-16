package com.qianwenad.controller.product;

import com.qianwenad.common.ApiResponse;
import com.qianwenad.common.mapper.AutoMapper;
import com.qianwenad.model.product.ProductArticle;
import com.qianwenad.service.product.ProductArticleService;
import com.qianwenad.vo.ProductArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductArticleRestApiController {


    @Autowired
    private ProductArticleService productArticleService;


    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getProductArticleById(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.ok(productArticleService.findByPrimaryKey(id)), HttpStatus.OK);
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getProductArticleList(ProductArticleVO productArticleVO) {
        ProductArticle pr = new ProductArticle();
        AutoMapper.mapping(productArticleVO, pr);
        List<ProductArticle> productArticles = productArticleService.selectPage(pr, new PageRequest(productArticleVO.getPage() - 1, productArticleVO.getPageSize()));
        return new ResponseEntity<>(ApiResponse.ok(productArticles), HttpStatus.OK);
    }

}
