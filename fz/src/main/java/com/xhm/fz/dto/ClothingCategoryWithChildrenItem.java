package com.xhm.fz.dto;

import com.xhm.fz.entity.ClothingCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含子级分类的商品分类
 * Created by macro on 2018/5/25.
 */
public class ClothingCategoryWithChildrenItem extends ClothingCategory {
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<ClothingCategory> children;
}
