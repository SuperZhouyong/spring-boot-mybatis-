package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebDocJobDistribution;
import com.resumed.sqtwin.model.responseban.WebDocJobDistrBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebDocJobDistributionMapper extends Mapper<WebDocJobDistribution> {

    @Select("select sum(count) as count,tplId,tplName from web_doc_job_distribution where industryId=#{industryId} group by tplId limit #{id}")
    List<WebDocJobDistrBean> selecIndustryList(@Param("industryId") Integer industryId, @Param("id") int id);
}