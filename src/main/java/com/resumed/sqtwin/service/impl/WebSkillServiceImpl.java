package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mappertwo.WebSkillMapper;
import com.resumed.sqtwin.model.WebSkill;
import com.resumed.sqtwin.service.WebSkillService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/18.
 */
@Service
@Transactional
public class WebSkillServiceImpl extends AbstractService<WebSkill> implements WebSkillService {
    @Resource
    private WebSkillMapper webSkillMapper;

}
