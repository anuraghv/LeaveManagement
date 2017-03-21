/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.hrdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.hrdb.models.query.*;

public interface HrdbQueryExecutorService {

    Page<PendingVacationRequestsResponse> executePendingVacationRequests(Integer id, Pageable pageable);

    Downloadable exportPendingVacationRequests(ExportType exportType, Integer id, Pageable pageable);

    Page<CntPendingQueryResponse> executeCntPendingQuery(Pageable pageable);

    Downloadable exportCntPendingQuery(ExportType exportType, Pageable pageable);

    Integer executeRejectLeave(RejectLeaveRequest rejectLeaveRequest);

    Page<VacationRequestsResponse> executeVacationRequests(Integer id, Pageable pageable);

    Downloadable exportVacationRequests(ExportType exportType, Integer id, Pageable pageable);

    Integer executeAcceptLeave(AcceptLeaveRequest acceptLeaveRequest);

}


