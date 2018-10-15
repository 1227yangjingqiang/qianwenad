package com.qianwenad.model.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResourceRef {

    private Long id;
    private Long roleId;
    private Long resourceId;
    private Date createTime;
    private Long createdBy;

}
















