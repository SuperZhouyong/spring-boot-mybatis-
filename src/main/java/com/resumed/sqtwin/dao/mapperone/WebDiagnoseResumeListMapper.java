package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebDiagnoseResumeList;
import com.resumed.sqtwin.model.responseban.WebIndustryListBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebDiagnoseResumeListMapper extends Mapper<WebDiagnoseResumeList> {
    @Select("select t.intension_industry as id,t3.name as name,ifnull(t4.id,0) as shine from web_diagnose_resume_list t\n" +
            "inner join web_resume t2 on t.rid=t2.rid\n" +
            "inner join sqtcom.web_industry t3 on t.intension_industry=t3.id\n" +
            "left join web_report_history t4 on t.intension_industry=t4.reportId and t2.gid=t4.gid and t4.type=1\n" +
            "where t.intension_industry is not null and (t2.status=1 or t2.status=8) and t2.gid=#{gid} group by t.intension_industry order by t.intension_industry asc")
    List<WebIndustryListBean> selecIndustryList(Integer gid);
}