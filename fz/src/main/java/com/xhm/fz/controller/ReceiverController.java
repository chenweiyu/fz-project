package com.xhm.fz.controller;

import java.util.List;

import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.ReceiverParam;
import com.xhm.fz.entity.Receiver;
import com.xhm.fz.service.ReceiverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Api(tags = "PClothingController", description = "配送地址管理")
@RequestMapping("/receiver")
public class ReceiverController {

    @Autowired
    ReceiverService receiverService;

    @ApiOperation("查询用户配送地址")
    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Receiver>> getList(@PathVariable Long uid) {
        List<Receiver> receiverList = receiverService.list(uid);
        return CommonResult.success(receiverList);
    }

    @ApiOperation("修改用户配送地址")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> update(@PathVariable Long id, @RequestBody ReceiverParam receiverParam) {
        int count = receiverService.update(id, receiverParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    
}
