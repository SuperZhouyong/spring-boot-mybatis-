package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebResumeMapper;
import com.resumed.sqtwin.model.WebResume;
import com.resumed.sqtwin.service.WebResumeService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/17.
 */
@Service
@Transactional
public class WebResumeServiceImpl extends AbstractService<WebResume> implements WebResumeService {
    @Resource
    private WebResumeMapper webResumeMapper;


}
