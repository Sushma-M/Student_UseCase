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
 * StandardDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`STANDARD_DETAILS`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`STANDARD_CODE`"})})
public class StandardDetails implements Serializable {

    private Integer standardId;
    private String standardCode;
    private String standardName;
    private List<Academics> academicses = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`STANDARD_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getStandardId() {
        return this.standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    @Column(name = "`STANDARD_CODE`", nullable = true, length = 255)
    public String getStandardCode() {
        return this.standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    @Column(name = "`STANDARD_NAME`", nullable = true, length = 255)
    public String getStandardName() {
        return this.standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "standardDetails")
    public List<Academics> getAcademicses() {
        return this.academicses;
    }

    public void setAcademicses(List<Academics> academicses) {
        this.academicses = academicses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardDetails)) return false;
        final StandardDetails standardDetails = (StandardDetails) o;
        return Objects.equals(getStandardId(), standardDetails.getStandardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStandardId());
    }
}
