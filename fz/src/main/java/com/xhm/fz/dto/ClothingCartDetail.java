package com.xhm.fz.dto;

import com.xhm.fz.entity.Clothing;
import com.xhm.fz.entity.ClothingCart;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

public class ClothingCartDetail {
    @Getter
    @Setter
    @ApiModelProperty("购物车商品列表")
    private Clothing clothingList;
    @Getter
    @Setter
    @ApiModelProperty("用户购物车列表")
    private ClothingCart clothingCartList;
}
