package com.xhm.fz.controller;

import java.util.List;

import com.xhm.fz.common.api.CommonPage;
import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.MoneyInfoParam;
import com.xhm.fz.dto.OrderDeliveryParam;
import com.xhm.fz.dto.OrderDetail;
import com.xhm.fz.dto.OrderParam;
import com.xhm.fz.dto.OrderQueryParam;
import com.xhm.fz.dto.PayInfoParam;
import com.xhm.fz.dto.ReceiverInfoParam;
import com.xhm.fz.entity.Order;
import com.xhm.fz.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

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

    @ApiOperation(value = "添加订单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Long> create(@RequestBody OrderParam orderParam) {
        Long count = orderService.createOrder(orderParam.getOrder(), orderParam.getClothing(),
                orderParam.getOrderClothingNum(), orderParam.getOrderClothingColor(),
                orderParam.getOrderClothingSize());
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    // @RequestParam(required = false, value = "list[]") List<String> list
    @ApiOperation(value = "批量添加订单")
    @RequestMapping(value = "/createBatch", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<long[]> createBatch(@RequestBody List<OrderParam> orderParam) {
        long[] count = orderService.createOrderBatch(orderParam);
        if (count != null) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取订单详情：订单信息、商品信息、操作记录")
    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OrderDetail>> userOrder(@PathVariable Integer userId,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OrderDetail> userOrderList = orderService.userOrderList(userId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(userOrderList));
    }

    @ApiOperation("修改订单支付和订单类型信息")
    @RequestMapping(value = "/update/payInfo", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updatePayInfo(@RequestBody PayInfoParam payInfoParam) {
        int count = orderService.updatePayInfo(payInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量修改订单支付和订单类型信息")
    @RequestMapping(value = "/update/payInfoList", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updatePayInfoList(@RequestBody List<PayInfoParam> payInfoParam) {
        int count = 1;
        for (int i = 0; i < payInfoParam.size(); i++) {
            count = orderService.updatePayInfo(payInfoParam.get(i));
            if (count <= 0) {
                return CommonResult.failed();
            }
        }
        return CommonResult.success(count);
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
