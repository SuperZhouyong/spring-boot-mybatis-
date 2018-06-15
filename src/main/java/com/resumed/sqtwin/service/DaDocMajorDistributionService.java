package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.DaDocMajorDistribution;
import com.resumed.sqtwin.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/13.
 */
public interface DaDocMajorDistributionService extends Service<DaDocMajorDistribution> {
     Integer selectNum();
     List<DaDocMajorDistribution> selecTenDaDoc(Integer industry,Integer limit);
}
