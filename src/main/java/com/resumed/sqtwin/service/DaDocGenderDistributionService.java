package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.DaDocGenderDistribution;
import com.resumed.sqtwin.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/13.
 */
public interface DaDocGenderDistributionService extends Service<DaDocGenderDistribution> {

    List<DaDocGenderDistribution> getSexNum(Integer industryId);
}
