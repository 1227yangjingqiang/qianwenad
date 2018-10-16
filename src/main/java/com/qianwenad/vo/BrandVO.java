package com.qianwenad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandVO implements Serializable {
    private Long id;
    private String brandName;
    private String brandCode;
    private String brandDesc;
    private Integer brandType;
    private Integer status;
    private Date createTime;
    private Date updateTime;

}