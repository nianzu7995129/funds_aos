package com.zhqq.funds.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.zhqq.funds.DTO.TProvincesDTO;
import com.zhqq.funds.VO.TProvincesVO;
import com.zhqq.funds.service.AreaService;
import com.zhqq.funds.utils.CopyUtils;

import cn.osworks.aos.core.asset.AOSJson;
import cn.osworks.aos.core.asset.WebCxt;



@Controller
public class CommonController {

	@Autowired
	private AreaService areaService;
	
	/**
	 * 获取省份
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="funds/getProvinces")
	public void getProvinces(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<TProvincesVO> rlt = Lists.newArrayList();
		List<TProvincesDTO> tProvincesDTOList = areaService.getAllProvinces();
		for(TProvincesDTO dto : tProvincesDTOList){
			rlt.add(CopyUtils.copyDTOToVO(dto));
		}
		WebCxt.write(response, AOSJson.toJson(rlt));
	}
	
	/**
	 * 专员页面初始化
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/hr/hrQueryList")
	public String hrQueryListInit() {
		return "funds/hr.jsp";
	}
	
	/**
	 * 数据管理页面初始化
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/patient/dataManagerQueryList")
	public String dataManagerQueryListInit() {
		return "funds/dataManagerList.jsp";
	}
	
	/**
	 * 医生页面初始化
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/doctor/doctorQueryList")
	public String doctorQueryList() {
		return "funds/doctorList.jsp";
	}
	
	/**
	 * 专员管理页面初始化
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/hr/hrList")
	public String hrList() {
		return "funds/hrList.jsp";
	}

	/**
	 * 医院与医生关联管理页面初始化
	 *
	 * @return
	 */
	@RequestMapping(value = "funds/hd/hdQueryList")
	public String hdQueryList() {
		return "funds/hdList.jsp";
	}
	
}
