package com.xhm.fz.controller;

import java.util.List;

import com.xhm.fz.common.api.CommonPage;
import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.ClothingCartDetail;
import com.xhm.fz.dto.ClothingCartParam;
import com.xhm.fz.service.ClothingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "ClothingCartController", description = "服装管理")
@RequestMapping("/clothingCart")
public class ClothingCartController {

    @Autowired
    ClothingCartService clothingCartService;

    @ApiOperation("查询用户购物车")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ClothingCartDetail>> getList(ClothingCartParam queryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ClothingCartDetail> clothingCartList = clothingCartService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingCartList));
    }

    @ApiOperation(value = "添加到购物车")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> create(@Validated @RequestBody ClothingCartParam queryParam) {
        int count = clothingCartService.createClothingCart(queryParam);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "移除购物车信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public <T> CommonResult<Integer> delete(@PathVariable("id") Long id) {
        int count = clothingCartService.deleteSingleClothingCart(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "批量移除购物车信息")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> deleteBatch(@RequestParam("ids") List<Long> ids) {
        int count = clothingCartService.deleteClothingCart(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    
}
