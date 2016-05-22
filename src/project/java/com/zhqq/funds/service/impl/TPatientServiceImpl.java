package com.zhqq.funds.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.po.SQLUtils;
import com.zhqq.funds.po.TPatient;
import com.zhqq.funds.mapper.TPatientMapper;
import com.zhqq.funds.po.TPatientExample;
import com.zhqq.funds.service.TPatientService;

import cn.osworks.aos.core.asset.AOSUtils;


@Service
public class TPatientServiceImpl implements TPatientService {

	@Autowired
	private TPatientMapper tPatientMapper;
	
	@Override
	public void addPatient(TPatientDTO tPatient) throws Exception {
	}

	@Override
	public TPatientDTO queryPatient(String name, String idcardnumber) throws Exception {
		TPatientDTO rlt = new TPatientDTO();
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();  
		criteria.andNameEqualTo(name);
		criteria.andIdcardnumberEqualTo(idcardnumber);
		List<TPatient> list = tPatientMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			TPatient po = list.get(0);
			AOSUtils.copyProperties(po, rlt);
		}
		return rlt;
	}

	@Override
	public boolean checkName(String name) throws Exception {
		TPatientExample example = new TPatientExample();
		example.createCriteria().andNameEqualTo(name);
		int count = tPatientMapper.countByExample(example);
		return count==0 ? false : true;
	}

	@Override
	public boolean checkCdCard(String name, String idcardnumber) throws Exception {
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();  
		criteria.andNameEqualTo(name);
		criteria.andIdcardnumberEqualTo(idcardnumber);
		int count = tPatientMapper.countByExample(example);
		return count==0 ? false : true;
	}

	/* (non-Javadoc)
	 * @see com.zhqq.funds.service.TPatientService#queryPatientList(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<TPatientDTO> queryPatientList(String hotkey, String patientQueryType, String page, String start,
			String limit) throws Exception {
		List<TPatientDTO> rlt = new ArrayList<TPatientDTO>();
		TPatientExample example = new TPatientExample();  
		TPatientExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(hotkey)){
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(patientQueryType)){
				criteria.andArchivesLike(hotkey);
			}else if("1".equals(patientQueryType)){
				criteria.andStateLike(hotkey);
			}else if("2".equals(patientQueryType)){
				criteria.andNameLike(hotkey);
			}else if("3".equals(patientQueryType)){
				criteria.andSexLike(hotkey);
			}else if("4".equals(patientQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("5".equals(patientQueryType)){
				criteria.andHrLike(hotkey);
			}else if("6".equals(patientQueryType)){
				criteria.andLangMuHospitalLike(hotkey);
			}else if("7".equals(patientQueryType)){
				criteria.andLangMuDoctorLike(hotkey);
			}
		}
		example.setLimitStart(Integer.valueOf(start));
		example.setLimitEnd(Integer.valueOf(start)+Integer.valueOf(limit));
		List<TPatient> list = tPatientMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			for(TPatient po : list){
				TPatientDTO dto = new TPatientDTO();
				AOSUtils.copyProperties(po, dto);
				rlt.add(dto);
			}
		}
		return rlt;
	}

	@Override
	public int queryPatientCount(String hotkey, String patientQueryType) throws Exception {
		int rlt = 0;
		TPatientExample example = new TPatientExample();  
		if(!StringUtils.isEmpty(hotkey)){
			TPatientExample.Criteria criteria = example.createCriteria();
			hotkey = SQLUtils.proLikeCondition(hotkey);
			if("0".equals(patientQueryType)){
				criteria.andArchivesLike(hotkey);
			}else if("1".equals(patientQueryType)){
				criteria.andStateLike(hotkey);
			}else if("2".equals(patientQueryType)){
				criteria.andNameLike(hotkey);
			}else if("3".equals(patientQueryType)){
				criteria.andSexLike(hotkey);
			}else if("4".equals(patientQueryType)){
				criteria.andPhoneLike(hotkey);
			}else if("5".equals(patientQueryType)){
				criteria.andHrLike(hotkey);
			}else if("6".equals(patientQueryType)){
				criteria.andLangMuHospitalLike(hotkey);
			}else if("7".equals(patientQueryType)){
				criteria.andLangMuDoctorLike(hotkey);
			}
		}
		rlt = tPatientMapper.countByExample(example);
		return rlt;
	}

}
