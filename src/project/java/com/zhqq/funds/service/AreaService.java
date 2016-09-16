package com.zhqq.funds.service;

import java.util.List;

import com.zhqq.funds.DTO.TProvincesDTO;

public interface AreaService {
	
	
	/**
	 * 获取所有省份
	 * @return
	 * @throws Exception
	 */
	public List<TProvincesDTO> getAllProvinces() throws Exception;
	
	
	
}
