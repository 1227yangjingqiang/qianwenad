package com.qianwenad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements Serializable{
	
	private Long id;
	private String userName;
	private String realName;
	private Integer sex;
	private Date birthday;
	private String email;
	private Long brandId;
	private String phoneNo;
	private Integer status;
	private Date createTime;

	private Integer page = 1;
	private Integer pageSize = 10;
}