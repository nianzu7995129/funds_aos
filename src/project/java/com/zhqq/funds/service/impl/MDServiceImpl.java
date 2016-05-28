package com.zhqq.funds.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhqq.funds.DTO.TDrugreleaseDTO;
import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.po.TDrugrelease;
import com.zhqq.funds.po.TDrugreleaseExample;
import com.zhqq.funds.service.MDService;
import com.zhqq.funds.mapper.TDrugreleaseMapper;
import com.zhqq.funds.utils.CopyUtils;
import com.zhqq.funds.utils.PatientUtils;
import com.zhqq.funds.utils.SQLUtils;

import cn.osworks.aos.core.asset.AOSUtils;
import cn.osworks.aos.core.typewrap.Dto;


@Service
public class MDServiceImpl implements MDService {

	@Autowired
	private TDrugreleaseMapper tDrugreleaseMapper;
	
	@Override
	public void addDrugrelease(TDrugreleaseDTO tDrugreleaseDTO) throws Exception {
		TDrugrelease record = CopyUtils.copyDTOToPO(tDrugreleaseDTO);
		tDrugreleaseMapper.insert(record);
	}

	@Override
	public TDrugreleaseDTO queryPatient(String name, String idcardnumber) throws Exception {
		TDrugreleaseDTO rlt = new TDrugreleaseDTO();
		TDrugreleaseExample example = new TDrugreleaseExample();  
		TDrugreleaseExample.Criteria criteria = example.createCriteria();  
		criteria.andNameEqualTo(name);
		criteria.andIdcardnumberEqualTo(idcardnumber);
		List<TDrugrelease> list = tDrugreleaseMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			TDrugrelease po = list.get(0);
			AOSUtils.copyProperties(po, rlt);
		}
		return rlt;
	}

	@Override
	public boolean checkName(String name) throws Exception {
		TDrugreleaseExample example = new TDrugreleaseExample();
		example.createCriteria().andNameEqualTo(name);
		int count = tDrugreleaseMapper.countByExample(example);
		return count==0 ? false : true;
	}

	@Override
	public boolean checkCdCard(String name, String idcardnumber) throws Exception {
		TDrugreleaseExample example = new TDrugreleaseExample();  
		TDrugreleaseExample.Criteria criteria = example.createCriteria();  
		criteria.andNameEqualTo(name);
		criteria.andIdcardnumberEqualTo(idcardnumber);
		int count = tDrugreleaseMapper.countByExample(example);
		return count==0 ? false : true;
	}

	/* (non-Javadoc)
	 * @see com.zhqq.funds.service.TPatientService#queryPatientList(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<TDrugreleaseDTO> queryMDList(String hotkey, String patientQueryType,String mdDateType, String page, String start,
			String limit,boolean pageFlag) throws Exception {
		List<TDrugreleaseDTO> rlt = new ArrayList<TDrugreleaseDTO>();
		TDrugreleaseExample example = new TDrugreleaseExample();  
		TDrugreleaseExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(hotkey)){
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(patientQueryType)){
				criteria.andPatientCodeLike(hotkey);
			}else if("1".equals(patientQueryType)){
				criteria.andNameLike(hotkey);
			}else if("2".equals(patientQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("3".equals(patientQueryType)){
//				criteria.andSexLike(hotkey);
			}else if("4".equals(patientQueryType)){
				criteria.andDiseaseLike(hotkey);
			}
		}
		//处理发药时间
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		if("0".equals(mdDateType)){//发药时间1天以内
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("1".equals(mdDateType)){//发药时间2天以内
			calendar.add(Calendar.DAY_OF_MONTH, 2);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("2".equals(mdDateType)){//发药时间3天以内
			calendar.add(Calendar.DAY_OF_MONTH, 3);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("3".equals(mdDateType)){//发药时间4天以内
			calendar.add(Calendar.DAY_OF_MONTH, 4);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("4".equals(mdDateType)){//发药时间5天以内
			calendar.add(Calendar.DAY_OF_MONTH, 5);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("5".equals(mdDateType)){//发药时间10天以内
			calendar.add(Calendar.DAY_OF_MONTH, 10);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("6".equals(mdDateType)){//发药时间15天以内
			calendar.add(Calendar.DAY_OF_MONTH, 15);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("7".equals(mdDateType)){//发药时间20天以内
			calendar.add(Calendar.DAY_OF_MONTH, 20);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("8".equals(mdDateType)){//发药时间25天以内
			calendar.add(Calendar.DAY_OF_MONTH, 25);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("9".equals(mdDateType)){//发药时间30天以内
			calendar.add(Calendar.DAY_OF_MONTH, 30);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}
		if(pageFlag){
			example.setLimitStart(Integer.valueOf(start));
			example.setLimitEnd(Integer.valueOf(start)+Integer.valueOf(limit));
		}
		List<TDrugrelease> list = tDrugreleaseMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(TDrugrelease po : list){
				TDrugreleaseDTO dto = CopyUtils.copyPOToDTO(po);
				rlt.add(dto);
			}
		}
		return rlt;
	}
	

	@Override
	public int queryMDCount(String hotkey, String patientQueryType,String mdDateType) throws Exception {
		int rlt = 0;
		TDrugreleaseExample example = new TDrugreleaseExample();  
		TDrugreleaseExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(hotkey)){
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(patientQueryType)){
				criteria.andPatientCodeLike(hotkey);
			}else if("1".equals(patientQueryType)){
				criteria.andNameLike(hotkey);
			}else if("2".equals(patientQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("3".equals(patientQueryType)){
//				criteria.andSexLike(hotkey);
			}else if("4".equals(patientQueryType)){
				criteria.andDiseaseLike(hotkey);
			}
		}
		//处理发药时间
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		if("0".equals(mdDateType)){//发药时间1天以内
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("1".equals(mdDateType)){//发药时间2天以内
			calendar.add(Calendar.DAY_OF_MONTH, 2);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("2".equals(mdDateType)){//发药时间3天以内
			calendar.add(Calendar.DAY_OF_MONTH, 3);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("3".equals(mdDateType)){//发药时间4天以内
			calendar.add(Calendar.DAY_OF_MONTH, 4);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("4".equals(mdDateType)){//发药时间5天以内
			calendar.add(Calendar.DAY_OF_MONTH, 5);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("5".equals(mdDateType)){//发药时间10天以内
			calendar.add(Calendar.DAY_OF_MONTH, 10);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("6".equals(mdDateType)){//发药时间15天以内
			calendar.add(Calendar.DAY_OF_MONTH, 15);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("7".equals(mdDateType)){//发药时间20天以内
			calendar.add(Calendar.DAY_OF_MONTH, 20);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("8".equals(mdDateType)){//发药时间25天以内
			calendar.add(Calendar.DAY_OF_MONTH, 25);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}else if("9".equals(mdDateType)){//发药时间30天以内
			calendar.add(Calendar.DAY_OF_MONTH, 30);
			criteria.andExpectedNexttimeBetween(date,calendar.getTime());
		}
		rlt = tDrugreleaseMapper.countByExample(example);
		return rlt;
	}

	@Override
	public TDrugreleaseDTO getMDByID(String id) throws Exception {
		TDrugreleaseDTO rlt = new TDrugreleaseDTO();
		TDrugrelease po = tDrugreleaseMapper.selectByPrimaryKey(Integer.valueOf(id));
		rlt = CopyUtils.copyPOToDTO(po);
		return rlt;
	}

	@Override
	public void deleteMDs(String ids) throws Exception {
		TDrugreleaseExample example = new TDrugreleaseExample();  
		TDrugreleaseExample.Criteria criteria = example.createCriteria();  
		if (StringUtils.isNotEmpty(ids)) {
			String[] temps = ids.split(",");
			List<Integer> values = new ArrayList<Integer>();
			for(String temp : temps){
				values.add(Integer.valueOf(temp));
			}
			criteria.andIdIn(values);
			tDrugreleaseMapper.deleteByExample(example);
		}
		
		
		
	}

	@Override
	public void updateMD(TDrugreleaseDTO tPatientDTO) throws Exception {
		TDrugrelease record = new TDrugrelease();
		record = CopyUtils.copyDTOToPO(tPatientDTO);
		tDrugreleaseMapper.updateByPrimaryKey(record);
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
		String mdQueryType = inDto.getString("mdQueryType");
		String mdDateType = inDto.getString("mdDateType");
		List<TDrugreleaseDTO> mdList = this.queryMDList(hotkey, mdQueryType, mdDateType, "", "", "", false);
		for(TDrugreleaseDTO tDrugreleaseDTO : mdList){
			tDrugreleaseDTO.setState(PatientUtils.getFormatValue(tDrugreleaseDTO.getState(), "0", "发药"));
			tDrugreleaseDTO.setState(PatientUtils.getFormatValue(tDrugreleaseDTO.getState(), "1", "已发"));
		}
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		createTitle(row);
		int size = mdList.size();
		for(int i=1;i<=size;i++){
			HSSFRow dataRow = sheet.createRow(i);
			createData(dataRow,mdList.get(i-1));
		}
		return workbook;
	}
	
	/**
	 * @param row
	 */
	private void createData(HSSFRow row,TDrugreleaseDTO tDrugreleaseDTO) {
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(tDrugreleaseDTO.getState());
		cell = row.createCell(1);
		cell.setCellValue(tDrugreleaseDTO.getPatientCode());
		cell = row.createCell(2);
		cell.setCellValue(tDrugreleaseDTO.getName());
		cell = row.createCell(3);
		cell.setCellValue(tDrugreleaseDTO.getPhone());
		cell = row.createCell(4);
		cell.setCellValue(tDrugreleaseDTO.getTakenDrugNumber());
		cell = row.createCell(5);
		cell.setCellValue(tDrugreleaseDTO.getCurrentDose());
		cell = row.createCell(6);
		cell.setCellValue(tDrugreleaseDTO.getExpectedNexttime());
		cell = row.createCell(7);
		cell.setCellValue(tDrugreleaseDTO.getHospitalGroup());
		cell = row.createCell(8);
		cell.setCellValue(tDrugreleaseDTO.getDisease());
	}

	/**
	 * @param row
	 */
	private void createTitle(HSSFRow row) {
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("操作");
		cell = row.createCell(1);
		cell.setCellValue("患者编码");
		cell = row.createCell(2);
		cell.setCellValue("患者名称");
		cell = row.createCell(3);
		cell.setCellValue("联系电话");
		cell = row.createCell(4);
		cell.setCellValue("已领赠药次数/瓶数");
		cell = row.createCell(5);
		cell.setCellValue("当前剂量");
		cell = row.createCell(6);
		cell.setCellValue("预计下次发药时间");
		cell = row.createCell(7);
		cell.setCellValue("入组医院");
		cell = row.createCell(8);
		cell.setCellValue("正式入组日期");
		cell = row.createCell(9);
		cell.setCellValue("病种");
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
		String mdQueryType = inDto.getString("mdQueryType");
		String mdDateType = inDto.getString("mdDateType");
		List<TDrugreleaseDTO> mdList = this.queryMDList(hotkey, mdQueryType, mdDateType, "", "", "", false);
		for(TDrugreleaseDTO tDrugreleaseDTO : mdList){
			tDrugreleaseDTO.setState(PatientUtils.getFormatValue(tDrugreleaseDTO.getState(), "0", "发药"));
			tDrugreleaseDTO.setState(PatientUtils.getFormatValue(tDrugreleaseDTO.getState(), "1", "已发"));
		}
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		createTitleXSSF(row);
		int size = mdList.size();
		for(int i=1;i<=size;i++){
			XSSFRow dataRow = sheet.createRow(i);
			createDataXSSF(dataRow,mdList.get(i-1));
		}

		return workbook;
	}
	
	
	/**
	 * @param row
	 */
	private void createDataXSSF(XSSFRow row,TDrugreleaseDTO tDrugreleaseDTO) {
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(tDrugreleaseDTO.getState());
		cell = row.createCell(1);
		cell.setCellValue(tDrugreleaseDTO.getPatientCode());
		cell = row.createCell(2);
		cell.setCellValue(tDrugreleaseDTO.getName());
		cell = row.createCell(3);
		cell.setCellValue(tDrugreleaseDTO.getPhone());
		cell = row.createCell(4);
		cell.setCellValue(tDrugreleaseDTO.getTakenDrugNumber());
		cell = row.createCell(5);
		cell.setCellValue(tDrugreleaseDTO.getCurrentDose());
		cell = row.createCell(6);
		cell.setCellValue(tDrugreleaseDTO.getExpectedNexttime());
		cell = row.createCell(7);
		cell.setCellValue(tDrugreleaseDTO.getHospitalGroup());
		cell = row.createCell(8);
		cell.setCellValue(tDrugreleaseDTO.getDisease());
	}

	/**
	 * @param row
	 */
	private void createTitleXSSF(XSSFRow row) {
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("操作");
		cell = row.createCell(1);
		cell.setCellValue("患者编码");
		cell = row.createCell(2);
		cell.setCellValue("患者名称");
		cell = row.createCell(3);
		cell.setCellValue("联系电话");
		cell = row.createCell(4);
		cell.setCellValue("已领赠药次数/瓶数");
		cell = row.createCell(5);
		cell.setCellValue("当前剂量");
		cell = row.createCell(6);
		cell.setCellValue("预计下次发药时间");
		cell = row.createCell(7);
		cell.setCellValue("入组医院");
		cell = row.createCell(8);
		cell.setCellValue("正式入组日期");
		cell = row.createCell(9);
		cell.setCellValue("病种");
	}


}
