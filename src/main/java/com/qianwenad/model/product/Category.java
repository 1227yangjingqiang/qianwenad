package com.qianwenad.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Long id;
    private String categoryName;
    private String categoryCode;
    private String categoryDesc;
    private Integer categoryType;
    private Long pid;
    private Long brandId;
    private Integer status;
    private Date createTime;
    private Date updateTime;


}
















