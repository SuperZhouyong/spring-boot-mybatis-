package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebElectronicResumeMapper;
import com.resumed.sqtwin.model.WebElectronicResume;
import com.resumed.sqtwin.service.WebElectronicResumeService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/24.
 */
@Service
@Transactional
public class WebElectronicResumeServiceImpl extends AbstractService<WebElectronicResume> implements WebElectronicResumeService {
    @Resource
    private WebElectronicResumeMapper webElectronicResumeMapper;

}
