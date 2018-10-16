package com.qianwenad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuVO implements Serializable{
	
	private Long id;
	private String sku;
	private String spu;
	private String imageUrl;
	private Long brandId;
	private BigDecimal price;
	private BigDecimal marketPrice;
	private BigDecimal discount;
	private Integer visibility;
	private Integer status;
	private Integer onSale;
	private Date createTime;
	private Date updateTime;
		
}