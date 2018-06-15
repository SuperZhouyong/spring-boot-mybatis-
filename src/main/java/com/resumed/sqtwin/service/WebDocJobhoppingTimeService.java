package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebDocJobhoppingTime;
import com.resumed.sqtwin.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/13.
 */
public interface WebDocJobhoppingTimeService extends Service<WebDocJobhoppingTime> {
    List<WebDocJobhoppingTime> getWebDocJobTimeList( Integer industryid,Integer limit);
}
