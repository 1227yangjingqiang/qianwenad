package com.qianwenad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentVO implements Serializable {

    private Long id;
    private String orderSn;
    private String payMethod;
    private String payTransId;
    private String payChannel;
    private Integer payAmount;
    private String currency;
    private Integer payStatus;
    private Long brandId;
    private Date createTime;
    private Date updateTime;

}