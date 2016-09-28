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

import com.student_usecase.school_db.AcademicSubjects;
import com.student_usecase.school_db.AcademicSubjectsId;
import com.student_usecase.school_db.AcademicTestSubjects;

/**
 * Service object for domain model class {@link AcademicSubjects}.
 */
public interface AcademicSubjectsService {

    /**
     * Creates a new AcademicSubjects. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AcademicSubjects if any.
     *
     * @param academicSubjects Details of the AcademicSubjects to be created; value cannot be null.
     * @return The newly created AcademicSubjects.
     */
	AcademicSubjects create(AcademicSubjects academicSubjects);


	/**
	 * Returns AcademicSubjects by given id if exists.
	 *
	 * @param academicsubjectsId The id of the AcademicSubjects to get; value cannot be null.
	 * @return AcademicSubjects associated with the given academicsubjectsId.
     * @throws EntityNotFoundException If no AcademicSubjects is found.
	 */
	AcademicSubjects getById(AcademicSubjectsId academicsubjectsId) throws EntityNotFoundException;

    /**
	 * Find and return the AcademicSubjects by given id if exists, returns null otherwise.
	 *
	 * @param academicsubjectsId The id of the AcademicSubjects to get; value cannot be null.
	 * @return AcademicSubjects associated with the given academicsubjectsId.
	 */
	AcademicSubjects findById(AcademicSubjectsId academicsubjectsId);


	/**
	 * Updates the details of an existing AcademicSubjects. It replaces all fields of the existing AcademicSubjects with the given academicSubjects.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on AcademicSubjects if any.
     *
	 * @param academicSubjects The details of the AcademicSubjects to be updated; value cannot be null.
	 * @return The updated AcademicSubjects.
	 * @throws EntityNotFoundException if no AcademicSubjects is found with given input.
	 */
	AcademicSubjects update(AcademicSubjects academicSubjects) throws EntityNotFoundException;

    /**
	 * Deletes an existing AcademicSubjects with the given id.
	 *
	 * @param academicsubjectsId The id of the AcademicSubjects to be deleted; value cannot be null.
	 * @return The deleted AcademicSubjects.
	 * @throws EntityNotFoundException if no AcademicSubjects found with the given id.
	 */
	AcademicSubjects delete(AcademicSubjectsId academicsubjectsId) throws EntityNotFoundException;

	/**
	 * Find all AcademicSubjects matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AcademicSubjects.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<AcademicSubjects> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all AcademicSubjects matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AcademicSubjects.
     *
     * @see Pageable
     * @see Page
	 */
    Page<AcademicSubjects> findAll(String query, Pageable pageable);

    /**
	 * Exports all AcademicSubjects matching the given input query to the given exportType format.
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
	 * Retrieve the count of the AcademicSubjects in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the AcademicSubjects.
	 */
	long count(String query);

    /*
     * Returns the associated academicTestSubjectses for given AcademicSubjects id.
     *
     * @param academicYear value of academicYear; value cannot be null
     * @param standardId value of standardId; value cannot be null
     * @param subjectId value of subjectId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated AcademicTestSubjects instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<AcademicTestSubjects> findAssociatedAcademicTestSubjectses(String academicYear, Integer standardId, Integer subjectId, Pageable pageable);

}

