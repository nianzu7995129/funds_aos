/**
 * 
 */
package com.zhqq.funds.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Maps;
import com.zhqq.funds.DTO.TCitiesDTO;
import com.zhqq.funds.DTO.TDoctorDTO;
import com.zhqq.funds.DTO.THospitalMappingDTO;
import com.zhqq.funds.DTO.THrDTO;
import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.DTO.TProvincesDTO;
import com.zhqq.funds.po.TDoctor;
import com.zhqq.funds.po.THospitalMapping;
import com.zhqq.funds.po.THr;
import com.zhqq.funds.po.TPatient;

public final class ChangeUtils {

	private static Map<String, String> provinceNameCacheMap;
	
	private static Map<String, String> provinceCodeCacheMap;
	
	private static Map<String, String> cityNameCacheMap;
	
	private static Map<String, String> cityCodeCacheMap;
	
	public static List<TProvincesDTO> tProvincesDTOList;
	
	public static List<TCitiesDTO> tCitiesDTOList;

	public static String getFormatValue(String src,String format,String target){
		String rlt = src;
		if(!StringUtils.isEmpty(rlt)){
			if(rlt.equals(format)){
				rlt = target;
			}
		}else{
			if(format.equals(rlt)){
				rlt = target;
			}
		}
		return rlt;
	}
	
	/**
	 * @param listTPatientDTO
	 */
	public static void proTPatientDTOList(List<TPatientDTO> listTPatientDTO,List<TProvincesDTO> tProvincesDTOList) {
		if(ChangeUtils.tProvincesDTOList==null){
			ChangeUtils.tProvincesDTOList = tProvincesDTOList;
		}
		for(TPatientDTO tPatientDTO : listTPatientDTO){
			proTPatientDTO(tPatientDTO);
			
		}
	}

	public static void proTPatientDTO(TPatientDTO tPatientDTO) {
		tPatientDTO.setState(ChangeUtils.getFormatValue(tPatientDTO.getState(), "0", "未通过"));
		tPatientDTO.setState(ChangeUtils.getFormatValue(tPatientDTO.getState(), "1", "已通过"));
		tPatientDTO.setSex(ChangeUtils.getFormatValue(tPatientDTO.getSex(), "0", "男"));
		tPatientDTO.setSex(ChangeUtils.getFormatValue(tPatientDTO.getSex(), "1", "女"));
		tPatientDTO.setApplyType(ChangeUtils.getFormatValue(tPatientDTO.getApplyType(), "0", "正常申请"));
		tPatientDTO.setApplyType(ChangeUtils.getFormatValue(tPatientDTO.getApplyType(), "1", "复申请"));
		tPatientDTO.setIsLangMuHospital(ChangeUtils.getFormatValue(tPatientDTO.getIsLangMuHospital(), "0", "是"));
		tPatientDTO.setIsLangMuHospital(ChangeUtils.getFormatValue(tPatientDTO.getIsLangMuHospital(), "1", "否"));
		tPatientDTO.setDiagnosticMaterial(ChangeUtils.getFormatValue(tPatientDTO.getDiagnosticMaterial(), "-999", "√"));
		tPatientDTO.setProofIdentity(ChangeUtils.getFormatValue(tPatientDTO.getProofIdentity(), "-999", "√"));
		tPatientDTO.setProofIncome(ChangeUtils.getFormatValue(tPatientDTO.getProofIncome(), "-999", "√"));
		tPatientDTO.setPurchaseInvoice(ChangeUtils.getFormatValue(tPatientDTO.getPurchaseInvoice(), "-999", "√"));
		tPatientDTO.setMedicalEvaluationForm(ChangeUtils.getFormatValue(tPatientDTO.getMedicalEvaluationForm(), "-999", "√"));
		tPatientDTO.setInformedConsentOfPatients(ChangeUtils.getFormatValue(tPatientDTO.getInformedConsentOfPatients(), "-999", "√"));
		tPatientDTO.setPatienteConomicStatus(ChangeUtils.getFormatValue(tPatientDTO.getPatienteConomicStatus(), "-999", "√"));
		tPatientDTO.setColdChainDrugInformedConsent(ChangeUtils.getFormatValue(tPatientDTO.getColdChainDrugInformedConsent(), "-999", "√"));
		tPatientDTO.setEstimatedTimeToIncreaseDrugInjection(ChangeUtils.getFormatValue(tPatientDTO.getEstimatedTimeToIncreaseDrugInjection(), "-999", "√"));
		tPatientDTO.setRecipientsReceiveSingleDrug(ChangeUtils.getFormatValue(tPatientDTO.getRecipientsReceiveSingleDrug(), "-999", "√"));
		tPatientDTO.setEndOfStatement(ChangeUtils.getFormatValue(tPatientDTO.getEndOfStatement(), "-999", "√"));
		tPatientDTO.setProvince(getProviceNameByCode(tPatientDTO.getProvince()));
		tPatientDTO.setDiagnosticMaterial(ChangeUtils.getFormatValue(tPatientDTO.getDiagnosticMaterial(), "", "无"));
		tPatientDTO.setProofIdentity(ChangeUtils.getFormatValue(tPatientDTO.getProofIdentity(), "", "无"));
		tPatientDTO.setProofIncome(ChangeUtils.getFormatValue(tPatientDTO.getProofIncome(), "", "无"));
		tPatientDTO.setPurchaseInvoice(ChangeUtils.getFormatValue(tPatientDTO.getPurchaseInvoice(), "", "无"));
		tPatientDTO.setMedicalEvaluationForm(ChangeUtils.getFormatValue(tPatientDTO.getMedicalEvaluationForm(), "", "无"));
		tPatientDTO.setInformedConsentOfPatients(ChangeUtils.getFormatValue(tPatientDTO.getInformedConsentOfPatients(), "", "无"));
		tPatientDTO.setPatienteConomicStatus(ChangeUtils.getFormatValue(tPatientDTO.getPatienteConomicStatus(), "", "无"));
		tPatientDTO.setColdChainDrugInformedConsent(ChangeUtils.getFormatValue(tPatientDTO.getColdChainDrugInformedConsent(), "", "无"));
		tPatientDTO.setEstimatedTimeToIncreaseDrugInjection(ChangeUtils.getFormatValue(tPatientDTO.getEstimatedTimeToIncreaseDrugInjection(), "", "无"));
		tPatientDTO.setRecipientsReceiveSingleDrug(ChangeUtils.getFormatValue(tPatientDTO.getRecipientsReceiveSingleDrug(), "", "无"));
		tPatientDTO.setEndOfStatement(ChangeUtils.getFormatValue(tPatientDTO.getEndOfStatement(), "", "无"));
	}
	
	public static void proTPatientReverse(TPatient tPatientDTO) {
		tPatientDTO.setState(ChangeUtils.getFormatValue(tPatientDTO.getState(), "未通过", "0"));
		tPatientDTO.setState(ChangeUtils.getFormatValue(tPatientDTO.getState(), "已通过", "1"));
		tPatientDTO.setSex(ChangeUtils.getFormatValue(tPatientDTO.getSex(), "男", "0"));
		tPatientDTO.setSex(ChangeUtils.getFormatValue(tPatientDTO.getSex(), "女", "1"));
		tPatientDTO.setApplyType(ChangeUtils.getFormatValue(tPatientDTO.getApplyType(), "正常申请", "0"));
		tPatientDTO.setApplyType(ChangeUtils.getFormatValue(tPatientDTO.getApplyType(), "复申请", "1"));
		tPatientDTO.setIsLangMuHospital(ChangeUtils.getFormatValue(tPatientDTO.getIsLangMuHospital(), "是", "0"));
		tPatientDTO.setIsLangMuHospital(ChangeUtils.getFormatValue(tPatientDTO.getIsLangMuHospital(), "否", "1"));
		tPatientDTO.setDiagnosticMaterial(ChangeUtils.getFormatValue(tPatientDTO.getDiagnosticMaterial(), "√", "-999"));
		tPatientDTO.setProofIdentity(ChangeUtils.getFormatValue(tPatientDTO.getProofIdentity(), "√", "-999"));
		tPatientDTO.setProofIncome(ChangeUtils.getFormatValue(tPatientDTO.getProofIncome(), "√", "-999"));
		tPatientDTO.setPurchaseInvoice(ChangeUtils.getFormatValue(tPatientDTO.getPurchaseInvoice(), "√", "-999"));
		tPatientDTO.setMedicalEvaluationForm(ChangeUtils.getFormatValue(tPatientDTO.getMedicalEvaluationForm(), "√", "-999"));
		tPatientDTO.setInformedConsentOfPatients(ChangeUtils.getFormatValue(tPatientDTO.getInformedConsentOfPatients(), "√", "-999"));
		tPatientDTO.setPatienteConomicStatus(ChangeUtils.getFormatValue(tPatientDTO.getPatienteConomicStatus(), "√", "-999"));
		tPatientDTO.setColdChainDrugInformedConsent(ChangeUtils.getFormatValue(tPatientDTO.getColdChainDrugInformedConsent(), "√", "-999"));
		tPatientDTO.setEstimatedTimeToIncreaseDrugInjection(ChangeUtils.getFormatValue(tPatientDTO.getEstimatedTimeToIncreaseDrugInjection(), "√", "-999"));
		tPatientDTO.setRecipientsReceiveSingleDrug(ChangeUtils.getFormatValue(tPatientDTO.getRecipientsReceiveSingleDrug(), "√", "-999"));
		tPatientDTO.setEndOfStatement(ChangeUtils.getFormatValue(tPatientDTO.getEndOfStatement(), "√", "-999"));
		tPatientDTO.setProvince(getProviceCodeByName(tPatientDTO.getProvince()));
	}
	
	public static void proTDoctorDTOList(List<TDoctorDTO> listTDoctorDTO,List<TProvincesDTO> tProvincesDTOList) {
		if(ChangeUtils.tProvincesDTOList==null){
			ChangeUtils.tProvincesDTOList = tProvincesDTOList;
		}
		for(TDoctorDTO tDoctorDTO : listTDoctorDTO){
			proTDoctorDTO(tDoctorDTO);
			
		}
	}
	
	public static void proTHospitalMappingDTOList(List<THospitalMappingDTO> listTHospitalMappingDTO,List<TProvincesDTO> tProvincesDTOList,List<TCitiesDTO> tCitiesDTOList) {
		if(ChangeUtils.tCitiesDTOList==null){
			ChangeUtils.tCitiesDTOList = tCitiesDTOList;
		}
		if(ChangeUtils.tProvincesDTOList==null){
			ChangeUtils.tProvincesDTOList = tProvincesDTOList;
		}
		for(THospitalMappingDTO tHospitalMappingDTO : listTHospitalMappingDTO){
			proTHospitalMappingDTO(tHospitalMappingDTO);
			
		}
	}
	
	public static void proTHospitalMappingDTO(THospitalMappingDTO tHospitalMappingDTO) {
		tHospitalMappingDTO.setProvince(getProviceNameByCode(tHospitalMappingDTO.getProvince()));
		tHospitalMappingDTO.setCity(getCityNameByCode(tHospitalMappingDTO.getCity()));
	}
	
	public static void proTHospitalMappingReverse(THospitalMapping tHospitalMapping) {
		tHospitalMapping.setProvince(getProviceNameByCode(tHospitalMapping.getProvince()));
		tHospitalMapping.setCity(getCityCodeByName(tHospitalMapping.getCity()));
	}
	
	public static void proTDoctorDTO(TDoctorDTO tDoctorDTO) {
		tDoctorDTO.setState(ChangeUtils.getFormatValue(tDoctorDTO.getState(), "0", "未通过"));
		tDoctorDTO.setState(ChangeUtils.getFormatValue(tDoctorDTO.getState(), "1", "已通过"));
		tDoctorDTO.setSex(ChangeUtils.getFormatValue(tDoctorDTO.getSex(), "0", "男"));
		tDoctorDTO.setSex(ChangeUtils.getFormatValue(tDoctorDTO.getSex(), "1", "女"));
		tDoctorDTO.setIdcardCopy(ChangeUtils.getFormatValue(tDoctorDTO.getIdcardCopy(), "-999", "√"));
		tDoctorDTO.setRegisterDoctorTable(ChangeUtils.getFormatValue(tDoctorDTO.getRegisterDoctorTable(), "-999", "√"));
		tDoctorDTO.setRegisterHospitalConsent(ChangeUtils.getFormatValue(tDoctorDTO.getRegisterHospitalConsent(), "-999", "√"));
		tDoctorDTO.setRegisterDoctorConsent(ChangeUtils.getFormatValue(tDoctorDTO.getRegisterDoctorConsent(), "-999", "√"));
		tDoctorDTO.setResume(ChangeUtils.getFormatValue(tDoctorDTO.getResume(), "-999", "√"));
		tDoctorDTO.setHospitalProfile(ChangeUtils.getFormatValue(tDoctorDTO.getHospitalProfile(), "-999", "√"));
		tDoctorDTO.setIsRegister(ChangeUtils.getFormatValue(tDoctorDTO.getIsRegister(), "0", "是"));
		tDoctorDTO.setIsRegister(ChangeUtils.getFormatValue(tDoctorDTO.getIsRegister(), "1", "否"));
		tDoctorDTO.setProvince(getProviceNameByCode(tDoctorDTO.getProvince()));
		tDoctorDTO.setIdcardCopy(ChangeUtils.getFormatValue(tDoctorDTO.getIdcardCopy(), "", "无"));
		tDoctorDTO.setRegisterDoctorTable(ChangeUtils.getFormatValue(tDoctorDTO.getRegisterDoctorTable(), "", "无"));
		tDoctorDTO.setRegisterHospitalConsent(ChangeUtils.getFormatValue(tDoctorDTO.getRegisterHospitalConsent(), "", "无"));
		tDoctorDTO.setRegisterDoctorConsent(ChangeUtils.getFormatValue(tDoctorDTO.getRegisterDoctorConsent(), "", "无"));
		tDoctorDTO.setResume(ChangeUtils.getFormatValue(tDoctorDTO.getResume(), "", "无"));
		tDoctorDTO.setHospitalProfile(ChangeUtils.getFormatValue(tDoctorDTO.getHospitalProfile(), "", "无"));
	}
	
	
	public static void proTHrDTOList(List<THrDTO> listTHrDTO) {
		for(THrDTO tHrDTO : listTHrDTO){
			proTHrDTO(tHrDTO);
		}
	}
	
	
	public static void proTHrDTO(THrDTO tHrDTO) {
		tHrDTO.setSex(ChangeUtils.getFormatValue(tHrDTO.getSex(), "0", "男"));
		tHrDTO.setSex(ChangeUtils.getFormatValue(tHrDTO.getSex(), "1", "女"));
		tHrDTO.setIdcardCopy(ChangeUtils.getFormatValue(tHrDTO.getIdcardCopy(), "-999", "√"));
		tHrDTO.setCompanyProfile(ChangeUtils.getFormatValue(tHrDTO.getCompanyProfile(), "-999", "√"));
		tHrDTO.setIsRegister(ChangeUtils.getFormatValue(tHrDTO.getIsRegister(), "0", "是"));
		tHrDTO.setIsRegister(ChangeUtils.getFormatValue(tHrDTO.getIsRegister(), "1", "否"));
		tHrDTO.setIdcardCopy(ChangeUtils.getFormatValue(tHrDTO.getIdcardCopy(), "", "无"));
		tHrDTO.setCompanyProfile(ChangeUtils.getFormatValue(tHrDTO.getCompanyProfile(), "", "无"));
	}
	
	public static void proTHrReverse(THr tHr) {
		tHr.setSex(ChangeUtils.getFormatValue(tHr.getSex(), "男", "0"));
		tHr.setSex(ChangeUtils.getFormatValue(tHr.getSex(), "女", "1"));
		tHr.setIdcardCopy(ChangeUtils.getFormatValue(tHr.getIdcardCopy(), "√", "-999"));
		tHr.setCompanyProfile(ChangeUtils.getFormatValue(tHr.getCompanyProfile(), "√", "-999"));
		tHr.setIsRegister(ChangeUtils.getFormatValue(tHr.getIsRegister(), "是", "0"));
		tHr.setIsRegister(ChangeUtils.getFormatValue(tHr.getIsRegister(), "否", "1"));
	}
	
	public static void proTDoctorReverse(TDoctor tDoctorDTO) {
		tDoctorDTO.setState(ChangeUtils.getFormatValue(tDoctorDTO.getState(), "未通过","0"));
		tDoctorDTO.setState(ChangeUtils.getFormatValue(tDoctorDTO.getState(), "已通过", "1"));
		tDoctorDTO.setSex(ChangeUtils.getFormatValue(tDoctorDTO.getSex(), "男", "0"));
		tDoctorDTO.setSex(ChangeUtils.getFormatValue(tDoctorDTO.getSex(), "女", "1"));
		tDoctorDTO.setIdcardCopy(ChangeUtils.getFormatValue(tDoctorDTO.getIdcardCopy(), "√", "-999"));
		tDoctorDTO.setRegisterDoctorTable(ChangeUtils.getFormatValue(tDoctorDTO.getRegisterDoctorTable(), "√", "-999"));
		tDoctorDTO.setRegisterHospitalConsent(ChangeUtils.getFormatValue(tDoctorDTO.getRegisterHospitalConsent(), "√", "-999"));
		tDoctorDTO.setRegisterDoctorConsent(ChangeUtils.getFormatValue(tDoctorDTO.getRegisterDoctorConsent(), "√", "-999"));
		tDoctorDTO.setResume(ChangeUtils.getFormatValue(tDoctorDTO.getResume(), "√", "-999"));
		tDoctorDTO.setHospitalProfile(ChangeUtils.getFormatValue(tDoctorDTO.getHospitalProfile(), "√", "-999"));
		tDoctorDTO.setIsRegister(ChangeUtils.getFormatValue(tDoctorDTO.getIsRegister(), "是", "0"));
		tDoctorDTO.setIsRegister(ChangeUtils.getFormatValue(tDoctorDTO.getIsRegister(), "否", "1"));
		tDoctorDTO.setProvince(getProviceCodeByName(tDoctorDTO.getProvince()));
	}
	
	/**
	 * 根据省份ID获取省份名字
	 * @param code
	 */
	public static String getProviceNameByCode(String code){
		if(provinceNameCacheMap==null){
			synchronized (ChangeUtils.class) {
				if(provinceNameCacheMap==null){
					try{
						provinceNameCacheMap = Maps.newHashMap();
						for(TProvincesDTO tProvincesDTO : tProvincesDTOList){
							provinceNameCacheMap.put(tProvincesDTO.getProvinceid(), tProvincesDTO.getProvince());
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		return provinceNameCacheMap.get(code);
	}
	
	/**
	 * 根据省份名字获取省份ID
	 * @param code
	 */
	public static String getProviceCodeByName(String name){
		if(provinceCodeCacheMap==null){
			synchronized (ChangeUtils.class) {
				if(provinceCodeCacheMap==null){
					try{
						provinceCodeCacheMap = Maps.newHashMap();
						for(TProvincesDTO tProvincesDTO : tProvincesDTOList){
							provinceCodeCacheMap.put(tProvincesDTO.getProvince(), tProvincesDTO.getProvinceid());
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		return provinceCodeCacheMap.get(name);
	}
	
	/**
	 * 根据城市ID获取城市名字
	 * @param code
	 */
	public static String getCityNameByCode(String code){
		if(cityCodeCacheMap==null){
			synchronized (ChangeUtils.class) {
				if(cityCodeCacheMap==null){
					try{
						cityCodeCacheMap = Maps.newHashMap();
						for(TCitiesDTO tCitiesDTO : tCitiesDTOList){
							cityCodeCacheMap.put(tCitiesDTO.getCityid(), tCitiesDTO.getCity());
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		return cityCodeCacheMap.get(code);
	}
	
	/**
	 * 根据城市名字获取城市ID
	 * @param code
	 */
	public static String getCityCodeByName(String name){
		if(cityNameCacheMap==null){
			synchronized (ChangeUtils.class) {
				if(cityNameCacheMap==null){
					try{
						cityNameCacheMap = Maps.newHashMap();
						for(TCitiesDTO tCitiesDTO : tCitiesDTOList){
							cityNameCacheMap.put(tCitiesDTO.getCity(), tCitiesDTO.getCityid());
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		return cityNameCacheMap.get(name);
	}
	

}
