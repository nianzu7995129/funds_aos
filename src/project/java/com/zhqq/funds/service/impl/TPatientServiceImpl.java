package com.zhqq.funds.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.po.TPatient;
import com.zhqq.funds.mapper.TPatientMapper;
import com.zhqq.funds.po.TPatientExample;
import com.zhqq.funds.service.TPatientService;
import com.zhqq.funds.utils.PatientUtils;
import com.zhqq.funds.utils.SQLUtils;

import cn.osworks.aos.core.asset.AOSJson;
import cn.osworks.aos.core.asset.AOSUtils;
import cn.osworks.aos.core.typewrap.Dto;


@Service
public class TPatientServiceImpl implements TPatientService {

	@Autowired
	private TPatientMapper tPatientMapper;
	
	@Override
	public void addPatient(TPatientDTO tPatient) throws Exception {
		TPatient record = new TPatient();
		AOSUtils.copyProperties(tPatient, record);
		tPatientMapper.insert(record);
	}

	@Override
	public TPatientDTO queryPatient(String name, String idcardnumber) throws Exception {
		TPatientDTO rlt = new TPatientDTO();
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();  
		criteria.andNameEqualTo(name);
		criteria.andIdcardnumberEqualTo(idcardnumber);
		List<TPatient> list = tPatientMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			TPatient po = list.get(0);
			AOSUtils.copyProperties(po, rlt);
		}
		return rlt;
	}

	@Override
	public boolean checkName(String name) throws Exception {
		TPatientExample example = new TPatientExample();
		example.createCriteria().andNameEqualTo(name);
		int count = tPatientMapper.countByExample(example);
		return count==0 ? false : true;
	}

	@Override
	public boolean checkCdCard(String name, String idcardnumber) throws Exception {
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();  
		criteria.andNameEqualTo(name);
		criteria.andIdcardnumberEqualTo(idcardnumber);
		int count = tPatientMapper.countByExample(example);
		return count==0 ? false : true;
	}

	/* (non-Javadoc)
	 * @see com.zhqq.funds.service.TPatientService#queryPatientList(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<TPatientDTO> queryPatientList(String hotkey, String patientQueryType, String page, String start,
			String limit,boolean pageFlag) throws Exception {
		List<TPatientDTO> rlt = new ArrayList<TPatientDTO>();
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(hotkey)){
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(patientQueryType)){
				criteria.andArchivesLike(hotkey);
			}else if("1".equals(patientQueryType)){
				criteria.andStateLike(hotkey);
			}else if("2".equals(patientQueryType)){
				criteria.andNameLike(hotkey);
			}else if("3".equals(patientQueryType)){
				criteria.andSexLike(hotkey);
			}else if("4".equals(patientQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("5".equals(patientQueryType)){
				criteria.andHrLike(hotkey);
			}else if("6".equals(patientQueryType)){
				criteria.andLangMuHospitalLike(hotkey);
			}else if("7".equals(patientQueryType)){
				criteria.andLangMuDoctorLike(hotkey);
			}
		}
		if(pageFlag){
			example.setLimitStart(Integer.valueOf(start));
			example.setLimitEnd(Integer.valueOf(start)+Integer.valueOf(limit));
		}
		List<TPatient> list = tPatientMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(TPatient po : list){
				TPatientDTO dto = new TPatientDTO();
				AOSUtils.copyProperties(po, dto);
				rlt.add(dto);
			}
		}
		return rlt;
	}

	@Override
	public int queryPatientCount(String hotkey, String patientQueryType) throws Exception {
		int rlt = 0;
		TPatientExample example = new TPatientExample();  
		if(!StringUtils.isEmpty(hotkey)){
			TPatientExample.Criteria criteria = example.createCriteria();
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(patientQueryType)){
				criteria.andArchivesLike(hotkey);
			}else if("1".equals(patientQueryType)){
				criteria.andStateLike(hotkey);
			}else if("2".equals(patientQueryType)){
				criteria.andNameLike(hotkey);
			}else if("3".equals(patientQueryType)){
				criteria.andSexLike(hotkey);
			}else if("4".equals(patientQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("5".equals(patientQueryType)){
				criteria.andHrLike(hotkey);
			}else if("6".equals(patientQueryType)){
				criteria.andLangMuHospitalLike(hotkey);
			}else if("7".equals(patientQueryType)){
				criteria.andLangMuDoctorLike(hotkey);
			}
		}
		rlt = tPatientMapper.countByExample(example);
		return rlt;
	}

	@Override
	public TPatientDTO getPatientByID(String id) throws Exception {
		TPatientDTO rlt = new TPatientDTO();
		TPatient po = tPatientMapper.selectByPrimaryKey(Integer.valueOf(id));
		AOSUtils.copyProperties(po, rlt);
		return rlt;
	}

	@Override
	public void deletePatients(String ids) throws Exception {
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();  
		if (StringUtils.isNotEmpty(ids)) {
			String[] temps = ids.split(",");
			List<Integer> values = new ArrayList<Integer>();
			for(String temp : temps){
				values.add(Integer.valueOf(temp));
			}
			criteria.andIdIn(values);
			tPatientMapper.deleteByExample(example);
		}
		
		
		
	}

	@Override
	public void updatePatient(TPatientDTO tPatientDTO) throws Exception {
		TPatient record = new TPatient();
		AOSUtils.copyProperties(tPatientDTO, record);
		tPatientMapper.updateByPrimaryKey(record);
	}
	
	public void exportExcel(Dto inDto, String sheetName, OutputStream out, String type) throws Exception {
		if("2003".equals(type)){
			HSSFWorkbook hssfWorkbook = export2003Excel(inDto,sheetName);
			hssfWorkbook.write(out);
		}else {
			XSSFWorkbook xssfWorkbook = export2007Excel(inDto,sheetName);
			xssfWorkbook.write(out);
		}
		out.flush();
		out.close();
	}

	public HSSFWorkbook export2003Excel(Dto inDto,String sheetName) throws Exception {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(sheetName);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式ß
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);


		String hotkey = inDto.getString("hotkey");
		String patientQueryType = inDto.getString("patientQueryType");
		List<TPatientDTO> patientList = queryPatientList(hotkey, patientQueryType, "", "", "", false);
		PatientUtils.proTPatientDTO(patientList);
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		createTitle(row);
		int size = patientList.size();
		for(int i=1;i<=size;i++){
			HSSFRow dataRow = sheet.createRow(i);
			createData(dataRow,patientList.get(i-1));
		}
		return workbook;
	}
	
	/**
	 * @param row
	 */
	private void createData(HSSFRow row,TPatientDTO tPatientDTO) {
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(tPatientDTO.getArchives());
		cell = row.createCell(1);
		cell.setCellValue(tPatientDTO.getState());
		cell = row.createCell(2);
		cell.setCellValue(tPatientDTO.getName());
		cell = row.createCell(3);
		cell.setCellValue(tPatientDTO.getSex());
		cell = row.createCell(4);
		cell.setCellValue(tPatientDTO.getAddress());
		cell = row.createCell(5);
		cell.setCellValue(tPatientDTO.getPhone());
		cell = row.createCell(6);
		cell.setCellValue(tPatientDTO.getIdcardnumber());
		cell = row.createCell(7);
		cell.setCellValue(tPatientDTO.getDiagnosticMaterial());
		cell = row.createCell(8);
		cell.setCellValue(tPatientDTO.getProofIdentity());
		cell = row.createCell(9);
		cell.setCellValue(tPatientDTO.getProofIncome());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getPurchaseInvoice());
		cell = row.createCell(11);
		cell.setCellValue(tPatientDTO.getMedicalEvaluationForm());
		cell = row.createCell(12);
		cell.setCellValue(tPatientDTO.getInformedConsentOfPatients());
		cell = row.createCell(13);
		cell.setCellValue(tPatientDTO.getPatienteConomicStatus());
		cell = row.createCell(14);
		cell.setCellValue(tPatientDTO.getColdChainDrugInformedConsent());
		cell = row.createCell(15);
		cell.setCellValue(tPatientDTO.getHr());
		cell = row.createCell(16);
		cell.setCellValue(tPatientDTO.getLangMuHospital());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getLangMuDoctor());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getEstimatedTimeToIncreaseDrugInjection());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getRemarks());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getRecipientsReceiveSingleDrug());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getEndOfStatement());
	}

	/**
	 * @param row
	 */
	private void createTitle(HSSFRow row) {
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("档案编号");
		cell = row.createCell(1);
		cell.setCellValue("是否通过");
		cell = row.createCell(2);
		cell.setCellValue("姓名");
		cell = row.createCell(3);
		cell.setCellValue("性别");
		cell = row.createCell(4);
		cell.setCellValue("住址");
		cell = row.createCell(5);
		cell.setCellValue("联系电话");
		cell = row.createCell(6);
		cell.setCellValue("身份号证");
		cell = row.createCell(7);
		cell.setCellValue("诊断材料");
		cell = row.createCell(8);
		cell.setCellValue("身份证明");
		cell = row.createCell(9);
		cell.setCellValue("收入证明");
		cell = row.createCell(10);
		cell.setCellValue("购药发票");
		cell = row.createCell(11);
		cell.setCellValue("医学评估表");
		cell = row.createCell(12);
		cell.setCellValue("患者知情同意函");
		cell = row.createCell(13);
		cell.setCellValue("患者经济状况填报表");
		cell = row.createCell(14);
		cell.setCellValue("冷链药品知情同意书");
		cell = row.createCell(15);
		cell.setCellValue("项目专员");
		cell = row.createCell(16);
		cell.setCellValue("朗沐医院");
		cell = row.createCell(10);
		cell.setCellValue("朗沐医生");
		cell = row.createCell(10);
		cell.setCellValue("预计增药注射时间");
		cell = row.createCell(10);
		cell.setCellValue("备注");
		cell = row.createCell(10);
		cell.setCellValue("受助药品领取单");
		cell = row.createCell(10);
		cell.setCellValue("捐助结束声明");
	}

	public XSSFWorkbook export2007Excel(Dto inDto,String sheetName) throws Exception {
		// 声明一个工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 生成一个表格
		XSSFSheet sheet = workbook.createSheet(sheetName);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);

		// 生成一个样式
		XSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式ß
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		XSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		XSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		XSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);

		String hotkey = inDto.getString("hotkey");
		String patientQueryType = inDto.getString("patientQueryType");
		List<TPatientDTO> patientList = queryPatientList(hotkey, patientQueryType, "", "", "", false);
		PatientUtils.proTPatientDTO(patientList);
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		createTitleXSSF(row);
		int size = patientList.size();
		for(int i=1;i<=size;i++){
			XSSFRow dataRow = sheet.createRow(i);
			createDataXSSF(dataRow,patientList.get(i-1));
		}

		return workbook;
	}
	
	
	/**
	 * @param row
	 */
	private void createDataXSSF(XSSFRow row,TPatientDTO tPatientDTO) {
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(tPatientDTO.getArchives());
		cell = row.createCell(1);
		cell.setCellValue(tPatientDTO.getState());
		cell = row.createCell(2);
		cell.setCellValue(tPatientDTO.getName());
		cell = row.createCell(3);
		cell.setCellValue(tPatientDTO.getSex());
		cell = row.createCell(4);
		cell.setCellValue(tPatientDTO.getAddress());
		cell = row.createCell(5);
		cell.setCellValue(tPatientDTO.getPhone());
		cell = row.createCell(6);
		cell.setCellValue(tPatientDTO.getIdcardnumber());
		cell = row.createCell(7);
		cell.setCellValue(tPatientDTO.getDiagnosticMaterial());
		cell = row.createCell(8);
		cell.setCellValue(tPatientDTO.getProofIdentity());
		cell = row.createCell(9);
		cell.setCellValue(tPatientDTO.getProofIncome());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getPurchaseInvoice());
		cell = row.createCell(11);
		cell.setCellValue(tPatientDTO.getMedicalEvaluationForm());
		cell = row.createCell(12);
		cell.setCellValue(tPatientDTO.getInformedConsentOfPatients());
		cell = row.createCell(13);
		cell.setCellValue(tPatientDTO.getPatienteConomicStatus());
		cell = row.createCell(14);
		cell.setCellValue(tPatientDTO.getColdChainDrugInformedConsent());
		cell = row.createCell(15);
		cell.setCellValue(tPatientDTO.getHr());
		cell = row.createCell(16);
		cell.setCellValue(tPatientDTO.getLangMuHospital());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getLangMuDoctor());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getEstimatedTimeToIncreaseDrugInjection());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getRemarks());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getRecipientsReceiveSingleDrug());
		cell = row.createCell(10);
		cell.setCellValue(tPatientDTO.getEndOfStatement());
	}

	/**
	 * @param row
	 */
	private void createTitleXSSF(XSSFRow row) {
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("档案编号");
		cell = row.createCell(1);
		cell.setCellValue("是否通过");
		cell = row.createCell(2);
		cell.setCellValue("姓名");
		cell = row.createCell(3);
		cell.setCellValue("性别");
		cell = row.createCell(4);
		cell.setCellValue("住址");
		cell = row.createCell(5);
		cell.setCellValue("联系电话");
		cell = row.createCell(6);
		cell.setCellValue("身份号证");
		cell = row.createCell(7);
		cell.setCellValue("诊断材料");
		cell = row.createCell(8);
		cell.setCellValue("身份证明");
		cell = row.createCell(9);
		cell.setCellValue("收入证明");
		cell = row.createCell(10);
		cell.setCellValue("购药发票");
		cell = row.createCell(11);
		cell.setCellValue("医学评估表");
		cell = row.createCell(12);
		cell.setCellValue("患者知情同意函");
		cell = row.createCell(13);
		cell.setCellValue("患者经济状况填报表");
		cell = row.createCell(14);
		cell.setCellValue("冷链药品知情同意书");
		cell = row.createCell(15);
		cell.setCellValue("项目专员");
		cell = row.createCell(16);
		cell.setCellValue("朗沐医院");
		cell = row.createCell(10);
		cell.setCellValue("朗沐医生");
		cell = row.createCell(10);
		cell.setCellValue("预计增药注射时间");
		cell = row.createCell(10);
		cell.setCellValue("备注");
		cell = row.createCell(10);
		cell.setCellValue("受助药品领取单");
		cell = row.createCell(10);
		cell.setCellValue("捐助结束声明");
	}
	
	/* (non-Javadoc)
	 * @see com.zhqq.funds.service.TPatientService#queryPatientList(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<TPatientDTO> queryPatientListHR(String hotkey, String patientQueryType,String hr, String page, String start,
			String limit,boolean pageFlag) throws Exception {
		List<TPatientDTO> rlt = new ArrayList<TPatientDTO>();
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(hotkey)){
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(patientQueryType)){
				criteria.andArchivesLike(hotkey);
			}else if("1".equals(patientQueryType)){
				criteria.andStateLike(hotkey);
			}else if("2".equals(patientQueryType)){
				criteria.andNameLike(hotkey);
			}else if("3".equals(patientQueryType)){
				criteria.andSexLike(hotkey);
			}else if("4".equals(patientQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("5".equals(patientQueryType)){
				criteria.andHrLike(hotkey);
			}else if("6".equals(patientQueryType)){
				criteria.andLangMuHospitalLike(hotkey);
			}else if("7".equals(patientQueryType)){
				criteria.andLangMuDoctorLike(hotkey);
			}
		}
		if(pageFlag){
			example.setLimitStart(Integer.valueOf(start));
			example.setLimitEnd(Integer.valueOf(start)+Integer.valueOf(limit));
		}
		criteria.andHrEqualTo(hr);
		List<TPatient> list = tPatientMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(TPatient po : list){
				TPatientDTO dto = new TPatientDTO();
				AOSUtils.copyProperties(po, dto);
				rlt.add(dto);
			}
		}
		return rlt;
	}

	@Override
	public int queryPatientCountHR(String hotkey, String patientQueryType,String hr) throws Exception {
		int rlt = 0;
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(hotkey)){
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(patientQueryType)){
				criteria.andArchivesLike(hotkey);
			}else if("1".equals(patientQueryType)){
				criteria.andStateLike(hotkey);
			}else if("2".equals(patientQueryType)){
				criteria.andNameLike(hotkey);
			}else if("3".equals(patientQueryType)){
				criteria.andSexLike(hotkey);
			}else if("4".equals(patientQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("5".equals(patientQueryType)){
				criteria.andHrLike(hotkey);
			}else if("6".equals(patientQueryType)){
				criteria.andLangMuHospitalLike(hotkey);
			}else if("7".equals(patientQueryType)){
				criteria.andLangMuDoctorLike(hotkey);
			}
		}
		criteria.andHrEqualTo(hr);
		rlt = tPatientMapper.countByExample(example);
		return rlt;
	}


}
