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

import com.zhqq.funds.DTO.TDoctorDTO;
import com.zhqq.funds.mapper.TDoctorMapper;
import com.zhqq.funds.po.TDoctor;
import com.zhqq.funds.po.TDoctorExample;
import com.zhqq.funds.service.AreaService;
import com.zhqq.funds.service.TDoctorService;
import com.zhqq.funds.utils.ChangeUtils;
import com.zhqq.funds.utils.CopyUtils;
import com.zhqq.funds.utils.SQLUtils;

import cn.osworks.aos.core.typewrap.Dto;


@Service
public class TDoctorServiceImpl implements TDoctorService {

	@Autowired
	private TDoctorMapper tDoctorMapper;
	
	@Autowired
	private AreaService areaService;
	
	@Override
	public void addDoctor(TDoctorDTO tDoctor) throws Exception {
		tDoctorMapper.insert(CopyUtils.createCopy(tDoctor, TDoctor.class));
	}
	
	@Override
	public List<TDoctorDTO> queryDoctorList(String hotkey, String doctorQueryType, String page, String start,
			String limit,boolean pageFlag) throws Exception {
		List<TDoctorDTO> rlt = new ArrayList<TDoctorDTO>();
		TDoctorExample example = new TDoctorExample();  
		TDoctorExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(hotkey)){
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(doctorQueryType)){
				criteria.andProvinceLike(hotkey);
			}else if("1".equals(doctorQueryType)){
				criteria.andStateLike(hotkey);
			}else if("2".equals(doctorQueryType)){
				criteria.andNameLike(hotkey);
			}else if("3".equals(doctorQueryType)){
				criteria.andSexLike(hotkey);
			}else if("4".equals(doctorQueryType)){
				criteria.andHospitalLike(hotkey);
			}else if("5".equals(doctorQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("6".equals(doctorQueryType)){
				criteria.andIsRegisterLike(hotkey);
			}
		}
		if(pageFlag){
			example.setLimitStart(Integer.valueOf(start));
			example.setLimitEnd(Integer.valueOf(start)+Integer.valueOf(limit));
		}
		List<TDoctor> list = tDoctorMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(TDoctor po : list){
				rlt.add(CopyUtils.createCopy(po, TDoctorDTO.class));
			}
		}
		return rlt;
	}

	@Override
	public int queryDoctorCount(String hotkey, String doctorQueryType) throws Exception {
		int rlt = 0;
		TDoctorExample example = new TDoctorExample();  
		if(!StringUtils.isEmpty(hotkey)){
			TDoctorExample.Criteria criteria = example.createCriteria();
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(doctorQueryType)){
				criteria.andProvinceLike(hotkey);
			}else if("1".equals(doctorQueryType)){
				criteria.andStateLike(hotkey);
			}else if("2".equals(doctorQueryType)){
				criteria.andNameLike(hotkey);
			}else if("3".equals(doctorQueryType)){
				criteria.andSexLike(hotkey);
			}else if("4".equals(doctorQueryType)){
				criteria.andHospitalLike(hotkey);
			}else if("5".equals(doctorQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("6".equals(doctorQueryType)){
				criteria.andIsRegisterLike(hotkey);
			}
		}
		rlt = tDoctorMapper.countByExample(example);
		return rlt;
	}

	@Override
	public TDoctorDTO getDoctorByID(String id) throws Exception {
		TDoctorDTO rlt = new TDoctorDTO();
		TDoctor po = tDoctorMapper.selectByPrimaryKey(Long.valueOf(id));
		rlt = CopyUtils.createCopy(po,TDoctorDTO.class);
		return rlt;
	}

	@Override
	public void deleteDoctors(String ids) throws Exception {
		TDoctorExample example = new TDoctorExample();  
		TDoctorExample.Criteria criteria = example.createCriteria();  
		if (StringUtils.isNotEmpty(ids)) {
			String[] temps = ids.split(",");
			List<Long> values = new ArrayList<Long>();
			for(String temp : temps){
				values.add(Long.valueOf(temp));
			}
			criteria.andIdIn(values);
			tDoctorMapper.deleteByExample(example);
		}
		
		
		
	}

	@Override
	public void updateDoctor(TDoctorDTO tDoctorDTO) throws Exception {
		TDoctor record = new TDoctor();
		record = CopyUtils.createCopy(tDoctorDTO,TDoctor.class);
		tDoctorMapper.updateByPrimaryKey(record);
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
		List<TDoctorDTO> listTDoctorDTO = queryDoctorList(hotkey, patientQueryType, "", "", "", false);
		if(ChangeUtils.tProvincesDTOList==null){
			ChangeUtils.proTDoctorDTOList(listTDoctorDTO,areaService.getAllProvinces());
		}else{
			ChangeUtils.proTDoctorDTOList(listTDoctorDTO,null);
		}
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		createTitle(row);
		int size = listTDoctorDTO.size();
		for(int i=1;i<=size;i++){
			HSSFRow dataRow = sheet.createRow(i);
			createData(dataRow,listTDoctorDTO.get(i-1));
		}
		return workbook;
	}
	
	/**
	 * @param row
	 */
	private void createData(HSSFRow row,TDoctorDTO tDoctorDTO) {
		int index = 0;
		HSSFCell cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getState());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getProvince());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getName());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getSex());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getHospital());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getIdcardCopy());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getRegisterDoctorTable());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getRegisterHospitalConsent());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getRegisterDoctorConsent());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getResume());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getHospitalProfile());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getPhone());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getIsRegister());
	}

	/**
	 * @param row
	 */
	private void createTitle(HSSFRow row) {
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("是否通过");
		cell = row.createCell(1);
		cell.setCellValue("省份");
		cell = row.createCell(2);
		cell.setCellValue("姓名");
		cell = row.createCell(3);
		cell.setCellValue("性别");
		cell = row.createCell(4);
		cell.setCellValue("所在医院");
		cell = row.createCell(5);
		cell.setCellValue("身份证复印件");
		cell = row.createCell(6);
		cell.setCellValue("注册医生申请表");
		cell = row.createCell(7);
		cell.setCellValue("注册医院同意书");
		cell = row.createCell(8);
		cell.setCellValue("注册医生同意书");
		cell = row.createCell(9);
		cell.setCellValue("个人简历");
		cell = row.createCell(10);
		cell.setCellValue("医院简介");
		cell = row.createCell(11);
		cell.setCellValue("联系电话");
		cell = row.createCell(12);
		cell.setCellValue("是否在册");
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
		List<TDoctorDTO> listTDoctorDTO = queryDoctorList(hotkey, patientQueryType, "", "", "", false);
		
		if(ChangeUtils.tProvincesDTOList==null){
			ChangeUtils.proTDoctorDTOList(listTDoctorDTO,areaService.getAllProvinces());
		}else{
			ChangeUtils.proTDoctorDTOList(listTDoctorDTO,null);
		}
		
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		createTitleXSSF(row);
		int size = listTDoctorDTO.size();
		for(int i=1;i<=size;i++){
			XSSFRow dataRow = sheet.createRow(i);
			createDataXSSF(dataRow,listTDoctorDTO.get(i-1));
		}

		return workbook;
	}
	
	
	/**
	 * @param row
	 */
	private void createDataXSSF(XSSFRow row,TDoctorDTO tDoctorDTO) {
		int index = 0;
		XSSFCell cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getState());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getProvince());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getName());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getSex());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getHospital());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getIdcardCopy());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getRegisterDoctorTable());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getRegisterHospitalConsent());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getRegisterDoctorConsent());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getResume());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getHospitalProfile());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getPhone());
		cell = row.createCell(index++);
		cell.setCellValue(tDoctorDTO.getIsRegister());
	}

	/**
	 * @param row
	 */
	private void createTitleXSSF(XSSFRow row) {
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("是否通过");
		cell = row.createCell(1);
		cell.setCellValue("省份");
		cell = row.createCell(2);
		cell.setCellValue("姓名");
		cell = row.createCell(3);
		cell.setCellValue("性别");
		cell = row.createCell(4);
		cell.setCellValue("所在医院");
		cell = row.createCell(5);
		cell.setCellValue("身份证复印件");
		cell = row.createCell(6);
		cell.setCellValue("注册医生申请表");
		cell = row.createCell(7);
		cell.setCellValue("注册医院同意书");
		cell = row.createCell(8);
		cell.setCellValue("注册医生同意书");
		cell = row.createCell(9);
		cell.setCellValue("个人简历");
		cell = row.createCell(10);
		cell.setCellValue("医院简介");
		cell = row.createCell(11);
		cell.setCellValue("联系电话");
		cell = row.createCell(12);
		cell.setCellValue("是否在册");
	}

	@Override
	public void importDoctorExcel(Workbook workbook) throws Exception {
		  // 得到第一张工作表
        Sheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();
        for(int i=1;i<=lastRow;i++) {
        	try{
	        	Row ssfRow = sheet.getRow(i);
	            if(ssfRow==null || ssfRow.getCell(0)==null || "".equals(getStringCellValue(ssfRow.getCell(0)))) continue;
	            TDoctor record = new TDoctor();
	            proTDoctor(ssfRow, record);
            	tDoctorMapper.insert(record);
	        }catch(Exception e){
				e.printStackTrace();
	        }
        }
	}

	/**
	 * @param ssfRow
	 * @param record
	 */
	private void proTDoctor(Row ssfRow, TDoctor record) {
		int index = 1;
		record.setState(getStringCellValue(ssfRow.getCell(index++)));
		record.setProvince(getStringCellValue(ssfRow.getCell(index++)));
		record.setName(getStringCellValue(ssfRow.getCell(index++)));
		record.setSex(getStringCellValue(ssfRow.getCell(index++)));
		record.setHospital(getStringCellValue(ssfRow.getCell(index++)));
		record.setIdcardCopy(getStringCellValue(ssfRow.getCell(index++)));
		record.setRegisterDoctorTable(getStringCellValue(ssfRow.getCell(index++)));
		record.setRegisterHospitalConsent(getStringCellValue(ssfRow.getCell(index++)));
		record.setRegisterDoctorConsent(getStringCellValue(ssfRow.getCell(index++)));
		record.setResume(getStringCellValue(ssfRow.getCell(index++)));
		record.setHospitalProfile(getStringCellValue(ssfRow.getCell(index++)));
		record.setPhone(getStringCellValue(ssfRow.getCell(index++)));
		record.setIsRegister(getStringCellValue(ssfRow.getCell(index++)));
		ChangeUtils.proTDoctorReverse(record);
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
}
