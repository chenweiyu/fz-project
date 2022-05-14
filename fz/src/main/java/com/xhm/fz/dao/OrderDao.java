package com.xhm.fz.dao;

import com.xhm.fz.dto.OrderDeliveryParam;
import com.xhm.fz.dto.OrderDetail;
import com.xhm.fz.dto.OrderQueryParam;
import com.xhm.fz.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单查询自定义Dao
 * Created by xhm on 2018/10/12.
 */
public interface OrderDao {
    /**
     * 条件查询订单
     */
    List<Order> getList(@Param("queryParam") OrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OrderDetail getDetail(@Param("id") Long id);

    List<OrderDetail> getUserOrder(@Param("userId") Integer userId);
}
