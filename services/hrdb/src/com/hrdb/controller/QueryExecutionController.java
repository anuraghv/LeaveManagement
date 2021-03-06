/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.hrdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.hrdb.service.HrdbQueryExecutorService;
import com.hrdb.models.query.*;

@RestController(value = "Hrdb.QueryExecutionController")
@RequestMapping("/hrdb/queryExecutor")
@Api(value = "QueryExecutionController", description = "controller class for query execution")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private HrdbQueryExecutorService queryService;

    @RequestMapping(value = "/queries/pendingVacationRequests", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "No description is provided")
    public Page<PendingVacationRequestsResponse> executePendingVacationRequests(@RequestParam(value = "id", required = false) Integer id, Pageable pageable) {
        LOGGER.debug("Executing named query: pendingVacationRequests");
        Page<PendingVacationRequestsResponse> _result = queryService.executePendingVacationRequests(id, pageable);
        LOGGER.debug("got the result for named query: pendingVacationRequests, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query pendingVacationRequests")
    @RequestMapping(value = "/queries/pendingVacationRequests/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPendingVacationRequests(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "id", required = false) Integer id, Pageable pageable) {
        LOGGER.debug("Exporting named query: pendingVacationRequests");

        return queryService.exportPendingVacationRequests(exportType, id, pageable);
    }

    @RequestMapping(value = "/queries/cntPendingQuery", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "No description is provided")
    public Page<CntPendingQueryResponse> executeCntPendingQuery(Pageable pageable) {
        LOGGER.debug("Executing named query: cntPendingQuery");
        Page<CntPendingQueryResponse> _result = queryService.executeCntPendingQuery(pageable);
        LOGGER.debug("got the result for named query: cntPendingQuery, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query cntPendingQuery")
    @RequestMapping(value = "/queries/cntPendingQuery/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCntPendingQuery(@PathVariable("exportType") ExportType exportType, Pageable pageable) {
        LOGGER.debug("Exporting named query: cntPendingQuery");

        return queryService.exportCntPendingQuery(exportType, pageable);
    }

    @RequestMapping(value = "/queries/rejectLeave", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "No description is provided")
    public Integer executeRejectLeave(@Valid @RequestBody RejectLeaveRequest rejectLeaveRequest) {
        LOGGER.debug("Executing named query: rejectLeave");
        Integer _result = queryService.executeRejectLeave(rejectLeaveRequest);
        LOGGER.debug("got the result for named query: rejectLeave, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/queries/vacationRequests", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "No description is provided")
    public Page<VacationRequestsResponse> executeVacationRequests(@RequestParam(value = "id", required = false) Integer id, Pageable pageable) {
        LOGGER.debug("Executing named query: vacationRequests");
        Page<VacationRequestsResponse> _result = queryService.executeVacationRequests(id, pageable);
        LOGGER.debug("got the result for named query: vacationRequests, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query vacationRequests")
    @RequestMapping(value = "/queries/vacationRequests/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportVacationRequests(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "id", required = false) Integer id, Pageable pageable) {
        LOGGER.debug("Exporting named query: vacationRequests");

        return queryService.exportVacationRequests(exportType, id, pageable);
    }

    @RequestMapping(value = "/queries/acceptLeave", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "No description is provided")
    public Integer executeAcceptLeave(@Valid @RequestBody AcceptLeaveRequest acceptLeaveRequest) {
        LOGGER.debug("Executing named query: acceptLeave");
        Integer _result = queryService.executeAcceptLeave(acceptLeaveRequest);
        LOGGER.debug("got the result for named query: acceptLeave, result:{}", _result);
        return _result;
    }

}


