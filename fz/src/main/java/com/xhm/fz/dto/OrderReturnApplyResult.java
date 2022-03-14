package com.xhm.fz.dto;

import com.xhm.fz.entity.CompanyAddress;
import com.xhm.fz.entity.OrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 * Created by xhm on 2018/10/18.
 */
public class OrderReturnApplyResult extends OrderReturnApply {
    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private CompanyAddress companyAddress;
}
