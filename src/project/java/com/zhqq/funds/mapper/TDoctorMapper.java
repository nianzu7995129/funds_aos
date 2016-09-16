package com.zhqq.funds.mapper;

import com.zhqq.funds.po.TDoctor;
import com.zhqq.funds.po.TDoctorExample;

import cn.osworks.aos.core.annotation.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TDoctorMapper {
    int countByExample(TDoctorExample example);

    int deleteByExample(TDoctorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDoctor record);

    int insertSelective(TDoctor record);

    List<TDoctor> selectByExample(TDoctorExample example);

    TDoctor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDoctor record, @Param("example") TDoctorExample example);

    int updateByExample(@Param("record") TDoctor record, @Param("example") TDoctorExample example);

    int updateByPrimaryKeySelective(TDoctor record);

    int updateByPrimaryKey(TDoctor record);
}