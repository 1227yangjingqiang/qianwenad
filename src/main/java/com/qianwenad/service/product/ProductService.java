
package com.qianwenad.service.product;

import com.qianwenad.model.product.Product;

public interface ProductService {

    public int create(Product product);

    public int createSelective(Product product);

    public Product findByPrimaryKey(Long id);

    public int updateByPrimaryKey(Product product);

    public int updateByPrimaryKeySelective(Product product);

    public int deleteByPrimaryKey(Long id);


    public int selectCount(Product product);

}