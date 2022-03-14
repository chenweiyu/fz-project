package com.xhm.fz.controller;

import java.util.List;

import com.xhm.fz.common.api.CommonPage;
import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.ClothingParam;
import com.xhm.fz.dto.ClothingQueryParam;
import com.xhm.fz.dto.ClothingResult;
// import com.xhm.fz.dto.ClothingQueryParam;
// import com.xhm.fz.dto.ClothingResult;
import com.xhm.fz.entity.Clothing;
import com.xhm.fz.service.ClothingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// import com.xhm.fz.service.ClothingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 服装管理Controller
 * Created by xhm on 2022/1/7.
 */
@Controller
@Api(tags = "PClothingController", description = "服装管理")
@RequestMapping("/clothing")
public class ClothingController {
    @Autowired
    private ClothingService clothingService;

    @ApiOperation("创建服装")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> create(@RequestBody ClothingParam clothingParam) {
        int count = clothingService.create(clothingParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据服装id获取服装编辑信息")
    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ClothingResult> getUpdateInfo(@PathVariable Long id) {
        ClothingResult clothingResult = clothingService.getUpdateInfo(id);
        return CommonResult.success(clothingResult);
    }

    @ApiOperation("更新服装")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> update(@PathVariable Long id, @RequestBody ClothingParam clothingParam) {
        int count = clothingService.update(id, clothingParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("查询服装")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Clothing>> getList(ClothingQueryParam clothingQueryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Clothing> clothingList = clothingService.list(clothingQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingList));
    }

    @ApiOperation("查询潮牌服装")
    @RequestMapping(value = "/listTide", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Clothing>> getTideList(ClothingQueryParam clothingQueryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Clothing> clothingList = clothingService.listTide(clothingQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingList));
    }

    @ApiOperation("查询简约服装")
    @RequestMapping(value = "/listSimple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Clothing>> getSimpleList(ClothingQueryParam clothingQueryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Clothing> clothingList = clothingService.listSimple(clothingQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingList));
    }

    @ApiOperation("查询运动服装")
    @RequestMapping(value = "/listSport", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Clothing>> getSportList(ClothingQueryParam clothingQueryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Clothing> clothingList = clothingService.listSport(clothingQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingList));
    }

    @ApiOperation("查询国风服装")
    @RequestMapping(value = "/listNation", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Clothing>> getNationList(ClothingQueryParam clothingQueryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Clothing> clothingList = clothingService.listNation(clothingQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingList));
    }

    @ApiOperation("根据服装名称或货号模糊查询")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Clothing>> getList(String keyword) {
        List<Clothing> clothingList = clothingService.list(keyword);
        return CommonResult.success(clothingList);
    }

    @ApiOperation("批量上下架服装")
    @RequestMapping(value = "/update/publishStatus", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                            @RequestParam("publishStatus") Integer publishStatus) {
        int count = clothingService.updatePublishStatus(ids, publishStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量推荐服装")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                              @RequestParam("recommendStatus") Integer recommendStatus) {
        int count = clothingService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                           @RequestParam("deleteStatus") Integer deleteStatus) {
        int count = clothingService.updateDeleteStatus(ids, deleteStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
