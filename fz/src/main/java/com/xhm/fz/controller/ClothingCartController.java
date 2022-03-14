package com.xhm.fz.controller;

import static org.mockito.Mockito.description;

import java.util.List;

import com.xhm.fz.common.api.CommonPage;
import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.ClothingQueryParam;
import com.xhm.fz.entity.Clothing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "PClothingController", description = "服装管理")
@RequestMapping("/clothingCart")
public class ClothingCartController {

    @Autowired
    ClothingCartService clothingCartService;

    @ApiOperation("查询服装")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Clothing>> getList(ClothingQueryParam clothingQueryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ClothingCart> clothingCartList = clothingCartService.list(clothingQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(clothingList));
    }
    
}
