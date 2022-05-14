package com.xhm.fz.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClothingCartParam {
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "模糊查找信息")
    private String query;

    @ApiModelProperty(value = "服装ID")
    private Long clothingId;

    @ApiModelProperty(value = "服装数量")
    private Long clothingNum;

    @ApiModelProperty(value = "服装颜色")
    private String clothingColor;

    @ApiModelProperty(value = "服装尺寸")
    private String clothingSize;

    @ApiModelProperty(value = "添加购物车时间")
    private Date entryTime;
}
