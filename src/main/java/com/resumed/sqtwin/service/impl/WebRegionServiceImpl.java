package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mappertwo.WebRegionMapper;
import com.resumed.sqtwin.model.WebRegion;
import com.resumed.sqtwin.service.WebRegionService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/17.
 */
@Service
@Transactional
public class WebRegionServiceImpl extends AbstractService<WebRegion> implements WebRegionService {
    @Resource
    private WebRegionMapper webRegionMapper;

}
