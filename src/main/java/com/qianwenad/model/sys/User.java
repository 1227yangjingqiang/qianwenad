package com.qianwenad.model.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

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
}
















