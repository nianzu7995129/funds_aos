/**
 * 
 */
package com.zhqq.funds.utils;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.zhqq.funds.DTO.TCitiesDTO;
import com.zhqq.funds.DTO.TDrugreleaseDTO;
import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.DTO.TProvincesDTO;
import com.zhqq.funds.VO.TCitiesVO;
import com.zhqq.funds.VO.TDrugreleaseVO;
import com.zhqq.funds.VO.TPatientVO;
import com.zhqq.funds.VO.TProvincesVO;
import com.zhqq.funds.po.TDrugrelease;
import com.zhqq.funds.po.TPatient;
import com.zhqq.funds.po.TProvinces;

/**
 * @author dell
 *
 */
public final class CopyUtils {
	
	
	/**
	 * 按照目标类名创建对象，并拷贝原对象属性
	 * 如果原对象为空，则将目标对象也置为空
	 * @param source 原对象
	 * @param targetClass 目标类名
	 */
	public static <T1 ,T2> T2 createCopy(T1 source,  Class<T2> targetClass){
		
		if(source==null){
			return null;
		}else{
			T2 target;
			try {
				target = targetClass.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
				return null;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
			BeanUtils.copyProperties(source, target);
			return target;
		}
		
	}
	
	/**
	 * 按照目标类名创建List，并拷贝原List中对象属性
	 * 如果原List为空，则返回为空
	 * @param sourceList 原对象List
	 * @param targetClass 目标类名
	 */
	public static <T1 ,T2> List<T2> createCopyList(List<T1> sourceList, Class<T2> targetClass){
		if(sourceList==null){
			return null;
		}else if(sourceList.size()==0){
			return new ArrayList<T2>();
		}else{
			List<T2> targetList=new ArrayList<T2>();
			for(Object source:sourceList){
				T2 target = (T2)createCopy(source,targetClass);
				targetList.add(target);
			}
			return targetList;
		}
	}
	
	public static TDrugrelease copyDTOToPO(TDrugreleaseDTO tDrugreleaseDTO){
		TDrugrelease rlt = new TDrugrelease();
		rlt.setId(tDrugreleaseDTO.getId());
		rlt.setPatientCode(tDrugreleaseDTO.getPatientCode());
		rlt.setName(tDrugreleaseDTO.getName());
		rlt.setSex(tDrugreleaseDTO.getSex());
		rlt.setIdcardnumber(tDrugreleaseDTO.getIdcardnumber());
		rlt.setPhone(tDrugreleaseDTO.getPhone());
		rlt.setTakenDrugNumber(tDrugreleaseDTO.getTakenDrugNumber());
		rlt.setCurrentDose(tDrugreleaseDTO.getCurrentDose());
		rlt.setExpectedNexttime(tDrugreleaseDTO.getExpectedNexttime());
		rlt.setHospitalGroup(tDrugreleaseDTO.getHospitalGroup());
		rlt.setFormalEntryTime(tDrugreleaseDTO.getFormalEntryTime());
		rlt.setDisease(tDrugreleaseDTO.getDisease());
		rlt.setState(tDrugreleaseDTO.getState());
		return rlt;
	}
	
	public static TPatient copyDTOToPO(TPatientDTO tPatient){
		TPatient rlt = new TPatient();
		rlt.setId(tPatient.getId());
		rlt.setArchives(tPatient.getArchives());
		rlt.setState(tPatient.getState());
		rlt.setName(tPatient.getName());
		rlt.setSex(tPatient.getSex());
		rlt.setProvince(tPatient.getProvince());
		rlt.setApplyType(tPatient.getApplyType());
		rlt.setIdcardnumber(tPatient.getIdcardnumber());
		rlt.setPhone(tPatient.getPhone());
		rlt.setAddress(tPatient.getAddress());
		rlt.setDiagnosticMaterial(tPatient.getDiagnosticMaterial());
		rlt.setProofIdentity(tPatient.getProofIdentity());
		rlt.setProofIncome(tPatient.getProofIncome());
		rlt.setPurchaseInvoice(tPatient.getPurchaseInvoice());
		rlt.setMedicalEvaluationForm(tPatient.getMedicalEvaluationForm());
		rlt.setInformedConsentOfPatients(tPatient.getInformedConsentOfPatients());
		rlt.setPatienteConomicStatus(tPatient.getPatienteConomicStatus());
		rlt.setColdChainDrugInformedConsent(tPatient.getColdChainDrugInformedConsent());
		rlt.setHr(tPatient.getHr());
		rlt.setLangMuHospital(tPatient.getLangMuHospital());
		rlt.setLangMuDoctor(tPatient.getLangMuDoctor());
		rlt.setEstimatedTimeToIncreaseDrugInjection(tPatient.getEstimatedTimeToIncreaseDrugInjection());
		rlt.setRemarks(tPatient.getRemarks());
		rlt.setRecipientsReceiveSingleDrug(tPatient.getRecipientsReceiveSingleDrug());
		rlt.setEndOfStatement(tPatient.getEndOfStatement());
		rlt.setPassdate(tPatient.getPassdate());
		rlt.setIsLangMuHospital(tPatient.getIsLangMuHospital());
		rlt.setYear(tPatient.getYear());
		return rlt;
	}
	
	public static TPatientDTO copyPOToDTO(TPatient tPatient){
		TPatientDTO rlt = new TPatientDTO();
		rlt.setId(tPatient.getId());
		rlt.setArchives(tPatient.getArchives());
		rlt.setState(tPatient.getState());
		rlt.setName(tPatient.getName());
		rlt.setSex(tPatient.getSex());
		rlt.setProvince(tPatient.getProvince());
		rlt.setApplyType(tPatient.getApplyType());
		rlt.setIdcardnumber(tPatient.getIdcardnumber());
		rlt.setPhone(tPatient.getPhone());
		rlt.setAddress(tPatient.getAddress());
		rlt.setDiagnosticMaterial(tPatient.getDiagnosticMaterial());
		rlt.setProofIdentity(tPatient.getProofIdentity());
		rlt.setProofIncome(tPatient.getProofIncome());
		rlt.setPurchaseInvoice(tPatient.getPurchaseInvoice());
		rlt.setMedicalEvaluationForm(tPatient.getMedicalEvaluationForm());
		rlt.setInformedConsentOfPatients(tPatient.getInformedConsentOfPatients());
		rlt.setPatienteConomicStatus(tPatient.getPatienteConomicStatus());
		rlt.setColdChainDrugInformedConsent(tPatient.getColdChainDrugInformedConsent());
		rlt.setHr(tPatient.getHr());
		rlt.setLangMuHospital(tPatient.getLangMuHospital());
		rlt.setLangMuDoctor(tPatient.getLangMuDoctor());
		rlt.setEstimatedTimeToIncreaseDrugInjection(tPatient.getEstimatedTimeToIncreaseDrugInjection());
		rlt.setRemarks(tPatient.getRemarks());
		rlt.setRecipientsReceiveSingleDrug(tPatient.getRecipientsReceiveSingleDrug());
		rlt.setEndOfStatement(tPatient.getEndOfStatement());
		rlt.setPassdate(tPatient.getPassdate());
		rlt.setIsLangMuHospital(tPatient.getIsLangMuHospital());
		rlt.setYear(tPatient.getYear());
		return rlt;
	}
	
	public static TProvincesDTO copyPOToDTO(TProvinces tProvinces){
		TProvincesDTO rlt = new TProvincesDTO();
		rlt.setId(tProvinces.getId());
		rlt.setProvinceid(tProvinces.getProvinceid());
		rlt.setProvince(tProvinces.getProvince());
		return rlt;
	}
	
	public static TPatientVO copyDTOToVO(TPatientDTO tPatient){
		TPatientVO rlt = new TPatientVO();
		rlt.setId(tPatient.getId());
		rlt.setArchives(tPatient.getArchives());
		rlt.setState(tPatient.getState());
		rlt.setName(tPatient.getName());
		rlt.setSex(tPatient.getSex());
		rlt.setProvince(tPatient.getProvince());
		rlt.setApplyType(tPatient.getApplyType());
		rlt.setIdcardnumber(tPatient.getIdcardnumber());
		rlt.setPhone(tPatient.getPhone());
		rlt.setAddress(tPatient.getAddress());
		rlt.setDiagnosticMaterial(tPatient.getDiagnosticMaterial());
		rlt.setProofIdentity(tPatient.getProofIdentity());
		rlt.setProofIncome(tPatient.getProofIncome());
		rlt.setPurchaseInvoice(tPatient.getPurchaseInvoice());
		rlt.setMedicalEvaluationForm(tPatient.getMedicalEvaluationForm());
		rlt.setInformedConsentOfPatients(tPatient.getInformedConsentOfPatients());
		rlt.setPatienteConomicStatus(tPatient.getPatienteConomicStatus());
		rlt.setColdChainDrugInformedConsent(tPatient.getColdChainDrugInformedConsent());
		rlt.setHr(tPatient.getHr());
		rlt.setLangMuHospital(tPatient.getLangMuHospital());
		rlt.setLangMuDoctor(tPatient.getLangMuDoctor());
		rlt.setEstimatedTimeToIncreaseDrugInjection(tPatient.getEstimatedTimeToIncreaseDrugInjection());
		rlt.setRemarks(tPatient.getRemarks());
		rlt.setRecipientsReceiveSingleDrug(tPatient.getRecipientsReceiveSingleDrug());
		rlt.setEndOfStatement(tPatient.getEndOfStatement());
		rlt.setPassdate(tPatient.getPassdate());
		rlt.setIsLangMuHospital(tPatient.getIsLangMuHospital());
		rlt.setYear(tPatient.getYear());
		return rlt;
	}
	
	public static TProvincesVO copyDTOToVO(TProvincesDTO tProvincesDTO){
		TProvincesVO rlt = new TProvincesVO();
		rlt.setDisplay(tProvincesDTO.getProvince());
		rlt.setValue(tProvincesDTO.getProvinceid());
		return rlt;
	}
	
	public static TCitiesVO copyDTOToVO(TCitiesDTO tCitiesDTO){
		TCitiesVO rlt = new TCitiesVO();
		rlt.setDisplay(tCitiesDTO.getCity());
		rlt.setValue(tCitiesDTO.getCityid());
		return rlt;
	}
	
	
	
	public static TDrugreleaseDTO copyPOToDTO(TDrugrelease tDrugrelease){
		TDrugreleaseDTO rlt = new TDrugreleaseDTO();
		rlt.setId(tDrugrelease.getId());
		rlt.setPatientCode(tDrugrelease.getPatientCode());
		rlt.setName(tDrugrelease.getName());
		rlt.setSex(tDrugrelease.getSex());
		rlt.setIdcardnumber(tDrugrelease.getIdcardnumber());
		rlt.setPhone(tDrugrelease.getPhone());
		rlt.setTakenDrugNumber(tDrugrelease.getTakenDrugNumber());
		rlt.setCurrentDose(tDrugrelease.getCurrentDose());
		rlt.setExpectedNexttime(tDrugrelease.getExpectedNexttime());
		rlt.setHospitalGroup(tDrugrelease.getHospitalGroup());
		rlt.setFormalEntryTime(tDrugrelease.getFormalEntryTime());
		rlt.setDisease(tDrugrelease.getDisease());
		rlt.setState(tDrugrelease.getState());
		return rlt;
	}
	
	public static TDrugreleaseVO copyDTOToVO(TDrugreleaseDTO tDrugrelease){
		TDrugreleaseVO rlt = new TDrugreleaseVO();
		rlt.setId(tDrugrelease.getId());
		rlt.setPatientCode(tDrugrelease.getPatientCode());
		rlt.setName(tDrugrelease.getName());
		rlt.setSex(tDrugrelease.getSex());
		rlt.setIdcardnumber(tDrugrelease.getIdcardnumber());
		rlt.setPhone(tDrugrelease.getPhone());
		rlt.setTakenDrugNumber(tDrugrelease.getTakenDrugNumber());
		rlt.setCurrentDose(tDrugrelease.getCurrentDose());
		rlt.setExpectedNexttime(tDrugrelease.getExpectedNexttime());
		rlt.setHospitalGroup(tDrugrelease.getHospitalGroup());
		rlt.setFormalEntryTime(tDrugrelease.getFormalEntryTime());
		rlt.setDisease(tDrugrelease.getDisease());
		rlt.setState(tDrugrelease.getState());
		return rlt;
	}
	
	
	public static String getFormatDateString(Date date){
	       String rlt = "";
	       if(date!=null){
	    	   try{
	    		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	        	   rlt = sdf.format(date);
	    	   }catch(Exception exception){
	    		   
	    	   }
	       }
	       return rlt;
	    }

}
