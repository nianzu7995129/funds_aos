/**
 * 
 */
package com.zhqq.funds.utils;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.zhqq.funds.DTO.TPatientDTO;

/**
 * @author dell
 *
 */
public final class PatientUtils {
	
	public static String getFormatValue(String src,String format,String target){
		String rlt = src;
		if(!StringUtils.isEmpty(rlt)){
			if(rlt.equals(format)){
				rlt = target;
			}
		}
		return rlt;
	}
	
	/**
	 * @param listTPatientDTO
	 */
	public static void proTPatientDTO(List<TPatientDTO> listTPatientDTO) {
		for(TPatientDTO tPatientDTO : listTPatientDTO){
			tPatientDTO.setState(PatientUtils.getFormatValue(tPatientDTO.getState(), "0", "未通过"));
			tPatientDTO.setState(PatientUtils.getFormatValue(tPatientDTO.getState(), "1", "已通过"));
			tPatientDTO.setSex(PatientUtils.getFormatValue(tPatientDTO.getSex(), "0", "男"));
			tPatientDTO.setSex(PatientUtils.getFormatValue(tPatientDTO.getSex(), "1", "女"));
			tPatientDTO.setDiagnosticMaterial(PatientUtils.getFormatValue(tPatientDTO.getDiagnosticMaterial(), "-999", "√"));
			tPatientDTO.setProofIdentity(PatientUtils.getFormatValue(tPatientDTO.getProofIdentity(), "-999", "√"));
			tPatientDTO.setProofIncome(PatientUtils.getFormatValue(tPatientDTO.getProofIncome(), "-999", "√"));
			tPatientDTO.setPurchaseInvoice(PatientUtils.getFormatValue(tPatientDTO.getPurchaseInvoice(), "-999", "√"));
			tPatientDTO.setMedicalEvaluationForm(PatientUtils.getFormatValue(tPatientDTO.getMedicalEvaluationForm(), "-999", "√"));
			tPatientDTO.setInformedConsentOfPatients(PatientUtils.getFormatValue(tPatientDTO.getInformedConsentOfPatients(), "-999", "√"));
			tPatientDTO.setPatienteConomicStatus(PatientUtils.getFormatValue(tPatientDTO.getPatienteConomicStatus(), "-999", "√"));
			tPatientDTO.setColdChainDrugInformedConsent(PatientUtils.getFormatValue(tPatientDTO.getColdChainDrugInformedConsent(), "-999", "√"));
			tPatientDTO.setEstimatedTimeToIncreaseDrugInjection(PatientUtils.getFormatValue(tPatientDTO.getEstimatedTimeToIncreaseDrugInjection(), "-999", "√"));
			tPatientDTO.setRecipientsReceiveSingleDrug(PatientUtils.getFormatValue(tPatientDTO.getRecipientsReceiveSingleDrug(), "-999", "√"));
			tPatientDTO.setEndOfStatement(PatientUtils.getFormatValue(tPatientDTO.getEndOfStatement(), "-999", "√"));
			
		}
	}

}
