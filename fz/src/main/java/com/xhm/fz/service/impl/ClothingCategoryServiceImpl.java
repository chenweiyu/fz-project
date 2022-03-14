package com.xhm.fz.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.xhm.fz.dao.ClothingCategoryAttributeRelationDao;
import com.xhm.fz.dao.ClothingCategoryDao;
import com.xhm.fz.dto.ClothingCategoryParam;
import com.xhm.fz.dto.ClothingCategoryWithChildrenItem;
import com.xhm.fz.entity.Clothing;
import com.xhm.fz.entity.ClothingCategory;
import com.xhm.fz.entity.ClothingCategoryAttributeRelation;
import com.xhm.fz.entity.ClothingCategoryAttributeRelationExample;
import com.xhm.fz.entity.ClothingCategoryExample;
import com.xhm.fz.entity.ClothingExample;
import com.xhm.fz.mapper.ClothingCategoryAttributeRelationMapper;
import com.xhm.fz.mapper.ClothingCategoryMapper;
import com.xhm.fz.mapper.ClothingMapper;
import com.xhm.fz.service.ClothingCategoryService;

// import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品分类管理Service实现类
 * Created by xhm on 2018/4/26.
 */
@Service
public class ClothingCategoryServiceImpl implements ClothingCategoryService {
    @Autowired
    private ClothingCategoryMapper clothingCategoryMapper;
    @Autowired
    private ClothingMapper clothingMapper;
    @Autowired
    private ClothingCategoryAttributeRelationDao clothingCategoryAttributeRelationDao;
    @Autowired
    private ClothingCategoryAttributeRelationMapper clothingCategoryAttributeRelationMapper;
    @Autowired
    private ClothingCategoryDao clothingCategoryDao;
    @Override
    public int create(ClothingCategoryParam clothingCategoryParam) {
        ClothingCategory clothingCategory = new ClothingCategory();
        clothingCategory.setClothingCount(0);
        BeanUtils.copyProperties(clothingCategoryParam, clothingCategory);
        //没有父分类时为一级分类
        setCategoryLevel(clothingCategory);
        int count = clothingCategoryMapper.insertSelective(clothingCategory);
        //创建筛选属性关联
        List<Long> clothingAttributeIdList = clothingCategoryParam.getClothingAttributeIdList();
        if(!CollectionUtils.isEmpty(clothingAttributeIdList)){
            insertRelationList(clothingCategory.getId(), clothingAttributeIdList);
        }
        return count;
    }

    /**
     * 批量插入商品分类与筛选属性关系表
     * @param clothingCategoryId 商品分类id
     * @param clothingAttributeIdList 相关商品筛选属性id集合
     */
    private void insertRelationList(Long clothingCategoryId, List<Long> clothingAttributeIdList) {
        List<ClothingCategoryAttributeRelation> relationList = new ArrayList<>();
        for (Long clothingAttrId : clothingAttributeIdList) {
            ClothingCategoryAttributeRelation relation = new ClothingCategoryAttributeRelation();
            relation.setClothingAttributeId(clothingAttrId);
            relation.setClothingCategoryId(clothingCategoryId);
            relationList.add(relation);
        }
        clothingCategoryAttributeRelationDao.insertList(relationList);
    }

    @Override
    public int update(Long id, ClothingCategoryParam clothingCategoryParam) {
        ClothingCategory clothingCategory = new ClothingCategory();
        clothingCategory.setId(id);
        BeanUtils.copyProperties(clothingCategoryParam, clothingCategory);
        setCategoryLevel(clothingCategory);
        //更新商品分类时要更新商品中的名称
        Clothing clothing = new Clothing();
        clothing.setClothingCategoryName(clothingCategory.getName());
        ClothingExample example = new ClothingExample();
        example.createCriteria().andClothingCategoryIdEqualTo(id);
        clothingMapper.updateByExampleSelective(clothing,example);
        //同时更新筛选属性的信息
        if(!CollectionUtils.isEmpty(clothingCategoryParam.getClothingAttributeIdList())){
            ClothingCategoryAttributeRelationExample relationExample = new ClothingCategoryAttributeRelationExample();
            relationExample.createCriteria().andClothingCategoryIdEqualTo(id);
            clothingCategoryAttributeRelationMapper.deleteByExample(relationExample);
            insertRelationList(id,clothingCategoryParam.getClothingAttributeIdList());
        }else{
            ClothingCategoryAttributeRelationExample relationExample = new ClothingCategoryAttributeRelationExample();
            relationExample.createCriteria().andClothingCategoryIdEqualTo(id);
            clothingCategoryAttributeRelationMapper.deleteByExample(relationExample);
        }
        return clothingCategoryMapper.updateByPrimaryKeySelective(clothingCategory);
    }

    @Override
    public List<ClothingCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ClothingCategoryExample example = new ClothingCategoryExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return clothingCategoryMapper.selectByExample(example);
    }

    @Override
    public int delete(Long id) {
        return clothingCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ClothingCategory getItem(Long id) {
        return clothingCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        ClothingCategory clothingCategory = new ClothingCategory();
        clothingCategory.setNavStatus(navStatus);
        ClothingCategoryExample example = new ClothingCategoryExample();
        example.createCriteria().andIdIn(ids);
        return clothingCategoryMapper.updateByExampleSelective(clothingCategory, example);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        ClothingCategory clothingCategory = new ClothingCategory();
        clothingCategory.setShowStatus(showStatus);
        ClothingCategoryExample example = new ClothingCategoryExample();
        example.createCriteria().andIdIn(ids);
        return clothingCategoryMapper.updateByExampleSelective(clothingCategory, example);
    }

    @Override
    public List<ClothingCategoryWithChildrenItem> listWithChildren() {
        return clothingCategoryDao.listWithChildren();
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(ClothingCategory clothingCategory) {
        //没有父分类时为一级分类
        if (clothingCategory.getParentId() == 0) {
            clothingCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            ClothingCategory parentCategory = clothingCategoryMapper.selectByPrimaryKey(clothingCategory.getParentId());
            if (parentCategory != null) {
                clothingCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                clothingCategory.setLevel(0);
            }
        }
    }
}
