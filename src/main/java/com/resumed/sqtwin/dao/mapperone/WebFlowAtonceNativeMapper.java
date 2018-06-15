package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.WebFlowAtonceNative;
import com.resumed.sqtwin.model.responseban.WebFlowAtonceNativeBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WebFlowAtonceNativeMapper extends Mapper<WebFlowAtonceNative> {


    @Select("  SELECT sum(count) FROM web_flow_atonce_native WHERE provinceId =#{cityId} ")
    Integer slectSumNum(Integer cityId);

    @Select("  SELECT sum(count) FROM web_flow_atonce_native WHERE provinceId =#{cityId} AND tplLevel =#{tplLevel} ")
    Integer slectSumNumTwo(@Param("cityId") Integer cityId, @Param("tplLevel") Integer tplLevel);

    @Select("SELECT provinceId AS reCityId,r.name,ROUND(sum(count)/#{sumNum}*100,1) AS reValue,sum(count) AS reCount FROM web_flow_atonce_native as f inner join sqtcom.web_region as r on f.provinceId=r.id WHERE provinceId =#{cityId}  GROUP BY provinceId ORDER BY sum(count)/#{sumNum} DESC  limit 10")
    List<WebFlowAtonceNativeBean> selectRevalueOne(@Param("sumNum") Integer sumNum, @Param("cityId") Integer cityId,@Param("limit") Integer limit);

    @Select("SELECT provinceId AS reCityId,r.name,ROUND(sum(count)/#{sumNum}*100,1) AS reValue,sum(count) AS reCount FROM web_flow_atonce_native as f inner join sqtcom.web_region as r on f.provinceId=r.id WHERE provinceId =#{cityId} AND tplLevel =#{tplLevel} GROUP BY provinceId ORDER BY sum(count)/#{sumNum} DESC  limit 10")
    List<WebFlowAtonceNativeBean> selectRevalueTwo(@Param("sumNum") Integer sumNum, @Param("cityId") Integer cityId, @Param("tplLevel") Integer tplLevel,@Param("limit") Integer limit);

}