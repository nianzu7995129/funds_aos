package com.zhqq.funds.mapper;

import com.zhqq.funds.po.THospitalMapping;
import com.zhqq.funds.po.THospitalMappingExample;

import cn.osworks.aos.core.annotation.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface THospitalMappingMapper {
    int countByExample(THospitalMappingExample example);

    int deleteByExample(THospitalMappingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(THospitalMapping record);

    int insertSelective(THospitalMapping record);

    List<THospitalMapping> selectByExample(THospitalMappingExample example);

    THospitalMapping selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") THospitalMapping record, @Param("example") THospitalMappingExample example);

    int updateByExample(@Param("record") THospitalMapping record, @Param("example") THospitalMappingExample example);

    int updateByPrimaryKeySelective(THospitalMapping record);

    int updateByPrimaryKey(THospitalMapping record);
}