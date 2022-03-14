package com.xhm.fz.controller;


import javax.servlet.http.HttpServletRequest;

import com.xhm.fz.common.api.CommonResult;
import com.xhm.fz.dto.OssCallbackResult;
import com.xhm.fz.dto.OssPolicyResult;
import com.xhm.fz.service.OssService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// import javax.servlet.http.HttpServletRequest;

/**
 * Oss对象存储管理Controller
 * Created by xhm on 2018/4/26.
 */
@Controller
@Api(tags = "OssController", description = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation(value = "Oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OssPolicyResult> policy() {
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }

    @ApiOperation(value = "Oss上传成功回调")
    @RequestMapping(value = "callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<OssCallbackResult> callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return CommonResult.success(ossCallbackResult);
    }

}
