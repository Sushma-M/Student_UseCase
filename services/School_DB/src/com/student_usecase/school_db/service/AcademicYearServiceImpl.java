/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.school_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

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

import com.student_usecase.school_db.AcademicYear;
import com.student_usecase.school_db.Academics;


/**
 * ServiceImpl object for domain model class AcademicYear.
 *
 * @see AcademicYear
 */
@Service("School_DB.AcademicYearService")
public class AcademicYearServiceImpl implements AcademicYearService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcademicYearServiceImpl.class);

    @Autowired
	@Qualifier("School_DB.AcademicsService")
	private AcademicsService academicsService;

    @Autowired
    @Qualifier("School_DB.AcademicYearDao")
    private WMGenericDao<AcademicYear, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AcademicYear, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
	public AcademicYear create(AcademicYear academicYearInstance) {
        LOGGER.debug("Creating a new AcademicYear with information: {}", academicYearInstance);
        AcademicYear academicYearInstanceCreated = this.wmGenericDao.create(academicYearInstance);
        if(academicYearInstanceCreated.getAcademicses() != null) {
            for(Academics academicse : academicYearInstanceCreated.getAcademicses()) {
                academicse.setAcademicYearByAcademicYear(academicYearInstanceCreated);
                LOGGER.debug("Creating a new child Academics with information: {}", academicse);
                academicsService.create(academicse);
            }
        }
        return academicYearInstanceCreated;
    }

	@Transactional(readOnly = true, value = "School_DBTransactionManager")
	@Override
	public AcademicYear getById(String academicyearId) throws EntityNotFoundException {
        LOGGER.debug("Finding AcademicYear by id: {}", academicyearId);
        AcademicYear academicYearInstance = this.wmGenericDao.findById(academicyearId);
        if (academicYearInstance == null){
            LOGGER.debug("No AcademicYear found with id: {}", academicyearId);
            throw new EntityNotFoundException(String.valueOf(academicyearId));
        }
        return academicYearInstance;
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
	@Override
	public AcademicYear findById(String academicyearId) {
        LOGGER.debug("Finding AcademicYear by id: {}", academicyearId);
        return this.wmGenericDao.findById(academicyearId);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public AcademicYear getByStartYear(int startYear) {
        Map<String, Object> startYearMap = new HashMap<>();
        startYearMap.put("startYear", startYear);

        LOGGER.debug("Finding AcademicYear by unique keys: {}", startYearMap);
        AcademicYear academicYearInstance = this.wmGenericDao.findByUniqueKey(startYearMap);

        if (academicYearInstance == null){
            LOGGER.debug("No AcademicYear found with given unique key values: {}", startYearMap);
            throw new EntityNotFoundException(String.valueOf(startYearMap));
        }

        return academicYearInstance;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "School_DBTransactionManager")
	@Override
	public AcademicYear update(AcademicYear academicYearInstance) throws EntityNotFoundException {
        LOGGER.debug("Updating AcademicYear with information: {}", academicYearInstance);
        this.wmGenericDao.update(academicYearInstance);

        String academicyearId = academicYearInstance.getAcademicYear();

        return this.wmGenericDao.findById(academicyearId);
    }

    @Transactional(value = "School_DBTransactionManager")
	@Override
	public AcademicYear delete(String academicyearId) throws EntityNotFoundException {
        LOGGER.debug("Deleting AcademicYear with id: {}", academicyearId);
        AcademicYear deleted = this.wmGenericDao.findById(academicyearId);
        if (deleted == null) {
            LOGGER.debug("No AcademicYear found with id: {}", academicyearId);
            throw new EntityNotFoundException(String.valueOf(academicyearId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "School_DBTransactionManager")
	@Override
	public Page<AcademicYear> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all AcademicYears");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<AcademicYear> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all AcademicYears");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service School_DB for table AcademicYear to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "School_DBTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<Academics> findAssociatedAcademicses(String academicYear, Pageable pageable) {
        LOGGER.debug("Fetching all associated academicses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("academicYearByAcademicYear.academicYear = '" + academicYear + "'");

        return academicsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AcademicsService instance
	 */
	protected void setAcademicsService(AcademicsService service) {
        this.academicsService = service;
    }

}

