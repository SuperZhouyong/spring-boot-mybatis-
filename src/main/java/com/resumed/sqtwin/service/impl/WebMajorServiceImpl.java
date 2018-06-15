package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mappertwo.WebMajorMapper;
import com.resumed.sqtwin.model.WebMajor;
import com.resumed.sqtwin.service.WebMajorService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/18.
 */
@Service
@Transactional
public class WebMajorServiceImpl extends AbstractService<WebMajor> implements WebMajorService {
    @Resource
    private WebMajorMapper webMajorMapper;

}
