package com.xhm.fz.controller;

import com.xhm.fz.common.api.CommonPage;
import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.ClothingAttributeCategoryItem;
import com.xhm.fz.entity.ClothingAttributeCategory;
import com.xhm.fz.service.ClothingAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品属性分类管理Controller
 * Created by xhm on 2018/4/26.
 * @param <T>
 */
@Controller
@Api(tags = "ClothingAttributeCategoryController", description = "商品属性分类管理")
@RequestMapping("/clothingAttribute/category")
public class ClothingAttributeCategoryController<T> {
    @Autowired
    private ClothingAttributeCategoryService clothingAttributeCategoryService;

    @ApiOperation("添加商品属性分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> create(@RequestParam String name) {
        int count = clothingAttributeCategoryService.create(name);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改商品属性分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> update(@PathVariable Long id, @RequestParam String name) {
        int count = clothingAttributeCategoryService.update(id, name);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除单个商品属性分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Integer> delete(@PathVariable Long id) {
        int count = clothingAttributeCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取单个商品属性分类信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ClothingAttributeCategory> getItem(@PathVariable Long id) {
        ClothingAttributeCategory clothingAttributeCategory = clothingAttributeCategoryService.getItem(id);
        return CommonResult.success(clothingAttributeCategory);
    }

    @ApiOperation("分页获取所有商品属性分类")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ClothingAttributeCategory>> getList(@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {
        List<ClothingAttributeCategory> clothingAttributeCategoryList = clothingAttributeCategoryService.getList(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingAttributeCategoryList));
    }

    @ApiOperation("获取所有商品属性分类及其下属性")
    @RequestMapping(value = "/list/withAttr", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ClothingAttributeCategoryItem>> getListWithAttr() {
        List<ClothingAttributeCategoryItem> clothingAttributeCategoryResultList = clothingAttributeCategoryService.getListWithAttr();
        return CommonResult.success(clothingAttributeCategoryResultList);
    }
}
