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

import com.zhqq.funds.DTO.TDrugreleaseDTO;
import com.zhqq.funds.VO.TDrugreleaseVO;
import com.zhqq.funds.VO.TPatientVO;
import com.zhqq.funds.service.MDService;
import com.zhqq.funds.utils.CopyUtils;
import com.zhqq.funds.utils.PatientUtils;

import cn.osworks.aos.core.asset.AOSJson;
import cn.osworks.aos.core.asset.AOSUtils;
import cn.osworks.aos.core.asset.WebCxt;
import cn.osworks.aos.core.typewrap.Dto;
import cn.osworks.aos.core.typewrap.Dtos;



@Controller
public class MDController {
	/** 导出Excel时临时保存的文件名前缀 */
	private static final String EXPORT_EXCEL_PREFIX = "tmpExportExcel_";

	/** 导出时选择文件保存位置等待的时间间隔 ,用来解决清理临时文件时不删除正在等待导出的文件*/
	private static final int EXPORT_WAIT_TIME = 1;


	@Autowired
	private MDService mDService;
	
	
	@RequestMapping(value="funds/md/deleteMD")
	public void deleteMD(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="aos_rows_")String ids) throws Exception {
		TDrugreleaseVO rlt = new TDrugreleaseVO();
		mDService.deleteMDs(ids);
		rlt.setAppcode(1);
		rlt.setAppmsg("删除医药下发成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	@RequestMapping(value="funds/md/updateMD")
	public void updateMD(HttpServletRequest request, HttpServletResponse response,TDrugreleaseDTO tPatientDTO) throws Exception {
		TDrugreleaseVO rlt = new TDrugreleaseVO();
		mDService.updateMD(tPatientDTO);
		rlt.setAppcode(1);
		rlt.setAppmsg("修改医药下发成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	
	
	@RequestMapping(value="funds/md/updateMDState")
	public void updateMDState(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="id")String id) throws Exception {
		TDrugreleaseVO rlt = new TDrugreleaseVO();
		TDrugreleaseDTO dto = mDService.getMDByID(id); 
		dto.setState("1");
		mDService.updateMD(dto);
		rlt = CopyUtils.copyDTOToVO(dto);
		rlt.setAppcode(1);
		rlt.setAppmsg("发药成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	@RequestMapping(value="funds/md/getMD")
	public void getMD(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="id")String id) throws Exception {
		TDrugreleaseVO rlt = new TDrugreleaseVO();
		TDrugreleaseDTO dto = mDService.getMDByID(id); 
		rlt = CopyUtils.copyDTOToVO(dto);
		rlt.setAppcode(1);
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	
	

	
	@RequestMapping(value="funds/md/saveMD")
	public void addPatient(HttpServletRequest requet, HttpServletResponse response,TDrugreleaseDTO tDrugreleaseDTO) throws Exception {
		TDrugreleaseVO rlt = new TDrugreleaseVO();
		mDService.addDrugrelease(tDrugreleaseDTO);
		rlt.setAppcode(1);
		rlt.setAppmsg("新增医药下发成功!");
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	@RequestMapping(value="funds/md/queryMDList")
	public void queryMDList(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="hotkey")String hotkey ,
			@RequestParam(value="mdQueryType")String mdQueryType,
			@RequestParam(value="mdDateType")String mdDateType,
			@RequestParam(value="limit")String limit,
			@RequestParam(value="page")String page,
			@RequestParam(value="start")String start) throws Exception {
		int totalCount = mDService.queryMDCount(hotkey,mdQueryType,mdDateType);
		List<TDrugreleaseDTO> listTDrugreleaseDTO = mDService.queryMDList(hotkey,mdQueryType,mdDateType,page,start,limit,true);
		for(TDrugreleaseDTO tPatientDTO : listTDrugreleaseDTO){
			tPatientDTO.setState(PatientUtils.getFormatValue(tPatientDTO.getState(), "0", "发药"));
			tPatientDTO.setState(PatientUtils.getFormatValue(tPatientDTO.getState(), "1", "已发"));
		}
		String outString = AOSJson.toGridJson(listTDrugreleaseDTO, totalCount);
		WebCxt.write(response, outString);
	}
	
	/**
	 * 页面初始化
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/md/mdQueryList")
	public String mdQueryListInit() {
		return "funds/md.jsp";
	}
	
	/**
	 * 导出Excel
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/md/exportExcel")
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
			mDService.exportExcel(inDto,"导出",fos,"2003");
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
