package com.zhqq.funds.po;

public class TDrugrelease {
    private Integer id;

    private String patientCode;

    private String name;

    private String sex;

    private String idcardnumber;

    private String phone;

    private String takenDrugNumber;

    private String currentDose;

    private String expectedNexttime;

    private String hospitalGroup;

    private String formalEntryTime;

    private String disease;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode == null ? null : patientCode.trim();
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

    public String getTakenDrugNumber() {
        return takenDrugNumber;
    }

    public void setTakenDrugNumber(String takenDrugNumber) {
        this.takenDrugNumber = takenDrugNumber == null ? null : takenDrugNumber.trim();
    }

    public String getCurrentDose() {
        return currentDose;
    }

    public void setCurrentDose(String currentDose) {
        this.currentDose = currentDose == null ? null : currentDose.trim();
    }

    public String getExpectedNexttime() {
        return expectedNexttime;
    }

    public void setExpectedNexttime(String expectedNexttime) {
        this.expectedNexttime = expectedNexttime == null ? null : expectedNexttime.trim();
    }

    public String getHospitalGroup() {
        return hospitalGroup;
    }

    public void setHospitalGroup(String hospitalGroup) {
        this.hospitalGroup = hospitalGroup == null ? null : hospitalGroup.trim();
    }

    public String getFormalEntryTime() {
        return formalEntryTime;
    }

    public void setFormalEntryTime(String formalEntryTime) {
        this.formalEntryTime = formalEntryTime == null ? null : formalEntryTime.trim();
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease == null ? null : disease.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}