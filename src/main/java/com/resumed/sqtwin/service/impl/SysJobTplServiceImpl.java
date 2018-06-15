package com.resumed.sqtwin.service.impl;

import com.resumed.sqtwin.dao.mappertwo.SysJobTplMapper;
import com.resumed.sqtwin.model.SysJobTpl;
import com.resumed.sqtwin.service.SysJobTplService;
import com.resumed.sqtwin.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/12.
 */
@Service
@Transactional
public class SysJobTplServiceImpl extends AbstractService<SysJobTpl> implements SysJobTplService {
    @Resource
    private SysJobTplMapper sysJobTplMapper;

    @Override
    public List<SysJobTpl> queryList(Integer gid) {
        return ((SysJobTplMapper)mapper).queryIntention(gid);
    }

 /*   public List<SysJobTpl> queryList(Integer gid) {
        return ((SysJobTplMapper)mapper).queryIntention(gid);
    }*/

}
