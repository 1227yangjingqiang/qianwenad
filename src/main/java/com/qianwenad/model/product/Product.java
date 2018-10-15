package com.qianwenad.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String spu;
    private String imageUrl;
    private Integer productType;
    private Long brandId;
    private String warehouse;
    private BigDecimal price;
    private BigDecimal marketPrice;
    private BigDecimal discount;
    private Integer visibility;
    private Integer status;
    private Integer onSale;
    private Date createTime;
    private Date updateTime;


}
















