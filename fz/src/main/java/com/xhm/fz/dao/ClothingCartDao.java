package com.xhm.fz.dao;

import java.util.List;

import com.xhm.fz.dto.ClothingCartDetail;
import com.xhm.fz.dto.ClothingCartParam;

import org.apache.ibatis.annotations.Param;


public interface ClothingCartDao {
    // 查询用户的购物车信息
    List<ClothingCartDetail> getDetail(@Param("queryParam") ClothingCartParam queryParam);
}
