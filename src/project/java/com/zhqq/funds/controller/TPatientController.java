package com.zhqq.funds.controller;

import java.util.List;

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
	
}
