package com.xhm.fz.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ClothingAttributeValue implements Serializable {
    private Long id;

    private Long clothingId;

    private Long clothingAttributeId;

    @ApiModelProperty(value = "手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开")
    private String value;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClothingId() {
        return clothingId;
    }

    public void setClothingId(Long clothingId) {
        this.clothingId = clothingId;
    }

    public Long getClothingAttributeId() {
        return clothingAttributeId;
    }

    public void setClothingAttributeId(Long clothingAttributeId) {
        this.clothingAttributeId = clothingAttributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clothingId=").append(clothingId);
        sb.append(", clothingAttributeId=").append(clothingAttributeId);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}