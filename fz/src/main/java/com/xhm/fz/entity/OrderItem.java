package com.xhm.fz.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {
    private Long id;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    private Long clothingId;

    private String clothingPic;

    private String clothingName;

    private String clothingBrand;

    private String clothingSn;

    @ApiModelProperty(value = "销售价格")
    private BigDecimal clothingPrice;

    @ApiModelProperty(value = "购买数量")
    private Integer clothingQuantity;

    @ApiModelProperty(value = "商品sku编号")
    private Long clothingSkuId;

    @ApiModelProperty(value = "商品sku条码")
    private String clothingSkuCode;

    @ApiModelProperty(value = "商品分类id")
    private Long clothingCategoryId;

    @ApiModelProperty(value = "商品促销名称")
    private String promotionName;

    @ApiModelProperty(value = "商品促销分解金额")
    private BigDecimal promotionAmount;

    @ApiModelProperty(value = "优惠券优惠分解金额")
    private BigDecimal couponAmount;

    @ApiModelProperty(value = "积分优惠分解金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty(value = "该商品经过优惠后的分解金额")
    private BigDecimal realAmount;

    private Integer giftIntegration;

    private Integer giftGrowth;

    @ApiModelProperty(value = "商品销售属性:[{'key':'颜色','value':'颜色'},{'key':'容量','value':'4G'}]")
    private String clothingAttr;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getClothingId() {
        return clothingId;
    }

    public void setClothingId(Long clothingId) {
        this.clothingId = clothingId;
    }

    public String getClothingPic() {
        return clothingPic;
    }

    public void setClothingPic(String clothingPic) {
        this.clothingPic = clothingPic;
    }

    public String getClothingName() {
        return clothingName;
    }

    public void setClothingName(String clothingName) {
        this.clothingName = clothingName;
    }

    public String getClothingBrand() {
        return clothingBrand;
    }

    public void setClothingBrand(String clothingBrand) {
        this.clothingBrand = clothingBrand;
    }

    public String getClothingSn() {
        return clothingSn;
    }

    public void setClothingSn(String clothingSn) {
        this.clothingSn = clothingSn;
    }

    public BigDecimal getClothingPrice() {
        return clothingPrice;
    }

    public void setClothingPrice(BigDecimal clothingPrice) {
        this.clothingPrice = clothingPrice;
    }

    public Integer getClothingQuantity() {
        return clothingQuantity;
    }

    public void setClothingQuantity(Integer clothingQuantity) {
        this.clothingQuantity = clothingQuantity;
    }

    public Long getClothingSkuId() {
        return clothingSkuId;
    }

    public void setClothingSkuId(Long clothingSkuId) {
        this.clothingSkuId = clothingSkuId;
    }

    public String getClothingSkuCode() {
        return clothingSkuCode;
    }

    public void setClothingSkuCode(String clothingSkuCode) {
        this.clothingSkuCode = clothingSkuCode;
    }

    public Long getClothingCategoryId() {
        return clothingCategoryId;
    }

    public void setClothingCategoryId(Long clothingCategoryId) {
        this.clothingCategoryId = clothingCategoryId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public Integer getGiftIntegration() {
        return giftIntegration;
    }

    public void setGiftIntegration(Integer giftIntegration) {
        this.giftIntegration = giftIntegration;
    }

    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }

    public String getClothingAttr() {
        return clothingAttr;
    }

    public void setClothingAttr(String clothingAttr) {
        this.clothingAttr = clothingAttr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", clothingId=").append(clothingId);
        sb.append(", clothingPic=").append(clothingPic);
        sb.append(", clothingName=").append(clothingName);
        sb.append(", clothingBrand=").append(clothingBrand);
        sb.append(", clothingSn=").append(clothingSn);
        sb.append(", clothingPrice=").append(clothingPrice);
        sb.append(", clothingQuantity=").append(clothingQuantity);
        sb.append(", clothingSkuId=").append(clothingSkuId);
        sb.append(", clothingSkuCode=").append(clothingSkuCode);
        sb.append(", clothingCategoryId=").append(clothingCategoryId);
        sb.append(", promotionName=").append(promotionName);
        sb.append(", promotionAmount=").append(promotionAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", integrationAmount=").append(integrationAmount);
        sb.append(", realAmount=").append(realAmount);
        sb.append(", giftIntegration=").append(giftIntegration);
        sb.append(", giftGrowth=").append(giftGrowth);
        sb.append(", clothingAttr=").append(clothingAttr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}