package com.xhm.fz.mapper;

import com.xhm.fz.entity.MemberPrice;
import com.xhm.fz.entity.MemberPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberPriceMapper {
    long countByExample(MemberPriceExample example);

    int deleteByExample(MemberPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberPrice record);

    int insertSelective(MemberPrice record);

    List<MemberPrice> selectByExample(MemberPriceExample example);

    MemberPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberPrice record, @Param("example") MemberPriceExample example);

    int updateByExample(@Param("record") MemberPrice record, @Param("example") MemberPriceExample example);

    int updateByPrimaryKeySelective(MemberPrice record);

    int updateByPrimaryKey(MemberPrice record);
}