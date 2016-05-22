/**
 * 
 */
package com.zhqq.funds.VO;

/**
 * @author dell
 *
 */
public class TPatientVO {
	
	private Integer appcode;
	
	private String appmsg;
	
	private Integer id;

    private String archives;

    private String state;

    private String name;

    private String sex;

    private String idcardnumber;

    private String phone;

    private String address;

    private String diagnosticMaterial;

    private String proofIdentity;

    private String proofIncome;

    private String purchaseInvoice;

    private String medicalEvaluationForm;

    private String informedConsentOfPatients;

    private String patienteConomicStatus;

    private String coldChainDrugInformedConsent;

    private String hr;

    private String langMuHospital;

    private String langMuDoctor;

    private String estimatedTimeToIncreaseDrugInjection;

    private String remarks;

    private String recipientsReceiveSingleDrug;

    private String endOfStatement;
    
    

    public Integer getAppcode() {
		return appcode;
	}

	public void setAppcode(Integer appcode) {
		this.appcode = appcode;
	}

	public String getAppmsg() {
		return appmsg;
	}

	public void setAppmsg(String appmsg) {
		this.appmsg = appmsg;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArchives() {
        return archives;
    }

    public void setArchives(String archives) {
        this.archives = archives == null ? null : archives.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdcardnumber() {
        return idcardnumber;
    }

    public void setIdcardnumber(String idcardnumber) {
        this.idcardnumber = idcardnumber == null ? null : idcardnumber.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDiagnosticMaterial() {
        return diagnosticMaterial;
    }

    public void setDiagnosticMaterial(String diagnosticMaterial) {
        this.diagnosticMaterial = diagnosticMaterial == null ? null : diagnosticMaterial.trim();
    }

    public String getProofIdentity() {
        return proofIdentity;
    }

    public void setProofIdentity(String proofIdentity) {
        this.proofIdentity = proofIdentity == null ? null : proofIdentity.trim();
    }

    public String getProofIncome() {
        return proofIncome;
    }

    public void setProofIncome(String proofIncome) {
        this.proofIncome = proofIncome == null ? null : proofIncome.trim();
    }

    public String getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public void setPurchaseInvoice(String purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice == null ? null : purchaseInvoice.trim();
    }

    public String getMedicalEvaluationForm() {
        return medicalEvaluationForm;
    }

    public void setMedicalEvaluationForm(String medicalEvaluationForm) {
        this.medicalEvaluationForm = medicalEvaluationForm == null ? null : medicalEvaluationForm.trim();
    }

    public String getInformedConsentOfPatients() {
        return informedConsentOfPatients;
    }

    public void setInformedConsentOfPatients(String informedConsentOfPatients) {
        this.informedConsentOfPatients = informedConsentOfPatients == null ? null : informedConsentOfPatients.trim();
    }

    public String getPatienteConomicStatus() {
        return patienteConomicStatus;
    }

    public void setPatienteConomicStatus(String patienteConomicStatus) {
        this.patienteConomicStatus = patienteConomicStatus == null ? null : patienteConomicStatus.trim();
    }

    public String getColdChainDrugInformedConsent() {
        return coldChainDrugInformedConsent;
    }

    public void setColdChainDrugInformedConsent(String coldChainDrugInformedConsent) {
        this.coldChainDrugInformedConsent = coldChainDrugInformedConsent == null ? null : coldChainDrugInformedConsent.trim();
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr == null ? null : hr.trim();
    }

    public String getLangMuHospital() {
        return langMuHospital;
    }

    public void setLangMuHospital(String langMuHospital) {
        this.langMuHospital = langMuHospital == null ? null : langMuHospital.trim();
    }

    public String getLangMuDoctor() {
        return langMuDoctor;
    }

    public void setLangMuDoctor(String langMuDoctor) {
        this.langMuDoctor = langMuDoctor == null ? null : langMuDoctor.trim();
    }

    public String getEstimatedTimeToIncreaseDrugInjection() {
        return estimatedTimeToIncreaseDrugInjection;
    }

    public void setEstimatedTimeToIncreaseDrugInjection(String estimatedTimeToIncreaseDrugInjection) {
        this.estimatedTimeToIncreaseDrugInjection = estimatedTimeToIncreaseDrugInjection == null ? null : estimatedTimeToIncreaseDrugInjection.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getRecipientsReceiveSingleDrug() {
        return recipientsReceiveSingleDrug;
    }

    public void setRecipientsReceiveSingleDrug(String recipientsReceiveSingleDrug) {
        this.recipientsReceiveSingleDrug = recipientsReceiveSingleDrug == null ? null : recipientsReceiveSingleDrug.trim();
    }

    public String getEndOfStatement() {
        return endOfStatement;
    }

    public void setEndOfStatement(String endOfStatement) {
        this.endOfStatement = endOfStatement == null ? null : endOfStatement.trim();
    }
}
