package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebResumeSkillMapper;
import com.resumed.sqtwin.model.WebResumeSkill;
import com.resumed.sqtwin.service.WebResumeSkillService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/16.
 */
@Service
@Transactional
public class WebResumeSkillServiceImpl extends AbstractService<WebResumeSkill> implements WebResumeSkillService {
    @Resource
    private WebResumeSkillMapper webResumeSkillMapper;

}
