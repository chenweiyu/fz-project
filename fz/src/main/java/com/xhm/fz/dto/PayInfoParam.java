package com.xhm.fz.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayInfoParam {
    @ApiModelProperty("订单ID")
    private Long orderId;

    @ApiModelProperty(value = "支付方式：0->未支付；1->支付宝；2->微信")
    private Integer payType;

    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单；6->已收货")
    private Integer status;

    @ApiModelProperty(value = "支付时间")
    private Date paymentTime;

    @ApiModelProperty(value = "订单类型：0->正常订单；1->秒杀订单；2->退款中的订单；3->退款成功的订单")
    private Integer orderType;
}
