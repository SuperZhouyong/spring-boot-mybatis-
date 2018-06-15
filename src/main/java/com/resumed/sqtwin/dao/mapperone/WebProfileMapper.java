package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebProfile;
import com.resumed.sqtwin.model.WebResume;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebProfileMapper extends Mapper<WebProfile> {

    @Select("SELECT t.intentioncity,t.intentioncityid FROM web_profile t INNER JOIN web_resume t2 ON t.rid = t2.rid WHERE t.gid = #{gid} AND (t2. STATUS = 1 OR t2. STATUS = 8) AND t.intentioncity != '' AND t.intentioncityid != '' AND t.intentioncity IS NOT NULL AND t.intentioncityid IS NOT NULL ORDER BY t2.updateTime DESC")
    List<WebProfile> selectRegionalList(Integer gid);
}