package com.xhm.fz.service.impl;

import com.github.pagehelper.PageHelper;
import com.xhm.fz.dao.ClothingAttributeCategoryDao;
import com.xhm.fz.dto.ClothingAttributeCategoryItem;
import com.xhm.fz.mapper.ClothingAttributeCategoryMapper;
import com.xhm.fz.entity.ClothingAttributeCategory;
import com.xhm.fz.entity.ClothingAttributeCategoryExample;
import com.xhm.fz.service.ClothingAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性分类管理Service实现类
 * Created by xhm on 2018/4/26.
 */
@Service
public class ClothingAttributeCategoryServiceImpl implements ClothingAttributeCategoryService {
    @Autowired
    private ClothingAttributeCategoryMapper clothingAttributeCategoryMapper;
    @Autowired
    private ClothingAttributeCategoryDao clothingAttributeCategoryDao;

    @Override
    public int create(String name) {
        ClothingAttributeCategory clothingAttributeCategory = new ClothingAttributeCategory();
        clothingAttributeCategory.setName(name);
        return clothingAttributeCategoryMapper.insertSelective(clothingAttributeCategory);
    }

    @Override
    public int update(Long id, String name) {
        ClothingAttributeCategory clothingAttributeCategory = new ClothingAttributeCategory();
        clothingAttributeCategory.setName(name);
        clothingAttributeCategory.setId(id);
        return clothingAttributeCategoryMapper.updateByPrimaryKeySelective(clothingAttributeCategory);
    }

    @Override
    public int delete(Long id) {
        return clothingAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ClothingAttributeCategory getItem(Long id) {
        return clothingAttributeCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ClothingAttributeCategory> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return clothingAttributeCategoryMapper.selectByExample(new ClothingAttributeCategoryExample());
    }

    @Override
    public List<ClothingAttributeCategoryItem> getListWithAttr() {
        return clothingAttributeCategoryDao.getListWithAttr();
    }
}
