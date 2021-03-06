package com.resumed.sqtwin.model.responseban;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Super
 * @data 2018/4/25 0025
 * @time 上午 11:37
 */
public class HonorInfo {
    private List<Integer> rankLisk = new ArrayList<>();

    public List<Integer> getRankLisk() {
        return rankLisk;
    }

    public void setRankLisk(List<Integer> rankLisk) {
        this.rankLisk = rankLisk;
    }

    //获取时间
    private List<Bean> obtainTime;
    //授予单位
    private List<Bean> awardedUnit;
    //奖项名称
    private List<Bean> honorName;
    // 综合
    private List<String> allDesc;

    public List<Bean> getObtainTime() {
        return obtainTime;
    }

    public void setObtainTime(List<Bean> obtainTime) {
        this.obtainTime = obtainTime;
    }

    public List<Bean> getAwardedUnit() {
        return awardedUnit;
    }

    public void setAwardedUnit(List<Bean> awardedUnit) {
        this.awardedUnit = awardedUnit;
    }

    public List<Bean> getHonorName() {
        return honorName;
    }

    public void setHonorName(List<Bean> honorName) {
        this.honorName = honorName;
    }

    public List<String> getAllDesc() {
        return allDesc;
    }

    public void setAllDesc(List<String> allDesc) {
        this.allDesc = allDesc;
    }
}
