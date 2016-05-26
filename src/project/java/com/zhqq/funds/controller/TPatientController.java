package com.zhqq.funds.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.VO.TPatientVO;
import com.zhqq.funds.service.TPatientService;

import cn.osworks.aos.core.asset.AOSJson;
import cn.osworks.aos.core.asset.AOSUtils;
import cn.osworks.aos.core.asset.WebCxt;
import cn.osworks.aos.core.typewrap.Dto;
import cn.osworks.aos.core.typewrap.Dtos;
import cn.osworks.aos.system.dao.po.Aos_sys_orgPO;



@Controller
public class TPatientController {

	/** 导出Excel时临时保存的文件名前缀 */
	private static final String EXPORT_EXCEL_PREFIX = "tmpExportExcel_";

	/** 导出时选择文件保存位置等待的时间间隔 ,用来解决清理临时文件时不删除正在等待导出的文件*/
	private static final int EXPORT_WAIT_TIME = 1;

	@Autowired
	private TPatientService tPatientService;
	
	//funds/patient/dataManagerQueryList
	//funds/md/mdQueryList
	//funds/hr/hrQueryList
	
	@RequestMapping(value="/doQuery")
	public void queryPatient(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="name_")String name ,@RequestParam(value="cdcard_")String cdcard) throws Exception {
		TPatientVO rlt = new TPatientVO();
		// 姓名检查
		if (!tPatientService.checkName(name)) {
			rlt.setAppcode(-1);
			rlt.setAppmsg("患者姓名不存在!");
			WebCxt.write(response, AOSJson.toJson(rlt));
			return;
		}
		// 身份证检查
		if (!tPatientService.checkCdCard(name,cdcard)) {
			rlt.setAppcode(-2);
			rlt.setAppmsg("患者身份证号不正确!");
			WebCxt.write(response, AOSJson.toJson(rlt));
			return;
		}
		TPatientDTO dto = tPatientService.queryPatient(name,cdcard); 
		AOSUtils.copyProperties(dto, rlt);
		rlt.setAppcode(1);
		WebCxt.write(response, AOSJson.toJson(rlt));
	}

	
	@RequestMapping(value="/addPatient")
	public ModelAndView addPatient(HttpServletRequest requet,TPatientDTO tPatientDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
//		tPatientService.addPatient(tPatientVo);
//		modelAndView.addObject("state", "增加患者资料成功!");
//		modelAndView.setViewName("add");
		return modelAndView;
	}
	
	@RequestMapping(value="funds/patient/queryPatientList")
	public void queryPatientList(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="hotkey")String hotkey ,
			@RequestParam(value="patientQueryType")String patientQueryType,
			@RequestParam(value="limit")String limit,
			@RequestParam(value="page")String page,
			@RequestParam(value="start")String start) throws Exception {
		int totalCount = tPatientService.queryPatientCount(hotkey,patientQueryType);
		List<TPatientDTO> listTPatientDTO = tPatientService.queryPatientList(hotkey,patientQueryType,page,start,limit);
		String outString = AOSJson.toGridJson(listTPatientDTO, totalCount);
		WebCxt.write(response, outString);
	}
	
	/**
	 * 页面初始化
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/patient/dataManagerQueryList")
	public String dataManagerQueryListInit() {
		return "funds/dataManagerList.jsp";
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
			System.out.println("zzzzzzzzzzzzzzzzz");
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
					executorService.shutdown();
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

}
