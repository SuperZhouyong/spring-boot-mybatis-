package com.resumed.sqtwin.model.responseban;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Super
 * @data 2018/4/25 0025
 * @time 上午 11:37
 */
public class WorkExpInfo {
    public List<Integer> getRankLisk() {
        return rankLisk;
    }

    public void setRankLisk(List<Integer> rankLisk) {
        this.rankLisk = rankLisk;
    }

    private List<resumeResultBean> mList = new ArrayList<>();

    private List<Integer> rankLisk = new ArrayList<>();
    //起止时间
    private List<Bean> startEndTime;
    //公司名称
    private List<Bean> companyName;
    //职位名称
    private List<Bean> postionName;
    //工作描述
    private List<Bean> workDesc;
    //综合
    private List<String> allDesc;

    public List<Bean> getStartEndTime() {
        return startEndTime;
    }

    public void setStartEndTime(List<Bean> startEndTime) {
        this.startEndTime = startEndTime;
    }

    public List<Bean> getCompanyName() {
        return companyName;
    }

    public void setCompanyName(List<Bean> companyName) {
        this.companyName = companyName;
    }

    public List<Bean> getPostionName() {
        return postionName;
    }

    public void setPostionName(List<Bean> postionName) {
        this.postionName = postionName;
    }

    public List<Bean> getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(List<Bean> workDesc) {
        this.workDesc = workDesc;
    }

    public List<String> getAllDesc() {
        return allDesc;
    }

    public void setAllDesc(List<String> allDesc) {
        this.allDesc = allDesc;
    }
}
