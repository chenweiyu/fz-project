package com.xhm.fz.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.github.pagehelper.PageHelper;
import com.xhm.fz.dao.OrderDao;
import com.xhm.fz.dao.OrderOperateHistoryDao;
import com.xhm.fz.dto.MoneyInfoParam;
import com.xhm.fz.dto.OrderDeliveryParam;
import com.xhm.fz.dto.OrderDetail;
import com.xhm.fz.dto.OrderParam;
import com.xhm.fz.dto.OrderQueryParam;
import com.xhm.fz.dto.PayInfoParam;
import com.xhm.fz.dto.ReceiverInfoParam;
import com.xhm.fz.entity.Clothing;
import com.xhm.fz.entity.Order;
import com.xhm.fz.entity.OrderExample;
import com.xhm.fz.entity.OrderItem;
import com.xhm.fz.entity.OrderOperateHistory;
import com.xhm.fz.mapper.OrderItemMapper;
import com.xhm.fz.mapper.OrderMapper;
import com.xhm.fz.mapper.OrderOperateHistoryMapper;
import com.xhm.fz.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<Order> list(OrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getList(queryParam);
    }

    @Override
    public List<OrderDetail> userOrderList(Integer userId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getUserOrder(userId);
    }

    @Override
    public Long createOrder(Order order, Clothing clothing, int orderClothingNum, String orderClothingColor,
            String orderClothingSize) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date createTime = new Date();
        OrderItem orderItem = new OrderItem();
        String[] str;
        String orderSn = "";
        int i, n;
        str = dateFormat.format(createTime).toString().split("-");
        for (i = 0; i < str.length; i++) {
            orderSn += str[i];
        }
        for (i = 0; i < 10; i++) {
            n = (int) (Math.random() * 10);
            orderSn += n;
        }
        order.setCreateTime(new Date());
        order.setOrderSn(orderSn);
        int count = orderMapper.insertByExample(order);
        if (count > 0) {
            String attr = "[{\"key\":\"颜色\",\"value\":\"" + orderClothingColor + "\"},";
            attr += "{\"key\":\"尺寸\",\"value\":\"" + orderClothingSize + "\"}]";
            orderItem.setOrderId(order.getId());
            orderItem.setOrderSn(orderSn);
            orderItem.setClothingId(clothing.getId());
            orderItem.setClothingPic(clothing.getPic());
            orderItem.setClothingName(clothing.getName());
            orderItem.setClothingBrand(clothing.getBrandName());
            orderItem.setClothingSn(clothing.getClothingSn());
            orderItem.setClothingPrice(clothing.getPrice());
            orderItem.setClothingQuantity(orderClothingNum);
            orderItem.setClothingCategoryId(clothing.getClothingCategoryId());
            orderItem.setClothingAttr(attr);
            int count1 = orderItemMapper.insert(orderItem);
            if (count1 > 0) {
                return order.getId();
            } else {
                return (long) -1;
            }
        } else {
            return (long) -1;
        }
    }

    @Override
    public long[] createOrderBatch(List<OrderParam> orderParam) {
        List<Order> orderList = new ArrayList<Order>();
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        long[] orderIds = new long[1000];
        for (int i = 0; i < orderParam.size(); i++) {
            Order order = orderParam.get(i).getOrder();
            Clothing clothing = orderParam.get(i).getClothing();
            OrderItem orderItem = new OrderItem();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date createTime = new Date();
            String[] str;
            String orderSn = "";
            int j, n;
            str = dateFormat.format(createTime).toString().split("-");
            for (j = 0; j < str.length; j++) {
                orderSn += str[j];
            }
            for (j = 0; j < 10; j++) {
                n = (int) (Math.random() * 10);
                orderSn += n;
            }
            order.setCreateTime(new Date());
            order.setOrderSn(orderSn);
            orderList.add(order);

            String attr = "[{\"key\":\"颜色\",\"value\":\"" + orderParam.get(i).getOrderClothingColor() + "\"},";
            attr += "{\"key\":\"尺寸\",\"value\":\"" + orderParam.get(i).getOrderClothingSize() + "\"}]";
            orderItem.setOrderId(order.getId());
            orderItem.setOrderSn(orderSn);
            orderItem.setClothingId(clothing.getId());
            orderItem.setClothingPic(clothing.getPic());
            orderItem.setClothingName(clothing.getName());
            orderItem.setClothingBrand(clothing.getBrandName());
            orderItem.setClothingSn(clothing.getClothingSn());
            orderItem.setClothingPrice(clothing.getPrice());
            orderItem.setClothingQuantity(orderParam.get(i).getOrderClothingNum());
            orderItem.setClothingCategoryId(clothing.getClothingCategoryId());
            orderItem.setClothingAttr(attr);
            orderItemList.add(orderItem);
        }
        int count = orderMapper.insertBatchOrderExample(orderList);
        if (count > 0) {
            int orderListSize = orderList.size();
            for (int i = 0; i < orderListSize; i++) {
                Order order1 = orderMapper.selectByOrderSn(orderList.get(i).getOrderSn());
                orderItemList.get(i).setOrderId(order1.getId());
                orderIds[i] = order1.getId();
            }
            int count1 = orderItemMapper.insertBatchOrderItem(orderItemList);
            if (count > 0 && count1 > 0) {
                return orderIds;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public int updatePayInfo(PayInfoParam payInfoParam) {
        Order order = new Order();
        order.setId(payInfoParam.getOrderId());
        order.setPayType(payInfoParam.getPayType());
        order.setStatus(payInfoParam.getStatus());
        order.setPaymentTime(new Date());
        order.setOrderType(payInfoParam.getOrderType());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int delivery(List<OrderDeliveryParam> deliveryParamList) {
        // 批量发货
        int count = orderDao.delivery(deliveryParamList);
        // 添加操作记录
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
            history.setNote("订单关闭:" + note);
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
        // 插入操作记录
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
        // 插入操作记录
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
        history.setNote("修改备注信息：" + note);
        orderOperateHistoryMapper.insert(history);
        return count;
    }
}
