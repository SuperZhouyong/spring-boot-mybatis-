package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebReportHistoryMapper;
import com.resumed.sqtwin.model.WebReportHistory;
import com.resumed.sqtwin.service.WebReportHistoryService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/11.
 */
@Service
@Transactional
public class WebReportHistoryServiceImpl extends AbstractService<WebReportHistory> implements WebReportHistoryService {
    @Resource
    private WebReportHistoryMapper webReportHistoryMapper;

}
