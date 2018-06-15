package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebFlowOutAtonceNativecityid;
import com.resumed.sqtwin.model.responseban.WebFlowOutAtonceNativecityidBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebFlowOutAtonceNativecityidMapper extends Mapper<WebFlowOutAtonceNativecityid> {
    @Select("  SELECT sum(count) FROM web_flow_out_atonce_nativeCityId WHERE cityId =#{cityId} ")
    Integer slectSumNum(Integer cityId);

    @Select("  SELECT sum(count) FROM web_flow_out_atonce_nativeCityId WHERE cityId =#{cityId} AND tplLevel =#{tplLevel} ")
    Integer selectSumNumTwo(@Param("cityId") Integer cityId, @Param("tplLevel") Integer tplLevel);

    @Select("SELECT nativeCityId AS reCityId,r.name,ROUND(sum(count)/#{sumNum}*100,1) AS reValue,sum(count) AS reCount FROM web_flow_out_atonce_nativeCityId as f inner join sqtcom.web_region as r on f.nativeCityId=r.id WHERE cityId =#{cityId}  GROUP BY nativeCityId ORDER BY sum(count)/#{sumNum} DESC  limit #{limit}")
    List<WebFlowOutAtonceNativecityidBean> selectRevalueOne(@Param("sumNum") Integer sumNum, @Param("cityId") Integer cityId,@Param("limit") Integer limit);

    @Select("SELECT nativeCityId AS reCityId,r.name,ROUND(sum(count)/#{sumNum}*100,1) AS reValue,sum(count) AS reCount FROM web_flow_out_atonce_nativeCityId as f inner join sqtcom.web_region as r on f.nativeCityId=r.id WHERE cityId =#{cityId} AND tplLevel =#{tplLevel} GROUP BY nativeCityId ORDER BY sum(count)/#{sumNum} DESC  limit #{limit}")
    List<WebFlowOutAtonceNativecityidBean> selectRevalueTwo(@Param("sumNum") Integer sumNum, @Param("cityId") Integer cityId, @Param("tplLevel") Integer tplLevel,@Param("limit") Integer limit);
}