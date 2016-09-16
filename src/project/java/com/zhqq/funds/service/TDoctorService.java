package com.zhqq.funds.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.zhqq.funds.DTO.TDoctorDTO;

import cn.osworks.aos.core.typewrap.Dto;

public interface TDoctorService {
	
	/**
	 * 导出Excel
	 * @param inDto
	 * @param sheetName
	 * @param out
	 * @param type
     * @throws IOException
     */
	public void exportExcel(Dto inDto, String sheetName, OutputStream out, String type) throws Exception ;

	
	public void addDoctor(TDoctorDTO tDoctorDTO) throws Exception;
	
	
	/**
	 * 
	 * 查找医生列表
	 * @param hotkey 关键字
	 * @param doctorQueryType 过滤类型
	 * @param page 查找页
	 * @param start 起始行
	 * @param limit 限制条数
	 * @return
	 * @throws Exception
	 */
	public List<TDoctorDTO> queryDoctorList(String hotkey ,String doctorQueryType,String page,String start,String limit,boolean pageFlag) throws Exception;
	
	/**
	 * 查找总数
	 * @param hotkey
	 * @param doctorQueryType
	 * @return
	 * @throws Exception
	 */
	public int queryDoctorCount(String hotkey ,String doctorQueryType) throws Exception;
	
	
	/**
	 * 根据医生ID获取医生
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TDoctorDTO getDoctorByID(String id) throws Exception;
	
	/**
	 * 删除医生信息
	 * @param ids
	 * @throws Exception
	 */
	public void deleteDoctors(String ids) throws Exception;
	
	public void updateDoctor(TDoctorDTO tDoctorDTO) throws Exception;
	
	/**
	 * 导入医生信息
	 * @param workbook
	 * @throws Exception
	 */
	public void importDoctorExcel(Workbook workbook) throws Exception;
	
	
}
