package com.qianwenad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleRefVO implements Serializable{
	
	private Long id;
	private Long userId;
	private Long roleId;
	private Long createdBy;
	private Date createTime;
		
}