package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebResumeEvalMapper;
import com.resumed.sqtwin.model.WebResumeEval;
import com.resumed.sqtwin.service.WebResumeEvalService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/17.
 */
@Service
@Transactional
public class WebResumeEvalServiceImpl extends AbstractService<WebResumeEval> implements WebResumeEvalService {
    @Resource
    private WebResumeEvalMapper webResumeEvalMapper;

}
