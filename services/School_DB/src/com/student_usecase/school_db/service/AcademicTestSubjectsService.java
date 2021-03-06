/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.school_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.student_usecase.school_db.AcademicTestSubjects;
import com.student_usecase.school_db.AcademicTestSubjectsId;
import com.student_usecase.school_db.Results;

/**
 * Service object for domain model class {@link AcademicTestSubjects}.
 */
public interface AcademicTestSubjectsService {

    /**
     * Creates a new AcademicTestSubjects. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AcademicTestSubjects if any.
     *
     * @param academicTestSubjects Details of the AcademicTestSubjects to be created; value cannot be null.
     * @return The newly created AcademicTestSubjects.
     */
	AcademicTestSubjects create(AcademicTestSubjects academicTestSubjects);


	/**
	 * Returns AcademicTestSubjects by given id if exists.
	 *
	 * @param academictestsubjectsId The id of the AcademicTestSubjects to get; value cannot be null.
	 * @return AcademicTestSubjects associated with the given academictestsubjectsId.
     * @throws EntityNotFoundException If no AcademicTestSubjects is found.
	 */
	AcademicTestSubjects getById(AcademicTestSubjectsId academictestsubjectsId) throws EntityNotFoundException;

    /**
	 * Find and return the AcademicTestSubjects by given id if exists, returns null otherwise.
	 *
	 * @param academictestsubjectsId The id of the AcademicTestSubjects to get; value cannot be null.
	 * @return AcademicTestSubjects associated with the given academictestsubjectsId.
	 */
	AcademicTestSubjects findById(AcademicTestSubjectsId academictestsubjectsId);


	/**
	 * Updates the details of an existing AcademicTestSubjects. It replaces all fields of the existing AcademicTestSubjects with the given academicTestSubjects.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on AcademicTestSubjects if any.
     *
	 * @param academicTestSubjects The details of the AcademicTestSubjects to be updated; value cannot be null.
	 * @return The updated AcademicTestSubjects.
	 * @throws EntityNotFoundException if no AcademicTestSubjects is found with given input.
	 */
	AcademicTestSubjects update(AcademicTestSubjects academicTestSubjects) throws EntityNotFoundException;

    /**
	 * Deletes an existing AcademicTestSubjects with the given id.
	 *
	 * @param academictestsubjectsId The id of the AcademicTestSubjects to be deleted; value cannot be null.
	 * @return The deleted AcademicTestSubjects.
	 * @throws EntityNotFoundException if no AcademicTestSubjects found with the given id.
	 */
	AcademicTestSubjects delete(AcademicTestSubjectsId academictestsubjectsId) throws EntityNotFoundException;

	/**
	 * Find all AcademicTestSubjects matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AcademicTestSubjects.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<AcademicTestSubjects> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all AcademicTestSubjects matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AcademicTestSubjects.
     *
     * @see Pageable
     * @see Page
	 */
    Page<AcademicTestSubjects> findAll(String query, Pageable pageable);

    /**
	 * Exports all AcademicTestSubjects matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the AcademicTestSubjects in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the AcademicTestSubjects.
	 */
	long count(String query);

    /*
     * Returns the associated resultses for given AcademicTestSubjects id.
     *
     * @param academicYear value of academicYear; value cannot be null
     * @param standardId value of standardId; value cannot be null
     * @param testId value of testId; value cannot be null
     * @param subjectId value of subjectId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Results instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Results> findAssociatedResultses(String academicYear, Integer standardId, Integer testId, Integer subjectId, Pageable pageable);

}

