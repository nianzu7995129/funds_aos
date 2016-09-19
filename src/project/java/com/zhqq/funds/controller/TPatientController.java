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
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.zhqq.funds.DTO.TCitiesDTO;
import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.VO.TCitiesVO;
import com.zhqq.funds.VO.TPatientVO;
import com.zhqq.funds.service.AreaService;
import com.zhqq.funds.service.TPatientService;
import com.zhqq.funds.utils.CopyUtils;
import com.zhqq.funds.utils.ChangeUtils;

import cn.osworks.aos.core.asset.AOSCons;
import cn.osworks.aos.core.asset.AOSJson;
import cn.osworks.aos.core.asset.AOSUtils;
import cn.osworks.aos.core.asset.WebCxt;
import cn.osworks.aos.core.typewrap.Dto;
import cn.osworks.aos.core.typewrap.Dtos;
import cn.osworks.aos.system.dao.po.Aos_sys_orgPO;
import cn.osworks.aos.system.dao.po.Aos_sys_user_cfgPO;
import cn.osworks.aos.system.dao.po.Aos_sys_user_extPO;
import cn.osworks.aos.system.modules.dao.vo.UserInfoVO;



@Controller
public class TPatientController {
	/** 导出Excel时临时保存的文件名前缀 */
	private static final String EXPORT_EXCEL_PREFIX = "tmpExportExcel_";

	/** 导出时选择文件保存位置等待的时间间隔 ,用来解决清理临时文件时不删除正在等待导出的文件*/
	private static final int EXPORT_WAIT_TIME = 1;

	@Autowired
	private TPatientService tPatientService;
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="/doQuery")
	public void queryPatient(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="name_")String name ,@RequestParam(value="cdcard_")String cdcard,@RequestParam(value="applyType_")String applyType) throws Exception {
		TPatientVO rlt = new TPatientVO();
		// 姓名检查
		if (!tPatientService.checkName(name,applyType)) {
			rlt.setAppcode(-1);
			rlt.setAppmsg("患者姓名不存在!");
			WebCxt.write(response, AOSJson.toJson(rlt));
			return;
		}
		// 身份证检查
		if (!tPatientService.checkCdCard(name,cdcard,applyType)) {
			rlt.setAppcode(-2);
			rlt.setAppmsg("患者身份证号不正确!");
			WebCxt.write(response, AOSJson.toJson(rlt));
			return;
		}
		TPatientDTO dto = tPatientService.queryPatient(name,cdcard,applyType); 
		ChangeUtils.proTPatientDTO(dto);
		rlt = CopyUtils.copyDTOToVO(dto);
		rlt.setAppcode(1);
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	@RequestMapping(value="funds/patient/deletePatient")
	public void deletePatient(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="aos_rows_")String ids) throws Exception {
		TPatientVO rlt = new TPatientVO();
		tPatientService.deletePatients(ids);
		rlt.setAppcode(1);
		rlt.setAppmsg("删除患者成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	@RequestMapping(value="funds/patient/updatePatient")
	public void updatePatient(HttpServletRequest request, HttpServletResponse response,TPatientDTO tPatientDTO) throws Exception {
		TPatientVO rlt = new TPatientVO();
		//检查档案号是否重复
		List<TPatientDTO> tPatientDTOList =  tPatientService.getPatientListByCondition(tPatientDTO.getArchives(), "0");
		if(tPatientDTOList!=null && tPatientDTOList.size()>0 && (int)(tPatientDTOList.get(0).getId())!=(int)(tPatientDTO.getId())){
			rlt.setAppcode(-1);
			rlt.setAppmsg("档案号重复!");
			WebCxt.write(response, AOSJson.toJson(rlt));
			return;
			
		}
		tPatientService.updatePatient(tPatientDTO);
		rlt.setAppcode(1);
		rlt.setAppmsg("修改患者成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	@RequestMapping(value="funds/patient/getPatient")
	public void getPatient(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="id")String id) throws Exception {
		TPatientVO rlt = new TPatientVO();
		TPatientDTO dto = tPatientService.getPatientByID(id); 
		rlt = CopyUtils.copyDTOToVO(dto);
		rlt.setAppcode(1);
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	
	

	
	@RequestMapping(value="funds/patient/savePatien")
	public void addPatient(HttpServletRequest requet, HttpServletResponse response,TPatientDTO tPatientDTO) throws Exception {
		TPatientVO rlt = new TPatientVO();
		//检查档案号是否重复
		List<TPatientDTO> tPatientDTOList =  tPatientService.getPatientListByCondition(tPatientDTO.getArchives(), "0");
		if(tPatientDTOList!=null && tPatientDTOList.size()>0){
			rlt.setAppcode(-1);
			rlt.setAppmsg("档案号重复!");
			WebCxt.write(response, AOSJson.toJson(rlt));
			return;
			
		}
		//如果未正常申请--检查身份证号重复
		if("0".equals(tPatientDTO.getApplyType())){
			tPatientDTOList =  tPatientService.getPatientListByCondition(tPatientDTO.getIdcardnumber(), "8");
			if(tPatientDTOList!=null && tPatientDTOList.size()>0){
				rlt.setAppcode(-1);
				rlt.setAppmsg("身份证号重复!");
				WebCxt.write(response, AOSJson.toJson(rlt));
				return;
			}
		}
		tPatientService.addPatient(tPatientDTO);
		rlt.setAppcode(1);
		rlt.setAppmsg("新增患者成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
		
		
		
		
	}
	
	@RequestMapping(value="funds/patient/queryPatientListHR")
	public void queryPatientListHR(HttpSession session,HttpServletRequest request, HttpServletResponse response,@RequestParam(value="hotkey")String hotkey ,
			@RequestParam(value="patientQueryType")String patientQueryType,
			@RequestParam(value="limit")String limit,
			@RequestParam(value="page")String page,
			@RequestParam(value="start")String start) throws Exception {
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute(AOSCons.USERINFOKEY);
		String hr = userInfoVO.getName_();
		
		int totalCount = tPatientService.queryPatientCountHR(hotkey,patientQueryType,hr);
		List<TPatientDTO> listTPatientDTO = tPatientService.queryPatientListHR(hotkey,patientQueryType,hr,page,start,limit,true);
		if(ChangeUtils.tProvincesDTOList==null){
			ChangeUtils.proTPatientDTOList(listTPatientDTO,areaService.getAllProvinces());
		}else{
			ChangeUtils.proTPatientDTOList(listTPatientDTO,null);
		}
		String outString = AOSJson.toGridJson(listTPatientDTO, totalCount);
		WebCxt.write(response, outString);
	}
	
	@RequestMapping(value="funds/patient/queryPatientList")
	public void queryPatientList(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="hotkey")String hotkey ,
			@RequestParam(value="patientQueryType")String patientQueryType,
			@RequestParam(value="limit")String limit,
			@RequestParam(value="page")String page,
			@RequestParam(value="start")String start) throws Exception {
		int totalCount = tPatientService.queryPatientCount(hotkey,patientQueryType);
		List<TPatientDTO> listTPatientDTO = tPatientService.queryPatientList(hotkey,patientQueryType,page,start,limit,true);
		if(ChangeUtils.tProvincesDTOList==null){
			ChangeUtils.proTPatientDTOList(listTPatientDTO,areaService.getAllProvinces());
		}else{
			ChangeUtils.proTPatientDTOList(listTPatientDTO,null);
		}
		String outString = AOSJson.toGridJson(listTPatientDTO, totalCount);
		WebCxt.write(response, outString);
	}

	/**
	 * 导出Excel
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/patient/exportExcel")
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
			tPatientService.exportExcel(inDto,"导出",fos,"2003");
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
	@RequestMapping(value = "funds/patient/importExcel")
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
	            	tPatientService.importPatientExcel(workbook);
                    outDto.setAppMsg("导入成功");
	            }catch(Exception e){
	                outDto.setAppMsg(e.getMessage()==null?"导入异常":e.getMessage());
	            }
	        }
		}
		return outDto;
	}
	
	@RequestMapping(value="funds/patient/getMaxArchives")
	public void getMaxArchives(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TPatientVO rlt = new TPatientVO();
		int maxArchives = tPatientService.getMaxArchives();
		rlt.setAppcode(1);
		rlt.setArchives(++maxArchives + "");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
}
