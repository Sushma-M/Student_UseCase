/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.student_usecase.studentportal_db.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Qualifier;
import com.student_usecase.studentportal_db.service.StudentPortal_DBQueryExecutorService;
import com.wavemaker.runtime.data.model.CustomQuery;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController(value = "StudentPortal_DB.QueryExecutionController")
@Api(value = "QueryExecutionController", description = "Controller class for query execution")
@RequestMapping("/StudentPortal_DB/queryExecutor")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private StudentPortal_DBQueryExecutorService queryService;

    @ApiOperation(value = "Process request to execute queries")
    @RequestMapping(value = "/queries/SV_AcademicSubjectsByStandard", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Object> executeSV_AcademicSubjectsByStandard(@RequestParam(value = "year", required = false) java.sql.Date year, @RequestParam(value = "standard", required = false) java.lang.String standard, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query SV_AcademicSubjectsByStandard");
        Page<Object> result = queryService.executeSV_AcademicSubjectsByStandard(pageable, year, standard);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @ApiOperation(value = "Process request to execute queries")
    @RequestMapping(value = "/queries/SV_CountOfStudentsInAcademics", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Object> executeSV_CountOfStudentsInAcademics(@RequestParam(value = "standard", required = false) java.lang.String standard, @RequestParam(value = "year", required = false) java.sql.Date year, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query SV_CountOfStudentsInAcademics");
        Page<Object> result = queryService.executeSV_CountOfStudentsInAcademics(pageable, standard, year);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @ApiOperation(value = "Process request to execute queries")
    @RequestMapping(value = "/queries/SV_ResultsByTestID", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Object> executeSV_ResultsByTestID(@RequestParam(value = "T_Name", required = false) java.lang.String T_Name, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query SV_ResultsByTestID");
        Page<Object> result = queryService.executeSV_ResultsByTestID(pageable, T_Name);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @ApiOperation(value = "Process request to execute queries")
    @RequestMapping(value = "/queries/SV_StudentAcademicResults", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Object> executeSV_StudentAcademicResults(@RequestParam(value = "student_id", required = false) java.lang.Integer student_id, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query SV_StudentAcademicResults");
        Page<Object> result = queryService.executeSV_StudentAcademicResults(pageable, student_id);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @ApiOperation(value = "Process request to execute queries")
    @RequestMapping(value = "/queries/SV_TestDetails", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Object> executeSV_TestDetails(Pageable pageable) {
        LOGGER.debug("Executing named query SV_TestDetails");
        Page<Object> result = queryService.executeSV_TestDetails(pageable);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @ApiOperation(value = "Process request to execute queries")
    @RequestMapping(value = "/queries/SV_TestQuery", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Object> executeSV_TestQuery(Pageable pageable) {
        LOGGER.debug("Executing named query SV_TestQuery");
        Page<Object> result = queryService.executeSV_TestQuery(pageable);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @ApiOperation(value = "Process request to execute customer queries")
    @RequestMapping(value = "/queries/wm_custom", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Object> executeWMCustomQuery(@RequestBody CustomQuery query, Pageable pageable) {
        Page<Object> result = queryService.executeWMCustomQuerySelect(query, pageable);
        LOGGER.debug("got the result {}" + result);
        return result;
    }

    @ApiOperation(value = "Process request to execute customer queries")
    @RequestMapping(value = "/queries/wm_custom_update", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public int executeWMCustomQuery(@RequestBody CustomQuery query) {
        int result = queryService.executeWMCustomQueryUpdate(query);
        LOGGER.debug("got the result {}" + result);
        return result;
    }
}
