package com.zhqq.funds.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.zhqq.funds.DTO.THospitalMappingDTO;

import cn.osworks.aos.core.typewrap.Dto;

public interface THdService {
	
	/**
	 * 导出Excel
	 * @param inDto
	 * @param sheetName
	 * @param out
	 * @param type
     * @throws IOException
     */
	public void exportExcel(Dto inDto, String sheetName, OutputStream out, String type) throws Exception ;

	
	public void addHospitalMapping(THospitalMappingDTO tHospitalMappingDTO) throws Exception;
	
	
	/**
	 * 
	 * 查找医院医生关联列表
	 * @param hotkey 关键字
	 * @param doctorQueryType 过滤类型
	 * @param page 查找页
	 * @param start 起始行
	 * @param limit 限制条数
	 * @return
	 * @throws Exception
	 */
	public List<THospitalMappingDTO> queryHospitalMappingList(String hotkey ,String doctorQueryType,String page,String start,String limit,boolean pageFlag) throws Exception;
	
	/**
	 * 查找总数
	 * @param hotkey
	 * @param doctorQueryType
	 * @return
	 * @throws Exception
	 */
	public int queryHospitalMappingCount(String hotkey ,String doctorQueryType) throws Exception;
	
	
	/**
	 * 根据医院医生关联ID获取医院医生关联
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public THospitalMappingDTO getHospitalMappingByID(String id) throws Exception;
	
	/**
	 * 删除医院医生关联信息
	 * @param ids
	 * @throws Exception
	 */
	public void deleteHospitalMappings(String ids) throws Exception;
	
	public void updateHospitalMapping(THospitalMappingDTO tHospitalMappingDTO) throws Exception;
	
	/**
	 * 导入医院医生关联信息
	 * @param workbook
	 * @throws Exception
	 */
	public void importHospitalMappingExcel(Workbook workbook) throws Exception;
	
	/**
	 * 根据条件查询医院医生关系
	 * @param key
	 * @param doctorQueryType
	 * @return
	 */
	public List<THospitalMappingDTO> getHospitalMappingListByCondition(String key ,String doctorQueryType);
	
	
}
