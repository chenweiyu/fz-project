package com.xhm.fz.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.xhm.fz.dto.BrandParam;
import com.xhm.fz.entity.Brand;
import com.xhm.fz.entity.BrandExample;
import com.xhm.fz.entity.Clothing;
import com.xhm.fz.entity.ClothingExample;
import com.xhm.fz.mapper.BrandMapper;
import com.xhm.fz.mapper.ClothingMapper;
import com.xhm.fz.service.BrandService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 商品品牌管理Service实现类
 * Created by xhm on 2018/4/26.
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private ClothingMapper clothingMapper;

    @Override
    public List<Brand> listAllBrand() {
        return brandMapper.selectByExample(new BrandExample());
    }

    @Override
    public int createBrand(BrandParam pmsBrandParam) {
        Brand pmsBrand = new Brand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        return brandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, BrandParam pmsBrandParam) {
        Brand pmsBrand = new Brand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        pmsBrand.setId(id);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        //更新品牌时要更新商品中的品牌名称
        Clothing clothing = new Clothing();
        clothing.setBrandName(pmsBrand.getName());
        ClothingExample example = new ClothingExample();
        example.createCriteria().andBrandIdEqualTo(id);
        clothingMapper.updateByExampleSelective(clothing,example);
        return brandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBrand(List<Long> ids) {
        BrandExample pmsBrandExample = new BrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        return brandMapper.deleteByExample(pmsBrandExample);
    }

    @Override
    public List<Brand> listBrand(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        BrandExample pmsBrandExample = new BrandExample();
        pmsBrandExample.setOrderByClause("sort desc");
        BrandExample.Criteria criteria = pmsBrandExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        return brandMapper.selectByExample(pmsBrandExample);
    }

    @Override
    public Brand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        Brand pmsBrand = new Brand();
        pmsBrand.setShowStatus(showStatus);
        BrandExample pmsBrandExample = new BrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        return brandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
    }

    // @Override
    // public int updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
    //     Brand pmsBrand = new Brand();
    //     pmsBrand.setFactoryStatus(factoryStatus);
    //     BrandExample pmsBrandExample = new BrandExample();
    //     pmsBrandExample.createCriteria().andIdIn(ids);
    //     return brandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
    // }
}
