/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.studentportal_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * GradeDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`GRADE_DETAILS`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`MIN_VALUE`"})})
public class GradeDetails implements Serializable {

    private Integer gradeId;
    private String grade;
    private String gradeRange;
    private Integer minValue;
    private Integer maxValue;
    private List<Results> resultses = new ArrayList<>();

    @Id
    @Column(name = "`GRADE_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    @Column(name = "`GRADE`", nullable = true, length = 255)
    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Column(name = "`GRADE_RANGE`", nullable = true, length = 255)
    public String getGradeRange() {
        return this.gradeRange;
    }

    public void setGradeRange(String gradeRange) {
        this.gradeRange = gradeRange;
    }

    @Column(name = "`MIN_VALUE`", nullable = true, scale = 0, precision = 10)
    public Integer getMinValue() {
        return this.minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    @Column(name = "`MAX_VALUE`", nullable = true, scale = 0, precision = 10)
    public Integer getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "gradeDetails")
    public List<Results> getResultses() {
        return this.resultses;
    }

    public void setResultses(List<Results> resultses) {
        this.resultses = resultses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GradeDetails)) return false;
        final GradeDetails gradeDetails = (GradeDetails) o;
        return Objects.equals(getGradeId(), gradeDetails.getGradeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGradeId());
    }
}

