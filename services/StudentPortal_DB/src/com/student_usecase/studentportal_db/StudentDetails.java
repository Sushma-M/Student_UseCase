/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.studentportal_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StudentDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`STUDENT_DETAILS`")
public class StudentDetails implements Serializable {

    private Integer studentId;
    private String studentName;
    private Date dateOfBirth;
    private String fatherName;
    private String address;
    private BigInteger contactNumber;
    private Date joiningDate;
    private List<StudentAcademics> studentAcademicses = new ArrayList<>();

    @Id
    @Column(name = "`STUDENT_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Column(name = "`STUDENT_NAME`", nullable = true, length = 255)
    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`DATE_OF_BIRTH`", nullable = true)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "`FATHER_NAME`", nullable = true, length = 255)
    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Column(name = "`ADDRESS`", nullable = true, length = 255)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "`CONTACT_NUMBER`", nullable = true, scale = 0, precision = 20)
    public BigInteger getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(BigInteger contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`JOINING_DATE`", nullable = true)
    public Date getJoiningDate() {
        return this.joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "studentDetails")
    public List<StudentAcademics> getStudentAcademicses() {
        return this.studentAcademicses;
    }

    public void setStudentAcademicses(List<StudentAcademics> studentAcademicses) {
        this.studentAcademicses = studentAcademicses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDetails)) return false;
        final StudentDetails studentDetails = (StudentDetails) o;
        return Objects.equals(getStudentId(), studentDetails.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }
}
