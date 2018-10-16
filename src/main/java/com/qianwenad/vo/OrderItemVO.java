package com.qianwenad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemVO implements Serializable {

    private Long id;
    private Long orderId;
    private String orderSn;
    private Long orderGoodsId;
    private Long merchandiseNo;
    private Integer qty;
    private Integer backQty;
    private String sku;
    private Long brandId;
    private Long merItemNo;
    private String sn;
    private String sellPrice;
    private Integer goodsType;
    private Integer totalAomunt;
    private String goodsSubtotal;
    private String exActSubtotal;
    private String exCouponSubTotal;
    private String exPaySubtotal;
    private String exAllSubtotal;
    private Long orderType;
    private Date createTime;
    private Date updateTime;

}