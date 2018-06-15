package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceIndustryid;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceIndustryBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebFlowOutAtonceIndustryidMapper extends Mapper<WebFlowOutAtonceIndustryid> {
    // and tplLevel = 2
    @Select("SELECT industryId,d.name,sum(count) AS count FROM web_flow_out_atonce_industryId as f inner join sqtcom.web_industry as d on f.industryId=d.id WHERE cityId = #{cityId} GROUP BY industryId ORDER BY sum(count) DESC LIMIT #{limit}")
    List<WebFlowOutAtonceIndustryBean> selectIndustryLocaltop(@Param("cityId") Integer cityId,@Param("limit") Integer limit);

    @Select("SELECT industryId,d.name,sum(count) AS count FROM web_flow_out_atonce_industryId as f inner join sqtcom.web_industry as d on f.industryId=d.id WHERE cityId = #{cityId} and tplLevel = #{tplLevel} GROUP BY industryId ORDER BY sum(count) DESC LIMIT #{limit}")
    List<WebFlowOutAtonceIndustryBean> selectIndustryLocaltopTwo(@Param("cityId") Integer cityId,@Param("tplLevel") Integer tplLevel,@Param("limit") Integer limit);

}