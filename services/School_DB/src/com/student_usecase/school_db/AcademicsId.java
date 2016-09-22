/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.school_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AcademicsId implements Serializable {

    private Date academicYear;
    private String standard;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Academics)) return false;
        final Academics academics = (Academics) o;
        return Objects.equals(getAcademicYear(), academics.getAcademicYear()) &&
                Objects.equals(getStandard(), academics.getStandard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcademicYear(),
                getStandard());
    }
}