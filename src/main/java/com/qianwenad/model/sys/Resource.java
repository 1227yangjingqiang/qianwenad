package com.qianwenad.model.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    public static final Integer AVAILABLE_RESOURCE = 1;
    public static final Integer UN_AVAILABLE_RESOURCE = 0;

    private Long id;
    private String cnName;
    private String enName;
    private String displayName;
    private Long pid;
    private String resourceCode;
    private Integer orderNo;
    private String resourceUrl;
    private Integer resourceType;
    private Integer status;
    private String remark;
    private Long createdBy;
    private Date createTime;
    private Long lastUpdatedBy;
    private Date updateTime;

}
















