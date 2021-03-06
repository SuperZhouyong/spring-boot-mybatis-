package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mapperone.WebMsgMapMapper;
import com.resumed.sqtwin.model.WebMsgMap;
import com.resumed.sqtwin.service.WebMsgMapService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/19.
 */
@Service
@Transactional
public class WebMsgMapServiceImpl extends AbstractService<WebMsgMap> implements WebMsgMapService {
    @Resource
    private WebMsgMapMapper webMsgMapMapper;

}
