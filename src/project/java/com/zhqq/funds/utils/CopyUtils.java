/**
 * 
 */
package com.zhqq.funds.utils;


import com.zhqq.funds.DTO.TDrugreleaseDTO;
import com.zhqq.funds.VO.TDrugreleaseVO;
import com.zhqq.funds.po.TDrugrelease;

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

}
