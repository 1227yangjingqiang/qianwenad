package com.qianwenad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginLogVO implements Serializable{
	
	private Long id;
	private String userId;
	private String ip;
	private String userName;
	private String loginRemark;
	private Date createTime;
	private Date updateTime;
}