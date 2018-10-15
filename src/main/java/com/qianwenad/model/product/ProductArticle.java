package com.qianwenad.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductArticle {

    private Long id;
    private Long productId;
    private String productName;
    private String articleType;
    private Long categoryId;
    private Long brandId;
    private String title;
    private String subTitle;
    private String content;
    private Integer type;
    private Integer status;
    private String imageUrl;
    private Long createdBy;
    private Long updatedBy;
    private Date createTime;
    private Date updateTime;


}
















