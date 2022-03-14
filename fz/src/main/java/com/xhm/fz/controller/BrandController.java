package com.xhm.fz.controller;

import java.util.List;

import com.xhm.fz.common.api.CommonPage;
import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.BrandParam;
import com.xhm.fz.entity.Brand;
import com.xhm.fz.service.BrandService;

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

/**
 * 商品品牌管理Controller
 * Created by xhm on 2018/4/26.
 */
@Controller
@Api(tags = "BrandController", description = "商品品牌管理")
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "获取全部品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Brand>> getList() {
        return CommonResult.success(brandService.listAllBrand());
    }

    @ApiOperation(value = "添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> create(@Validated @RequestBody BrandParam pmsBrand) {
        int count = brandService.createBrand(pmsBrand);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新品牌")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> update(@PathVariable("id") Long id,
                               @Validated @RequestBody BrandParam pmsBrandParam) {
        CommonResult<Integer> commonResult;
        int count = brandService.updateBrand(id, pmsBrandParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public <T> CommonResult<Integer> delete(@PathVariable("id") Long id) {
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Brand>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<Brand> brandList = brandService.listBrand(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation(value = "根据编号查询品牌信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Brand> getItem(@PathVariable("id") Long id) {
        return CommonResult.success(brandService.getBrand(id));
    }

    @ApiOperation(value = "批量删除品牌")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> deleteBatch(@RequestParam("ids") List<Long> ids) {
        int count = brandService.deleteBrand(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "批量更新显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    public <T> CommonResult<Integer> updateShowStatus(@RequestParam("ids") List<Long> ids,
                                   @RequestParam("showStatus") Integer showStatus) {
        int count = brandService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    // @ApiOperation(value = "批量更新厂家制造商状态")
    // @RequestMapping(value = "/update/factoryStatus", method = RequestMethod.POST)
    // @ResponseBody
    // public CommonResult updateFactoryStatus(@RequestParam("ids") List<Long> ids,
    //                                   @RequestParam("factoryStatus") Integer factoryStatus) {
    //     int count = brandService.updateFactoryStatus(ids, factoryStatus);
    //     if (count > 0) {
    //         return CommonResult.success(count);
    //     } else {
    //         return CommonResult.failed();
    //     }
    // }
}