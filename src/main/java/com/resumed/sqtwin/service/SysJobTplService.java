package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.SysJobTpl;
import com.resumed.sqtwin.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/12.
 */
public interface SysJobTplService extends Service<SysJobTpl> {

    List<SysJobTpl> queryList(Integer gid);
}
