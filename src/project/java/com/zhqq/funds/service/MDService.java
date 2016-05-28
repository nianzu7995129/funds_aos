package com.zhqq.funds.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.zhqq.funds.DTO.TDrugreleaseDTO;

import cn.osworks.aos.core.typewrap.Dto;

public interface MDService {
	
	/**
	 * 导出Excel
	 * @param inDto
	 * @param sheetName
	 * @param out
	 * @param type
     * @throws IOException
     */
	public void exportExcel(Dto inDto, String sheetName, OutputStream out, String type) throws Exception ;
	
	
	public void addDrugrelease(TDrugreleaseDTO tDrugreleaseDTO) throws Exception;
	
	/**
	 * 医药下发查询
	 * @param name
	 * @param idcardnumber
	 * @return
	 * @throws Exception
	 */
	public TDrugreleaseDTO queryPatient(String name ,String idcardnumber) throws Exception;
	
	/**
	 * 检查医药下发姓名是否存在
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public boolean checkName(String name ) throws Exception;
	
	/**
	 * 检查医药下发身份证号是否存在
	 * @param name
	 * @param idcardnumber
	 * @return
	 * @throws Exception
	 */
	public boolean checkCdCard(String name ,String idcardnumber) throws Exception;
	
	/**
	 * 
	 * 查找医药下发列表
	 * @param hotkey 关键字
	 * @param patientQueryType 过滤类型
	 * @param mdDateType 预计发药时间
	 * @param page 查找页
	 * @param start 起始行
	 * @param limit 限制条数
	 * @return
	 * @throws Exception
	 */
	public List<TDrugreleaseDTO> queryMDList(String hotkey ,String patientQueryType,String mdDateType,String page,String start,String limit,boolean pageFlag) throws Exception;
	
	/**
	 * 查找总数
	 * @param hotkey
	 * @param patientQueryType
	 * @return
	 * @throws Exception
	 */
	public int queryMDCount(String hotkey ,String patientQueryType,String mdDateType) throws Exception;
	
	/**
	 * 根据医药下发ID获取医药下发
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TDrugreleaseDTO getMDByID(String id) throws Exception;
	
	/**
	 * 删除医药下发信息
	 * @param ids
	 * @throws Exception
	 */
	public void deleteMDs(String ids) throws Exception;
	
	public void updateMD(TDrugreleaseDTO tPatientDTO) throws Exception;
	
	
}
