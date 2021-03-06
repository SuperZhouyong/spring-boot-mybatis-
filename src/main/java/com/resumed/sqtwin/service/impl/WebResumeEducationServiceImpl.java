package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebResumeEducationMapper;
import com.resumed.sqtwin.model.WebResumeEducation;
import com.resumed.sqtwin.service.WebResumeEducationService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/16.
 */
@Service
@Transactional
public class WebResumeEducationServiceImpl extends AbstractService<WebResumeEducation> implements WebResumeEducationService {
    @Resource
    private WebResumeEducationMapper webResumeEducationMapper;

}
