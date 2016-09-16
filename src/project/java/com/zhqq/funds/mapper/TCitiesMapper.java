package com.zhqq.funds.mapper;

import com.zhqq.funds.po.TCities;
import com.zhqq.funds.po.TCitiesExample;

import cn.osworks.aos.core.annotation.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TCitiesMapper {
    int countByExample(TCitiesExample example);

    int deleteByExample(TCitiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCities record);

    int insertSelective(TCities record);

    List<TCities> selectByExample(TCitiesExample example);

    TCities selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCities record, @Param("example") TCitiesExample example);

    int updateByExample(@Param("record") TCities record, @Param("example") TCitiesExample example);

    int updateByPrimaryKeySelective(TCities record);

    int updateByPrimaryKey(TCities record);
}