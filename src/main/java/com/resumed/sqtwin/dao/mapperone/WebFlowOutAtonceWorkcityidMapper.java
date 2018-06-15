package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceWorkcityid;
import com.resumed.sqtwin.model.responseban.WebFlowOutBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebFlowOutAtonceWorkcityidMapper extends Mapper<WebFlowOutAtonceWorkcityid> {

    @Select("SELECT sum(count) FROM web_flow_out_atonce_workCityId WHERE cityId = #{cityId} AND tplLevel = #{tplLevel} ")
    Double selectNumCountOne(Integer cityId, Integer tplLevel);

    @Select("SELECT sum(count) FROM web_flow_out_atonce_workCityId WHERE cityId = #{cityId}  ")
    Double selectNumCountTwo(Integer cityId);

    @Select("SELECT t.workCityId AS reCityId,r.`name`,ROUND(sum(t.count)/#{sum}*100,1) AS reValue,sum(t.count) AS reCount FROM web_flow_out_atonce_workCityId t INNER JOIN sqtcom.web_region r ON t.workCityId = r.id WHERE t.cityId = #{cityId}  GROUP BY t.workCityId ORDER BY sum(t.count)/#{sum2} DESC  Limit #{limit} ")
    List<WebFlowOutBean> selectRevalueOne(@Param("sum")Double sum,@Param("cityId")Integer cityId , @Param("sum2") Double sumNum2,@Param("limit") Integer limit);

    @Select("SELECT t.workCityId AS reCityId,r.`name`,ROUND(sum(t.count)/#{sum}*100,1) AS reValue,sum(t.count) AS reCount FROM web_flow_out_atonce_workCityId t INNER JOIN sqtcom.web_region r ON t.workCityId = r.id WHERE t.cityId = #{cityId} AND tplLevel = #{tplLevel} GROUP BY t.workCityId ORDER BY sum(t.count)/#{sum2} DESC Limit #{limit} ")
    List<WebFlowOutBean> selectRevalueTwo(@Param("sum")Double sum,@Param("cityId")Integer cityId ,@Param("tplLevel")Integer tplLevel,@Param("sum2")Double sum2,@Param("limit") Integer limit);
}