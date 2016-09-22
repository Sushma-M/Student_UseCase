/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.studentportal_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AcademicTestSubjects generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ACADEMIC_TEST_SUBJECTS`")
@IdClass(AcademicTestSubjectsId.class)
public class AcademicTestSubjects implements Serializable {

    private Date academicYear;
    private String standard;
    private Integer testId;
    private Integer subjectId;
    private String maxMarks;
    private Date examConductedOn;
    private AcademicSubjects academicSubjects;
    private TestDetails testDetails;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "`ACADEMIC_YEAR`", nullable = false)
    public Date getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(Date academicYear) {
        this.academicYear = academicYear;
    }

    @Id
    @Column(name = "`STANDARD`", nullable = false, length = 255)
    public String getStandard() {
        return this.standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Id
    @Column(name = "`TEST_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getTestId() {
        return this.testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Id
    @Column(name = "`SUBJECT_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name = "`MAX_MARKS`", nullable = true, length = 255)
    public String getMaxMarks() {
        return this.maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`EXAM_CONDUCTED_ON`", nullable = true)
    public Date getExamConductedOn() {
        return this.examConductedOn;
    }

    public void setExamConductedOn(Date examConductedOn) {
        this.examConductedOn = examConductedOn;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "`ACADEMIC_YEAR`", referencedColumnName = "`ACADEMIC_YEAR`", insertable = false, updatable = false),
            @JoinColumn(name = "`STANDARD`", referencedColumnName = "`STANDARD`", insertable = false, updatable = false),
            @JoinColumn(name = "`SUBJECT_ID`", referencedColumnName = "`SUBJECT_ID`", insertable = false, updatable = false)        })
    public AcademicSubjects getAcademicSubjects() {
        return this.academicSubjects;
    }

    public void setAcademicSubjects(AcademicSubjects academicSubjects) {
        if(academicSubjects != null) {
            this.academicYear = academicSubjects.getAcademicYear();
            this.standard = academicSubjects.getStandard();
            this.subjectId = academicSubjects.getSubjectId();
        }

        this.academicSubjects = academicSubjects;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`TEST_ID`", referencedColumnName = "`TEST_ID`", insertable = false, updatable = false)
    public TestDetails getTestDetails() {
        return this.testDetails;
    }

    public void setTestDetails(TestDetails testDetails) {
        if(testDetails != null) {
            this.testId = testDetails.getTestId();
        }

        this.testDetails = testDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcademicTestSubjects)) return false;
        final AcademicTestSubjects academicTestSubjects = (AcademicTestSubjects) o;
        return Objects.equals(getAcademicYear(), academicTestSubjects.getAcademicYear()) &&
                Objects.equals(getStandard(), academicTestSubjects.getStandard()) &&
                Objects.equals(getTestId(), academicTestSubjects.getTestId()) &&
                Objects.equals(getSubjectId(), academicTestSubjects.getSubjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcademicYear(),
                getStandard(),
                getTestId(),
                getSubjectId());
    }
}

