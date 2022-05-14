package com.xhm.fz.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClothingCart {
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private int userId;

    @ApiModelProperty(value = "服装ID")
    private Long clothingId;

    @ApiModelProperty(value = "服装数量")
    private Long clothingNum;

    @ApiModelProperty(value = "服装颜色")
    private String clothingColor;

    @ApiModelProperty(value = "服装尺码")
    private String clothingSize;

    @ApiModelProperty(value = "加入购物时间")
    private Date entryTime;
}