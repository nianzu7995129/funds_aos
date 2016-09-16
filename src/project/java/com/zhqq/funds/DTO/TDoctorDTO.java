package com.zhqq.funds.DTO;

public class TDoctorDTO {
    private Long id;

    private String state;

    private String province;

    private String name;

    private String sex;

    private String hospital;

    private String idcardCopy;

    private String registerDoctorTable;

    private String registerHospitalConsent;

    private String registerDoctorConsent;

    private String resume;

    private String hospitalProfile;

    private String phone;

    private String isRegister;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
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

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getIdcardCopy() {
        return idcardCopy;
    }

    public void setIdcardCopy(String idcardCopy) {
        this.idcardCopy = idcardCopy == null ? null : idcardCopy.trim();
    }

    public String getRegisterDoctorTable() {
        return registerDoctorTable;
    }

    public void setRegisterDoctorTable(String registerDoctorTable) {
        this.registerDoctorTable = registerDoctorTable == null ? null : registerDoctorTable.trim();
    }

    public String getRegisterHospitalConsent() {
        return registerHospitalConsent;
    }

    public void setRegisterHospitalConsent(String registerHospitalConsent) {
        this.registerHospitalConsent = registerHospitalConsent == null ? null : registerHospitalConsent.trim();
    }

    public String getRegisterDoctorConsent() {
        return registerDoctorConsent;
    }

    public void setRegisterDoctorConsent(String registerDoctorConsent) {
        this.registerDoctorConsent = registerDoctorConsent == null ? null : registerDoctorConsent.trim();
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
    }

    public String getHospitalProfile() {
        return hospitalProfile;
    }

    public void setHospitalProfile(String hospitalProfile) {
        this.hospitalProfile = hospitalProfile == null ? null : hospitalProfile.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIsRegister() {
        return isRegister;
    }

    public void setIsRegister(String isRegister) {
        this.isRegister = isRegister == null ? null : isRegister.trim();
    }
}