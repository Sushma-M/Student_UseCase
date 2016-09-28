/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.school_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TestDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TEST_DETAILS`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`TEST_NAME`"})})
public class TestDetails implements Serializable {

    private Integer testId;
    private String testName;
    private List<AcademicTestSubjects> academicTestSubjectses = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`TEST_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getTestId() {
        return this.testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Column(name = "`TEST_NAME`", nullable = true, length = 255)
    public String getTestName() {
        return this.testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "testDetails")
    public List<AcademicTestSubjects> getAcademicTestSubjectses() {
        return this.academicTestSubjectses;
    }

    public void setAcademicTestSubjectses(List<AcademicTestSubjects> academicTestSubjectses) {
        this.academicTestSubjectses = academicTestSubjectses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestDetails)) return false;
        final TestDetails testDetails = (TestDetails) o;
        return Objects.equals(getTestId(), testDetails.getTestId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestId());
    }
}

