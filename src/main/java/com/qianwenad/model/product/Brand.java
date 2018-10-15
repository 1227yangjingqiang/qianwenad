package com.qianwenad.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: andy.yang
 * Date: 2018/10/11
 * Time: 10:12
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    private Long id;
    private String brandName;
    private String brandCode;
    private String brandDesc;
    private Integer brandType;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
