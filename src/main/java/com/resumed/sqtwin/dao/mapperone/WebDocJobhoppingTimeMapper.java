package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebDocJobhoppingTime;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebDocJobhoppingTimeMapper extends Mapper<WebDocJobhoppingTime> {
    @Select("Select t.functionId,t.functionName,ceil(sum(t.jobHoppingTime)/count(t.id))as value,t2.industryId as industryId from web_doc_jobhopping_time t left join web_doc_jobhopping_time_industry_ten t2 on t.functionId=t2.functionId and t.industryId=t2.industryId where t.industryId=#{industryid} and t.functionName!='其他' and (t.tplLevel =1 || t.tplLevel=2) group by t.functionId order by industryId desc,value desc limit #{limit}\n")
    List<WebDocJobhoppingTime> getWebDocJobTimeList(@Param("industryid") Integer industryid, @Param("limit") Integer limit);
}