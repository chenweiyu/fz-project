package com.xhm.fz.dto;

import java.util.List;

import com.xhm.fz.entity.Clothing;
import com.xhm.fz.entity.ClothingAttributeValue;
import com.xhm.fz.entity.ClothingFullReduction;
import com.xhm.fz.entity.ClothingLadder;
import com.xhm.fz.entity.MemberPrice;
import com.xhm.fz.entity.PrefrenceAreaClothingRelation;
import com.xhm.fz.entity.SkuStock;
import com.xhm.fz.entity.SubjectClothingRelation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建和修改商品的请求参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClothingParam extends Clothing{
    @ApiModelProperty("商品阶梯价格设置")
    private List<ClothingLadder> clothingLadderList;
    @ApiModelProperty("商品满减价格设置")
    private List<ClothingFullReduction> clothingFullReductionList;
    @ApiModelProperty("商品会员价格设置")
    private List<MemberPrice> memberPriceList;
    @ApiModelProperty("商品的sku库存信息")
    private List<SkuStock> skuStockList;
    @ApiModelProperty("商品参数及自定义规格属性")
    private List<ClothingAttributeValue> clothingAttributeValueList;
    @ApiModelProperty("专题和商品关系")
    private List<SubjectClothingRelation> subjectClothingRelationList;
    @ApiModelProperty("优选专区和商品的关系")
    private List<PrefrenceAreaClothingRelation> prefrenceAreaClothingRelationList;
}
