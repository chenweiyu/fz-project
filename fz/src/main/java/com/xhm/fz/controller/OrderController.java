package com.xhm.fz.controller;

import com.xhm.fz.common.api.CommonPage;
import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.*;
import com.xhm.fz.entity.Order;
import com.xhm.fz.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理Controller
 * Created by xhm on 2018/10/11.
 */
@Controller
@Api(tags = "OrderController", description = "订单管理")
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Order>> list(OrderQueryParam queryParam,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Order> orderList = orderService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> delivery(@RequestBody List<OrderDeliveryParam> deliveryParamList) {
        int count = orderService.delivery(deliveryParamList);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        int count = orderService.close(ids, note);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> delete(@RequestParam("ids") List<Long> ids) {
        log.info("进来了");
        int count = orderService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取订单详情：订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OrderDetail> detail(@PathVariable Long id) {
        OrderDetail orderDetailResult = orderService.detail(id);
        return CommonResult.success(orderDetailResult);
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updateReceiverInfo(@RequestBody ReceiverInfoParam receiverInfoParam) {
        int count = orderService.updateReceiverInfo(receiverInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updateReceiverInfo(@RequestBody MoneyInfoParam moneyInfoParam) {
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updateNote(@RequestParam("id") Long id,
                                   @RequestParam("note") String note,
                                   @RequestParam("status") Integer status) {
        int count = orderService.updateNote(id, note, status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
