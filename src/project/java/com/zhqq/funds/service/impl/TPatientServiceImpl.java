package com.zhqq.funds.service.impl;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.mapper.TPatientMapper;
import com.zhqq.funds.po.TPatient;
import com.zhqq.funds.po.TPatientExample;
import com.zhqq.funds.service.AreaService;
import com.zhqq.funds.service.TPatientService;
import com.zhqq.funds.utils.ChangeUtils;
import com.zhqq.funds.utils.CopyUtils;
import com.zhqq.funds.utils.SQLUtils;

import cn.osworks.aos.core.typewrap.Dto;


@Service
public class TPatientServiceImpl implements TPatientService {

	@Autowired
	private TPatientMapper tPatientMapper;
	
	@Autowired
	private AreaService areaService;
	
	@Override
	public void addPatient(TPatientDTO tPatient) throws Exception {
		TPatient record = new TPatient();
		record = CopyUtils.copyDTOToPO(tPatient);
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
			TPatient po = list.get(list.size()-1);
			rlt = CopyUtils.copyPOToDTO(po);
		}
		return rlt;
	}

	@Override
	public boolean checkName(String name) throws Exception {
		TPatientExample example = new TPatientExample();
		TPatientExample.Criteria criteria = example.createCriteria();  
		criteria.andNameEqualTo(name);
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
				if("%是%".equals(hotkey)){
					criteria.andStateEqualTo("1");
				}else if("%否%".equals(hotkey)){
					criteria.andStateEqualTo("0");
				}else{
					criteria.andStateEqualTo(hotkey);
				}
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
			}else if("8".equals(patientQueryType)){
				criteria.andIdcardnumberLike(hotkey);
			}else if("9".equals(patientQueryType)){
				if("%正常申请%".equals(hotkey)){
					criteria.andApplyTypeEqualTo("0");
				}else if("%复申请%".equals(hotkey)){
					criteria.andApplyTypeEqualTo("1");
				}else{
					criteria.andApplyTypeEqualTo(hotkey);
				}
				
			}
		}
		if(pageFlag){
			example.setLimitStart(Integer.valueOf(start));
			example.setLimitEnd(Integer.valueOf(start)+Integer.valueOf(limit));
		}
		List<TPatient> list = tPatientMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(TPatient po : list){
				rlt.add(CopyUtils.copyPOToDTO(po));
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
				if("%是%".equals(hotkey)){
					criteria.andStateEqualTo("1");
				}else if("%否%".equals(hotkey)){
					criteria.andStateEqualTo("0");
				}else{
					criteria.andStateEqualTo(hotkey);
				}
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
			}else if("8".equals(patientQueryType)){
				criteria.andIdcardnumberLike(hotkey);
			}else if("9".equals(patientQueryType)){
				if("%正常申请%".equals(hotkey)){
					criteria.andApplyTypeEqualTo("0");
				}else if("%复申请%".equals(hotkey)){
					criteria.andApplyTypeEqualTo("1");
				}else{
					criteria.andApplyTypeEqualTo(hotkey);
				}
			}
		}
		rlt = tPatientMapper.countByExample(example);
		return rlt;
	}

	@Override
	public TPatientDTO getPatientByID(String id) throws Exception {
		TPatientDTO rlt = new TPatientDTO();
		TPatient po = tPatientMapper.selectByPrimaryKey(Integer.valueOf(id));
		rlt = CopyUtils.copyPOToDTO(po);
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
		record = CopyUtils.copyDTOToPO(tPatientDTO);
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
		if(ChangeUtils.tProvincesDTOList==null||ChangeUtils.tCitiesDTOList==null){
			ChangeUtils.proTPatientDTOList(patientList,areaService.getAllProvinces());
		}else{
			ChangeUtils.proTPatientDTOList(patientList,null);
		}
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		createTitle(row);
		int size = patientList.size();
		for(int i=1;i<=size;i++){
			HSSFRow dataRow = sheet.createRow(i);
			createData(dataRow,patientList.get(i-1),i);
		}
		return workbook;
	}
	
	/**
	 * @param row
	 */
	private void createData(HSSFRow row,TPatientDTO tPatientDTO,int count) {
		int index = 0;
		HSSFCell cell = row.createCell(index++);
		cell.setCellValue(count);
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getArchives());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getState());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getName());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getSex());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getProvince());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getApplyType());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getAddress());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getPhone());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getIdcardnumber());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getPatientType());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getDiagnosticMaterial());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getProofIdentity());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getProofIncome());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getPurchaseInvoice());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getMedicalEvaluationForm());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getInformedConsentOfPatients());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getPatienteConomicStatus());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getColdChainDrugInformedConsent());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getHr());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getLangMuHospital());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getLangMuDoctor());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getEstimatedTimeToIncreaseDrugInjection());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getRemarks());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getIsLangMuHospital());
		cell = row.createCell(index++);
		cell.setCellValue(CopyUtils.getFormatDateString(tPatientDTO.getPassdate()));
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getRecipientsReceiveSingleDrug());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getEndOfStatement());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getYear());
	}

	/**
	 * @param row
	 */
	private void createTitle(HSSFRow row) {
		int index = 0;
		HSSFCell cell = row.createCell(index++);
		cell.setCellValue("序号");
		cell = row.createCell(index++);
		cell.setCellValue("档案编号");
		cell = row.createCell(index++);
		cell.setCellValue("是否通过");
		cell = row.createCell(index++);
		cell.setCellValue("姓名");
		cell = row.createCell(index++);
		cell.setCellValue("性别");
		cell = row.createCell(index++);
		cell.setCellValue("省份");
		cell = row.createCell(index++);
		cell.setCellValue("申请类型");
		cell = row.createCell(index++);
		cell.setCellValue("住址");
		cell = row.createCell(index++);
		cell.setCellValue("联系电话");
		cell = row.createCell(index++);
		cell.setCellValue("身份号证");
		cell = row.createCell(index++);
		cell.setCellValue("患者类型");
		cell = row.createCell(index++);
		cell.setCellValue("诊断材料");
		cell = row.createCell(index++);
		cell.setCellValue("身份证明");
		cell = row.createCell(index++);
		cell.setCellValue("收入证明");
		cell = row.createCell(index++);
		cell.setCellValue("购药发票");
		cell = row.createCell(index++);
		cell.setCellValue("医学评估表");
		cell = row.createCell(index++);
		cell.setCellValue("患者知情同意函");
		cell = row.createCell(index++);
		cell.setCellValue("患者经济状况填报表");
		cell = row.createCell(index++);
		cell.setCellValue("冷链药品知情同意书");
		cell = row.createCell(index++);
		cell.setCellValue("项目专员");
		cell = row.createCell(index++);
		cell.setCellValue("朗沐医院");
		cell = row.createCell(index++);
		cell.setCellValue("朗沐医生");
		cell = row.createCell(index++);
		cell.setCellValue("预计增药注射时间");
		cell = row.createCell(index++);
		cell.setCellValue("备注");
		cell = row.createCell(index++);
		cell.setCellValue("诊断医院是否为朗沐医院");
		cell = row.createCell(index++);
		cell.setCellValue("通过日期");
		cell = row.createCell(index++);
		cell.setCellValue("受助药品领取单");
		cell = row.createCell(index++);
		cell.setCellValue("捐助结束声明");
		cell = row.createCell(index++);
		cell.setCellValue("年份");
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
		if(ChangeUtils.tProvincesDTOList==null||ChangeUtils.tCitiesDTOList==null){
			ChangeUtils.proTPatientDTOList(patientList,areaService.getAllProvinces());
		}else{
			ChangeUtils.proTPatientDTOList(patientList,null);
		}
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		createTitleXSSF(row);
		int size = patientList.size();
		for(int i=1;i<=size;i++){
			XSSFRow dataRow = sheet.createRow(i);
			createDataXSSF(dataRow,patientList.get(i-1),i);
		}

		return workbook;
	}
	
	
	/**
	 * @param row
	 */
	private void createDataXSSF(XSSFRow row,TPatientDTO tPatientDTO,int count) {
		int index = 0;
		XSSFCell cell = row.createCell(index++);
		cell.setCellValue(count);
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getArchives());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getState());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getName());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getSex());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getProvince());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getApplyType());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getAddress());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getPhone());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getIdcardnumber());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getPatientType());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getDiagnosticMaterial());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getProofIdentity());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getProofIncome());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getPurchaseInvoice());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getMedicalEvaluationForm());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getInformedConsentOfPatients());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getPatienteConomicStatus());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getColdChainDrugInformedConsent());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getHr());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getLangMuHospital());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getLangMuDoctor());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getEstimatedTimeToIncreaseDrugInjection());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getRemarks());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getIsLangMuHospital());
		cell = row.createCell(index++);
		cell.setCellValue(CopyUtils.getFormatDateString(tPatientDTO.getPassdate()));
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getRecipientsReceiveSingleDrug());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getEndOfStatement());
		cell = row.createCell(index++);
		cell.setCellValue(tPatientDTO.getYear());
		
	}

	/**
	 * @param row
	 */
	private void createTitleXSSF(XSSFRow row) {
		int index = 0;
		XSSFCell cell = row.createCell(index++);
		cell.setCellValue("序号");
		cell = row.createCell(index++);
		cell.setCellValue("档案编号");
		cell = row.createCell(index++);
		cell.setCellValue("是否通过");
		cell = row.createCell(index++);
		cell.setCellValue("姓名");
		cell = row.createCell(index++);
		cell.setCellValue("性别");
		cell = row.createCell(index++);
		cell.setCellValue("省份");
		cell = row.createCell(index++);
		cell.setCellValue("申请类型");
		cell = row.createCell(index++);
		cell.setCellValue("住址");
		cell = row.createCell(index++);
		cell.setCellValue("联系电话");
		cell = row.createCell(index++);
		cell.setCellValue("身份号证");
		cell = row.createCell(index++);
		cell.setCellValue("患者类型");
		cell = row.createCell(index++);
		cell.setCellValue("诊断材料");
		cell = row.createCell(index++);
		cell.setCellValue("身份证明");
		cell = row.createCell(index++);
		cell.setCellValue("收入证明");
		cell = row.createCell(index++);
		cell.setCellValue("购药发票");
		cell = row.createCell(index++);
		cell.setCellValue("医学评估表");
		cell = row.createCell(index++);
		cell.setCellValue("患者知情同意函");
		cell = row.createCell(index++);
		cell.setCellValue("患者经济状况填报表");
		cell = row.createCell(index++);
		cell.setCellValue("冷链药品知情同意书");
		cell = row.createCell(index++);
		cell.setCellValue("项目专员");
		cell = row.createCell(index++);
		cell.setCellValue("朗沐医院");
		cell = row.createCell(index++);
		cell.setCellValue("朗沐医生");
		cell = row.createCell(index++);
		cell.setCellValue("预计增药注射时间");
		cell = row.createCell(index++);
		cell.setCellValue("备注");
		cell = row.createCell(index++);
		cell.setCellValue("诊断医院是否为朗沐医院");
		cell = row.createCell(index++);
		cell.setCellValue("通过日期");
		cell = row.createCell(index++);
		cell.setCellValue("受助药品领取单");
		cell = row.createCell(index++);
		cell.setCellValue("捐助结束声明");
		cell = row.createCell(index++);
		cell.setCellValue("年份");
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
				rlt.add(CopyUtils.copyPOToDTO(po));
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
	
	public List<TPatient> getPatientByArchives(String hotkey) throws Exception {
		List<TPatient> rlt = new ArrayList<TPatient>();
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();
		criteria.andArchivesEqualTo(hotkey);
		rlt = tPatientMapper.selectByExample(example);
		return rlt;
	}

	@Override
	public void importPatientExcel(Workbook workbook) throws Exception {
		  // 得到第一张工作表
        Sheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();
        for(int i=1;i<=lastRow;i++) {
        	try{
	        	Row ssfRow = sheet.getRow(i);
	            if(ssfRow==null || ssfRow.getCell(0)==null || "".equals(getStringCellValue(ssfRow.getCell(0)))) continue;
	            TPatient record = new TPatient();
	            proTPatient(ssfRow, record);
	            ChangeUtils.proTPatientReverse(record);
	            List<TPatient> rlt = getPatientByArchives(record.getArchives());
	            if(rlt!=null && rlt.size()>0){
	            	record.setId(rlt.get(0).getId());
	            	tPatientMapper.updateByPrimaryKey(record);
	            }else{
	            	tPatientMapper.insert(record);
	            }
	        }catch(Exception e){
				e.printStackTrace();
	        }
        }
	}

	/**
	 * @param ssfRow
	 * @param record
	 */
	private void proTPatient(Row ssfRow, TPatient record) {
		
		int index = 1;
		record.setArchives(getStringCellValue(ssfRow.getCell(index++)));
		record.setState(getStringCellValue(ssfRow.getCell(index++)));
		record.setName(getStringCellValue(ssfRow.getCell(index++)));
		record.setSex(getStringCellValue(ssfRow.getCell(index++)));
		record.setProvince(getStringCellValue(ssfRow.getCell(index++)));
		record.setApplyType(getStringCellValue(ssfRow.getCell(index++)));
		record.setAddress(getStringCellValue(ssfRow.getCell(index++)));
		record.setPhone(getStringCellValue(ssfRow.getCell(index++)));
		record.setIdcardnumber(getStringCellValue(ssfRow.getCell(index++)));
		record.setPatientType(getStringCellValue(ssfRow.getCell(index++)));
		record.setDiagnosticMaterial(getStringCellValue(ssfRow.getCell(index++)));
		record.setProofIdentity(getStringCellValue(ssfRow.getCell(index++)));
		record.setProofIncome(getStringCellValue(ssfRow.getCell(index++)));
		record.setPurchaseInvoice(getStringCellValue(ssfRow.getCell(index++)));
		record.setMedicalEvaluationForm(getStringCellValue(ssfRow.getCell(index++)));
		record.setInformedConsentOfPatients(getStringCellValue(ssfRow.getCell(index++)));
		record.setPatienteConomicStatus(getStringCellValue(ssfRow.getCell(index++)));
		record.setColdChainDrugInformedConsent(getStringCellValue(ssfRow.getCell(index++)));
		record.setHr(getStringCellValue(ssfRow.getCell(index++)));
		record.setLangMuHospital(getStringCellValue(ssfRow.getCell(index++)));
		record.setLangMuDoctor(getStringCellValue(ssfRow.getCell(index++)));
		record.setEstimatedTimeToIncreaseDrugInjection(getStringCellValue(ssfRow.getCell(index++)));
		record.setRemarks(getStringCellValue(ssfRow.getCell(index++)));
		record.setIsLangMuHospital(getStringCellValue(ssfRow.getCell(index++)));
		record.setPassdate(getDateCellValue(ssfRow.getCell(index++)));
		record.setRecipientsReceiveSingleDrug(getStringCellValue(ssfRow.getCell(index++)));
		record.setEndOfStatement(getStringCellValue(ssfRow.getCell(index++)));
		record.setYear(getStringCellValue(ssfRow.getCell(index++)));
		ChangeUtils.proTPatientReverse(record);
	}
	
	 /** 获得日期单元格值 */
    public Date getDateCellValue(Cell cell){
    	Date rlt = null;
    	if(cell!=null || !"".equals(getStringCellValue(cell))){
    		 if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
    	        	rlt = cell.getDateCellValue();
    	        } else {
    	            try{
    	            	rlt = getFormatDate("yyyy年mm月dd日 HH:mm:ss",cell);
    	            }catch(Exception e1){
    	                try {
    	                	rlt = getFormatDate("yyyy-mm-dd HH:mm:ss", cell);
    	                }catch(Exception e2){
    	                    try {
    	                    	rlt = getFormatDate("yyyy/mm/dd HH:mm:ss", cell);
    	                    }catch(Exception e3){
    	                    	rlt = new Date();
    	                    }
    	                }
    	            }
    	        }
    	}
        return rlt;
    }
    
    private Date getFormatDate(String format,Cell cell) throws Exception{
        String tmpValue = cell.getStringCellValue();
        if(tmpValue == null || tmpValue.trim().length()==0) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date realDate = sdf.parse(cell.getStringCellValue());;
        return realDate;
    }
	
	/** 获得字符串单元格值 */
    private String getStringCellValue(Cell cell){
        String tmpValue = "";
        if(cell!=null){
        	 if(Cell.CELL_TYPE_NUMERIC == cell.getCellType()){
                 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                 tmpValue = "" + cell.getStringCellValue();
             }else {
                 tmpValue = cell.getStringCellValue();
             }
             if(tmpValue!=null){
                 tmpValue = tmpValue.trim();
                 if("√".equals(tmpValue)){
                	 tmpValue = "-999";
                 }
             }
        }
        return tmpValue;
    }

	@Override
	public List<TPatientDTO> getPatientListByCondition(String key, String patientQueryType) {
		List<TPatientDTO> rlt = new ArrayList<TPatientDTO>();
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(key)){
			if("0".equals(patientQueryType)){
				criteria.andArchivesEqualTo(key);
			}else if("1".equals(patientQueryType)){
				criteria.andStateEqualTo(key);
			}else if("2".equals(patientQueryType)){
				criteria.andNameEqualTo(key);
			}else if("3".equals(patientQueryType)){
				criteria.andSexEqualTo(key);
			}else if("4".equals(patientQueryType)){
				criteria.andPhoneEqualTo(key);
			}else if("5".equals(patientQueryType)){
				criteria.andHrEqualTo(key);
			}else if("6".equals(patientQueryType)){
				criteria.andLangMuHospitalEqualTo(key);
			}else if("7".equals(patientQueryType)){
				criteria.andLangMuDoctorEqualTo(key);
			}else if("8".equals(patientQueryType)){
				criteria.andIdcardnumberEqualTo(key);
			}else if("9".equals(patientQueryType)){
				criteria.andApplyTypeEqualTo(key);
			}
		}
		List<TPatient> list = tPatientMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(TPatient po : list){
				rlt.add(CopyUtils.copyPOToDTO(po));
			}
		}
		return rlt;
	}

	@Override
	public int getMaxArchives() {
		return tPatientMapper.selectMaxArchives();
	}
}
