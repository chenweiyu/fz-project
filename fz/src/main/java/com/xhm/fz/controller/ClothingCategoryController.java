package com.xhm.fz.controller;

import com.xhm.fz.common.api.CommonPage;
import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.ClothingCategoryParam;
import com.xhm.fz.dto.ClothingCategoryWithChildrenItem;
import com.xhm.fz.entity.ClothingCategory;
import com.xhm.fz.service.ClothingCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类管理Controller
 * Created by xhm on 2018/4/26.
 */
@Controller
@Api(tags = "ClothingCategoryController", description = "商品分类管理")
@RequestMapping("/clothingCategory")
public class ClothingCategoryController {
    @Autowired
    private ClothingCategoryService clothingCategoryService;

    @ApiOperation("添加商品分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> create(@Validated @RequestBody ClothingCategoryParam clothingCategoryParam) {
        int count = clothingCategoryService.create(clothingCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改商品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> update(@PathVariable Long id,
                         @Validated
                         @RequestBody ClothingCategoryParam clothingCategoryParam) {
        int count = clothingCategoryService.update(id, clothingCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询商品分类")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ClothingCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ClothingCategory> clothingCategoryList = clothingCategoryService.getList(parentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingCategoryList));
    }

    @ApiOperation("根据id获取商品分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ClothingCategory> getItem(@PathVariable Long id) {
        ClothingCategory clothingCategory = clothingCategoryService.getItem(id);
        return CommonResult.success(clothingCategory);
    }

    @ApiOperation("删除商品分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> delete(@PathVariable Long id) {
        int count = clothingCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改导航栏显示状态")
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updateNavStatus(@RequestParam("ids") List<Long> ids, @RequestParam("navStatus") Integer navStatus) {
        int count = clothingCategoryService.updateNavStatus(ids, navStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updateShowStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus) {
        int count = clothingCategoryService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ClothingCategoryWithChildrenItem>> listWithChildren() {
        List<ClothingCategoryWithChildrenItem> list = clothingCategoryService.listWithChildren();
        return CommonResult.success(list);
    }
}
