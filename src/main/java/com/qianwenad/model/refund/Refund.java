package com.qianwenad.model.refund;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Refund {

    private Long id;
    private String orderSn;
    private Long shippingAmount;
    private String subTotal;
    private String discountAmount;
    private Integer discountDesc;
    private String refundReason;
    private String payMethod;
    private Integer status;
    private String payChannel;
    private Long brandId;
    private String saleChannel;
    private Date createTime;
    private Date updateTime;


}
















