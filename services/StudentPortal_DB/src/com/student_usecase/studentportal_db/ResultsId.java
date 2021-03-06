/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.studentportal_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ResultsId implements Serializable {

    private Date academicYear;
    private String standard;
    private Integer studentId;
    private Integer gradeId;
    private Integer testId;
    private Integer subjectId;

    public Date getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(Date academicYear) {
        this.academicYear = academicYear;
    }

    public String getStandard() {
        return this.standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getTestId() {
        return this.testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Results)) return false;
        final Results results = (Results) o;
        return Objects.equals(getAcademicYear(), results.getAcademicYear()) &&
                Objects.equals(getStandard(), results.getStandard()) &&
                Objects.equals(getStudentId(), results.getStudentId()) &&
                Objects.equals(getGradeId(), results.getGradeId()) &&
                Objects.equals(getTestId(), results.getTestId()) &&
                Objects.equals(getSubjectId(), results.getSubjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcademicYear(),
                getStandard(),
                getStudentId(),
                getGradeId(),
                getTestId(),
                getSubjectId());
    }
}
