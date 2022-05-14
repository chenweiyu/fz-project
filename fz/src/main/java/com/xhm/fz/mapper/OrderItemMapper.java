package com.xhm.fz.mapper;

import java.util.List;

import com.xhm.fz.entity.OrderItem;

public interface OrderItemMapper {
    int insert(OrderItem orderItem);

    int insertBatchOrderItem(List<OrderItem> orderItem);
}
