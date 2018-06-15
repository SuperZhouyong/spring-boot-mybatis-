package com.resumed.sqtwin.dao.mappertwo;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.SysJobTpl;

import java.util.List;

public interface SysJobTplMapper extends Mapper<SysJobTpl> {

    List<SysJobTpl> queryIntention(Integer gid);

}