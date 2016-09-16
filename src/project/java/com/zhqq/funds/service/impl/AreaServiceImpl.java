/**
 * 
 */
package com.zhqq.funds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.zhqq.funds.DTO.TProvincesDTO;
import com.zhqq.funds.mapper.TProvincesMapper;
import com.zhqq.funds.po.TPatient;
import com.zhqq.funds.po.TProvinces;
import com.zhqq.funds.po.TProvincesExample;
import com.zhqq.funds.service.AreaService;
import com.zhqq.funds.utils.CopyUtils;

/**
 * @author dell
 *
 */
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private TProvincesMapper tProvincesMapper;
	
	@Override
	public List<TProvincesDTO> getAllProvinces() throws Exception {
		List<TProvincesDTO> rlt = Lists.newArrayList();
		TProvincesExample example = new TProvincesExample();  
		List<TProvinces> TProvincesList = tProvincesMapper.selectByExample(example);
		if(TProvincesList!=null && TProvincesList.size()>0){
			for(TProvinces po : TProvincesList){
				rlt.add(CopyUtils.copyPOToDTO(po));
			}
		}
		return rlt;
	}
}
