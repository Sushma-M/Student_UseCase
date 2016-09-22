/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.studentportal_db.service;

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

import com.student_usecase.studentportal_db.AcademicSubjects;
import com.student_usecase.studentportal_db.Subjects;


/**
 * ServiceImpl object for domain model class Subjects.
 *
 * @see Subjects
 */
@Service("StudentPortal_DB.SubjectsService")
public class SubjectsServiceImpl implements SubjectsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectsServiceImpl.class);

    @Autowired
	@Qualifier("StudentPortal_DB.AcademicSubjectsService")
	private AcademicSubjectsService academicSubjectsService;

    @Autowired
    @Qualifier("StudentPortal_DB.SubjectsDao")
    private WMGenericDao<Subjects, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Subjects, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "StudentPortal_DBTransactionManager")
    @Override
	public Subjects create(Subjects subjects) {
        LOGGER.debug("Creating a new Subjects with information: {}", subjects);
        Subjects subjectsCreated = this.wmGenericDao.create(subjects);
        if(subjectsCreated.getAcademicSubjectses() != null) {
            for(AcademicSubjects academicSubjectse : subjectsCreated.getAcademicSubjectses()) {
                academicSubjectse.setSubjects(subjectsCreated);
                LOGGER.debug("Creating a new child AcademicSubjects with information: {}", academicSubjectse);
                academicSubjectsService.create(academicSubjectse);
            }
        }
        return subjectsCreated;
    }

	@Transactional(readOnly = true, value = "StudentPortal_DBTransactionManager")
	@Override
	public Subjects getById(Integer subjectsId) throws EntityNotFoundException {
        LOGGER.debug("Finding Subjects by id: {}", subjectsId);
        Subjects subjects = this.wmGenericDao.findById(subjectsId);
        if (subjects == null){
            LOGGER.debug("No Subjects found with id: {}", subjectsId);
            throw new EntityNotFoundException(String.valueOf(subjectsId));
        }
        return subjects;
    }

    @Transactional(readOnly = true, value = "StudentPortal_DBTransactionManager")
	@Override
	public Subjects findById(Integer subjectsId) {
        LOGGER.debug("Finding Subjects by id: {}", subjectsId);
        return this.wmGenericDao.findById(subjectsId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "StudentPortal_DBTransactionManager")
	@Override
	public Subjects update(Subjects subjects) throws EntityNotFoundException {
        LOGGER.debug("Updating Subjects with information: {}", subjects);
        this.wmGenericDao.update(subjects);

        Integer subjectsId = subjects.getSubjectId();

        return this.wmGenericDao.findById(subjectsId);
    }

    @Transactional(value = "StudentPortal_DBTransactionManager")
	@Override
	public Subjects delete(Integer subjectsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Subjects with id: {}", subjectsId);
        Subjects deleted = this.wmGenericDao.findById(subjectsId);
        if (deleted == null) {
            LOGGER.debug("No Subjects found with id: {}", subjectsId);
            throw new EntityNotFoundException(String.valueOf(subjectsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "StudentPortal_DBTransactionManager")
	@Override
	public Page<Subjects> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Subjects");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "StudentPortal_DBTransactionManager")
    @Override
    public Page<Subjects> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Subjects");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "StudentPortal_DBTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service StudentPortal_DB for table Subjects to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "StudentPortal_DBTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "StudentPortal_DBTransactionManager")
    @Override
    public Page<AcademicSubjects> findAssociatedAcademicSubjectses(Integer subjectId, Pageable pageable) {
        LOGGER.debug("Fetching all associated academicSubjectses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("subjects.subjectId = '" + subjectId + "'");

        return academicSubjectsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AcademicSubjectsService instance
	 */
	protected void setAcademicSubjectsService(AcademicSubjectsService service) {
        this.academicSubjectsService = service;
    }

}
