package com.xhm.fz.controller;

import com.xhm.fz.common.api.CommonPage;
import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.ClothingAttributeParam;
import com.xhm.fz.dto.ClothingAttrInfo;
import com.xhm.fz.entity.ClothingAttribute;
import com.xhm.fz.service.ClothingAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品属性管理Controller
 * Created by xhm on 2018/4/26.
 */
@Controller
@Api(tags = "ClothingAttributeController", description = "商品属性管理")
@RequestMapping("/clothingAttribute")
public class ClothingAttributeController {
    @Autowired
    private ClothingAttributeService clothingAttributeService;

    @ApiOperation("根据分类查询属性列表或参数列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "0表示属性，1表示参数", required = true, paramType = "query", dataType = "integer")})
    @RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ClothingAttribute>> getList(@PathVariable Long cid,
                                                                 @RequestParam(value = "type") Integer type,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ClothingAttribute> clothingAttributeList = clothingAttributeService.getList(cid, type, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingAttributeList));
    }

    @ApiOperation("添加商品属性信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> create(@RequestBody ClothingAttributeParam clothingAttributeParam) {
        int count = clothingAttributeService.create(clothingAttributeParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改商品属性信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> update(@PathVariable Long id, @RequestBody ClothingAttributeParam clothingAttributeParam) {
        int count = clothingAttributeService.update(id, clothingAttributeParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("查询单个商品属性")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ClothingAttribute> getItem(@PathVariable Long id) {
        ClothingAttribute clothingAttribute = clothingAttributeService.getItem(id);
        return CommonResult.success(clothingAttribute);
    }

    @ApiOperation("批量删除商品属性")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> delete(@RequestParam("ids") List<Long> ids) {
        int count = clothingAttributeService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @RequestMapping(value = "/attrInfo/{clothingCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ClothingAttrInfo>> getAttrInfo(@PathVariable Long clothingCategoryId) {
        List<ClothingAttrInfo> clothingAttrInfoList = clothingAttributeService.getClothingAttrInfo(clothingCategoryId);
        return CommonResult.success(clothingAttrInfoList);
    }
}
