package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebProfile;
import com.resumed.sqtwin.core.Service;
import com.resumed.sqtwin.model.WebResume;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/16.
 */
public interface WebProfileService extends Service<WebProfile> {
      WebProfile InsertResume();

      List<WebProfile> selectRegionalList(Integer gid);
}
