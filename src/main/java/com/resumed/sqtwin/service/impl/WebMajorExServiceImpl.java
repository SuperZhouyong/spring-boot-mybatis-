package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mappertwo.WebMajorExMapper;
import com.resumed.sqtwin.model.WebMajorEx;
import com.resumed.sqtwin.service.WebMajorExService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/18.
 */
@Service
@Transactional
public class WebMajorExServiceImpl extends AbstractService<WebMajorEx> implements WebMajorExService {
    @Resource
    private WebMajorExMapper webMajorExMapper;

}
