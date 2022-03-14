package com.xhm.fz.dto;

import com.xhm.fz.entity.Order;
import com.xhm.fz.entity.OrderItem;
import com.xhm.fz.entity.OrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * Created by xhm on 2018/10/11.
 */
public class OrderDetail extends Order {
    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OrderOperateHistory> historyList;
}
