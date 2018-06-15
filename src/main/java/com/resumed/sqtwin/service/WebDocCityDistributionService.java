package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebDocCityDistribution;
import com.resumed.sqtwin.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/13.
 */
public interface WebDocCityDistributionService extends Service<WebDocCityDistribution> {

    List<WebDocCityDistribution> selectEmployarea(Integer industryid, int i);
}
