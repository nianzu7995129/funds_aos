package com.zhqq.funds.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zhqq.funds.DTO.THrDTO;
import com.zhqq.funds.VO.THrVO;
import com.zhqq.funds.service.THrService;
import com.zhqq.funds.utils.ChangeUtils;
import com.zhqq.funds.utils.CopyUtils;

import cn.osworks.aos.core.asset.AOSJson;
import cn.osworks.aos.core.asset.WebCxt;
import cn.osworks.aos.core.typewrap.Dto;
import cn.osworks.aos.core.typewrap.Dtos;



@Controller
public class THrController {
	/** 导出Excel时临时保存的文件名前缀 */
	private static final String EXPORT_EXCEL_PREFIX = "tmpExportExcel_";

	/** 导出时选择文件保存位置等待的时间间隔 ,用来解决清理临时文件时不删除正在等待导出的文件*/
	private static final int EXPORT_WAIT_TIME = 1;

	@Autowired
	private THrService tHrService;
	
	@RequestMapping(value="funds/hr/deleteHr")
	public void deleteHr(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="aos_rows_")String ids) throws Exception {
		THrVO rlt = new THrVO();
		tHrService.deleteHrs(ids);
		rlt.setAppcode(1);
		rlt.setAppmsg("删除专员成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	@RequestMapping(value="funds/hr/updateHr")
	public void updateHr(HttpServletRequest request, HttpServletResponse response,THrDTO tHrDTO) throws Exception {
		THrVO rlt = new THrVO();
		tHrService.updateHr(tHrDTO);
		rlt.setAppcode(1);
		rlt.setAppmsg("修改专员成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	@RequestMapping(value="funds/hr/getHr")
	public void getHr(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="id")String id) throws Exception {
		THrVO rlt = new THrVO();
		THrDTO dto = tHrService.getHrByID(id); 
		rlt = CopyUtils.createCopy(dto, THrVO.class);
		rlt.setAppcode(1);
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	@RequestMapping(value="funds/hr/saveHr")
	public void addHr(HttpServletRequest requet, HttpServletResponse response,THrDTO tHrDTO) throws Exception {
		THrVO rlt = new THrVO();
		tHrService.addHr(tHrDTO);
		rlt.setAppcode(1);
		rlt.setAppmsg("新增专员成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	
	@RequestMapping(value="funds/hr/queryHrList")
	public void queryHrList(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="hotkey")String hotkey ,
			@RequestParam(value="patientQueryType")String patientQueryType,
			@RequestParam(value="limit")String limit,
			@RequestParam(value="page")String page,
			@RequestParam(value="start")String start) throws Exception {
		int totalCount = tHrService.queryHrCount(hotkey,patientQueryType);
		List<THrDTO> listTHrDTO = tHrService.queryHrList(hotkey,patientQueryType,page,start,limit,true);
		ChangeUtils.proTHrDTOList(listTHrDTO);
		String outString = AOSJson.toGridJson(CopyUtils.createCopyList(listTHrDTO, THrVO.class), totalCount);
		WebCxt.write(response, outString);
	}

	
	/**
	 * 导出Excel
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/hr/exportExcel")
	public void exportExcel(final HttpServletRequest request, HttpServletResponse response) {
		OutputStream os = null;
		FileOutputStream fos = null;
		try{
			long time = 0;
			synchronized (this){
				time = System.currentTimeMillis();
			}
			final String excelTmpName = EXPORT_EXCEL_PREFIX + time ;
			final String appPath = request.getServletContext().getRealPath("/");
			
			new Thread(){
				public void run(){
					ExecutorService executorService = Executors.newCachedThreadPool();
					executorService.execute(new Thread(){
						public void run(){
							File file = new File(appPath);
							if(file==null) return;
							//过滤出满足条件,可以删除的文件,目前规则是前缀为EXPORT_EXCEL_PREFIX
							File[] files = file.listFiles(new FileFilter() {
								@Override
								public boolean accept(File tmpFile) {
									String tmpName = tmpFile.getName();
									if(tmpName!=null && tmpName.indexOf(EXPORT_EXCEL_PREFIX)!=-1) {
										if (intervalMinute(tmpName,excelTmpName+".xls")) return false;
										//System.out.println("--过滤通过的文件-->"+tmpFile.getName());
										return true;
									}else{
										return false;
									}
								}
							});
							if(files==null) return;
							int len = files.length;
							//临时文件数大于30则清理
							if(len>5) {
								for (int i = len - 1; i >= 0; i--) {
									File tmpF = files[i];
									//System.out.println("--清理的文件-->"+tmpF.getName());
									tmpF.delete();
								}
							}
						}
					});
				}
			}.start();

			Dto inDto = Dtos.newDto(request);

			String tmpFilePath = appPath+excelTmpName+".xls";
			fos = new FileOutputStream(new File(tmpFilePath));
			tHrService.exportExcel(inDto,"导出",fos,"2003");
			fos.close();
			WebCxt.write(response, excelTmpName+".xls");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(fos!=null){
				try {
					fos.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	//为了避免导出前删除了临时文件,所以设定导出等待的时间间隔为EXPORT_WAIT_TIME分钟
	private boolean intervalMinute(String sourcetmpName, String targetFileName) {
		String sourceTimeMillis = truncateTime(sourcetmpName);
		String targetTimeMillis = truncateTime(targetFileName);
		Calendar sourceCalendar = Calendar.getInstance();
		sourceCalendar.setTime(new java.util.Date(new Long(sourceTimeMillis).longValue()));
		int resultSource = sourceCalendar.get(Calendar.MINUTE);
		Calendar targetCalendar = Calendar.getInstance();
		targetCalendar.setTime(new java.util.Date(new Long(targetTimeMillis).longValue()));
		int resultTarget = targetCalendar.get(Calendar.MINUTE);
		if(Math.abs(resultTarget-resultSource) < EXPORT_WAIT_TIME){
			return true ;
		}
		return false;
	}

	private String truncateTime(String tmpName) {
		int startPos = EXPORT_EXCEL_PREFIX.length();
		int endPos = 0;
		if(tmpName.lastIndexOf(".xlsx")!=-1){
			endPos = tmpName.lastIndexOf(".xlsx");
		}else if(tmpName.lastIndexOf(".xls")!=-1){
			endPos = tmpName.lastIndexOf(".xls");
		}
		return tmpName.substring(startPos,endPos);
	}


	/**
	 * 导入数据
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/hr/importExcel")
	public Dto importExcel(@RequestParam("myFile1") MultipartFile multipartFile,final HttpServletRequest request, HttpServletResponse response) {
		Dto outDto = Dtos.newOutDto();
		if(multipartFile==null){
			outDto.setAppMsg("操作被取消，Excel文件获取失败。");
		}else{
			String originalFileName = multipartFile.getOriginalFilename();
	        String updateCaseName = originalFileName.toUpperCase();
	        //XLS、XLSX
	        if (StringUtils.indexOf(updateCaseName, ".XLS") > 0 || StringUtils.indexOf(updateCaseName, ".XLSX") > 0 ) {
	            InputStream is = null;
	            try {
	                is = multipartFile.getInputStream();
	            }catch(Exception e){
	                outDto.setAppMsg("操作被取消，获取导入的Excel文件流失败");
	            }
	            Workbook workbook = null;
	            try{
	                workbook = new HSSFWorkbook(is);
	            }catch(Exception ioException1){
	                try {
	                    is = multipartFile.getInputStream();
	                    workbook = new XSSFWorkbook(is);
	                }catch(Exception ioException2){
	                    outDto.setAppMsg("操作被取消，转换输入流出现问题");
	                }
	            }

	            if(is!=null){
	                try {
	                    is.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }

	            if (workbook == null) {
	                outDto.setAppMsg("操作被取消，文件对象获取失败");
	            }

	            int num = workbook.getNumberOfSheets();
	            if (num == 0) {
	                outDto.setAppMsg("操作被取消，未获得有效的Sheet。");
	            }
	            try {
	            	tHrService.importHrExcel(workbook);
                    outDto.setAppMsg("导入成功");
	            }catch(Exception e){
	                outDto.setAppMsg(e.getMessage()==null?"导入异常":e.getMessage());
	            }
	        }
		}
		return outDto;
	}
	
}
