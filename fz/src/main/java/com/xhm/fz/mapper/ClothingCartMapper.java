package com.xhm.fz.mapper;

import com.xhm.fz.dto.ClothingCartParam;
import com.xhm.fz.entity.ClothingCartExample;

public interface ClothingCartMapper {

    int insert(ClothingCartParam queryParam);

    int deleteByPrimaryKey(Long id);

    int deleteByExample(ClothingCartExample example);
    
}
