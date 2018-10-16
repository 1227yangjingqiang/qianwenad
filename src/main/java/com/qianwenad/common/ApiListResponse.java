package com.qianwenad.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author: andy.yang
 * Date: 2018/10/16
 * Time: 14:04
 * Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiListResponse<T>  {
    private Integer count;
    private T list;
}
