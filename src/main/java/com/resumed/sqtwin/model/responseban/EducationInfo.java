package com.resumed.sqtwin.model.responseban;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Super
 * @data 2018/4/25 0025
 * @time 上午 11:37
 */
public class EducationInfo {

    public List<Integer> getRankLisk() {
        return rankLisk;
    }

    public void setRankLisk(List<Integer> rankLisk) {
        this.rankLisk = rankLisk;
    }

    private List<Integer> rankLisk = new ArrayList<>();
    //起止时间
    private List<Bean> startEndDate;
    // 学校名字
    private List<Bean> schoolName;
    //专业名字
    private List<Bean> majorName;
    // 综述
    private List<String> allDesc;


//    private List<resumeResultBean>

    public List<Bean> getStartEndDate() {
        return startEndDate;
    }

    public void setStartEndDate(List<Bean> startEndDate) {
        this.startEndDate = startEndDate;
    }

    public List<Bean> getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(List<Bean> schoolName) {
        this.schoolName = schoolName;
    }

    public List<Bean> getMajorName() {
        return majorName;
    }

    public void setMajorName(List<Bean> majorName) {
        this.majorName = majorName;
    }

    public List<String> getAllDesc() {
        return allDesc;
    }

    public void setAllDesc(List<String> allDesc) {
        this.allDesc = allDesc;
    }
}