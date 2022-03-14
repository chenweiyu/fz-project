package com.xhm.fz.controller;

import java.util.List;

import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.entity.SkuStock;
import com.xhm.fz.service.SkuStockService;

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

/**
 * 商品SKU库存管理Controller
 * Created by xhm on 2018/4/27.
 */
@Controller
@Api(tags = "SkuStockController", description = "sku商品库存管理")
@RequestMapping("/sku")
public class SkuStockController {
    @Autowired
    private SkuStockService skuStockService;

    @ApiOperation("根据商品ID及sku编码模糊搜索sku库存")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SkuStock>> getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword) {
        List<SkuStock> skuStockList = skuStockService.getList(pid, keyword);
        return CommonResult.success(skuStockList);
    }
    @ApiOperation("批量更新sku库存信息")
    @RequestMapping(value ="/update/{pid}",method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> update(@PathVariable Long pid,@RequestBody List<SkuStock> skuStockList){
        int count = skuStockService.update(pid,skuStockList);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }
}
