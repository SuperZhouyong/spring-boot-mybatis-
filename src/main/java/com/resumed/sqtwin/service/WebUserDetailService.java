package com.resumed.sqtwin.service;
import com.resumed.sqtwin.model.WebUserDetail;
import com.resumed.sqtwin.core.Service;

import java.util.Date;


/**
 * Created by CodeGenerator on 2018/04/13.
 */
public interface WebUserDetailService extends Service<WebUserDetail> {

    void UpdateIconImage(String gid, String icon_image, Date update_date);
}
