package com.xhm.fz.dto;

import com.xhm.fz.entity.ClothingAttribute;
import com.xhm.fz.entity.ClothingAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 带有属性的商品属性分类
 * Created by xhm on 2018/5/24.
 */
public class ClothingAttributeCategoryItem extends ClothingAttributeCategory {
    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<ClothingAttribute> clothingAttributeList;
}
