package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebResumeWorkExp;
import com.resumed.sqtwin.model.responseban.WebIndustryListBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebResumeWorkExpMapper extends Mapper<WebResumeWorkExp> {
    @Select("select t.industry_id as id,t4.name as name,ifnull(t3.id,0) as shine from web_resume_work_exp t\n" +
            "inner join web_resume t2 on t.rid=t2.rid\n" +
            "inner join sqtcom.web_industry t4 on t.industry_id=t4.id\n" +
            "left join web_report_history t3 on t.industry_id=t3.reportId and t2.gid=t3.gid and t3.type=1\n" +
            "where t.industry_id>0 and (t2.status=1 or t2.status=8) and t2.gid=#{gid} group by t.industry_id order by t.industry_id asc")
    List<WebIndustryListBean> selectIndustryList(Integer gid);
}