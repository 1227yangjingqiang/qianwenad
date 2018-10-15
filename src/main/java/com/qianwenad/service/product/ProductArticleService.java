
package com.qianwenad.service.product;

import com.qianwenad.model.product.ProductArticle;

public interface ProductArticleService {

    public int create(ProductArticle productArticle);

    public int createSelective(ProductArticle productArticle);

    public ProductArticle findByPrimaryKey(Long id);

    public int updateByPrimaryKey(ProductArticle productArticle);

    public int updateByPrimaryKeySelective(ProductArticle productArticle);

    public int deleteByPrimaryKey(Long id);


    public int selectCount(ProductArticle productArticle);

}