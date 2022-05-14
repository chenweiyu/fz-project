package com.xhm.fz.dto;

import com.xhm.fz.entity.Clothing;
import com.xhm.fz.entity.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderParam {
    private Order order;
    private Clothing clothing;
    private Integer orderClothingNum;
    private String orderClothingColor;
    private String orderClothingSize;
}
