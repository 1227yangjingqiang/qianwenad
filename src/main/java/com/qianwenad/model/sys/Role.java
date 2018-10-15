package com.qianwenad.model.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    public static final Integer AVAILABLE_ROLE = 1;
    public static final Integer UN_AVAILABLE_ROLE = 0;

    private Long id;
    private String cnName;
    private String enName;
    private String roleCode;
    private Integer status;
    private String remark;
    private Long createdBy;
    private Date createTime;
    private Long lastUpdatedBy;
    private Date updateTime;

}
















