package com.xhm.fz.service.impl;

import com.github.pagehelper.PageHelper;
import com.xhm.fz.dao.ClothingAttributeDao;
import com.xhm.fz.dto.ClothingAttributeParam;
import com.xhm.fz.dto.ClothingAttrInfo;
import com.xhm.fz.mapper.ClothingAttributeCategoryMapper;
import com.xhm.fz.mapper.ClothingAttributeMapper;
import com.xhm.fz.entity.ClothingAttribute;
import com.xhm.fz.entity.ClothingAttributeCategory;
import com.xhm.fz.entity.ClothingAttributeExample;
import com.xhm.fz.service.ClothingAttributeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性管理Service实现类
 * Created by xhm on 2018/4/26.
 */
@Service
public class ClothingAttributeServiceImpl implements ClothingAttributeService {
    @Autowired
    private ClothingAttributeMapper clothingAttributeMapper;
    @Autowired
    private ClothingAttributeCategoryMapper clothingAttributeCategoryMapper;
    @Autowired
    private ClothingAttributeDao clothingAttributeDao;

    @Override
    public List<ClothingAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ClothingAttributeExample example = new ClothingAttributeExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andClothingAttributeCategoryIdEqualTo(cid).andTypeEqualTo(type);
        return clothingAttributeMapper.selectByExample(example);
    }

    @Override
    public int create(ClothingAttributeParam pmsClothingAttributeParam) {
        ClothingAttribute pmsClothingAttribute = new ClothingAttribute();
        BeanUtils.copyProperties(pmsClothingAttributeParam, pmsClothingAttribute);
        int count = clothingAttributeMapper.insertSelective(pmsClothingAttribute);
        //新增商品属性以后需要更新商品属性分类数量
        ClothingAttributeCategory pmsClothingAttributeCategory = clothingAttributeCategoryMapper.selectByPrimaryKey(pmsClothingAttribute.getClothingAttributeCategoryId());
        if(pmsClothingAttribute.getType()==0){
            pmsClothingAttributeCategory.setAttributeCount(pmsClothingAttributeCategory.getAttributeCount()+1);
        }else if(pmsClothingAttribute.getType()==1){
            pmsClothingAttributeCategory.setParamCount(pmsClothingAttributeCategory.getParamCount()+1);
        }
        clothingAttributeCategoryMapper.updateByPrimaryKey(pmsClothingAttributeCategory);
        return count;
    }

    @Override
    public int update(Long id, ClothingAttributeParam clothingAttributeParam) {
        ClothingAttribute pmsClothingAttribute = new ClothingAttribute();
        pmsClothingAttribute.setId(id);
        BeanUtils.copyProperties(clothingAttributeParam, pmsClothingAttribute);
        return clothingAttributeMapper.updateByPrimaryKeySelective(pmsClothingAttribute);
    }

    @Override
    public ClothingAttribute getItem(Long id) {
        return clothingAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(List<Long> ids) {
        //获取分类
        ClothingAttribute pmsClothingAttribute = clothingAttributeMapper.selectByPrimaryKey(ids.get(0));
        Integer type = pmsClothingAttribute.getType();
        ClothingAttributeCategory pmsClothingAttributeCategory = clothingAttributeCategoryMapper.selectByPrimaryKey(pmsClothingAttribute.getClothingAttributeCategoryId());
        ClothingAttributeExample example = new ClothingAttributeExample();
        example.createCriteria().andIdIn(ids);
        int count = clothingAttributeMapper.deleteByExample(example);
        //删除完成后修改数量
        if(type==0){
            if(pmsClothingAttributeCategory.getAttributeCount()>=count){
                pmsClothingAttributeCategory.setAttributeCount(pmsClothingAttributeCategory.getAttributeCount()-count);
            }else{
                pmsClothingAttributeCategory.setAttributeCount(0);
            }
        }else if(type==1){
            if(pmsClothingAttributeCategory.getParamCount()>=count){
                pmsClothingAttributeCategory.setParamCount(pmsClothingAttributeCategory.getParamCount()-count);
            }else{
                pmsClothingAttributeCategory.setParamCount(0);
            }
        }
        clothingAttributeCategoryMapper.updateByPrimaryKey(pmsClothingAttributeCategory);
        return count;
    }

    @Override
    public List<ClothingAttrInfo> getClothingAttrInfo(Long clothingCategoryId) {
        return clothingAttributeDao.getClothingAttrInfo(clothingCategoryId);
    }
}
