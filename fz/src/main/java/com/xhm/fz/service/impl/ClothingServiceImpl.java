package com.xhm.fz.service.impl;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.xhm.fz.dao.ClothingAttributeValueDao;
import com.xhm.fz.dao.ClothingDao;
import com.xhm.fz.dao.ClothingFullReductionDao;
import com.xhm.fz.dao.ClothingLadderDao;
import com.xhm.fz.dao.MemberPriceDao;
import com.xhm.fz.dao.PrefrenceAreaClothingRelationDao;
import com.xhm.fz.dao.SkuStockDao;
import com.xhm.fz.dao.SubjectClothingRelationDao;
import com.xhm.fz.dto.ClothingParam;
import com.xhm.fz.dto.ClothingQueryParam;
import com.xhm.fz.dto.ClothingResult;
import com.xhm.fz.entity.Clothing;
import com.xhm.fz.entity.ClothingAttributeValueExample;
import com.xhm.fz.entity.ClothingExample;
import com.xhm.fz.entity.ClothingFullReductionExample;
import com.xhm.fz.entity.ClothingLadderExample;
import com.xhm.fz.entity.MemberPriceExample;
import com.xhm.fz.entity.PrefrenceAreaClothingRelationExample;
import com.xhm.fz.entity.SkuStock;
import com.xhm.fz.entity.SkuStockExample;
import com.xhm.fz.entity.SubjectClothingRelationExample;
import com.xhm.fz.mapper.ClothingAttributeValueMapper;
import com.xhm.fz.mapper.ClothingFullReductionMapper;
import com.xhm.fz.mapper.ClothingLadderMapper;
import com.xhm.fz.mapper.ClothingMapper;
import com.xhm.fz.mapper.MemberPriceMapper;
import com.xhm.fz.mapper.PrefrenceAreaClothingRelationMapper;
import com.xhm.fz.mapper.SkuStockMapper;
import com.xhm.fz.mapper.SubjectClothingRelationMapper;
import com.xhm.fz.service.ClothingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.log4j.Log4j2;

/**
 * 商品管理Service实现类
 * Created by xhm on 2018/4/26.
 */
@Log4j2
@Service
public class ClothingServiceImpl implements ClothingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClothingServiceImpl.class);
    @Autowired
    private ClothingMapper clothingMapper;
    @Autowired
    private MemberPriceDao memberPriceDao;
    @Autowired
    private MemberPriceMapper memberPriceMapper;
    @Autowired
    private ClothingLadderDao clothingLadderDao;
    @Autowired
    private ClothingLadderMapper clothingLadderMapper;
    @Autowired
    private ClothingFullReductionDao clothingFullReductionDao;
    @Autowired
    private ClothingFullReductionMapper clothingFullReductionMapper;
    @Autowired
    private SkuStockDao skuStockDao;
    @Autowired
    private SkuStockMapper skuStockMapper;
    @Autowired
    private ClothingAttributeValueDao clothingAttributeValueDao;
    @Autowired
    private ClothingAttributeValueMapper clothingAttributeValueMapper;
    @Autowired
    private SubjectClothingRelationDao subjectClothingRelationDao;
    @Autowired
    private SubjectClothingRelationMapper subjectClothingRelationMapper;
    @Autowired
    private PrefrenceAreaClothingRelationDao prefrenceAreaClothingRelationDao;
    @Autowired
    private PrefrenceAreaClothingRelationMapper prefrenceAreaClothingRelationMapper;
    @Autowired
    private ClothingDao clothingDao;
    // @Autowired
    // private ClothingVertifyRecordDao clothingVertifyRecordDao;

    @Override
    public int create(ClothingParam clothingParam) {
        log.info("this.clothingParam" + ", " + clothingParam);
        int count;
        //创建商品
        Clothing clothing = clothingParam;
        clothing.setId(null);
        clothingMapper.insertSelective(clothing);
        //根据促销类型设置价格：会员价格、阶梯价格、满减价格
        Long clothingId = clothing.getId();
        //会员价格
        relateAndInsertList(memberPriceDao, clothingParam.getMemberPriceList(), clothingId);
        //阶梯价格
        relateAndInsertList(clothingLadderDao, clothingParam.getClothingLadderList(), clothingId);
        //满减价格
        relateAndInsertList(clothingFullReductionDao, clothingParam.getClothingFullReductionList(), clothingId);
        //处理sku的编码
        handleSkuStockCode(clothingParam.getSkuStockList(),clothingId);
        //添加sku库存信息
        relateAndInsertList(skuStockDao, clothingParam.getSkuStockList(), clothingId);
        //添加商品参数,添加自定义商品规格
        relateAndInsertList(clothingAttributeValueDao, clothingParam.getClothingAttributeValueList(), clothingId);
        //关联专题
        relateAndInsertList(subjectClothingRelationDao, clothingParam.getSubjectClothingRelationList(), clothingId);
        //关联优选
        relateAndInsertList(prefrenceAreaClothingRelationDao, clothingParam.getPrefrenceAreaClothingRelationList(), clothingId);
        count = 1;
        return count;
    }

    private void handleSkuStockCode(List<SkuStock> skuStockList, Long clothingId) {
        if(CollectionUtils.isEmpty(skuStockList))return;
        for(int i=0;i<skuStockList.size();i++){
            SkuStock skuStock = skuStockList.get(i);
            if(StringUtils.isEmpty(skuStock.getSkuCode())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04d", clothingId));
                //三位索引id
                sb.append(String.format("%03d", i+1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }

    @Override
    public ClothingResult getUpdateInfo(Long id) {
        return clothingDao.getUpdateInfo(id);
    }

    @Override
    public int update(Long id, ClothingParam clothingParam) {
        int count;
        //更新商品信息
        Clothing clothing = clothingParam;
        clothing.setId(id);
        clothingMapper.updateByPrimaryKeySelective(clothing);
        //会员价格
        MemberPriceExample MemberPriceExample = new MemberPriceExample();
        MemberPriceExample.createCriteria().andClothingIdEqualTo(id);
        memberPriceMapper.deleteByExample(MemberPriceExample);
        relateAndInsertList(memberPriceDao, clothingParam.getMemberPriceList(), id);
        //阶梯价格
        ClothingLadderExample ladderExample = new ClothingLadderExample();
        ladderExample.createCriteria().andClothingIdEqualTo(id);
        clothingLadderMapper.deleteByExample(ladderExample);
        relateAndInsertList(clothingLadderDao, clothingParam.getClothingLadderList(), id);
        //满减价格
        ClothingFullReductionExample fullReductionExample = new ClothingFullReductionExample();
        fullReductionExample.createCriteria().andClothingIdEqualTo(id);
        clothingFullReductionMapper.deleteByExample(fullReductionExample);
        relateAndInsertList(clothingFullReductionDao, clothingParam.getClothingFullReductionList(), id);
        //修改sku库存信息
        handleUpdateSkuStockList(id, clothingParam);
        //修改商品参数,添加自定义商品规格
        ClothingAttributeValueExample clothingAttributeValueExample = new ClothingAttributeValueExample();
        clothingAttributeValueExample.createCriteria().andClothingIdEqualTo(id);
        clothingAttributeValueMapper.deleteByExample(clothingAttributeValueExample);
        relateAndInsertList(clothingAttributeValueDao, clothingParam.getClothingAttributeValueList(), id);
        //关联专题
        SubjectClothingRelationExample subjectClothingRelationExample = new SubjectClothingRelationExample();
        subjectClothingRelationExample.createCriteria().andClothingIdEqualTo(id);
        subjectClothingRelationMapper.deleteByExample(subjectClothingRelationExample);
        relateAndInsertList(subjectClothingRelationDao, clothingParam.getSubjectClothingRelationList(), id);
        //关联优选
        PrefrenceAreaClothingRelationExample prefrenceAreaExample = new PrefrenceAreaClothingRelationExample();
        prefrenceAreaExample.createCriteria().andClothingIdEqualTo(id);
        prefrenceAreaClothingRelationMapper.deleteByExample(prefrenceAreaExample);
        relateAndInsertList(prefrenceAreaClothingRelationDao, clothingParam.getPrefrenceAreaClothingRelationList(), id);
        count = 1;
        return count;
    }

    private void handleUpdateSkuStockList(Long id, ClothingParam clothingParam) {
        //当前的sku信息
        List<SkuStock> currSkuList = clothingParam.getSkuStockList();
        //当前没有sku直接删除
        if(CollUtil.isEmpty(currSkuList)){
            SkuStockExample skuStockExample = new SkuStockExample();
            skuStockExample.createCriteria().andClothingIdEqualTo(id);
            skuStockMapper.deleteByExample(skuStockExample);
            return;
        }
        //获取初始sku信息
        SkuStockExample skuStockExample = new SkuStockExample();
        skuStockExample.createCriteria().andClothingIdEqualTo(id);
        List<SkuStock> oriStuList = skuStockMapper.selectByExample(skuStockExample);
        //获取新增sku信息
        List<SkuStock> insertSkuList = currSkuList.stream().filter(item->item.getId()==null).collect(Collectors.toList());
        //获取需要更新的sku信息
        List<SkuStock> updateSkuList = currSkuList.stream().filter(item->item.getId()!=null).collect(Collectors.toList());
        List<Long> updateSkuIds = updateSkuList.stream().map(SkuStock::getId).collect(Collectors.toList());
        //获取需要删除的sku信息
        List<SkuStock> removeSkuList = oriStuList.stream().filter(item-> !updateSkuIds.contains(item.getId())).collect(Collectors.toList());
        handleSkuStockCode(insertSkuList,id);
        handleSkuStockCode(updateSkuList,id);
        //新增sku
        if(CollUtil.isNotEmpty(insertSkuList)){
            relateAndInsertList(skuStockDao, insertSkuList, id);
        }
        //删除sku
        if(CollUtil.isNotEmpty(removeSkuList)){
            List<Long> removeSkuIds = removeSkuList.stream().map(SkuStock::getId).collect(Collectors.toList());
            SkuStockExample removeExample = new SkuStockExample();
            removeExample.createCriteria().andIdIn(removeSkuIds);
            skuStockMapper.deleteByExample(removeExample);
        }
        //修改sku
        if(CollUtil.isNotEmpty(updateSkuList)){
            for (SkuStock SkuStock : updateSkuList) {
                skuStockMapper.updateByPrimaryKeySelective(SkuStock);
            }
        }

    }

    @Override
    public List<Clothing> list(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ClothingExample clothingExample = new ClothingExample();
        ClothingExample.Criteria criteria = clothingExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (clothingQueryParam.getPublishStatus() != null) {
            criteria.andPublishStatusEqualTo(clothingQueryParam.getPublishStatus());
        }
        if (clothingQueryParam.getVerifyStatus() != null) {
            criteria.andVerifyStatusEqualTo(clothingQueryParam.getVerifyStatus());
        }
        if (!StringUtils.isEmpty(clothingQueryParam.getKeyword())) {
            criteria.andNameLike("%" + clothingQueryParam.getKeyword() + "%");
        }
        if (!StringUtils.isEmpty(clothingQueryParam.getClothingSn())) {
            criteria.andClothingSnEqualTo(clothingQueryParam.getClothingSn());
        }
        if (clothingQueryParam.getBrandId() != null) {
            criteria.andBrandIdEqualTo(clothingQueryParam.getBrandId());
        }
        if (clothingQueryParam.getClothingCategoryId() != null) {
            criteria.andClothingCategoryIdEqualTo(clothingQueryParam.getClothingCategoryId());
        }
        return clothingMapper.selectByExample(clothingExample);
    }

    @Override
    public List<Clothing> listTide(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ClothingExample clothingExample = new ClothingExample();
        ClothingExample.Criteria criteria = clothingExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (clothingQueryParam.getClothingCategoryId() != null) {
            criteria.andClothingCategoryIdEqualTo(clothingQueryParam.getClothingCategoryId());
        }
        return clothingMapper.selectByExampleWithCategoryTide(clothingExample);
    }

    @Override
    public List<Clothing> listSimple(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ClothingExample clothingExample = new ClothingExample();
        ClothingExample.Criteria criteria = clothingExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (clothingQueryParam.getClothingCategoryId() != null) {
            criteria.andClothingCategoryIdEqualTo(clothingQueryParam.getClothingCategoryId());
        }
        return clothingMapper.selectByExampleWithCategorySimple(clothingExample);
    }

    @Override
    public List<Clothing> listSport(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ClothingExample clothingExample = new ClothingExample();
        ClothingExample.Criteria criteria = clothingExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (clothingQueryParam.getClothingCategoryId() != null) {
            criteria.andClothingCategoryIdEqualTo(clothingQueryParam.getClothingCategoryId());
        }
        return clothingMapper.selectByExampleWithCategorySport(clothingExample);
    }

    @Override
    public List<Clothing> listNation(ClothingQueryParam clothingQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ClothingExample clothingExample = new ClothingExample();
        ClothingExample.Criteria criteria = clothingExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (clothingQueryParam.getClothingCategoryId() != null) {
            criteria.andClothingCategoryIdEqualTo(clothingQueryParam.getClothingCategoryId());
        }
        return clothingMapper.selectByExampleWithCategoryNation(clothingExample);
    }

    // @Override
    // public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
    //     Clothing clothing = new Clothing();
    //     clothing.setVerifyStatus(verifyStatus);
    //     ClothingExample example = new ClothingExample();
    //     example.createCriteria().andIdIn(ids);
    //     List<ClothingVertifyRecord> list = new ArrayList<>();
    //     int count = clothingMapper.updateByExampleSelective(clothing, example);
    //     //修改完审核状态后插入审核记录
    //     for (Long id : ids) {
    //         ClothingVertifyRecord record = new ClothingVertifyRecord();
    //         record.setClothingId(id);
    //         record.setCreateTime(new Date());
    //         record.setDetail(detail);
    //         record.setStatus(verifyStatus);
    //         record.setVertifyMan("test");
    //         list.add(record);
    //     }
    //     clothingVertifyRecordDao.insertList(list);
    //     return count;
    // }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        Clothing record = new Clothing();
        record.setPublishStatus(publishStatus);
        ClothingExample example = new ClothingExample();
        example.createCriteria().andIdIn(ids);
        return clothingMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        Clothing record = new Clothing();
        record.setRecommandStatus(recommendStatus);
        ClothingExample example = new ClothingExample();
        example.createCriteria().andIdIn(ids);
        return clothingMapper.updateByExampleSelective(record, example);
    }

    // @Override
    // public int updateNewStatus(List<Long> ids, Integer newStatus) {
    //     Clothing record = new Clothing();
    //     record.setNewStatus(newStatus);
    //     ClothingExample example = new ClothingExample();
    //     example.createCriteria().andIdIn(ids);
    //     return clothingMapper.updateByExampleSelective(record, example);
    // }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        Clothing record = new Clothing();
        record.setDeleteStatus(deleteStatus);
        ClothingExample example = new ClothingExample();
        example.createCriteria().andIdIn(ids);
        return clothingMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<Clothing> list(String keyword) {
        ClothingExample clothingExample = new ClothingExample();
        ClothingExample.Criteria criteria = clothingExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if(!StringUtils.isEmpty(keyword)){
            criteria.andNameLike("%" + keyword + "%");
            clothingExample.or().andDeleteStatusEqualTo(0).andClothingSnLike("%" + keyword + "%");
        }
        return clothingMapper.selectByExample(clothingExample);
    }

    // /**
    //  * 建立和插入关系表操作
    //  *
    //  * @param dao       可以操作的dao
    //  * @param dataList  要插入的数据
    //  * @param clothingId 建立关系的id
    //  */
    private <E> void relateAndInsertList(Object dao, List<E> dataList, Long clothingId) {
        try {
            log.info("message----" + dao + ", " + dataList + ", " + clothingId);
            if (CollectionUtils.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item, (Long) null);
                Method setClothingId = item.getClass().getMethod("setClothingId", Long.class);
                setClothingId.invoke(item, clothingId);
            }
            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao, dataList);
        } catch (Exception e) {
            LOGGER.warn("创建产品出错:{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
