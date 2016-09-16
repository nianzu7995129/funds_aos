package com.zhqq.funds.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPatientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TPatientExample() {
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

        public Criteria andArchivesIsNull() {
            addCriterion("archives is null");
            return (Criteria) this;
        }

        public Criteria andArchivesIsNotNull() {
            addCriterion("archives is not null");
            return (Criteria) this;
        }

        public Criteria andArchivesEqualTo(String value) {
            addCriterion("archives =", value, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesNotEqualTo(String value) {
            addCriterion("archives <>", value, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesGreaterThan(String value) {
            addCriterion("archives >", value, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesGreaterThanOrEqualTo(String value) {
            addCriterion("archives >=", value, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesLessThan(String value) {
            addCriterion("archives <", value, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesLessThanOrEqualTo(String value) {
            addCriterion("archives <=", value, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesLike(String value) {
            addCriterion("archives like", value, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesNotLike(String value) {
            addCriterion("archives not like", value, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesIn(List<String> values) {
            addCriterion("archives in", values, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesNotIn(List<String> values) {
            addCriterion("archives not in", values, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesBetween(String value1, String value2) {
            addCriterion("archives between", value1, value2, "archives");
            return (Criteria) this;
        }

        public Criteria andArchivesNotBetween(String value1, String value2) {
            addCriterion("archives not between", value1, value2, "archives");
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

        public Criteria andApplyTypeIsNull() {
            addCriterion("apply_type is null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNotNull() {
            addCriterion("apply_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeEqualTo(String value) {
            addCriterion("apply_type =", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotEqualTo(String value) {
            addCriterion("apply_type <>", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThan(String value) {
            addCriterion("apply_type >", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_type >=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThan(String value) {
            addCriterion("apply_type <", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThanOrEqualTo(String value) {
            addCriterion("apply_type <=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLike(String value) {
            addCriterion("apply_type like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotLike(String value) {
            addCriterion("apply_type not like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIn(List<String> values) {
            addCriterion("apply_type in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotIn(List<String> values) {
            addCriterion("apply_type not in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeBetween(String value1, String value2) {
            addCriterion("apply_type between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotBetween(String value1, String value2) {
            addCriterion("apply_type not between", value1, value2, "applyType");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialIsNull() {
            addCriterion("diagnostic_material is null");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialIsNotNull() {
            addCriterion("diagnostic_material is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialEqualTo(String value) {
            addCriterion("diagnostic_material =", value, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialNotEqualTo(String value) {
            addCriterion("diagnostic_material <>", value, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialGreaterThan(String value) {
            addCriterion("diagnostic_material >", value, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("diagnostic_material >=", value, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialLessThan(String value) {
            addCriterion("diagnostic_material <", value, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialLessThanOrEqualTo(String value) {
            addCriterion("diagnostic_material <=", value, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialLike(String value) {
            addCriterion("diagnostic_material like", value, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialNotLike(String value) {
            addCriterion("diagnostic_material not like", value, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialIn(List<String> values) {
            addCriterion("diagnostic_material in", values, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialNotIn(List<String> values) {
            addCriterion("diagnostic_material not in", values, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialBetween(String value1, String value2) {
            addCriterion("diagnostic_material between", value1, value2, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andDiagnosticMaterialNotBetween(String value1, String value2) {
            addCriterion("diagnostic_material not between", value1, value2, "diagnosticMaterial");
            return (Criteria) this;
        }

        public Criteria andProofIdentityIsNull() {
            addCriterion("proof_identity is null");
            return (Criteria) this;
        }

        public Criteria andProofIdentityIsNotNull() {
            addCriterion("proof_identity is not null");
            return (Criteria) this;
        }

        public Criteria andProofIdentityEqualTo(String value) {
            addCriterion("proof_identity =", value, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityNotEqualTo(String value) {
            addCriterion("proof_identity <>", value, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityGreaterThan(String value) {
            addCriterion("proof_identity >", value, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("proof_identity >=", value, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityLessThan(String value) {
            addCriterion("proof_identity <", value, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityLessThanOrEqualTo(String value) {
            addCriterion("proof_identity <=", value, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityLike(String value) {
            addCriterion("proof_identity like", value, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityNotLike(String value) {
            addCriterion("proof_identity not like", value, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityIn(List<String> values) {
            addCriterion("proof_identity in", values, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityNotIn(List<String> values) {
            addCriterion("proof_identity not in", values, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityBetween(String value1, String value2) {
            addCriterion("proof_identity between", value1, value2, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIdentityNotBetween(String value1, String value2) {
            addCriterion("proof_identity not between", value1, value2, "proofIdentity");
            return (Criteria) this;
        }

        public Criteria andProofIncomeIsNull() {
            addCriterion("proof_income is null");
            return (Criteria) this;
        }

        public Criteria andProofIncomeIsNotNull() {
            addCriterion("proof_income is not null");
            return (Criteria) this;
        }

        public Criteria andProofIncomeEqualTo(String value) {
            addCriterion("proof_income =", value, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeNotEqualTo(String value) {
            addCriterion("proof_income <>", value, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeGreaterThan(String value) {
            addCriterion("proof_income >", value, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("proof_income >=", value, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeLessThan(String value) {
            addCriterion("proof_income <", value, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeLessThanOrEqualTo(String value) {
            addCriterion("proof_income <=", value, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeLike(String value) {
            addCriterion("proof_income like", value, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeNotLike(String value) {
            addCriterion("proof_income not like", value, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeIn(List<String> values) {
            addCriterion("proof_income in", values, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeNotIn(List<String> values) {
            addCriterion("proof_income not in", values, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeBetween(String value1, String value2) {
            addCriterion("proof_income between", value1, value2, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andProofIncomeNotBetween(String value1, String value2) {
            addCriterion("proof_income not between", value1, value2, "proofIncome");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceIsNull() {
            addCriterion("purchase_invoice is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceIsNotNull() {
            addCriterion("purchase_invoice is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceEqualTo(String value) {
            addCriterion("purchase_invoice =", value, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceNotEqualTo(String value) {
            addCriterion("purchase_invoice <>", value, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceGreaterThan(String value) {
            addCriterion("purchase_invoice >", value, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_invoice >=", value, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceLessThan(String value) {
            addCriterion("purchase_invoice <", value, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceLessThanOrEqualTo(String value) {
            addCriterion("purchase_invoice <=", value, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceLike(String value) {
            addCriterion("purchase_invoice like", value, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceNotLike(String value) {
            addCriterion("purchase_invoice not like", value, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceIn(List<String> values) {
            addCriterion("purchase_invoice in", values, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceNotIn(List<String> values) {
            addCriterion("purchase_invoice not in", values, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceBetween(String value1, String value2) {
            addCriterion("purchase_invoice between", value1, value2, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andPurchaseInvoiceNotBetween(String value1, String value2) {
            addCriterion("purchase_invoice not between", value1, value2, "purchaseInvoice");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormIsNull() {
            addCriterion("medical_evaluation_form is null");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormIsNotNull() {
            addCriterion("medical_evaluation_form is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormEqualTo(String value) {
            addCriterion("medical_evaluation_form =", value, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormNotEqualTo(String value) {
            addCriterion("medical_evaluation_form <>", value, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormGreaterThan(String value) {
            addCriterion("medical_evaluation_form >", value, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormGreaterThanOrEqualTo(String value) {
            addCriterion("medical_evaluation_form >=", value, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormLessThan(String value) {
            addCriterion("medical_evaluation_form <", value, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormLessThanOrEqualTo(String value) {
            addCriterion("medical_evaluation_form <=", value, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormLike(String value) {
            addCriterion("medical_evaluation_form like", value, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormNotLike(String value) {
            addCriterion("medical_evaluation_form not like", value, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormIn(List<String> values) {
            addCriterion("medical_evaluation_form in", values, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormNotIn(List<String> values) {
            addCriterion("medical_evaluation_form not in", values, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormBetween(String value1, String value2) {
            addCriterion("medical_evaluation_form between", value1, value2, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andMedicalEvaluationFormNotBetween(String value1, String value2) {
            addCriterion("medical_evaluation_form not between", value1, value2, "medicalEvaluationForm");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsIsNull() {
            addCriterion("informed_consent_of_patients is null");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsIsNotNull() {
            addCriterion("informed_consent_of_patients is not null");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsEqualTo(String value) {
            addCriterion("informed_consent_of_patients =", value, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsNotEqualTo(String value) {
            addCriterion("informed_consent_of_patients <>", value, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsGreaterThan(String value) {
            addCriterion("informed_consent_of_patients >", value, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsGreaterThanOrEqualTo(String value) {
            addCriterion("informed_consent_of_patients >=", value, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsLessThan(String value) {
            addCriterion("informed_consent_of_patients <", value, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsLessThanOrEqualTo(String value) {
            addCriterion("informed_consent_of_patients <=", value, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsLike(String value) {
            addCriterion("informed_consent_of_patients like", value, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsNotLike(String value) {
            addCriterion("informed_consent_of_patients not like", value, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsIn(List<String> values) {
            addCriterion("informed_consent_of_patients in", values, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsNotIn(List<String> values) {
            addCriterion("informed_consent_of_patients not in", values, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsBetween(String value1, String value2) {
            addCriterion("informed_consent_of_patients between", value1, value2, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andInformedConsentOfPatientsNotBetween(String value1, String value2) {
            addCriterion("informed_consent_of_patients not between", value1, value2, "informedConsentOfPatients");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusIsNull() {
            addCriterion("patiente_conomic_status is null");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusIsNotNull() {
            addCriterion("patiente_conomic_status is not null");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusEqualTo(String value) {
            addCriterion("patiente_conomic_status =", value, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusNotEqualTo(String value) {
            addCriterion("patiente_conomic_status <>", value, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusGreaterThan(String value) {
            addCriterion("patiente_conomic_status >", value, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusGreaterThanOrEqualTo(String value) {
            addCriterion("patiente_conomic_status >=", value, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusLessThan(String value) {
            addCriterion("patiente_conomic_status <", value, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusLessThanOrEqualTo(String value) {
            addCriterion("patiente_conomic_status <=", value, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusLike(String value) {
            addCriterion("patiente_conomic_status like", value, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusNotLike(String value) {
            addCriterion("patiente_conomic_status not like", value, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusIn(List<String> values) {
            addCriterion("patiente_conomic_status in", values, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusNotIn(List<String> values) {
            addCriterion("patiente_conomic_status not in", values, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusBetween(String value1, String value2) {
            addCriterion("patiente_conomic_status between", value1, value2, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andPatienteConomicStatusNotBetween(String value1, String value2) {
            addCriterion("patiente_conomic_status not between", value1, value2, "patienteConomicStatus");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentIsNull() {
            addCriterion("Cold_chain_drug_informed_consent is null");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentIsNotNull() {
            addCriterion("Cold_chain_drug_informed_consent is not null");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentEqualTo(String value) {
            addCriterion("Cold_chain_drug_informed_consent =", value, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentNotEqualTo(String value) {
            addCriterion("Cold_chain_drug_informed_consent <>", value, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentGreaterThan(String value) {
            addCriterion("Cold_chain_drug_informed_consent >", value, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentGreaterThanOrEqualTo(String value) {
            addCriterion("Cold_chain_drug_informed_consent >=", value, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentLessThan(String value) {
            addCriterion("Cold_chain_drug_informed_consent <", value, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentLessThanOrEqualTo(String value) {
            addCriterion("Cold_chain_drug_informed_consent <=", value, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentLike(String value) {
            addCriterion("Cold_chain_drug_informed_consent like", value, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentNotLike(String value) {
            addCriterion("Cold_chain_drug_informed_consent not like", value, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentIn(List<String> values) {
            addCriterion("Cold_chain_drug_informed_consent in", values, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentNotIn(List<String> values) {
            addCriterion("Cold_chain_drug_informed_consent not in", values, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentBetween(String value1, String value2) {
            addCriterion("Cold_chain_drug_informed_consent between", value1, value2, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andColdChainDrugInformedConsentNotBetween(String value1, String value2) {
            addCriterion("Cold_chain_drug_informed_consent not between", value1, value2, "coldChainDrugInformedConsent");
            return (Criteria) this;
        }

        public Criteria andHrIsNull() {
            addCriterion("hr is null");
            return (Criteria) this;
        }

        public Criteria andHrIsNotNull() {
            addCriterion("hr is not null");
            return (Criteria) this;
        }

        public Criteria andHrEqualTo(String value) {
            addCriterion("hr =", value, "hr");
            return (Criteria) this;
        }

        public Criteria andHrNotEqualTo(String value) {
            addCriterion("hr <>", value, "hr");
            return (Criteria) this;
        }

        public Criteria andHrGreaterThan(String value) {
            addCriterion("hr >", value, "hr");
            return (Criteria) this;
        }

        public Criteria andHrGreaterThanOrEqualTo(String value) {
            addCriterion("hr >=", value, "hr");
            return (Criteria) this;
        }

        public Criteria andHrLessThan(String value) {
            addCriterion("hr <", value, "hr");
            return (Criteria) this;
        }

        public Criteria andHrLessThanOrEqualTo(String value) {
            addCriterion("hr <=", value, "hr");
            return (Criteria) this;
        }

        public Criteria andHrLike(String value) {
            addCriterion("hr like", value, "hr");
            return (Criteria) this;
        }

        public Criteria andHrNotLike(String value) {
            addCriterion("hr not like", value, "hr");
            return (Criteria) this;
        }

        public Criteria andHrIn(List<String> values) {
            addCriterion("hr in", values, "hr");
            return (Criteria) this;
        }

        public Criteria andHrNotIn(List<String> values) {
            addCriterion("hr not in", values, "hr");
            return (Criteria) this;
        }

        public Criteria andHrBetween(String value1, String value2) {
            addCriterion("hr between", value1, value2, "hr");
            return (Criteria) this;
        }

        public Criteria andHrNotBetween(String value1, String value2) {
            addCriterion("hr not between", value1, value2, "hr");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalIsNull() {
            addCriterion("lang_mu_hospital is null");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalIsNotNull() {
            addCriterion("lang_mu_hospital is not null");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalEqualTo(String value) {
            addCriterion("lang_mu_hospital =", value, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalNotEqualTo(String value) {
            addCriterion("lang_mu_hospital <>", value, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalGreaterThan(String value) {
            addCriterion("lang_mu_hospital >", value, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalGreaterThanOrEqualTo(String value) {
            addCriterion("lang_mu_hospital >=", value, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalLessThan(String value) {
            addCriterion("lang_mu_hospital <", value, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalLessThanOrEqualTo(String value) {
            addCriterion("lang_mu_hospital <=", value, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalLike(String value) {
            addCriterion("lang_mu_hospital like", value, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalNotLike(String value) {
            addCriterion("lang_mu_hospital not like", value, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalIn(List<String> values) {
            addCriterion("lang_mu_hospital in", values, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalNotIn(List<String> values) {
            addCriterion("lang_mu_hospital not in", values, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalBetween(String value1, String value2) {
            addCriterion("lang_mu_hospital between", value1, value2, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuHospitalNotBetween(String value1, String value2) {
            addCriterion("lang_mu_hospital not between", value1, value2, "langMuHospital");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorIsNull() {
            addCriterion("lang_mu_doctor is null");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorIsNotNull() {
            addCriterion("lang_mu_doctor is not null");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorEqualTo(String value) {
            addCriterion("lang_mu_doctor =", value, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorNotEqualTo(String value) {
            addCriterion("lang_mu_doctor <>", value, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorGreaterThan(String value) {
            addCriterion("lang_mu_doctor >", value, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorGreaterThanOrEqualTo(String value) {
            addCriterion("lang_mu_doctor >=", value, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorLessThan(String value) {
            addCriterion("lang_mu_doctor <", value, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorLessThanOrEqualTo(String value) {
            addCriterion("lang_mu_doctor <=", value, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorLike(String value) {
            addCriterion("lang_mu_doctor like", value, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorNotLike(String value) {
            addCriterion("lang_mu_doctor not like", value, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorIn(List<String> values) {
            addCriterion("lang_mu_doctor in", values, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorNotIn(List<String> values) {
            addCriterion("lang_mu_doctor not in", values, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorBetween(String value1, String value2) {
            addCriterion("lang_mu_doctor between", value1, value2, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andLangMuDoctorNotBetween(String value1, String value2) {
            addCriterion("lang_mu_doctor not between", value1, value2, "langMuDoctor");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionIsNull() {
            addCriterion("estimated_time_to_increase_drug_injection is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionIsNotNull() {
            addCriterion("estimated_time_to_increase_drug_injection is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionEqualTo(String value) {
            addCriterion("estimated_time_to_increase_drug_injection =", value, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionNotEqualTo(String value) {
            addCriterion("estimated_time_to_increase_drug_injection <>", value, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionGreaterThan(String value) {
            addCriterion("estimated_time_to_increase_drug_injection >", value, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionGreaterThanOrEqualTo(String value) {
            addCriterion("estimated_time_to_increase_drug_injection >=", value, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionLessThan(String value) {
            addCriterion("estimated_time_to_increase_drug_injection <", value, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionLessThanOrEqualTo(String value) {
            addCriterion("estimated_time_to_increase_drug_injection <=", value, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionLike(String value) {
            addCriterion("estimated_time_to_increase_drug_injection like", value, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionNotLike(String value) {
            addCriterion("estimated_time_to_increase_drug_injection not like", value, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionIn(List<String> values) {
            addCriterion("estimated_time_to_increase_drug_injection in", values, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionNotIn(List<String> values) {
            addCriterion("estimated_time_to_increase_drug_injection not in", values, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionBetween(String value1, String value2) {
            addCriterion("estimated_time_to_increase_drug_injection between", value1, value2, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeToIncreaseDrugInjectionNotBetween(String value1, String value2) {
            addCriterion("estimated_time_to_increase_drug_injection not between", value1, value2, "estimatedTimeToIncreaseDrugInjection");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugIsNull() {
            addCriterion("recipients_receive_single_drug is null");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugIsNotNull() {
            addCriterion("recipients_receive_single_drug is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugEqualTo(String value) {
            addCriterion("recipients_receive_single_drug =", value, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugNotEqualTo(String value) {
            addCriterion("recipients_receive_single_drug <>", value, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugGreaterThan(String value) {
            addCriterion("recipients_receive_single_drug >", value, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugGreaterThanOrEqualTo(String value) {
            addCriterion("recipients_receive_single_drug >=", value, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugLessThan(String value) {
            addCriterion("recipients_receive_single_drug <", value, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugLessThanOrEqualTo(String value) {
            addCriterion("recipients_receive_single_drug <=", value, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugLike(String value) {
            addCriterion("recipients_receive_single_drug like", value, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugNotLike(String value) {
            addCriterion("recipients_receive_single_drug not like", value, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugIn(List<String> values) {
            addCriterion("recipients_receive_single_drug in", values, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugNotIn(List<String> values) {
            addCriterion("recipients_receive_single_drug not in", values, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugBetween(String value1, String value2) {
            addCriterion("recipients_receive_single_drug between", value1, value2, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andRecipientsReceiveSingleDrugNotBetween(String value1, String value2) {
            addCriterion("recipients_receive_single_drug not between", value1, value2, "recipientsReceiveSingleDrug");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementIsNull() {
            addCriterion("end_of_statement is null");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementIsNotNull() {
            addCriterion("end_of_statement is not null");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementEqualTo(String value) {
            addCriterion("end_of_statement =", value, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementNotEqualTo(String value) {
            addCriterion("end_of_statement <>", value, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementGreaterThan(String value) {
            addCriterion("end_of_statement >", value, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementGreaterThanOrEqualTo(String value) {
            addCriterion("end_of_statement >=", value, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementLessThan(String value) {
            addCriterion("end_of_statement <", value, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementLessThanOrEqualTo(String value) {
            addCriterion("end_of_statement <=", value, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementLike(String value) {
            addCriterion("end_of_statement like", value, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementNotLike(String value) {
            addCriterion("end_of_statement not like", value, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementIn(List<String> values) {
            addCriterion("end_of_statement in", values, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementNotIn(List<String> values) {
            addCriterion("end_of_statement not in", values, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementBetween(String value1, String value2) {
            addCriterion("end_of_statement between", value1, value2, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andEndOfStatementNotBetween(String value1, String value2) {
            addCriterion("end_of_statement not between", value1, value2, "endOfStatement");
            return (Criteria) this;
        }

        public Criteria andPassdateIsNull() {
            addCriterion("passDate is null");
            return (Criteria) this;
        }

        public Criteria andPassdateIsNotNull() {
            addCriterion("passDate is not null");
            return (Criteria) this;
        }

        public Criteria andPassdateEqualTo(Date value) {
            addCriterion("passDate =", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateNotEqualTo(Date value) {
            addCriterion("passDate <>", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateGreaterThan(Date value) {
            addCriterion("passDate >", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateGreaterThanOrEqualTo(Date value) {
            addCriterion("passDate >=", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateLessThan(Date value) {
            addCriterion("passDate <", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateLessThanOrEqualTo(Date value) {
            addCriterion("passDate <=", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateIn(List<Date> values) {
            addCriterion("passDate in", values, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateNotIn(List<Date> values) {
            addCriterion("passDate not in", values, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateBetween(Date value1, Date value2) {
            addCriterion("passDate between", value1, value2, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateNotBetween(Date value1, Date value2) {
            addCriterion("passDate not between", value1, value2, "passdate");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalIsNull() {
            addCriterion("is_lang_mu_hospital is null");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalIsNotNull() {
            addCriterion("is_lang_mu_hospital is not null");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalEqualTo(String value) {
            addCriterion("is_lang_mu_hospital =", value, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalNotEqualTo(String value) {
            addCriterion("is_lang_mu_hospital <>", value, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalGreaterThan(String value) {
            addCriterion("is_lang_mu_hospital >", value, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalGreaterThanOrEqualTo(String value) {
            addCriterion("is_lang_mu_hospital >=", value, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalLessThan(String value) {
            addCriterion("is_lang_mu_hospital <", value, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalLessThanOrEqualTo(String value) {
            addCriterion("is_lang_mu_hospital <=", value, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalLike(String value) {
            addCriterion("is_lang_mu_hospital like", value, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalNotLike(String value) {
            addCriterion("is_lang_mu_hospital not like", value, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalIn(List<String> values) {
            addCriterion("is_lang_mu_hospital in", values, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalNotIn(List<String> values) {
            addCriterion("is_lang_mu_hospital not in", values, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalBetween(String value1, String value2) {
            addCriterion("is_lang_mu_hospital between", value1, value2, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andIsLangMuHospitalNotBetween(String value1, String value2) {
            addCriterion("is_lang_mu_hospital not between", value1, value2, "isLangMuHospital");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
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