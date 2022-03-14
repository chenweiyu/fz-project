package com.xhm.fz.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询单个商品修改后返回的结果
 * Created by macro on 2018/4/26.
 */
public class ClothingResult extends ClothingParam {
    @Getter
    @Setter
    @ApiModelProperty("商品所选分类的父id")
    private Long cateParentId;
}
