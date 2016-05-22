package com.zhqq.funds.mapper;

import com.zhqq.funds.po.TDrugrelease;
import com.zhqq.funds.po.TDrugreleaseExample;

import cn.osworks.aos.core.annotation.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TDrugreleaseMapper {
    int countByExample(TDrugreleaseExample example);

    int deleteByExample(TDrugreleaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDrugrelease record);

    int insertSelective(TDrugrelease record);

    List<TDrugrelease> selectByExample(TDrugreleaseExample example);

    TDrugrelease selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDrugrelease record, @Param("example") TDrugreleaseExample example);

    int updateByExample(@Param("record") TDrugrelease record, @Param("example") TDrugreleaseExample example);

    int updateByPrimaryKeySelective(TDrugrelease record);

    int updateByPrimaryKey(TDrugrelease record);
}