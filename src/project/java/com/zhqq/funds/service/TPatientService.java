package com.zhqq.funds.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import cn.osworks.aos.core.typewrap.Dto;
import com.zhqq.funds.DTO.TPatientDTO;

public interface TPatientService {
	
	public void addPatient(TPatientDTO tPatientDTO) throws Exception;
	
	/**
	 * 患者查询
	 * @param name
	 * @param idcardnumber
	 * @return
	 * @throws Exception
	 */
	public TPatientDTO queryPatient(String name ,String idcardnumber) throws Exception;
	
	/**
	 * 检查患者姓名是否存在
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public boolean checkName(String name ) throws Exception;
	
	/**
	 * 检查患者身份证号是否存在
	 * @param name
	 * @param idcardnumber
	 * @return
	 * @throws Exception
	 */
	public boolean checkCdCard(String name ,String idcardnumber) throws Exception;
	
	/**
	 * 
	 * 查找患者列表
	 * @param hotkey 关键字
	 * @param patientQueryType 过滤类型
	 * @param page 查找页
	 * @param start 起始行
	 * @param limit 限制条数
	 * @return
	 * @throws Exception
	 */
	public List<TPatientDTO> queryPatientList(String hotkey ,String patientQueryType,String page,String start,String limit) throws Exception;
	
	/**
	 * 查找总数
	 * @param hotkey
	 * @param patientQueryType
	 * @return
	 * @throws Exception
	 */
	public int queryPatientCount(String hotkey ,String patientQueryType) throws Exception;


	/**
	 * 导出Excel
	 * @param inDto
	 * @param sheetName
	 * @param out
	 * @param type
     * @throws IOException
     */
	public void exportExcel(Dto inDto, String sheetName, OutputStream out, String type) throws IOException ;
	
	
}
