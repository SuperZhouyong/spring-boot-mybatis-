package com.resumed.sqtwin.dao.mapperone;

import com.resumed.sqtwin.core.Mapper;
import com.resumed.sqtwin.model.DaDocGenderDistribution;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DaDocGenderDistributionMapper extends Mapper<DaDocGenderDistribution> {
    @Select("select gender,sum(count) as sum from da_doc_gender_distribution where industryId=#{industryId} group by gender")
    List<DaDocGenderDistribution> getSexNum(Integer industryId);
}