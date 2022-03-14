package com.xhm.fz.service;

import java.util.List;

import com.xhm.fz.dto.ClothingParam;
// import com.xhm.fz.dto.ClothingParam;
import com.xhm.fz.dto.ClothingQueryParam;
import com.xhm.fz.dto.ClothingResult;
import com.xhm.fz.entity.Clothing;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服装管理Service
 * Created by xhm on 2022/1/7.
 */
public interface ClothingService {
    /**
     * 创建服装
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(ClothingParam clothingParam);

    /**
     * 根据服装编号获取更新信息
     */
    ClothingResult getUpdateInfo(Long id);

    /**
     * 更新服装
     */
    @Transactional
    int update(Long id, ClothingParam clothingParam);

    /**
     * 分页查询服装
     */
    List<Clothing> list(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 分页查询潮牌服装
     */
    List<Clothing> listTide(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 分页查询简约服装
     */
    List<Clothing> listSimple(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 分页查询运动服装
     */
    List<Clothing> listSport(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 分页查询国风服装
     */
    List<Clothing> listNation(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量修改审核状态
     * @param ids 产品id
     * @param verifyStatus 审核状态
     * @param detail 审核详情
     */
    // @Transactional
    // int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    // /**
    //  * 批量修改服装上架状态
    //  */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    // /**
    //  * 批量修改服装推荐状态
    //  */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    // /**
    //  * 批量修改新品状态
    //  */
    // int updateNewStatus(List<Long> ids, Integer newStatus);

    // /**
    //  * 批量删除服装
    //  */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    // /**
    //  * 根据服装名称或者货号模糊查询
    //  */
    List<Clothing> list(String keyword);
}
