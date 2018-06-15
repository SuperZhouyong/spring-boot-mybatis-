package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.DaDocWorkingHoursDistributionMapper;
import com.resumed.sqtwin.model.DaDocWorkingHoursDistribution;
import com.resumed.sqtwin.service.DaDocWorkingHoursDistributionService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/13.
 */
@Service
@Transactional
public class DaDocWorkingHoursDistributionServiceImpl extends AbstractService<DaDocWorkingHoursDistribution> implements DaDocWorkingHoursDistributionService {
    @Resource
    private DaDocWorkingHoursDistributionMapper daDocWorkingHoursDistributionMapper;

}
