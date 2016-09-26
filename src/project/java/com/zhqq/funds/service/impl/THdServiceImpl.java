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

import com.zhqq.funds.DTO.THospitalMappingDTO;
import com.zhqq.funds.mapper.THospitalMappingMapper;
import com.zhqq.funds.po.THospitalMapping;
import com.zhqq.funds.po.THospitalMappingExample;
import com.zhqq.funds.service.AreaService;
import com.zhqq.funds.service.THdService;
import com.zhqq.funds.utils.ChangeUtils;
import com.zhqq.funds.utils.CopyUtils;
import com.zhqq.funds.utils.SQLUtils;

import cn.osworks.aos.core.typewrap.Dto;


@Service
public class THdServiceImpl implements THdService {

	@Autowired
	private THospitalMappingMapper tHospitalMappingMapper;
	
	@Autowired
	private AreaService areaService;
	
	@Override
	public void addHospitalMapping(THospitalMappingDTO tHospitalMapping) throws Exception {
		tHospitalMappingMapper.insert(CopyUtils.createCopy(tHospitalMapping, THospitalMapping.class));
	}
	
	@Override
	public List<THospitalMappingDTO> queryHospitalMappingList(String hotkey, String doctorQueryType, String page, String start,
			String limit,boolean pageFlag) throws Exception {
		List<THospitalMappingDTO> rlt = new ArrayList<THospitalMappingDTO>();
		THospitalMappingExample example = new THospitalMappingExample();  
		THospitalMappingExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(hotkey)){
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(doctorQueryType)){
				criteria.andAreaLike(hotkey);
			}else if("1".equals(doctorQueryType)){
				criteria.andHospitalNameLike(hotkey);
			}else if("2".equals(doctorQueryType)){
				criteria.andProvinceLike(hotkey);
			}else if("3".equals(doctorQueryType)){
				criteria.andCityLike(hotkey);
			}else if("4".equals(doctorQueryType)){
				criteria.andHospitalGradeLike(hotkey);
			}else if("5".equals(doctorQueryType)){
				criteria.andHospitalLevelLike(hotkey);
			}else if("6".equals(doctorQueryType)){
				criteria.andHospitalTypeLike(hotkey);
			}else if("7".equals(doctorQueryType)){
				criteria.andAreaManagerLike(hotkey);
			}else if("8".equals(doctorQueryType)){
				criteria.andHrLike(hotkey);
			}else if("9".equals(doctorQueryType)){
				criteria.andDoctorNameLike(hotkey);
			}else if("10".equals(doctorQueryType)){
				criteria.andDoctorTitleLike(hotkey);
			}else if("11".equals(doctorQueryType)){
				criteria.andAdministrativePostLike(hotkey);
			}else if("12".equals(doctorQueryType)){
				criteria.andProfessionalDirectionLike(hotkey);
			}
		}
		if(pageFlag){
			example.setLimitStart(Integer.valueOf(start));
			example.setLimitEnd(Integer.valueOf(start)+Integer.valueOf(limit));
		}
		List<THospitalMapping> list = tHospitalMappingMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(THospitalMapping po : list){
				rlt.add(CopyUtils.createCopy(po, THospitalMappingDTO.class));
			}
		}
		return rlt;
	}

	@Override
	public int queryHospitalMappingCount(String hotkey, String doctorQueryType) throws Exception {
		int rlt = 0;
		THospitalMappingExample example = new THospitalMappingExample();  
		if(!StringUtils.isEmpty(hotkey)){
			THospitalMappingExample.Criteria criteria = example.createCriteria();
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(doctorQueryType)){
				criteria.andAreaLike(hotkey);
			}else if("1".equals(doctorQueryType)){
				criteria.andHospitalNameLike(hotkey);
			}else if("2".equals(doctorQueryType)){
				criteria.andProvinceLike(hotkey);
			}else if("3".equals(doctorQueryType)){
				criteria.andCityLike(hotkey);
			}else if("4".equals(doctorQueryType)){
				criteria.andHospitalGradeLike(hotkey);
			}else if("5".equals(doctorQueryType)){
				criteria.andHospitalLevelLike(hotkey);
			}else if("6".equals(doctorQueryType)){
				criteria.andHospitalTypeLike(hotkey);
			}else if("7".equals(doctorQueryType)){
				criteria.andAreaManagerLike(hotkey);
			}else if("8".equals(doctorQueryType)){
				criteria.andHrLike(hotkey);
			}else if("9".equals(doctorQueryType)){
				criteria.andDoctorNameLike(hotkey);
			}else if("10".equals(doctorQueryType)){
				criteria.andDoctorTitleLike(hotkey);
			}else if("11".equals(doctorQueryType)){
				criteria.andAdministrativePostLike(hotkey);
			}else if("12".equals(doctorQueryType)){
				criteria.andProfessionalDirectionLike(hotkey);
			}
		}
		rlt = tHospitalMappingMapper.countByExample(example);
		return rlt;
	}

	@Override
	public THospitalMappingDTO getHospitalMappingByID(String id) throws Exception {
		THospitalMappingDTO rlt = new THospitalMappingDTO();
		THospitalMapping po = tHospitalMappingMapper.selectByPrimaryKey(Long.valueOf(id));
		rlt = CopyUtils.createCopy(po,THospitalMappingDTO.class);
		return rlt;
	}

	@Override
	public void deleteHospitalMappings(String ids) throws Exception {
		THospitalMappingExample example = new THospitalMappingExample();  
		THospitalMappingExample.Criteria criteria = example.createCriteria();  
		if (StringUtils.isNotEmpty(ids)) {
			String[] temps = ids.split(",");
			List<Long> values = new ArrayList<Long>();
			for(String temp : temps){
				values.add(Long.valueOf(temp));
			}
			criteria.andIdIn(values);
			tHospitalMappingMapper.deleteByExample(example);
		}
		
		
		
	}

	@Override
	public void updateHospitalMapping(THospitalMappingDTO tHospitalMappingDTO) throws Exception {
		THospitalMapping record = new THospitalMapping();
		record = CopyUtils.createCopy(tHospitalMappingDTO,THospitalMapping.class);
		tHospitalMappingMapper.updateByPrimaryKey(record);
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
		List<THospitalMappingDTO> listTHospitalMappingDTO = queryHospitalMappingList(hotkey, patientQueryType, "", "", "", false);
		if(ChangeUtils.tProvincesDTOList==null||ChangeUtils.tCitiesDTOList==null){
			ChangeUtils.proTHospitalMappingDTOList(listTHospitalMappingDTO,areaService.getAllProvinces(),areaService.getAllCities());
		}else{
			ChangeUtils.proTHospitalMappingDTOList(listTHospitalMappingDTO,null,null);
		}
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		createTitle(row);
		int size = listTHospitalMappingDTO.size();
		for(int i=1;i<=size;i++){
			HSSFRow dataRow = sheet.createRow(i);
			createData(dataRow,listTHospitalMappingDTO.get(i-1),i);
		}
		return workbook;
	}
	
	private void createData(HSSFRow row,THospitalMappingDTO tHospitalMappingDTO,int count) {
		int index = 0;
		HSSFCell cell = row.createCell(index++);
		cell.setCellValue(count);
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getArea());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHospitalName());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getProvince());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getCity());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHospitalGrade());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHospitalLevel());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHospitalType());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getAreaManager());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHr());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getDoctorName());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getDoctorTitle());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getAdministrativePost());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getProfessionalDirection());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getRemark());
	}

	/**
	 * @param row
	 */
	private void createTitle(HSSFRow row) {
		int index = 0;
		HSSFCell cell = row.createCell(index++);
		cell.setCellValue("序号");
		cell = row.createCell(index++);
		cell.setCellValue("区域");
		cell = row.createCell(index++);
		cell.setCellValue("医院");
		cell = row.createCell(index++);
		cell.setCellValue("省份");
		cell = row.createCell(index++);
		cell.setCellValue("城市");
		cell = row.createCell(index++);
		cell.setCellValue("医院分级");
		cell = row.createCell(index++);
		cell.setCellValue("医院级别");
		cell = row.createCell(index++);
		cell.setCellValue("医院类型");
		cell = row.createCell(index++);
		cell.setCellValue("地区经理");
		cell = row.createCell(index++);
		cell.setCellValue("专员");
		cell = row.createCell(index++);
		cell.setCellValue("医生姓名");
		cell = row.createCell(index++);
		cell.setCellValue("医生职称");
		cell = row.createCell(index++);
		cell.setCellValue("医生行政职务");
		cell = row.createCell(index++);
		cell.setCellValue("医生专业方向");
		cell = row.createCell(index++);
		cell.setCellValue("备注");
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
		List<THospitalMappingDTO> listTHospitalMappingDTO = queryHospitalMappingList(hotkey, patientQueryType, "", "", "", false);
		
		if(ChangeUtils.tProvincesDTOList==null||ChangeUtils.tCitiesDTOList==null){
			ChangeUtils.proTHospitalMappingDTOList(listTHospitalMappingDTO,areaService.getAllProvinces(),areaService.getAllCities());
		}else{
			ChangeUtils.proTHospitalMappingDTOList(listTHospitalMappingDTO,null,null);
		}
		
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		createTitleXSSF(row);
		int size = listTHospitalMappingDTO.size();
		for(int i=1;i<=size;i++){
			XSSFRow dataRow = sheet.createRow(i);
			createDataXSSF(dataRow,listTHospitalMappingDTO.get(i-1),i);
		}

		return workbook;
	}
	
	private void createDataXSSF(XSSFRow row,THospitalMappingDTO tHospitalMappingDTO,int count) {
		int index = 0;
		XSSFCell cell = row.createCell(index++);
		cell.setCellValue(count);
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getArea());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHospitalName());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getProvince());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getCity());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHospitalGrade());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHospitalLevel());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHospitalType());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getAreaManager());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getHr());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getDoctorName());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getDoctorTitle());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getAdministrativePost());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getProfessionalDirection());
		cell = row.createCell(index++);
		cell.setCellValue(tHospitalMappingDTO.getRemark());
	}

	/**
	 * @param row
	 */
	private void createTitleXSSF(XSSFRow row) {
		int index = 0;
		XSSFCell cell = row.createCell(index++);
		cell.setCellValue("序号");
		cell = row.createCell(index++);
		cell.setCellValue("区域");
		cell = row.createCell(index++);
		cell.setCellValue("医院");
		cell = row.createCell(index++);
		cell.setCellValue("省份");
		cell = row.createCell(index++);
		cell.setCellValue("城市");
		cell = row.createCell(index++);
		cell.setCellValue("医院分级");
		cell = row.createCell(index++);
		cell.setCellValue("医院级别");
		cell = row.createCell(index++);
		cell.setCellValue("医院类型");
		cell = row.createCell(index++);
		cell.setCellValue("地区经理");
		cell = row.createCell(index++);
		cell.setCellValue("专员");
		cell = row.createCell(index++);
		cell.setCellValue("医生姓名");
		cell = row.createCell(index++);
		cell.setCellValue("医生职称");
		cell = row.createCell(index++);
		cell.setCellValue("医生行政职务");
		cell = row.createCell(index++);
		cell.setCellValue("医生专业方向");
		cell = row.createCell(index++);
		cell.setCellValue("备注");
	}

	@Override
	public void importHospitalMappingExcel(Workbook workbook) throws Exception {
		  // 得到第一张工作表
        Sheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();
        for(int i=1;i<=lastRow;i++) {
        	try{
	        	Row ssfRow = sheet.getRow(i);
	            if(ssfRow==null || ssfRow.getCell(0)==null || "".equals(getStringCellValue(ssfRow.getCell(0)))) continue;
	            THospitalMapping record = new THospitalMapping();
	            proTHospitalMapping(ssfRow, record);
            	tHospitalMappingMapper.insert(record);
	        }catch(Exception e){
				e.printStackTrace();
	        }
        }
	}

	/**
	 * @param ssfRow
	 * @param record
	 */
	private void proTHospitalMapping(Row ssfRow, THospitalMapping record) {
		int index = 1;
		record.setArea(getStringCellValue(ssfRow.getCell(index++)));
		record.setHospitalName(getStringCellValue(ssfRow.getCell(index++)));
		record.setProvince(getStringCellValue(ssfRow.getCell(index++)));
		record.setCity(getStringCellValue(ssfRow.getCell(index++)));
		record.setHospitalGrade(getStringCellValue(ssfRow.getCell(index++)));
		record.setHospitalLevel(getStringCellValue(ssfRow.getCell(index++)));
		record.setHospitalType(getStringCellValue(ssfRow.getCell(index++)));
		record.setAreaManager(getStringCellValue(ssfRow.getCell(index++)));
		record.setHr(getStringCellValue(ssfRow.getCell(index++)));
		record.setDoctorName(getStringCellValue(ssfRow.getCell(index++)));
		record.setDoctorTitle(getStringCellValue(ssfRow.getCell(index++)));
		record.setAdministrativePost(getStringCellValue(ssfRow.getCell(index++)));
		record.setProfessionalDirection(getStringCellValue(ssfRow.getCell(index++)));
		record.setRemark(getStringCellValue(ssfRow.getCell(index++)));
		ChangeUtils.proTHospitalMappingReverse(record);
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
        }
        return tmpValue;
    }

	@Override
	public List<THospitalMappingDTO> getHospitalMappingListByCondition(String key, String doctorQueryType) {
		List<THospitalMappingDTO> rlt = new ArrayList<THospitalMappingDTO>();
		THospitalMappingExample example = new THospitalMappingExample();  
		THospitalMappingExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(key)){
			if("0".equals(doctorQueryType)){
				criteria.andAreaEqualTo(key);
			}else if("1".equals(doctorQueryType)){
				criteria.andHospitalNameEqualTo(key);
			}else if("2".equals(doctorQueryType)){
				criteria.andProvinceEqualTo(key);
			}else if("3".equals(doctorQueryType)){
				criteria.andCityEqualTo(key);
			}else if("4".equals(doctorQueryType)){
				criteria.andHospitalGradeEqualTo(key);
			}else if("5".equals(doctorQueryType)){
				criteria.andHospitalLevelEqualTo(key);
			}else if("6".equals(doctorQueryType)){
				criteria.andHospitalTypeEqualTo(key);
			}else if("7".equals(doctorQueryType)){
				criteria.andAreaManagerEqualTo(key);
			}else if("8".equals(doctorQueryType)){
				criteria.andHrEqualTo(key);
			}else if("9".equals(doctorQueryType)){
				criteria.andDoctorNameEqualTo(key);
			}else if("10".equals(doctorQueryType)){
				criteria.andDoctorTitleEqualTo(key);
			}else if("11".equals(doctorQueryType)){
				criteria.andAdministrativePostEqualTo(key);
			}else if("12".equals(doctorQueryType)){
				criteria.andProfessionalDirectionEqualTo(key);
			}
		}
		List<THospitalMapping> list = tHospitalMappingMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(THospitalMapping po : list){
				rlt.add(CopyUtils.createCopy(po, THospitalMappingDTO.class));
			}
		}
		return rlt;
	}
}
