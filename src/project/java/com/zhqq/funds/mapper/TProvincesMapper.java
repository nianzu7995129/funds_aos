package com.zhqq.funds.mapper;

import com.zhqq.funds.po.TProvinces;
import com.zhqq.funds.po.TProvincesExample;

import cn.osworks.aos.core.annotation.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TProvincesMapper {
    int countByExample(TProvincesExample example);

    int deleteByExample(TProvincesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProvinces record);

    int insertSelective(TProvinces record);

    List<TProvinces> selectByExample(TProvincesExample example);

    TProvinces selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProvinces record, @Param("example") TProvincesExample example);

    int updateByExample(@Param("record") TProvinces record, @Param("example") TProvincesExample example);

    int updateByPrimaryKeySelective(TProvinces record);

    int updateByPrimaryKey(TProvinces record);
}