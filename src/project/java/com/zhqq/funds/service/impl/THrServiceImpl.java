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

import com.zhqq.funds.DTO.THrDTO;
import com.zhqq.funds.mapper.THrMapper;
import com.zhqq.funds.po.THr;
import com.zhqq.funds.po.THrExample;
import com.zhqq.funds.service.THrService;
import com.zhqq.funds.utils.ChangeUtils;
import com.zhqq.funds.utils.CopyUtils;
import com.zhqq.funds.utils.SQLUtils;

import cn.osworks.aos.core.typewrap.Dto;


@Service
public class THrServiceImpl implements THrService {

	@Autowired
	private THrMapper tHrMapper;
	
	@Override
	public void addHr(THrDTO tHr) throws Exception {
		tHrMapper.insert(CopyUtils.createCopy(tHr, THr.class));
	}
	
	@Override
	public List<THrDTO> queryHrList(String hotkey, String hrQueryType, String page, String start,
			String limit,boolean pageFlag) throws Exception {
		List<THrDTO> rlt = new ArrayList<THrDTO>();
		THrExample example = new THrExample();  
		THrExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(hotkey)){
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(hrQueryType)){
				criteria.andNameLike(hotkey);
			}else if("1".equals(hrQueryType)){
				criteria.andSexLike(hotkey);
			}else if("2".equals(hrQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("3".equals(hrQueryType)){
				criteria.andEmailLike(hotkey);
			}else if("4".equals(hrQueryType)){
				criteria.andIsRegisterLike(hotkey);
			}
		}
		if(pageFlag){
			example.setLimitStart(Integer.valueOf(start));
			example.setLimitEnd(Integer.valueOf(start)+Integer.valueOf(limit));
		}
		List<THr> list = tHrMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(THr po : list){
				rlt.add(CopyUtils.createCopy(po, THrDTO.class));
			}
		}
		return rlt;
	}

	@Override
	public int queryHrCount(String hotkey, String hrQueryType) throws Exception {
		int rlt = 0;
		THrExample example = new THrExample();  
		if(!StringUtils.isEmpty(hotkey)){
			THrExample.Criteria criteria = example.createCriteria();
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(hrQueryType)){
				criteria.andNameLike(hotkey);
			}else if("1".equals(hrQueryType)){
				criteria.andSexLike(hotkey);
			}else if("2".equals(hrQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("3".equals(hrQueryType)){
				criteria.andEmailLike(hotkey);
			}else if("4".equals(hrQueryType)){
				criteria.andIsRegisterLike(hotkey);
			}
		}
		rlt = tHrMapper.countByExample(example);
		return rlt;
	}

	@Override
	public THrDTO getHrByID(String id) throws Exception {
		THrDTO rlt = new THrDTO();
		THr po = tHrMapper.selectByPrimaryKey(Long.valueOf(id));
		rlt = CopyUtils.createCopy(po,THrDTO.class);
		return rlt;
	}

	@Override
	public void deleteHrs(String ids) throws Exception {
		THrExample example = new THrExample();  
		THrExample.Criteria criteria = example.createCriteria();  
		if (StringUtils.isNotEmpty(ids)) {
			String[] temps = ids.split(",");
			List<Long> values = new ArrayList<Long>();
			for(String temp : temps){
				values.add(Long.valueOf(temp));
			}
			criteria.andIdIn(values);
			tHrMapper.deleteByExample(example);
		}
		
		
		
	}

	@Override
	public void updateHr(THrDTO tHrDTO) throws Exception {
		THr record = new THr();
		record = CopyUtils.createCopy(tHrDTO,THr.class);
		tHrMapper.updateByPrimaryKey(record);
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
		List<THrDTO> listTHrDTO = queryHrList(hotkey, patientQueryType, "", "", "", false);
		ChangeUtils.proTHrDTOList(listTHrDTO);
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		createTitle(row);
		int size = listTHrDTO.size();
		for(int i=1;i<=size;i++){
			HSSFRow dataRow = sheet.createRow(i);
			createData(dataRow,listTHrDTO.get(i-1),i);
		}
		return workbook;
	}
	
	/**
	 * @param row
	 */
	private void createData(HSSFRow row,THrDTO tHrDTO,int count) {
		int index = 0;
		HSSFCell cell = row.createCell(index++);
		cell.setCellValue(count);
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getName());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getSex());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getIdcardCopy());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getCompanyProfile());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getPhone());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getEmail());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getIsRegister());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getRemark());
	}

	/**
	 * @param row
	 */
	private void createTitle(HSSFRow row) {
		int index = 0;
		HSSFCell cell = row.createCell(index++);
		cell.setCellValue("序号");
		cell = row.createCell(index++);
		cell.setCellValue("姓名");
		cell = row.createCell(index++);
		cell.setCellValue("性别");
		cell = row.createCell(index++);
		cell.setCellValue("身份证复印件");
		cell = row.createCell(index++);
		cell.setCellValue("公司名片");
		cell = row.createCell(index++);
		cell.setCellValue("联系电话");
		cell = row.createCell(index++);
		cell.setCellValue("邮箱");
		cell = row.createCell(index++);
		cell.setCellValue("是否在册");
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
		List<THrDTO> listTHrDTO = queryHrList(hotkey, patientQueryType, "", "", "", false);
		
		ChangeUtils.proTHrDTOList(listTHrDTO);
		
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		createTitleXSSF(row);
		int size = listTHrDTO.size();
		for(int i=1;i<=size;i++){
			XSSFRow dataRow = sheet.createRow(i);
			createDataXSSF(dataRow,listTHrDTO.get(i-1),i);
		}

		return workbook;
	}
	
	
	/**
	 * @param row
	 */
	private void createDataXSSF(XSSFRow row,THrDTO tHrDTO,int count) {
		int index = 0;
		XSSFCell cell = row.createCell(index++);
		cell.setCellValue(count);
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getName());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getSex());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getIdcardCopy());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getCompanyProfile());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getPhone());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getEmail());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getIsRegister());
		cell = row.createCell(index++);
		cell.setCellValue(tHrDTO.getRemark());
	}

	private void createTitleXSSF(XSSFRow row) {
		int index = 0;
		XSSFCell cell = row.createCell(index++);
		cell.setCellValue("序号");
		cell = row.createCell(index++);
		cell.setCellValue("姓名");
		cell = row.createCell(index++);
		cell.setCellValue("性别");
		cell = row.createCell(index++);
		cell.setCellValue("身份证复印件");
		cell = row.createCell(index++);
		cell.setCellValue("公司名片");
		cell = row.createCell(index++);
		cell.setCellValue("联系电话");
		cell = row.createCell(index++);
		cell.setCellValue("邮箱");
		cell = row.createCell(index++);
		cell.setCellValue("是否在册");
		cell = row.createCell(index++);
		cell.setCellValue("备注");
	}

	@Override
	public void importHrExcel(Workbook workbook) throws Exception {
		  // 得到第一张工作表
        Sheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();
        for(int i=1;i<=lastRow;i++) {
        	try{
	        	Row ssfRow = sheet.getRow(i);
	            if(ssfRow==null || ssfRow.getCell(0)==null || "".equals(getStringCellValue(ssfRow.getCell(0)))) continue;
	            THr record = new THr();
	            proTHr(ssfRow, record);
            	tHrMapper.insert(record);
	        }catch(Exception e){
				e.printStackTrace();
	        }
        }
	}

	/**
	 * @param ssfRow
	 * @param record
	 */
	private void proTHr(Row ssfRow, THr record) {
		int index = 1;
		record.setName(getStringCellValue(ssfRow.getCell(index++)));
		record.setSex(getStringCellValue(ssfRow.getCell(index++)));
		record.setIdcardCopy(getStringCellValue(ssfRow.getCell(index++)));
		record.setCompanyProfile(getStringCellValue(ssfRow.getCell(index++)));
		record.setPhone(getStringCellValue(ssfRow.getCell(index++)));
		record.setEmail(getStringCellValue(ssfRow.getCell(index++)));
		record.setIsRegister(getStringCellValue(ssfRow.getCell(index++)));
		ChangeUtils.proTHrReverse(record);
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
}
