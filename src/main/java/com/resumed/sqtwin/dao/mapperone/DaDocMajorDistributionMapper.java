package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.DaDocMajorDistribution;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DaDocMajorDistributionMapper extends Mapper<DaDocMajorDistribution> {
    @Select("select sum(count) as sum from da_doc_major_distribution where industryId=1 and majorId!=0 and majorName!=''order by count desc limit 10")
    Integer selecNum();

    @Select(" select *  from da_doc_major_distribution where industryId=#{industryId} and majorId!=0 and majorName!=''order by count desc limit #{limit}")
    List<DaDocMajorDistribution> selecTenDaDoc(@Param("industryId") Integer industryId,@Param("limit") Integer limit);
}