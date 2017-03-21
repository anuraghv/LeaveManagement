/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.hrdb.service;

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

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.hrdb.models.query.*;

@Service
public class HrdbQueryExecutorServiceImpl implements HrdbQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HrdbQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("hrdbWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Page<PendingVacationRequestsResponse> executePendingVacationRequests(Integer id, Pageable pageable) {
        Map params = new HashMap(1);

        params.put("id", id);

        return queryExecutor.executeNamedQuery("pendingVacationRequests", params, PendingVacationRequestsResponse.class, pageable);
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Downloadable exportPendingVacationRequests(ExportType exportType, Integer id, Pageable pageable) {
        Map params = new HashMap(1);

        params.put("id", id);

        return queryExecutor.exportNamedQueryData("pendingVacationRequests", params, exportType, PendingVacationRequestsResponse.class, pageable);
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Page<CntPendingQueryResponse> executeCntPendingQuery(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("cntPendingQuery", params, CntPendingQueryResponse.class, pageable);
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Downloadable exportCntPendingQuery(ExportType exportType, Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.exportNamedQueryData("cntPendingQuery", params, exportType, CntPendingQueryResponse.class, pageable);
    }

    @Transactional(value = "hrdbTransactionManager")
    @Override
    public Integer executeRejectLeave(RejectLeaveRequest rejectLeaveRequest) {
        Map params = new HashMap(1);

        params.put("id", rejectLeaveRequest.getId());

        return queryExecutor.executeNamedQueryForUpdate("rejectLeave", params);
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Page<VacationRequestsResponse> executeVacationRequests(Integer id, Pageable pageable) {
        Map params = new HashMap(1);

        params.put("id", id);

        return queryExecutor.executeNamedQuery("vacationRequests", params, VacationRequestsResponse.class, pageable);
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Downloadable exportVacationRequests(ExportType exportType, Integer id, Pageable pageable) {
        Map params = new HashMap(1);

        params.put("id", id);

        return queryExecutor.exportNamedQueryData("vacationRequests", params, exportType, VacationRequestsResponse.class, pageable);
    }

    @Transactional(value = "hrdbTransactionManager")
    @Override
    public Integer executeAcceptLeave(AcceptLeaveRequest acceptLeaveRequest) {
        Map params = new HashMap(1);

        params.put("id", acceptLeaveRequest.getId());

        return queryExecutor.executeNamedQueryForUpdate("acceptLeave", params);
    }

}

