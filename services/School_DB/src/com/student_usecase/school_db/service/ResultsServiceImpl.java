/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.school_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.student_usecase.school_db.Results;
import com.student_usecase.school_db.ResultsId;


/**
 * ServiceImpl object for domain model class Results.
 *
 * @see Results
 */
@Service("School_DB.ResultsService")
public class ResultsServiceImpl implements ResultsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultsServiceImpl.class);


    @Autowired
    @Qualifier("School_DB.ResultsDao")
    private WMGenericDao<Results, ResultsId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Results, ResultsId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
	public Results create(Results results) {
        LOGGER.debug("Creating a new Results with information: {}", results);
        Results resultsCreated = this.wmGenericDao.create(results);
        return resultsCreated;
    }

	@Transactional(readOnly = true, value = "School_DBTransactionManager")
	@Override
	public Results getById(ResultsId resultsId) throws EntityNotFoundException {
        LOGGER.debug("Finding Results by id: {}", resultsId);
        Results results = this.wmGenericDao.findById(resultsId);
        if (results == null){
            LOGGER.debug("No Results found with id: {}", resultsId);
            throw new EntityNotFoundException(String.valueOf(resultsId));
        }
        return results;
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
	@Override
	public Results findById(ResultsId resultsId) {
        LOGGER.debug("Finding Results by id: {}", resultsId);
        return this.wmGenericDao.findById(resultsId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "School_DBTransactionManager")
	@Override
	public Results update(Results results) throws EntityNotFoundException {
        LOGGER.debug("Updating Results with information: {}", results);
        this.wmGenericDao.update(results);

        ResultsId resultsId = new ResultsId();
        resultsId.setAcademicYear(results.getAcademicYear());
        resultsId.setStandardId(results.getStandardId());
        resultsId.setStudentId(results.getStudentId());
        resultsId.setGradeId(results.getGradeId());
        resultsId.setTestId(results.getTestId());
        resultsId.setSubjectId(results.getSubjectId());

        return this.wmGenericDao.findById(resultsId);
    }

    @Transactional(value = "School_DBTransactionManager")
	@Override
	public Results delete(ResultsId resultsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Results with id: {}", resultsId);
        Results deleted = this.wmGenericDao.findById(resultsId);
        if (deleted == null) {
            LOGGER.debug("No Results found with id: {}", resultsId);
            throw new EntityNotFoundException(String.valueOf(resultsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "School_DBTransactionManager")
	@Override
	public Page<Results> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Results");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<Results> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Results");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service School_DB for table Results to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "School_DBTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

