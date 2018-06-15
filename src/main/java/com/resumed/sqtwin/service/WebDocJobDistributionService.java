package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebDocJobDistribution;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.responseban.WebDocJobDistrBean;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/11.
 */
public interface WebDocJobDistributionService extends Service<WebDocJobDistribution> {

    List<WebDocJobDistrBean> selecIndustryList(Integer industryId,int i);
}
