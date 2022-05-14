package com.xhm.fz.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.xhm.fz.dao.ClothingCartDao;
import com.xhm.fz.dto.ClothingCartDetail;
import com.xhm.fz.dto.ClothingCartParam;
import com.xhm.fz.entity.ClothingCartExample;
import com.xhm.fz.mapper.ClothingCartMapper;
import com.xhm.fz.service.ClothingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothingCartServiceImpl implements ClothingCartService {

    @Autowired
    ClothingCartDao clothingCartDao;

    @Autowired
    ClothingCartMapper clothingCartMapper;

    @Override
    public List<ClothingCartDetail> list(ClothingCartParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return clothingCartDao.getDetail(queryParam);
    }

    @Override
    public int createClothingCart(ClothingCartParam queryParam) {
        queryParam.setEntryTime(new Date());
        return clothingCartMapper.insert(queryParam);
    }

    @Override
    public int deleteSingleClothingCart(Long id) {
        return clothingCartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteClothingCart(List<Long> ids) {
        ClothingCartExample clothingCartExample = new ClothingCartExample();
        clothingCartExample.createCriteria().andIdIn(ids);
        return clothingCartMapper.deleteByExample(clothingCartExample);
    }
    
}
