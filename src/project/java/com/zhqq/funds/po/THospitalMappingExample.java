package com.zhqq.funds.po;

import java.util.ArrayList;
import java.util.List;

public class THospitalMappingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public THospitalMappingExample() {
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

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andHospitalNameIsNull() {
            addCriterion("hospital_name is null");
            return (Criteria) this;
        }

        public Criteria andHospitalNameIsNotNull() {
            addCriterion("hospital_name is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalNameEqualTo(String value) {
            addCriterion("hospital_name =", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameNotEqualTo(String value) {
            addCriterion("hospital_name <>", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameGreaterThan(String value) {
            addCriterion("hospital_name >", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameGreaterThanOrEqualTo(String value) {
            addCriterion("hospital_name >=", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameLessThan(String value) {
            addCriterion("hospital_name <", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameLessThanOrEqualTo(String value) {
            addCriterion("hospital_name <=", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameLike(String value) {
            addCriterion("hospital_name like", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameNotLike(String value) {
            addCriterion("hospital_name not like", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameIn(List<String> values) {
            addCriterion("hospital_name in", values, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameNotIn(List<String> values) {
            addCriterion("hospital_name not in", values, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameBetween(String value1, String value2) {
            addCriterion("hospital_name between", value1, value2, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameNotBetween(String value1, String value2) {
            addCriterion("hospital_name not between", value1, value2, "hospitalName");
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

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeIsNull() {
            addCriterion("hospital_grade is null");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeIsNotNull() {
            addCriterion("hospital_grade is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeEqualTo(String value) {
            addCriterion("hospital_grade =", value, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeNotEqualTo(String value) {
            addCriterion("hospital_grade <>", value, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeGreaterThan(String value) {
            addCriterion("hospital_grade >", value, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeGreaterThanOrEqualTo(String value) {
            addCriterion("hospital_grade >=", value, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeLessThan(String value) {
            addCriterion("hospital_grade <", value, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeLessThanOrEqualTo(String value) {
            addCriterion("hospital_grade <=", value, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeLike(String value) {
            addCriterion("hospital_grade like", value, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeNotLike(String value) {
            addCriterion("hospital_grade not like", value, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeIn(List<String> values) {
            addCriterion("hospital_grade in", values, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeNotIn(List<String> values) {
            addCriterion("hospital_grade not in", values, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeBetween(String value1, String value2) {
            addCriterion("hospital_grade between", value1, value2, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalGradeNotBetween(String value1, String value2) {
            addCriterion("hospital_grade not between", value1, value2, "hospitalGrade");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelIsNull() {
            addCriterion("hospital_level is null");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelIsNotNull() {
            addCriterion("hospital_level is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelEqualTo(String value) {
            addCriterion("hospital_level =", value, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelNotEqualTo(String value) {
            addCriterion("hospital_level <>", value, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelGreaterThan(String value) {
            addCriterion("hospital_level >", value, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelGreaterThanOrEqualTo(String value) {
            addCriterion("hospital_level >=", value, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelLessThan(String value) {
            addCriterion("hospital_level <", value, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelLessThanOrEqualTo(String value) {
            addCriterion("hospital_level <=", value, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelLike(String value) {
            addCriterion("hospital_level like", value, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelNotLike(String value) {
            addCriterion("hospital_level not like", value, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelIn(List<String> values) {
            addCriterion("hospital_level in", values, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelNotIn(List<String> values) {
            addCriterion("hospital_level not in", values, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelBetween(String value1, String value2) {
            addCriterion("hospital_level between", value1, value2, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalLevelNotBetween(String value1, String value2) {
            addCriterion("hospital_level not between", value1, value2, "hospitalLevel");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeIsNull() {
            addCriterion("hospital_type is null");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeIsNotNull() {
            addCriterion("hospital_type is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeEqualTo(String value) {
            addCriterion("hospital_type =", value, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeNotEqualTo(String value) {
            addCriterion("hospital_type <>", value, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeGreaterThan(String value) {
            addCriterion("hospital_type >", value, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeGreaterThanOrEqualTo(String value) {
            addCriterion("hospital_type >=", value, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeLessThan(String value) {
            addCriterion("hospital_type <", value, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeLessThanOrEqualTo(String value) {
            addCriterion("hospital_type <=", value, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeLike(String value) {
            addCriterion("hospital_type like", value, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeNotLike(String value) {
            addCriterion("hospital_type not like", value, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeIn(List<String> values) {
            addCriterion("hospital_type in", values, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeNotIn(List<String> values) {
            addCriterion("hospital_type not in", values, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeBetween(String value1, String value2) {
            addCriterion("hospital_type between", value1, value2, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andHospitalTypeNotBetween(String value1, String value2) {
            addCriterion("hospital_type not between", value1, value2, "hospitalType");
            return (Criteria) this;
        }

        public Criteria andAreaManagerIsNull() {
            addCriterion("area_manager is null");
            return (Criteria) this;
        }

        public Criteria andAreaManagerIsNotNull() {
            addCriterion("area_manager is not null");
            return (Criteria) this;
        }

        public Criteria andAreaManagerEqualTo(String value) {
            addCriterion("area_manager =", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerNotEqualTo(String value) {
            addCriterion("area_manager <>", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerGreaterThan(String value) {
            addCriterion("area_manager >", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerGreaterThanOrEqualTo(String value) {
            addCriterion("area_manager >=", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerLessThan(String value) {
            addCriterion("area_manager <", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerLessThanOrEqualTo(String value) {
            addCriterion("area_manager <=", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerLike(String value) {
            addCriterion("area_manager like", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerNotLike(String value) {
            addCriterion("area_manager not like", value, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerIn(List<String> values) {
            addCriterion("area_manager in", values, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerNotIn(List<String> values) {
            addCriterion("area_manager not in", values, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerBetween(String value1, String value2) {
            addCriterion("area_manager between", value1, value2, "areaManager");
            return (Criteria) this;
        }

        public Criteria andAreaManagerNotBetween(String value1, String value2) {
            addCriterion("area_manager not between", value1, value2, "areaManager");
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

        public Criteria andDoctorNameIsNull() {
            addCriterion("doctor_name is null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNotNull() {
            addCriterion("doctor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameEqualTo(String value) {
            addCriterion("doctor_name =", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotEqualTo(String value) {
            addCriterion("doctor_name <>", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThan(String value) {
            addCriterion("doctor_name >", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_name >=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThan(String value) {
            addCriterion("doctor_name <", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThanOrEqualTo(String value) {
            addCriterion("doctor_name <=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLike(String value) {
            addCriterion("doctor_name like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotLike(String value) {
            addCriterion("doctor_name not like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIn(List<String> values) {
            addCriterion("doctor_name in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotIn(List<String> values) {
            addCriterion("doctor_name not in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameBetween(String value1, String value2) {
            addCriterion("doctor_name between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotBetween(String value1, String value2) {
            addCriterion("doctor_name not between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleIsNull() {
            addCriterion("doctor_title is null");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleIsNotNull() {
            addCriterion("doctor_title is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleEqualTo(String value) {
            addCriterion("doctor_title =", value, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleNotEqualTo(String value) {
            addCriterion("doctor_title <>", value, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleGreaterThan(String value) {
            addCriterion("doctor_title >", value, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_title >=", value, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleLessThan(String value) {
            addCriterion("doctor_title <", value, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleLessThanOrEqualTo(String value) {
            addCriterion("doctor_title <=", value, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleLike(String value) {
            addCriterion("doctor_title like", value, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleNotLike(String value) {
            addCriterion("doctor_title not like", value, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleIn(List<String> values) {
            addCriterion("doctor_title in", values, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleNotIn(List<String> values) {
            addCriterion("doctor_title not in", values, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleBetween(String value1, String value2) {
            addCriterion("doctor_title between", value1, value2, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andDoctorTitleNotBetween(String value1, String value2) {
            addCriterion("doctor_title not between", value1, value2, "doctorTitle");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostIsNull() {
            addCriterion("administrative_post is null");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostIsNotNull() {
            addCriterion("administrative_post is not null");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostEqualTo(String value) {
            addCriterion("administrative_post =", value, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostNotEqualTo(String value) {
            addCriterion("administrative_post <>", value, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostGreaterThan(String value) {
            addCriterion("administrative_post >", value, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostGreaterThanOrEqualTo(String value) {
            addCriterion("administrative_post >=", value, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostLessThan(String value) {
            addCriterion("administrative_post <", value, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostLessThanOrEqualTo(String value) {
            addCriterion("administrative_post <=", value, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostLike(String value) {
            addCriterion("administrative_post like", value, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostNotLike(String value) {
            addCriterion("administrative_post not like", value, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostIn(List<String> values) {
            addCriterion("administrative_post in", values, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostNotIn(List<String> values) {
            addCriterion("administrative_post not in", values, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostBetween(String value1, String value2) {
            addCriterion("administrative_post between", value1, value2, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andAdministrativePostNotBetween(String value1, String value2) {
            addCriterion("administrative_post not between", value1, value2, "administrativePost");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionIsNull() {
            addCriterion("professional_direction is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionIsNotNull() {
            addCriterion("professional_direction is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionEqualTo(String value) {
            addCriterion("professional_direction =", value, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionNotEqualTo(String value) {
            addCriterion("professional_direction <>", value, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionGreaterThan(String value) {
            addCriterion("professional_direction >", value, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("professional_direction >=", value, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionLessThan(String value) {
            addCriterion("professional_direction <", value, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionLessThanOrEqualTo(String value) {
            addCriterion("professional_direction <=", value, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionLike(String value) {
            addCriterion("professional_direction like", value, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionNotLike(String value) {
            addCriterion("professional_direction not like", value, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionIn(List<String> values) {
            addCriterion("professional_direction in", values, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionNotIn(List<String> values) {
            addCriterion("professional_direction not in", values, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionBetween(String value1, String value2) {
            addCriterion("professional_direction between", value1, value2, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andProfessionalDirectionNotBetween(String value1, String value2) {
            addCriterion("professional_direction not between", value1, value2, "professionalDirection");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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