package com.xhm.fz.service;


import java.util.List;

import com.xhm.fz.dto.MoneyInfoParam;
import com.xhm.fz.dto.OrderDeliveryParam;
import com.xhm.fz.dto.OrderDetail;
import com.xhm.fz.dto.OrderQueryParam;
import com.xhm.fz.dto.ReceiverInfoParam;
import com.xhm.fz.entity.Order;

import org.springframework.transaction.annotation.Transactional;

/**
 * 订单管理Service
 * Created by xhm on 2018/10/11.
 */
public interface OrderService {
    /**
     * 订单查询
     */
    List<Order> list(OrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量发货
     */
    @Transactional
    int delivery(List<OrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     */
    @Transactional
    int close(List<Long> ids, String note);

    /**
     * 批量删除订单
     */
    int delete(List<Long> ids);

    /**
     * 获取指定订单详情
     */
    OrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     */
    @Transactional
    int updateReceiverInfo(ReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用信息
     */
    @Transactional
    int updateMoneyInfo(MoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);
}
