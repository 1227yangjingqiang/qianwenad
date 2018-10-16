package com.qianwenad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVO implements Serializable{
	
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