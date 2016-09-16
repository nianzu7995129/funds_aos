package com.zhqq.funds.service;

import java.util.List;

import com.zhqq.funds.DTO.TCitiesDTO;
import com.zhqq.funds.DTO.TProvincesDTO;

public interface AreaService {
	
	
	/**
	 * 获取所有省份
	 * @return
	 * @throws Exception
	 */
	public List<TProvincesDTO> getAllProvinces() throws Exception;
	
	/**
	 * 获取所有城市
	 * @return
	 * @throws Exception
	 */
	public List<TCitiesDTO> getAllCities() throws Exception;
	
	/**
	 * 获取省下面的市
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public List<TCitiesDTO> getCitiesByProvince(String code) throws Exception;
	
	
	
	
	
	
}
