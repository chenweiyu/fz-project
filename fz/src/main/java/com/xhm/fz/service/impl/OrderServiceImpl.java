package com.xhm.fz.service.impl;

import com.github.pagehelper.PageHelper;
import com.xhm.fz.dao.OrderDao;
import com.xhm.fz.dao.OrderOperateHistoryDao;
import com.xhm.fz.dto.*;
import com.xhm.fz.mapper.OrderMapper;
import com.xhm.fz.mapper.OrderOperateHistoryMapper;
import com.xhm.fz.entity.Order;
import com.xhm.fz.entity.OrderExample;
import com.xhm.fz.entity.OrderOperateHistory;
import com.xhm.fz.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单管理Service实现类
 * Created by xhm on 2018/10/11.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderOperateHistoryDao orderOperateHistoryDao;
    @Autowired
    private OrderOperateHistoryMapper orderOperateHistoryMapper;

    @Override
    public List<Order> list(OrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getList(queryParam);
    }

    @Override
    public int delivery(List<OrderDeliveryParam> deliveryParamList) {
        //批量发货
        int count = orderDao.delivery(deliveryParamList);
        //添加操作记录
        List<OrderOperateHistory> operateHistoryList = deliveryParamList.stream()
                .map(omsOrderDeliveryParam -> {
                    OrderOperateHistory history = new OrderOperateHistory();
                    history.setOrderId(omsOrderDeliveryParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        orderOperateHistoryDao.insertList(operateHistoryList);
        return count;
    }

    @Override
    public int close(List<Long> ids, String note) {
        Order record = new Order();
        record.setStatus(4);
        OrderExample example = new OrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        int count = orderMapper.updateByExampleSelective(record, example);
        List<OrderOperateHistory> historyList = ids.stream().map(orderId -> {
            OrderOperateHistory history = new OrderOperateHistory();
            history.setOrderId(orderId);
            history.setCreateTime(new Date());
            history.setOperateMan("后台管理员");
            history.setOrderStatus(4);
            history.setNote("订单关闭:"+note);
            return history;
        }).collect(Collectors.toList());
        orderOperateHistoryDao.insertList(historyList);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        Order record = new Order();
        record.setDeleteStatus(1);
        OrderExample example = new OrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        return orderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public OrderDetail detail(Long id) {
        return orderDao.getDetail(id);
    }

    @Override
    public int updateReceiverInfo(ReceiverInfoParam receiverInfoParam) {
        Order order = new Order();
        order.setId(receiverInfoParam.getOrderId());
        order.setReceiverName(receiverInfoParam.getReceiverName());
        order.setReceiverPhone(receiverInfoParam.getReceiverPhone());
        order.setReceiverPostCode(receiverInfoParam.getReceiverPostCode());
        order.setReceiverDetailAddress(receiverInfoParam.getReceiverDetailAddress());
        order.setReceiverProvince(receiverInfoParam.getReceiverProvince());
        order.setReceiverCity(receiverInfoParam.getReceiverCity());
        order.setReceiverRegion(receiverInfoParam.getReceiverRegion());
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        //插入操作记录
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(receiverInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(receiverInfoParam.getStatus());
        history.setNote("修改收货人信息");
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateMoneyInfo(MoneyInfoParam moneyInfoParam) {
        Order order = new Order();
        order.setId(moneyInfoParam.getOrderId());
        order.setFreightAmount(moneyInfoParam.getFreightAmount());
        order.setDiscountAmount(moneyInfoParam.getDiscountAmount());
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        //插入操作记录
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(moneyInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(moneyInfoParam.getStatus());
        history.setNote("修改费用信息");
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        Order order = new Order();
        order.setId(id);
        order.setNote(note);
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息："+note);
        orderOperateHistoryMapper.insert(history);
        return count;
    }
}
