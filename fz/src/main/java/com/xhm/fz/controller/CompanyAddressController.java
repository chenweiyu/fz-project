package com.xhm.fz.controller;

import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.entity.CompanyAddress;
import com.xhm.fz.service.CompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "CompanyAddressController", description = "收货地址管理")
@RequestMapping("/companyAddress")
public class CompanyAddressController {
    @Autowired
    private CompanyAddressService companyAddressService;

    @ApiOperation("获取所有收货地址")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CompanyAddress>> list() {
        List<CompanyAddress> companyAddressList = companyAddressService.list();
        return CommonResult.success(companyAddressList);
    }
}
