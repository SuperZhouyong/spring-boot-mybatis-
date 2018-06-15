package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebResumeProjectExpMapper;
import com.resumed.sqtwin.model.WebResumeProjectExp;
import com.resumed.sqtwin.service.WebResumeProjectExpService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/11.
 */
@Service
@Transactional
public class WebResumeProjectExpServiceImpl extends AbstractService<WebResumeProjectExp> implements WebResumeProjectExpService {
    @Resource
    private WebResumeProjectExpMapper webResumeProjectExpMapper;

}
