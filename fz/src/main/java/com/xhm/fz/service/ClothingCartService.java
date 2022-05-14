package com.xhm.fz.service;

import java.util.List;

import com.xhm.fz.dto.ClothingCartDetail;
import com.xhm.fz.dto.ClothingCartParam;

public interface ClothingCartService {
    List<ClothingCartDetail> list(ClothingCartParam queryParam, Integer pageSize, Integer pageNum);

    int createClothingCart(ClothingCartParam queryParam);

    int deleteSingleClothingCart(Long id);

    int deleteClothingCart(List<Long> ids);
}
