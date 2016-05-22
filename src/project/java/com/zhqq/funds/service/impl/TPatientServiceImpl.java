package com.zhqq.funds.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.osworks.aos.core.asset.AOSJson;
import cn.osworks.aos.core.typewrap.Dto;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.po.SQLUtils;
import com.zhqq.funds.po.TPatient;
import com.zhqq.funds.mapper.TPatientMapper;
import com.zhqq.funds.po.TPatientExample;
import com.zhqq.funds.service.TPatientService;

import cn.osworks.aos.core.asset.AOSUtils;


@Service
public class TPatientServiceImpl implements TPatientService {

	@Autowired
	private TPatientMapper tPatientMapper;
	
	@Override
	public void addPatient(TPatientDTO tPatient) throws Exception {
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
			String limit) throws Exception {
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
		example.setLimitStart(Integer.valueOf(start));
		example.setLimitEnd(Integer.valueOf(start)+Integer.valueOf(limit));
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

	public void exportExcel(Dto inDto, String sheetName, OutputStream out, String type) throws IOException {
		if("2003".equals(type)){
			HSSFWorkbook hssfWorkbook = export2003Excel(inDto,sheetName);
			hssfWorkbook.write(out);
		}else {
			XSSFWorkbook xssfWorkbook = export2007Excel(inDto,sheetName);
			xssfWorkbook.write(out);
		}
		out.close();
	}

	public HSSFWorkbook export2003Excel(Dto inDto,String sheetName) {
		System.out.println("export2003Excel>>>>>>>>>>>>>>>"+sheetName);
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


		String jsonData = inDto.getString("aos_rows_");
		System.out.println("export2003Excel>>>>>>>>>>>>>jsonData>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+jsonData);
		AOSJson.fromJson(jsonData);

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);


		// 遍历集合数据，产生数据行
		List<Dto> jo = null;
		try{
			jo = AOSJson.fromJson("[{\"a\":\"1\",\"b\":\"2\"}]");
		}catch (Exception e){

		}

		Iterator<Dto> it = jo.iterator();
		int index = 0;
		while (it.hasNext())
		{
			index++;
			row = sheet.createRow(index);
			Dto t =  it.next();
			HSSFCell cell1 = row.createCell(0);
			cell1.setCellStyle(style2);
			cell1.setCellValue(t.getString("a"));
			HSSFCell cell2 = row.createCell(1);
			cell2.setCellStyle(style2);
			cell2.setCellValue(t.getString("b"));

		}
		return workbook;
	}

	public XSSFWorkbook export2007Excel(Dto inDto,String sheetName) {
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

		// 产生表格标题行
		XSSFRow row = null;
		XSSFCell cell = null;
		String jsonData = inDto.getString("aos_rows_");

		System.out.println("export2007Excel>>>>>>>>>jsonData>>>>>>>>>>>>"+jsonData);

		JSONArray ja = new JSONArray(jsonData);
		if(ja!=null){
			int len = ja.length();
			for(int i=0;i<len;i++){
				row = sheet.createRow(i+1);
				JSONObject jo = ja.getJSONObject(i);
				Iterator<String> it = jo.keys();
				int colIndex = 0;
				while(it.hasNext()){
					String tmpKey = it.next();
					String tmpValue = jo.optString(tmpKey);
					cell = row.createCell(colIndex);
					cell.setCellStyle(style2);
					cell.setCellValue(tmpValue);
					colIndex++;
				}
			}
		}

		return workbook;
	}

}
