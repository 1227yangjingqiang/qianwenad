
package com.qianwenad.service.product.impl;

import com.qianwenad.common.mapper.BeanMapper;
import com.qianwenad.model.product.ProductArticle;
import com.qianwenad.service.product.ProductArticleService;
import com.qianwenad.storage.product.ProductArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductArticleServiceImpl implements ProductArticleService {

    @Autowired
    private ProductArticleRepository productArticleRepo;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productArticleRepo.deleteByPrimaryKey(id);
    }


    @Override
    public ProductArticle findByPrimaryKey(Long id) {
        return productArticleRepo.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(ProductArticle productArticle) {
        return productArticleRepo.updateByPrimaryKey(productArticle);
    }


    @Override
    public int updateByPrimaryKeySelective(ProductArticle productArticle) {
        return productArticleRepo.updateByPrimaryKeySelective(productArticle);
    }


    @Override
    public int create(ProductArticle productArticle) {
        return productArticleRepo.insert(productArticle);
    }


    @Override
    public int createSelective(ProductArticle productArticle) {
        return productArticleRepo.insertSelective(productArticle);
    }


    @Override
    public int selectCount(ProductArticle productArticle) {
        return productArticleRepo.selectCount(productArticle);
    }

    @Override
    public List<ProductArticle> selectPage(ProductArticle productArticle, Pageable pageable) {
        return productArticleRepo.selectPage(productArticle,pageable);
    }


}
