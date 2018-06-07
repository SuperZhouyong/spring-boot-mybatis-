package com.resumed.sqtwin.model.requestbean;

/**
 * @auther Super
 * @data 2018/4/17 0017
 * @time 上午 10:12
 */
public class ProjectExpRequest {
    /*
    * 	"describe": ""
								"endTime":"",
								"projectContent":"",// 项目内容
								"projectName":""	//项目名称
								"projectPostion"    //项目职位
								"startTime":""
    * */
    private String describe;
    private String endTime;
    private String projectContent;
    private String projectName;
    private String projectPostion;
    private String startTime;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectPostion() {
        return projectPostion;
    }

    public void setProjectPostion(String projectPostion) {
        this.projectPostion = projectPostion;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
