

CREATE TABLE `user_login_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(30) NOT NULL DEFAULT '' COMMENT '用户id',
  `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '登录ip',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '登录ip',
  `login_remark` varchar(100) NOT NULL DEFAULT '' COMMENT '登录备注',
  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  index `idx_user_login_log_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='顾问登录日志';



CREATE TABLE `qw_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
  `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单ID',
  `order_sn` varchar(50) NOT NULL DEFAULT '' COMMENT '订单号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户id',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `source` varchar(100) NOT NULL DEFAULT '' COMMENT '订单来源',
  `platform` int(10) NOT NULL DEFAULT 0 COMMENT '平台标识',
  `order_source_type` varchar(50) NOT NULL DEFAULT '' COMMENT '订单来源类型 0:正常下单 1:换货订单 2:修改订单 3:合并订单 5.拆单引擎生成子单6.上门揽换订单',
  `order_date` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '下单时间',
  `order_update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '订单最后更新时间',
  `order_status` int(4) NOT NULL DEFAULT 0 COMMENT '订单状态',
  `order_status_update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '订单状态更新时间',
  `order_type` int(11) NOT NULL DEFAULT 0 COMMENT '订单类型',
  `is_special` int(11) NOT NULL DEFAULT 0 COMMENT '订单特殊标志：0-正常， 1-异常',
  `pay_id` int(11) NOT NULL DEFAULT 0 COMMENT '支付ID(预付订单中生效)',
  `pay_type` int(11) NOT NULL DEFAULT 0 COMMENT '支付方式',
  `pay_status` int(4) NOT NULL DEFAULT 0 COMMENT '支付状态',
  `currency` varchar(50) NOT NULL DEFAULT 'CNY' COMMENT '标识订单的货币种类，默认CNY',
  `money_paid` varchar(100) NOT NULL DEFAULT '' COMMENT '订单支付金额',
  `money_remaining` varchar(100) NOT NULL DEFAULT '' COMMENT '订单支付金额剩余额',
  `wallet_money_paid` varchar(100) NOT NULL DEFAULT '' COMMENT '账户余额支付金额',
  `wallet_money_remaining` varchar(100) NOT NULL DEFAULT '' COMMENT '账户余额支付金额剩余额',
  `ex_discount_type` varchar(100) NOT NULL DEFAULT '' COMMENT '额外优惠',
  `ex_discount_money_paid` varchar(100) NOT NULL DEFAULT '' COMMENT '额外优惠金额',
  `ex_discount_money_remaining` varchar(100) NOT NULL DEFAULT '' COMMENT '额外优惠金额剩余额',
  `end_type` varchar(20) NOT NULL DEFAULT '1' COMMENT '订单状态同步类型，1-未结束，需要继续去同步，2-签收后15天等待期，3-订单已结束，可进行最终结算',
  `pay_time` timestamp NULL DEFAULT '2000-01-01 00:00:00' COMMENT '支付时间，（单位为秒）',
  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  index `idx_qw_order_order_sn` (`order_sn`),
  index `idx_qw_order_user_id` (`user_id`),
   index `idx_qw_order_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='原始订单表';

CREATE TABLE `qw_order_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
  `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单ID',
  `order_sn` varchar(50) NOT NULL DEFAULT '' COMMENT '订单号',
  `order_goods_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单商品ID',
  `merchandise_no` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品ID',
  `qty` int(11) NOT NULL DEFAULT 0 COMMENT '商品数量，(amount=totalAmount-退回数量-换货数量)',
  `back_qty` int(11) NOT NULL DEFAULT 0 COMMENT '退回数量',
  `sku` varchar(100) NOT NULL DEFAULT '' COMMENT '商品SKU',
  `brand_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品牌id,对应：brand_id',
  `mer_item_no` bigint(20) NOT NULL DEFAULT 0 COMMENT '档期、专场的SKU id(对应：size_id)',
  `sn` varchar(50) NOT NULL DEFAULT '' COMMENT '条码',
  `sell_price` varchar(50) NOT NULL DEFAULT '' COMMENT '商品售价',
  `goods_type` int(11) NOT NULL DEFAULT 0 COMMENT '商品类型，0 普通商品 1 赠品 5加价购 6套装商品 7套装子商品',
  `total_aomunt` int(11) NOT NULL DEFAULT 0 COMMENT '购买商品总数量',
  `goods_subtotal` varchar(50) NOT NULL DEFAULT '' COMMENT '商品价格小计',
  `ex_act_subtotal` varchar(50) NOT NULL DEFAULT '' COMMENT '活动优惠(单件)',
  `ex_coupon_sub_total` varchar(50) NOT NULL DEFAULT '' COMMENT '支付优惠(单件)',
  `ex_pay_subtotal` varchar(50) NOT NULL DEFAULT '' COMMENT '支付优惠(单件)',
  `ex_all_subtotal` varchar(50) NOT NULL DEFAULT '' COMMENT '优惠总金额（单件）',
  `order_type` bigint(20) NOT NULL DEFAULT 1 COMMENT '订单类型：1-正常单 2-退款单(废弃，请别用该字段)',
  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  index `idx_order_item_order_sn` (`order_sn`),
  index `idx_order_item_merchandise_no` (`merchandise_no`),
  index `idx_order_item_sku` (`sku`),
   index `idx_order_item_goods_type` (`goods_type`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='原始订单详情';



CREATE TABLE `qw_payment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
  `order_sn` varchar(50) NOT NULL DEFAULT '' COMMENT '订单号',
  `pay_method` varchar(20) NOT NULL DEFAULT 0 COMMENT '支付方式',
  `pay_trans_id` varchar(50) NOT NULL DEFAULT '' COMMENT '交易流水id',
  `pay_channel` varchar(100) NOT NULL DEFAULT '' COMMENT '支付渠道',
  `pay_amount` int(10) NOT NULL DEFAULT 0 COMMENT '支付金额',
  `currency` varchar(50) NOT NULL DEFAULT '' COMMENT '币种',
  `pay_status` int(4) NOT NULL DEFAULT 0 COMMENT '退款单状态',
  `brand_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品牌id',
  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  index `idx_qw_payment_order_sn` (`order_sn`),
  index `idx_qw_payment_pay_channel` (`pay_channel`),
  index  `idx_qw_payment_brand_id` (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='支付帐单';




CREATE TABLE `qw_refund` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
  `order_sn` varchar(50) NOT NULL DEFAULT '' COMMENT '订单号',
  `shipping_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '运费',
  `sub_total` varchar(50) NOT NULL DEFAULT '' COMMENT '小计',
  `discount_amount` varchar(100) NOT NULL DEFAULT '' COMMENT '折扣金额',
  `discount_desc` int(10) NOT NULL DEFAULT 0 COMMENT '折扣描述',
  `refund_reason` varchar(200) NOT NULL DEFAULT '' COMMENT '退款原因',
  `pay_method` varchar(20) NOT NULL DEFAULT 0 COMMENT '支付方式',
  `status` int(4) NOT NULL DEFAULT 0 COMMENT '退款单状态',
  `pay_channel` varchar(100) NOT NULL DEFAULT '' COMMENT '支付渠道',
  `brand_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品牌id',
  `sale_channel` varchar(100) NOT NULL DEFAULT '' COMMENT '销售渠道',
  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  index `idx_qw_refund_order_sn` (`order_sn`),
  index `idx_qw_refund_sale_channel` (`sale_channel`),
  index  `idx_qw_refund_brand_id` (`brand_id`),
  index  `idx_qw_refund_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='原始退款单';



CREATE TABLE `qw_category` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`category_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '分类名称',
	`category_code` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '分类代码',
	`category_desc` VARCHAR(255) NULL DEFAULT '' COMMENT '商品描述',
	`category_type` INT(6) NOT NULL DEFAULT 0 COMMENT '分类类型',
	`pid` BIGINT(20) NOT NULL DEFAULT 0  COMMENT '父分类id',
	`brand_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '品牌id',
	`status` int(4) NOT NULL DEFAULT 0 COMMENT '分类状态',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录修改时间',
	PRIMARY KEY (`id`),
	INDEX `idx_qw_category_category_code` (`category_code`),
	INDEX `idx_qw_category_pid` (`pid`),
	INDEX `idx_qw_category_brand_id` (`brand_id`),
	INDEX `idx_qw_category_status` (`status`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='分类表';


CREATE TABLE `qw_product` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '商品名称',
	`spu` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '商品spu',
	`image_url` VARCHAR(255) NULL DEFAULT '' COMMENT '商品图片url',
	`product_type` INT(6) NOT NULL DEFAULT 0 COMMENT '商品类型0: 普通商品,1:赠品,2:自由赠,3:换购商品,4:捆绑销售商品,5:礼品）s',
	`brand_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品牌id',
	`warehouse` varchar(50) NOT NULL DEFAULT '' COMMENT '仓库代码',
	`price` decimal(16,2) NOT NULL DEFAULT 0.00 COMMENT '价格',
	`market_price` decimal(16,2) NOT NULL DEFAULT 0.00 COMMENT '市场价格',
    `discount` decimal(16,2) NOT NULL DEFAULT 0.00 COMMENT '折扣',
    `visibility` INT(4) NOT NULL DEFAULT 1 COMMENT '是否显示 1:显示 0:不显示',
	`status` INT(6) NOT NULL DEFAULT 1 COMMENT '0:禁用，1:启用',
	`on_sale` INT(6) NOT NULL DEFAULT 1 COMMENT '商品是否在售 1：在售 2：待售',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录修改时间',
	PRIMARY KEY (`id`),
	INDEX `idx_qw_product_brand_id` (`brand_id`),
	INDEX `idx_qw_product_spu` (`spu`),
	INDEX `idx_qw_product_status` (`status`),
	INDEX `idx_qw_product_on_sale` (`on_sale`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品表';

CREATE TABLE `qw_sku` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`sku` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '商品名称',
	`spu` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '商品spu',
	`image_url` VARCHAR(255) NULL DEFAULT '' COMMENT '商品图片url',
	`brand_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品牌id',
	`price` decimal(16,2) NOT NULL DEFAULT 0.00 COMMENT '价格',
	`market_price` decimal(16,2) NOT NULL DEFAULT 0.00 COMMENT '市场价格',
    `discount` decimal(16,2) NOT NULL DEFAULT 0.00 COMMENT '折扣',
    `visibility` INT(4) NOT NULL DEFAULT 1 COMMENT '是否显示 1:显示 0:不显示',
	`status` INT(6) NOT NULL DEFAULT 1 COMMENT '0:禁用，1:启用',
	`on_sale` INT(6) NOT NULL DEFAULT 1 COMMENT '商品是否在售 1：在售 2：待售',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录修改时间',
	PRIMARY KEY (`id`),
	INDEX `idx_qw_product_brand_id` (`brand_id`),
	INDEX `idx_qw_product_spu` (`spu`),
	INDEX `idx_qw_product_sku` (`sku`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品表';



CREATE TABLE `qw_product_article` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`product_id` BIGINT(20) NOT NULL COMMENT '商品主键',
	`product_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '商品名称',
	`article_type` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '文章类型',
	`category_id` bigint(20) NULL DEFAULT 0 COMMENT '分类id',
	`brand_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品牌id',
	`title` VARCHAR(255)  NOT NULL DEFAULT '' COMMENT '标题',
	`sub_title` VARCHAR(255)  NOT NULL DEFAULT '' COMMENT '副标题',
	`content`VARCHAR(255)  NOT NULL DEFAULT '' COMMENT '文章内容',
	`type` INT(4) NOT NULL DEFAULT 0 COMMENT '文章类型',
	`status` INT(6) NOT NULL DEFAULT 1 COMMENT '文章状态：0:禁用，1:启用',
	`image_url` varchar(255) NOT NULL DEFAULT '' COMMENT '文章内的图片路径',
	`created_by` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
	`updated_by` bigint(20) NOT NULL DEFAULT 0 COMMENT '最后更新人',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录修改时间',
	PRIMARY KEY (`id`),
	INDEX `idx_qw_product_article_brand_id` (`brand_id`),
	INDEX `idx_qw_product_article_title` (`title`),
	INDEX `idx_qw_product_type` (`type`),
	INDEX `idx_qw_product_status` (`status`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品物料表，应用于文章系统';

CREATE TABLE `qw_brand` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`brand_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '品牌名称',
	`brand_code` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '品牌代码',
	`brand_desc` VARCHAR(255) NULL DEFAULT '' COMMENT '品牌描述',
	`brand_type` INT(6) NOT NULL DEFAULT 1 COMMENT '1:餐饮 2:娱乐',
	`status` INT(4) NOT NULL DEFAULT 1 COMMENT '0:禁用，1:启用',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录修改时间',
	PRIMARY KEY (`id`),
	INDEX `idx_qw_brand_brand_code` (`brand_code`),
	INDEX `idx_qw_brand_brand_name` (`brand_name`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='品牌表';

CREATE TABLE `sys_resource` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`cn_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '中文名称',
	`en_name` VARCHAR(255) NULL DEFAULT '' COMMENT '英文名称',
	`display_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '显示名称',
	`pid` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '父级ID,0:最顶层元素',
	`resource_code` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '资源代码',
	`order_no` INT(11) NOT NULL DEFAULT 0 COMMENT '序号',
	`resource_url` VARCHAR(255) NULL DEFAULT '' COMMENT '资源路径',
	`resource_type` INT(6) NOT NULL DEFAULT 0 COMMENT '0:菜单,1:页面按钮,2:接口',
	`status` INT(4) NOT NULL DEFAULT 1 COMMENT '0:禁用，1:启用',
	`remark` VARCHAR(255) NULL DEFAULT '' COMMENT '备注',
	`created_by` BIGINT(20) NULL DEFAULT 0 COMMENT '创建者',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	`last_updated_by` BIGINT(20) NULL DEFAULT 0 COMMENT '修改者',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录修改时间',
	PRIMARY KEY (`id`),
	INDEX `idx_sys_resource_resource_code` (`resource_code`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统资源表';


CREATE TABLE `sys_role` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`cn_name` VARCHAR(255)  NOT NULL DEFAULT '' COMMENT '中文名称',
	`en_name` VARCHAR(255) NULL DEFAULT '' COMMENT '英文名称',
	`role_code` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '角色代码',
	`status` INT(4) NOT NULL DEFAULT 0 COMMENT '0:禁用，1:启用',
	`remark` VARCHAR(255) NULL DEFAULT '' COMMENT '备注',
	`created_by` BIGINT(20) NULL DEFAULT 0 COMMENT '创建者',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	`last_updated_by` BIGINT(20) NULL DEFAULT 0 COMMENT '修改者',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录修改时间',
	PRIMARY KEY (`id`),
	INDEX `idx_sys_role_role_code` (`role_code`),
	INDEX `idx_sys_role_cn_name` (`cn_name`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统角色表';



CREATE TABLE `sys_role_resource_ref` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`role_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '角色ID',
	`resource_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '资源ID',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	`created_by` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建者',
	PRIMARY KEY (`id`),
	INDEX `idx_sys_role_resource_ref_role_id` (`role_id`),
	INDEX `idx_sys_role_resource_ref_resource_id` (`resource_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='角色资源表';


CREATE TABLE `sys_user` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`user_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '登录名',
	`real_name` VARCHAR(255) NULL DEFAULT '' COMMENT '真实姓名',
	`sex` INT(2) NULL DEFAULT 0 COMMENT '性别：0-女,1-男',
	`birthday` TIMESTAMP NULL DEFAULT '2000-01-01 00:00:00' COMMENT '生日',
	`email` VARCHAR(255) NULL DEFAULT '' COMMENT '邮件地址',
	`brand_id` BIGINT(20) NOT NULL DEFAULT 0  COMMENT '品牌id',
	`phone_no` VARCHAR(32) NULL DEFAULT '' COMMENT '手机号',
	`status` INT(4) NOT NULL DEFAULT 1 COMMENT '用户状态：0:禁用，1:启用',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	PRIMARY KEY (`id`),
	INDEX `idx_sys_user_brand_id` (`brand_id`),
	INDEX `idx_sys_user_status` (`status`),
	INDEX `idx_sys_user_user_name` (`user_name`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统用户表';


CREATE TABLE `sys_user_role_ref` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`user_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '用户ID',
	`role_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '角色ID',
	`created_by` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建者',
	`create_time` TIMESTAMP NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '记录创建时间',
	PRIMARY KEY (`id`),
	INDEX `idx_sys_user_role_ref_user_id` (`user_id`),
	INDEX `idx_sys_user_role_ref_role_id` (`role_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

