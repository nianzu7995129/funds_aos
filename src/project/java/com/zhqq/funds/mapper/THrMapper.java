package com.zhqq.funds.mapper;

import com.zhqq.funds.po.THr;
import com.zhqq.funds.po.THrExample;

import cn.osworks.aos.core.annotation.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface THrMapper {
    int countByExample(THrExample example);

    int deleteByExample(THrExample example);

    int deleteByPrimaryKey(Long id);

    int insert(THr record);

    int insertSelective(THr record);

    List<THr> selectByExample(THrExample example);

    THr selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") THr record, @Param("example") THrExample example);

    int updateByExample(@Param("record") THr record, @Param("example") THrExample example);

    int updateByPrimaryKeySelective(THr record);

    int updateByPrimaryKey(THr record);
}