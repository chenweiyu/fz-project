package com.xhm.fz.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Receiver {

    private Long id;

    @ApiModelProperty(value = "用户ID")
    private int userId;

    @ApiModelProperty(value = "收货人名字")
    private String  receiverName;

    @ApiModelProperty(value = "收货人电话")
    private String  receiverPhone;

    @ApiModelProperty(value = "收货人所在省份")
    private String  receiverProvince;

    @ApiModelProperty(value = "收货人所在城市")
    private String  receiverCity;

    @ApiModelProperty(value = "收货人所在区/县/乡")
    private String  receiverRegion;

    @ApiModelProperty(value = "收货人详细地址")
    private String  receiverDetailAddress;
    
}
