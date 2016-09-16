package com.zhqq.funds.po;

import java.util.ArrayList;
import java.util.List;

public class TDoctorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TDoctorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNull() {
            addCriterion("hospital is null");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNotNull() {
            addCriterion("hospital is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalEqualTo(String value) {
            addCriterion("hospital =", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotEqualTo(String value) {
            addCriterion("hospital <>", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThan(String value) {
            addCriterion("hospital >", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThanOrEqualTo(String value) {
            addCriterion("hospital >=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThan(String value) {
            addCriterion("hospital <", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThanOrEqualTo(String value) {
            addCriterion("hospital <=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLike(String value) {
            addCriterion("hospital like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotLike(String value) {
            addCriterion("hospital not like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalIn(List<String> values) {
            addCriterion("hospital in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotIn(List<String> values) {
            addCriterion("hospital not in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalBetween(String value1, String value2) {
            addCriterion("hospital between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotBetween(String value1, String value2) {
            addCriterion("hospital not between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyIsNull() {
            addCriterion("idcard_copy is null");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyIsNotNull() {
            addCriterion("idcard_copy is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyEqualTo(String value) {
            addCriterion("idcard_copy =", value, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyNotEqualTo(String value) {
            addCriterion("idcard_copy <>", value, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyGreaterThan(String value) {
            addCriterion("idcard_copy >", value, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_copy >=", value, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyLessThan(String value) {
            addCriterion("idcard_copy <", value, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyLessThanOrEqualTo(String value) {
            addCriterion("idcard_copy <=", value, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyLike(String value) {
            addCriterion("idcard_copy like", value, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyNotLike(String value) {
            addCriterion("idcard_copy not like", value, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyIn(List<String> values) {
            addCriterion("idcard_copy in", values, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyNotIn(List<String> values) {
            addCriterion("idcard_copy not in", values, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyBetween(String value1, String value2) {
            addCriterion("idcard_copy between", value1, value2, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andIdcardCopyNotBetween(String value1, String value2) {
            addCriterion("idcard_copy not between", value1, value2, "idcardCopy");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableIsNull() {
            addCriterion("register_doctor_table is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableIsNotNull() {
            addCriterion("register_doctor_table is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableEqualTo(String value) {
            addCriterion("register_doctor_table =", value, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableNotEqualTo(String value) {
            addCriterion("register_doctor_table <>", value, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableGreaterThan(String value) {
            addCriterion("register_doctor_table >", value, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableGreaterThanOrEqualTo(String value) {
            addCriterion("register_doctor_table >=", value, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableLessThan(String value) {
            addCriterion("register_doctor_table <", value, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableLessThanOrEqualTo(String value) {
            addCriterion("register_doctor_table <=", value, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableLike(String value) {
            addCriterion("register_doctor_table like", value, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableNotLike(String value) {
            addCriterion("register_doctor_table not like", value, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableIn(List<String> values) {
            addCriterion("register_doctor_table in", values, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableNotIn(List<String> values) {
            addCriterion("register_doctor_table not in", values, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableBetween(String value1, String value2) {
            addCriterion("register_doctor_table between", value1, value2, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorTableNotBetween(String value1, String value2) {
            addCriterion("register_doctor_table not between", value1, value2, "registerDoctorTable");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentIsNull() {
            addCriterion("register_hospital_consent is null");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentIsNotNull() {
            addCriterion("register_hospital_consent is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentEqualTo(String value) {
            addCriterion("register_hospital_consent =", value, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentNotEqualTo(String value) {
            addCriterion("register_hospital_consent <>", value, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentGreaterThan(String value) {
            addCriterion("register_hospital_consent >", value, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentGreaterThanOrEqualTo(String value) {
            addCriterion("register_hospital_consent >=", value, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentLessThan(String value) {
            addCriterion("register_hospital_consent <", value, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentLessThanOrEqualTo(String value) {
            addCriterion("register_hospital_consent <=", value, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentLike(String value) {
            addCriterion("register_hospital_consent like", value, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentNotLike(String value) {
            addCriterion("register_hospital_consent not like", value, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentIn(List<String> values) {
            addCriterion("register_hospital_consent in", values, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentNotIn(List<String> values) {
            addCriterion("register_hospital_consent not in", values, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentBetween(String value1, String value2) {
            addCriterion("register_hospital_consent between", value1, value2, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterHospitalConsentNotBetween(String value1, String value2) {
            addCriterion("register_hospital_consent not between", value1, value2, "registerHospitalConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentIsNull() {
            addCriterion("register_doctor_consent is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentIsNotNull() {
            addCriterion("register_doctor_consent is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentEqualTo(String value) {
            addCriterion("register_doctor_consent =", value, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentNotEqualTo(String value) {
            addCriterion("register_doctor_consent <>", value, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentGreaterThan(String value) {
            addCriterion("register_doctor_consent >", value, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentGreaterThanOrEqualTo(String value) {
            addCriterion("register_doctor_consent >=", value, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentLessThan(String value) {
            addCriterion("register_doctor_consent <", value, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentLessThanOrEqualTo(String value) {
            addCriterion("register_doctor_consent <=", value, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentLike(String value) {
            addCriterion("register_doctor_consent like", value, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentNotLike(String value) {
            addCriterion("register_doctor_consent not like", value, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentIn(List<String> values) {
            addCriterion("register_doctor_consent in", values, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentNotIn(List<String> values) {
            addCriterion("register_doctor_consent not in", values, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentBetween(String value1, String value2) {
            addCriterion("register_doctor_consent between", value1, value2, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andRegisterDoctorConsentNotBetween(String value1, String value2) {
            addCriterion("register_doctor_consent not between", value1, value2, "registerDoctorConsent");
            return (Criteria) this;
        }

        public Criteria andResumeIsNull() {
            addCriterion("resume is null");
            return (Criteria) this;
        }

        public Criteria andResumeIsNotNull() {
            addCriterion("resume is not null");
            return (Criteria) this;
        }

        public Criteria andResumeEqualTo(String value) {
            addCriterion("resume =", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotEqualTo(String value) {
            addCriterion("resume <>", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeGreaterThan(String value) {
            addCriterion("resume >", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeGreaterThanOrEqualTo(String value) {
            addCriterion("resume >=", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLessThan(String value) {
            addCriterion("resume <", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLessThanOrEqualTo(String value) {
            addCriterion("resume <=", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLike(String value) {
            addCriterion("resume like", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotLike(String value) {
            addCriterion("resume not like", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeIn(List<String> values) {
            addCriterion("resume in", values, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotIn(List<String> values) {
            addCriterion("resume not in", values, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeBetween(String value1, String value2) {
            addCriterion("resume between", value1, value2, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotBetween(String value1, String value2) {
            addCriterion("resume not between", value1, value2, "resume");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileIsNull() {
            addCriterion("hospital_profile is null");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileIsNotNull() {
            addCriterion("hospital_profile is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileEqualTo(String value) {
            addCriterion("hospital_profile =", value, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileNotEqualTo(String value) {
            addCriterion("hospital_profile <>", value, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileGreaterThan(String value) {
            addCriterion("hospital_profile >", value, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileGreaterThanOrEqualTo(String value) {
            addCriterion("hospital_profile >=", value, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileLessThan(String value) {
            addCriterion("hospital_profile <", value, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileLessThanOrEqualTo(String value) {
            addCriterion("hospital_profile <=", value, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileLike(String value) {
            addCriterion("hospital_profile like", value, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileNotLike(String value) {
            addCriterion("hospital_profile not like", value, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileIn(List<String> values) {
            addCriterion("hospital_profile in", values, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileNotIn(List<String> values) {
            addCriterion("hospital_profile not in", values, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileBetween(String value1, String value2) {
            addCriterion("hospital_profile between", value1, value2, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andHospitalProfileNotBetween(String value1, String value2) {
            addCriterion("hospital_profile not between", value1, value2, "hospitalProfile");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andIsRegisterIsNull() {
            addCriterion("is_register is null");
            return (Criteria) this;
        }

        public Criteria andIsRegisterIsNotNull() {
            addCriterion("is_register is not null");
            return (Criteria) this;
        }

        public Criteria andIsRegisterEqualTo(String value) {
            addCriterion("is_register =", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotEqualTo(String value) {
            addCriterion("is_register <>", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterGreaterThan(String value) {
            addCriterion("is_register >", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterGreaterThanOrEqualTo(String value) {
            addCriterion("is_register >=", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterLessThan(String value) {
            addCriterion("is_register <", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterLessThanOrEqualTo(String value) {
            addCriterion("is_register <=", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterLike(String value) {
            addCriterion("is_register like", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotLike(String value) {
            addCriterion("is_register not like", value, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterIn(List<String> values) {
            addCriterion("is_register in", values, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotIn(List<String> values) {
            addCriterion("is_register not in", values, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterBetween(String value1, String value2) {
            addCriterion("is_register between", value1, value2, "isRegister");
            return (Criteria) this;
        }

        public Criteria andIsRegisterNotBetween(String value1, String value2) {
            addCriterion("is_register not between", value1, value2, "isRegister");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}