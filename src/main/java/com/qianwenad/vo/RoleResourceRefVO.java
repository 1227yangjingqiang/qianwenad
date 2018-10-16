package com.qianwenad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResourceRefVO implements Serializable{
	
	private Long id;
	private Long roleId;
	private Long resourceId;
	private Date createTime;
	private Long createdBy;

	private Integer page = 1;
	private Integer pageSize = 10;
}