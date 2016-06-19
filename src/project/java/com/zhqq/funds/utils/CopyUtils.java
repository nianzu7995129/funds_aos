/**
 * 
 */
package com.zhqq.funds.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhqq.funds.DTO.TDrugreleaseDTO;
import com.zhqq.funds.DTO.TPatientDTO;
import com.zhqq.funds.VO.TDrugreleaseVO;
import com.zhqq.funds.VO.TPatientVO;
import com.zhqq.funds.po.TDrugrelease;
import com.zhqq.funds.po.TPatient;

/**
 * @author dell
 *
 */
public final class CopyUtils {
	
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
		rlt.setIdcardnumber(tPatient.getIdcardnumber());
		rlt.setPhone(tPatient.getPhone());
		rlt.setAddress(tPatient.getAddress());
		rlt.setDiagnosticMaterial(tPatient.getDiagnosticMaterial());
		rlt.setProofIdentity(tPatient.getProofIdentity());
		rlt.setProofIncome(tPatient.getProofIncome());
		rlt.setPurchaseInvoice(tPatient.getPurchaseInvoice());
		rlt.setMedicalEvaluationForm(tPatient.getMedicalEvaluationForm());
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
		rlt.setOther1(tPatient.getOther1());
		rlt.setOther2(tPatient.getOther2());
		rlt.setOther3(tPatient.getOther3());
		rlt.setOther4(tPatient.getOther4());
		rlt.setOther5(tPatient.getOther5());
		return rlt;
	}
	
	public static TPatientDTO copyPOToDTO(TPatient tPatient){
		TPatientDTO rlt = new TPatientDTO();
		rlt.setId(tPatient.getId());
		rlt.setArchives(tPatient.getArchives());
		rlt.setState(tPatient.getState());
		rlt.setName(tPatient.getName());
		rlt.setSex(tPatient.getSex());
		rlt.setIdcardnumber(tPatient.getIdcardnumber());
		rlt.setPhone(tPatient.getPhone());
		rlt.setAddress(tPatient.getAddress());
		rlt.setDiagnosticMaterial(tPatient.getDiagnosticMaterial());
		rlt.setProofIdentity(tPatient.getProofIdentity());
		rlt.setProofIncome(tPatient.getProofIncome());
		rlt.setPurchaseInvoice(tPatient.getPurchaseInvoice());
		rlt.setMedicalEvaluationForm(tPatient.getMedicalEvaluationForm());
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
		rlt.setOther1(tPatient.getOther1());
		rlt.setOther2(tPatient.getOther2());
		rlt.setOther3(tPatient.getOther3());
		rlt.setOther4(tPatient.getOther4());
		rlt.setOther5(tPatient.getOther5());
		return rlt;
	}
	
	public static TPatientVO copyDTOToVO(TPatientDTO tPatient){
		TPatientVO rlt = new TPatientVO();
		rlt.setId(tPatient.getId());
		rlt.setArchives(tPatient.getArchives());
		rlt.setState(tPatient.getState());
		rlt.setName(tPatient.getName());
		rlt.setSex(tPatient.getSex());
		rlt.setIdcardnumber(tPatient.getIdcardnumber());
		rlt.setPhone(tPatient.getPhone());
		rlt.setAddress(tPatient.getAddress());
		rlt.setDiagnosticMaterial(tPatient.getDiagnosticMaterial());
		rlt.setProofIdentity(tPatient.getProofIdentity());
		rlt.setProofIncome(tPatient.getProofIncome());
		rlt.setPurchaseInvoice(tPatient.getPurchaseInvoice());
		rlt.setMedicalEvaluationForm(tPatient.getMedicalEvaluationForm());
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
		rlt.setOther1(tPatient.getOther1());
		rlt.setOther2(tPatient.getOther2());
		rlt.setOther3(tPatient.getOther3());
		rlt.setOther4(tPatient.getOther4());
		rlt.setOther5(tPatient.getOther5());
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
