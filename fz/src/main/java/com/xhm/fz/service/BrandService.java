package com.xhm.fz.service;

import java.util.List;

import com.xhm.fz.dto.BrandParam;
import com.xhm.fz.entity.Brand;

/**
 * 商品品牌管理Service
 * Created by xhm on 2018/4/26.
 */
public interface BrandService {
    /**
     * 获取所有品牌
     */
    List<Brand> listAllBrand();

    /**
     * 创建品牌
     */
    int createBrand(BrandParam pmsBrandParam);

    /**
     * 修改品牌
     */
    // @Transactional
    int updateBrand(Long id, BrandParam pmsBrandParam);

    /**
     * 删除品牌
     */
    int deleteBrand(Long id);

    /**
     * 批量删除品牌
     */
    int deleteBrand(List<Long> ids);

    /**
     * 分页查询品牌
     */
    List<Brand> listBrand(String keyword, int pageNum, int pageSize);

    /**
     * 获取品牌详情
     */
    Brand getBrand(Long id);

    /**
     * 修改显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 修改厂家制造商状态
     */
    // int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
