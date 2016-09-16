package com.zhqq.funds.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.zhqq.funds.DTO.THrDTO;

import cn.osworks.aos.core.typewrap.Dto;

public interface THrService {
	
	/**
	 * 导出Excel
	 * @param inDto
	 * @param sheetName
	 * @param out
	 * @param type
     * @throws IOException
     */
	public void exportExcel(Dto inDto, String sheetName, OutputStream out, String type) throws Exception ;

	
	public void addHr(THrDTO tHrDTO) throws Exception;
	
	
	/**
	 * 
	 * 查找专员列表
	 * @param hotkey 关键字
	 * @param hrQueryType 过滤类型
	 * @param page 查找页
	 * @param start 起始行
	 * @param limit 限制条数
	 * @return
	 * @throws Exception
	 */
	public List<THrDTO> queryHrList(String hotkey ,String hrQueryType,String page,String start,String limit,boolean pageFlag) throws Exception;
	
	/**
	 * 查找总数
	 * @param hotkey
	 * @param hrQueryType
	 * @return
	 * @throws Exception
	 */
	public int queryHrCount(String hotkey ,String hrQueryType) throws Exception;
	
	
	/**
	 * 根据专员ID获取专员
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public THrDTO getHrByID(String id) throws Exception;
	
	/**
	 * 删除专员信息
	 * @param ids
	 * @throws Exception
	 */
	public void deleteHrs(String ids) throws Exception;
	
	public void updateHr(THrDTO tHrDTO) throws Exception;
	
	/**
	 * 导入专员信息
	 * @param workbook
	 * @throws Exception
	 */
	public void importHrExcel(Workbook workbook) throws Exception;
	
	
}
