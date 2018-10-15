package com.qianwenad.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long orderId;
    private String orderSn;
    private Long userId;
    private String userName;
    private String source;
    private Integer platform;
    private String orderSourceType;
    private Date orderDate;
    private Date orderUpdateTime;
    private Integer orderStatus;
    private Date orderStatusUpdateTime;
    private Integer orderType;
    private Integer isSpecial;
    private Integer payId;
    private Integer payType;
    private Integer payStatus;
    private String currency;
    private String moneyPaid;
    private String moneyRemaining;
    private String walletMoneyPaid;
    private String walletMoneyRemaining;
    private String exDiscountType;
    private String exDiscountMoneyPaid;
    private String exDiscountMoneyRemaining;
    private String endType;
    private Date payTime;
    private Date createTime;
    private Date updateTime;

}
















