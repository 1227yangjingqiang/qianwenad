package com.qianwenad.model.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginLog {

    private Long id;
    private String userId;
    private String ip;
    private String userName;
    private String loginRemark;
    private Date createTime;
    private Date updateTime;

}
















