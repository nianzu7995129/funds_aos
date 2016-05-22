package com.zhqq.funds.mapper;

import com.zhqq.funds.po.TPatient;
import com.zhqq.funds.po.TPatientExample;

import cn.osworks.aos.core.annotation.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TPatientMapper {
    int countByExample(TPatientExample example);

    int deleteByExample(TPatientExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatient record);

    int insertSelective(TPatient record);

    List<TPatient> selectByExample(TPatientExample example);

    TPatient selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatient record, @Param("example") TPatientExample example);

    int updateByExample(@Param("record") TPatient record, @Param("example") TPatientExample example);

    int updateByPrimaryKeySelective(TPatient record);

    int updateByPrimaryKey(TPatient record);
}