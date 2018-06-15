package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mappertwo.DaITplMapper;
import com.resumed.sqtwin.model.DaITpl;
import com.resumed.sqtwin.service.DaITplService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/13.
 */
@Service
@Transactional
public class DaITplServiceImpl extends AbstractService<DaITpl> implements DaITplService {
    @Resource
    private DaITplMapper daITplMapper;

}
