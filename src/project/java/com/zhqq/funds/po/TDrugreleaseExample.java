package com.zhqq.funds.po;

import java.util.ArrayList;
import java.util.List;

public class TDrugreleaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TDrugreleaseExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPatientCodeIsNull() {
            addCriterion("patient_code is null");
            return (Criteria) this;
        }

        public Criteria andPatientCodeIsNotNull() {
            addCriterion("patient_code is not null");
            return (Criteria) this;
        }

        public Criteria andPatientCodeEqualTo(String value) {
            addCriterion("patient_code =", value, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeNotEqualTo(String value) {
            addCriterion("patient_code <>", value, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeGreaterThan(String value) {
            addCriterion("patient_code >", value, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeGreaterThanOrEqualTo(String value) {
            addCriterion("patient_code >=", value, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeLessThan(String value) {
            addCriterion("patient_code <", value, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeLessThanOrEqualTo(String value) {
            addCriterion("patient_code <=", value, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeLike(String value) {
            addCriterion("patient_code like", value, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeNotLike(String value) {
            addCriterion("patient_code not like", value, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeIn(List<String> values) {
            addCriterion("patient_code in", values, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeNotIn(List<String> values) {
            addCriterion("patient_code not in", values, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeBetween(String value1, String value2) {
            addCriterion("patient_code between", value1, value2, "patientCode");
            return (Criteria) this;
        }

        public Criteria andPatientCodeNotBetween(String value1, String value2) {
            addCriterion("patient_code not between", value1, value2, "patientCode");
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

        public Criteria andIdcardnumberIsNull() {
            addCriterion("idcardnumber is null");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberIsNotNull() {
            addCriterion("idcardnumber is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberEqualTo(String value) {
            addCriterion("idcardnumber =", value, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberNotEqualTo(String value) {
            addCriterion("idcardnumber <>", value, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberGreaterThan(String value) {
            addCriterion("idcardnumber >", value, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("idcardnumber >=", value, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberLessThan(String value) {
            addCriterion("idcardnumber <", value, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberLessThanOrEqualTo(String value) {
            addCriterion("idcardnumber <=", value, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberLike(String value) {
            addCriterion("idcardnumber like", value, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberNotLike(String value) {
            addCriterion("idcardnumber not like", value, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberIn(List<String> values) {
            addCriterion("idcardnumber in", values, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberNotIn(List<String> values) {
            addCriterion("idcardnumber not in", values, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberBetween(String value1, String value2) {
            addCriterion("idcardnumber between", value1, value2, "idcardnumber");
            return (Criteria) this;
        }

        public Criteria andIdcardnumberNotBetween(String value1, String value2) {
            addCriterion("idcardnumber not between", value1, value2, "idcardnumber");
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

        public Criteria andTakenDrugNumberIsNull() {
            addCriterion("taken_drug_number is null");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberIsNotNull() {
            addCriterion("taken_drug_number is not null");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberEqualTo(String value) {
            addCriterion("taken_drug_number =", value, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberNotEqualTo(String value) {
            addCriterion("taken_drug_number <>", value, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberGreaterThan(String value) {
            addCriterion("taken_drug_number >", value, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberGreaterThanOrEqualTo(String value) {
            addCriterion("taken_drug_number >=", value, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberLessThan(String value) {
            addCriterion("taken_drug_number <", value, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberLessThanOrEqualTo(String value) {
            addCriterion("taken_drug_number <=", value, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberLike(String value) {
            addCriterion("taken_drug_number like", value, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberNotLike(String value) {
            addCriterion("taken_drug_number not like", value, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberIn(List<String> values) {
            addCriterion("taken_drug_number in", values, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberNotIn(List<String> values) {
            addCriterion("taken_drug_number not in", values, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberBetween(String value1, String value2) {
            addCriterion("taken_drug_number between", value1, value2, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andTakenDrugNumberNotBetween(String value1, String value2) {
            addCriterion("taken_drug_number not between", value1, value2, "takenDrugNumber");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseIsNull() {
            addCriterion("current_dose is null");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseIsNotNull() {
            addCriterion("current_dose is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseEqualTo(String value) {
            addCriterion("current_dose =", value, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseNotEqualTo(String value) {
            addCriterion("current_dose <>", value, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseGreaterThan(String value) {
            addCriterion("current_dose >", value, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseGreaterThanOrEqualTo(String value) {
            addCriterion("current_dose >=", value, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseLessThan(String value) {
            addCriterion("current_dose <", value, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseLessThanOrEqualTo(String value) {
            addCriterion("current_dose <=", value, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseLike(String value) {
            addCriterion("current_dose like", value, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseNotLike(String value) {
            addCriterion("current_dose not like", value, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseIn(List<String> values) {
            addCriterion("current_dose in", values, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseNotIn(List<String> values) {
            addCriterion("current_dose not in", values, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseBetween(String value1, String value2) {
            addCriterion("current_dose between", value1, value2, "currentDose");
            return (Criteria) this;
        }

        public Criteria andCurrentDoseNotBetween(String value1, String value2) {
            addCriterion("current_dose not between", value1, value2, "currentDose");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeIsNull() {
            addCriterion("expected_nextTime is null");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeIsNotNull() {
            addCriterion("expected_nextTime is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeEqualTo(String value) {
            addCriterion("expected_nextTime =", value, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeNotEqualTo(String value) {
            addCriterion("expected_nextTime <>", value, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeGreaterThan(String value) {
            addCriterion("expected_nextTime >", value, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeGreaterThanOrEqualTo(String value) {
            addCriterion("expected_nextTime >=", value, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeLessThan(String value) {
            addCriterion("expected_nextTime <", value, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeLessThanOrEqualTo(String value) {
            addCriterion("expected_nextTime <=", value, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeLike(String value) {
            addCriterion("expected_nextTime like", value, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeNotLike(String value) {
            addCriterion("expected_nextTime not like", value, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeIn(List<String> values) {
            addCriterion("expected_nextTime in", values, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeNotIn(List<String> values) {
            addCriterion("expected_nextTime not in", values, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeBetween(String value1, String value2) {
            addCriterion("expected_nextTime between", value1, value2, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andExpectedNexttimeNotBetween(String value1, String value2) {
            addCriterion("expected_nextTime not between", value1, value2, "expectedNexttime");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupIsNull() {
            addCriterion("hospital_group is null");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupIsNotNull() {
            addCriterion("hospital_group is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupEqualTo(String value) {
            addCriterion("hospital_group =", value, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupNotEqualTo(String value) {
            addCriterion("hospital_group <>", value, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupGreaterThan(String value) {
            addCriterion("hospital_group >", value, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupGreaterThanOrEqualTo(String value) {
            addCriterion("hospital_group >=", value, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupLessThan(String value) {
            addCriterion("hospital_group <", value, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupLessThanOrEqualTo(String value) {
            addCriterion("hospital_group <=", value, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupLike(String value) {
            addCriterion("hospital_group like", value, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupNotLike(String value) {
            addCriterion("hospital_group not like", value, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupIn(List<String> values) {
            addCriterion("hospital_group in", values, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupNotIn(List<String> values) {
            addCriterion("hospital_group not in", values, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupBetween(String value1, String value2) {
            addCriterion("hospital_group between", value1, value2, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andHospitalGroupNotBetween(String value1, String value2) {
            addCriterion("hospital_group not between", value1, value2, "hospitalGroup");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeIsNull() {
            addCriterion("formal_entry_time is null");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeIsNotNull() {
            addCriterion("formal_entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeEqualTo(String value) {
            addCriterion("formal_entry_time =", value, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeNotEqualTo(String value) {
            addCriterion("formal_entry_time <>", value, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeGreaterThan(String value) {
            addCriterion("formal_entry_time >", value, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeGreaterThanOrEqualTo(String value) {
            addCriterion("formal_entry_time >=", value, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeLessThan(String value) {
            addCriterion("formal_entry_time <", value, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeLessThanOrEqualTo(String value) {
            addCriterion("formal_entry_time <=", value, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeLike(String value) {
            addCriterion("formal_entry_time like", value, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeNotLike(String value) {
            addCriterion("formal_entry_time not like", value, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeIn(List<String> values) {
            addCriterion("formal_entry_time in", values, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeNotIn(List<String> values) {
            addCriterion("formal_entry_time not in", values, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeBetween(String value1, String value2) {
            addCriterion("formal_entry_time between", value1, value2, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andFormalEntryTimeNotBetween(String value1, String value2) {
            addCriterion("formal_entry_time not between", value1, value2, "formalEntryTime");
            return (Criteria) this;
        }

        public Criteria andDiseaseIsNull() {
            addCriterion("disease is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIsNotNull() {
            addCriterion("disease is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseEqualTo(String value) {
            addCriterion("disease =", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotEqualTo(String value) {
            addCriterion("disease <>", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseGreaterThan(String value) {
            addCriterion("disease >", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseGreaterThanOrEqualTo(String value) {
            addCriterion("disease >=", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLessThan(String value) {
            addCriterion("disease <", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLessThanOrEqualTo(String value) {
            addCriterion("disease <=", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLike(String value) {
            addCriterion("disease like", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotLike(String value) {
            addCriterion("disease not like", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseIn(List<String> values) {
            addCriterion("disease in", values, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotIn(List<String> values) {
            addCriterion("disease not in", values, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseBetween(String value1, String value2) {
            addCriterion("disease between", value1, value2, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotBetween(String value1, String value2) {
            addCriterion("disease not between", value1, value2, "disease");
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