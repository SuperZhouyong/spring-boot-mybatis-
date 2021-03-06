package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebResumeHonorMapper;
import com.resumed.sqtwin.model.WebResumeHonor;
import com.resumed.sqtwin.service.WebResumeHonorService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/16.
 */
@Service
@Transactional
public class WebResumeHonorServiceImpl extends AbstractService<WebResumeHonor> implements WebResumeHonorService {
    @Resource
    private WebResumeHonorMapper webResumeHonorMapper;

}
