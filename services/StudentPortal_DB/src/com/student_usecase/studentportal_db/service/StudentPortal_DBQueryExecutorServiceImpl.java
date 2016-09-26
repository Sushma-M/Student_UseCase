/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.student_usecase.studentportal_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.model.CustomQuery;
import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;

@Service
public class StudentPortal_DBQueryExecutorServiceImpl implements StudentPortal_DBQueryExecutorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentPortal_DBQueryExecutorServiceImpl.class);

	@Autowired
	@Qualifier("StudentPortal_DBWMQueryExecutor")
	private WMQueryExecutor queryExecutor;

	@Transactional(value = "StudentPortal_DBTransactionManager")
	@Override
	public Page<Object> executeSV_AcademicSubjectsByStandard(Pageable pageable, java.sql.Date year, java.lang.String standard)
	throws QueryParameterMismatchException{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("year", year);
        params.put("standard", standard);
        return queryExecutor.executeNamedQuery("SV_AcademicSubjectsByStandard", params, pageable);
	}
	@Transactional(value = "StudentPortal_DBTransactionManager")
	@Override
	public Page<Object> executeSV_CountOfStudentsInAcademics(Pageable pageable, java.lang.String standard, java.sql.Date year)
	throws QueryParameterMismatchException{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("standard", standard);
        params.put("year", year);
        return queryExecutor.executeNamedQuery("SV_CountOfStudentsInAcademics", params, pageable);
	}
	@Transactional(value = "StudentPortal_DBTransactionManager")
	@Override
	public Page<Object> executeSV_ResultsByTestID(Pageable pageable, java.lang.String T_Name)
	throws QueryParameterMismatchException{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("T_Name", T_Name);
        return queryExecutor.executeNamedQuery("SV_ResultsByTestID", params, pageable);
	}
	@Transactional(value = "StudentPortal_DBTransactionManager")
	@Override
	public Page<Object> executeSV_StudentAcademicResults(Pageable pageable, java.lang.Integer student_id)
	throws QueryParameterMismatchException{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("student_id", student_id);
        return queryExecutor.executeNamedQuery("SV_StudentAcademicResults", params, pageable);
	}
	@Transactional(value = "StudentPortal_DBTransactionManager")
	@Override
	public Page<Object> executeSV_TestDetails(Pageable pageable)
	throws QueryParameterMismatchException{
        Map<String, Object> params = new HashMap<String, Object>();
        return queryExecutor.executeNamedQuery("SV_TestDetails", params, pageable);
	}
	@Transactional(value = "StudentPortal_DBTransactionManager")
	@Override
	public Page<Object> executeSV_TestQuery(Pageable pageable)
	throws QueryParameterMismatchException{
        Map<String, Object> params = new HashMap<String, Object>();
        return queryExecutor.executeNamedQuery("SV_TestQuery", params, pageable);
	}

	@Transactional(value = "StudentPortal_DBTransactionManager")
	@Override
	public Page<Object> executeWMCustomQuerySelect(CustomQuery query, Pageable pageable) {
	    return queryExecutor.executeCustomQuery(query, pageable);
	}

	@Transactional(value = "StudentPortal_DBTransactionManager")
    @Override
    public int executeWMCustomQueryUpdate(CustomQuery query) {
        return queryExecutor.executeCustomQueryForUpdate(query);
    }
}

