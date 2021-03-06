/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.studentportal_db.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.student_usecase.studentportal_db.StudentAcademics;
import com.student_usecase.studentportal_db.StudentAcademicsId;
import com.student_usecase.studentportal_db.service.StudentAcademicsService;

/**
 * Controller object for domain model class StudentAcademics.
 * @see StudentAcademics
 */
@RestController("StudentPortal_DB.StudentAcademicsController")
@Api(value = "StudentAcademicsController", description = "Exposes APIs to work with StudentAcademics resource.")
@RequestMapping("/StudentPortal_DB/StudentAcademics")
public class StudentAcademicsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAcademicsController.class);

    @Autowired
    @Qualifier("StudentPortal_DB.StudentAcademicsService")
    private StudentAcademicsService studentAcademicsService;

    @ApiOperation(value = "Creates a new StudentAcademics instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StudentAcademics createStudentAcademics(@RequestBody StudentAcademics studentAcademics) {
        LOGGER.debug("Create StudentAcademics with information: {}", studentAcademics);
        studentAcademics = studentAcademicsService.create(studentAcademics);
        LOGGER.debug("Created StudentAcademics with information: {}", studentAcademics);
        return studentAcademics;
    }

    @ApiOperation(value = "Returns the StudentAcademics instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StudentAcademics getStudentAcademics(@RequestParam(value = "studentId", required = true) Integer studentId, @RequestParam(value = "academicYear", required = true) Date academicYear, @RequestParam(value = "standard", required = true) String standard) throws EntityNotFoundException {
        StudentAcademicsId studentacademicsId = new StudentAcademicsId();
        studentacademicsId.setStudentId(studentId);
        studentacademicsId.setAcademicYear(academicYear);
        studentacademicsId.setStandard(standard);
        LOGGER.debug("Getting StudentAcademics with id: {}", studentacademicsId);
        StudentAcademics studentAcademics = studentAcademicsService.getById(studentacademicsId);
        LOGGER.debug("StudentAcademics details with id: {}", studentAcademics);
        return studentAcademics;
    }

    @ApiOperation(value = "Updates the StudentAcademics instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StudentAcademics editStudentAcademics(@RequestParam(value = "studentId", required = true) Integer studentId, @RequestParam(value = "academicYear", required = true) Date academicYear, @RequestParam(value = "standard", required = true) String standard, @RequestBody StudentAcademics studentAcademics) throws EntityNotFoundException {
        studentAcademics.setStudentId(studentId);
        studentAcademics.setAcademicYear(academicYear);
        studentAcademics.setStandard(standard);
        LOGGER.debug("StudentAcademics details with id is updated with: {}", studentAcademics);
        return studentAcademicsService.update(studentAcademics);
    }

    @ApiOperation(value = "Deletes the StudentAcademics instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteStudentAcademics(@RequestParam(value = "studentId", required = true) Integer studentId, @RequestParam(value = "academicYear", required = true) Date academicYear, @RequestParam(value = "standard", required = true) String standard) throws EntityNotFoundException {
        StudentAcademicsId studentacademicsId = new StudentAcademicsId();
        studentacademicsId.setStudentId(studentId);
        studentacademicsId.setAcademicYear(academicYear);
        studentacademicsId.setStandard(standard);
        LOGGER.debug("Deleting StudentAcademics with id: {}", studentacademicsId);
        StudentAcademics studentAcademics = studentAcademicsService.delete(studentacademicsId);
        return studentAcademics != null;
    }

    @RequestMapping(value = "/studentId-academicYear-standard-rollNumber", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching StudentAcademics with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StudentAcademics getByStudentIdAndAcademicYearAndStandardAndRollNumber(@RequestParam(value = "null", required = true) int studentId, @RequestParam(value = "null", required = true) Date academicYear, @RequestParam(value = "null", required = true) String standard, @RequestParam(value = "null", required = true) int rollNumber) {
        LOGGER.debug("Getting StudentAcademics with uniques key StudentIdAndAcademicYearAndStandardAndRollNumber");
        return studentAcademicsService.getByStudentIdAndAcademicYearAndStandardAndRollNumber(studentId, academicYear, standard, rollNumber);
    }

    /**
     * @deprecated Use {@link #findStudentAcademics(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of StudentAcademics instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<StudentAcademics> findStudentAcademics(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering StudentAcademics list");
        return studentAcademicsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of StudentAcademics instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<StudentAcademics> findStudentAcademics(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering StudentAcademics list");
        return studentAcademicsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportStudentAcademics(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return studentAcademicsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of StudentAcademics instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countStudentAcademics(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting StudentAcademics");
        return studentAcademicsService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service StudentAcademicsService instance
	 */
    protected void setStudentAcademicsService(StudentAcademicsService service) {
        this.studentAcademicsService = service;
    }
}
