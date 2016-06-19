package com.zhqq.funds.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.zhqq.funds.DTO.TPatientDTO;

import cn.osworks.aos.core.typewrap.Dto;

public interface TPatientService {
	
	/**
	 * 导出Excel
	 * @param inDto
	 * @param sheetName
	 * @param out
	 * @param type
     * @throws IOException
     */
	public void exportExcel(Dto inDto, String sheetName, OutputStream out, String type) throws Exception ;

	
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
	public List<TPatientDTO> queryPatientList(String hotkey ,String patientQueryType,String page,String start,String limit,boolean pageFlag) throws Exception;
	
	/**
	 * 查找总数
	 * @param hotkey
	 * @param patientQueryType
	 * @return
	 * @throws Exception
	 */
	public int queryPatientCount(String hotkey ,String patientQueryType) throws Exception;
	
	
	/**
	 * 
	 * 查找患者列表HR
	 * @param hotkey 关键字
	 * @param patientQueryType 过滤类型
	 * @param page 查找页
	 * @param start 起始行
	 * @param limit 限制条数
	 * @return
	 * @throws Exception
	 */
	public List<TPatientDTO> queryPatientListHR(String hotkey ,String patientQueryType,String hr,String page,String start,String limit,boolean pageFlag) throws Exception;
	
	/**
	 * 查找总数HR
	 * @param hotkey
	 * @param patientQueryType
	 * @return
	 * @throws Exception
	 */
	public int queryPatientCountHR(String hotkey ,String patientQueryType,String hr) throws Exception;
	
	/**
	 * 根据患者ID获取患者
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TPatientDTO getPatientByID(String id) throws Exception;
	
	/**
	 * 删除患者信息
	 * @param ids
	 * @throws Exception
	 */
	public void deletePatients(String ids) throws Exception;
	
	public void updatePatient(TPatientDTO tPatientDTO) throws Exception;
	
	/**
	 * 导入患者信息
	 * @param workbook
	 * @throws Exception
	 */
	public void importPatientExcel(Workbook workbook) throws Exception;
	
	
}
