package com.xhm.fz.entity;

import java.io.Serializable;

public class ClothingCategoryAttributeRelation implements Serializable {
    private Long id;

    private Long clothingCategoryId;

    private Long clothingAttributeId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClothingCategoryId() {
        return clothingCategoryId;
    }

    public void setClothingCategoryId(Long clothingCategoryId) {
        this.clothingCategoryId = clothingCategoryId;
    }

    public Long getClothingAttributeId() {
        return clothingAttributeId;
    }

    public void setClothingAttributeId(Long clothingAttributeId) {
        this.clothingAttributeId = clothingAttributeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clothingCategoryId=").append(clothingCategoryId);
        sb.append(", clothingAttributeId=").append(clothingAttributeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}