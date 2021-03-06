/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.studentportal_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AcademicSubjects generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ACADEMIC_SUBJECTS`")
@IdClass(AcademicSubjectsId.class)
public class AcademicSubjects implements Serializable {

    private Date academicYear;
    private String standard;
    private Integer subjectId;
    private String subjectTeacher;
    private Academics academics;
    private Subjects subjects;
    private List<AcademicTestSubjects> academicTestSubjectses = new ArrayList<>();

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
    @Column(name = "`SUBJECT_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name = "`SUBJECT_TEACHER`", nullable = true, length = 255)
    public String getSubjectTeacher() {
        return this.subjectTeacher;
    }

    public void setSubjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "`ACADEMIC_YEAR`", referencedColumnName = "`ACADEMIC_YEAR`", insertable = false, updatable = false),
            @JoinColumn(name = "`STANDARD`", referencedColumnName = "`STANDARD`", insertable = false, updatable = false)        })
    public Academics getAcademics() {
        return this.academics;
    }

    public void setAcademics(Academics academics) {
        if(academics != null) {
            this.academicYear = academics.getAcademicYear();
            this.standard = academics.getStandard();
        }

        this.academics = academics;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`SUBJECT_ID`", referencedColumnName = "`SUBJECT_ID`", insertable = false, updatable = false)
    public Subjects getSubjects() {
        return this.subjects;
    }

    public void setSubjects(Subjects subjects) {
        if(subjects != null) {
            this.subjectId = subjects.getSubjectId();
        }

        this.subjects = subjects;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "academicSubjects")
    public List<AcademicTestSubjects> getAcademicTestSubjectses() {
        return this.academicTestSubjectses;
    }

    public void setAcademicTestSubjectses(List<AcademicTestSubjects> academicTestSubjectses) {
        this.academicTestSubjectses = academicTestSubjectses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcademicSubjects)) return false;
        final AcademicSubjects academicSubjects = (AcademicSubjects) o;
        return Objects.equals(getAcademicYear(), academicSubjects.getAcademicYear()) &&
                Objects.equals(getStandard(), academicSubjects.getStandard()) &&
                Objects.equals(getSubjectId(), academicSubjects.getSubjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcademicYear(),
                getStandard(),
                getSubjectId());
    }
}

