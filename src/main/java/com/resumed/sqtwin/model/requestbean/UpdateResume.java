package com.resumed.sqtwin.model.requestbean;

import com.resumed.sqtwin.model.*;

import java.util.List;

/**
 * @auther Super
 * @data 2018/4/16 0016
 * @time 下午 19:28
 */
public class UpdateResume {


    private int gid;

    private String resumeTitle;

    private String rid;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    // 个人信息
    private WebProfile webProfile;
    //教育经历
    private List<WebResumeEducation> webResumeEducation;
    //工作经验
    private List<WebResumeWorkExp> webResumeWorkExp;
    // 项目经验
    private List<WebResumeProjectExp> webResumeProjectExp;
    //擅长技能
    private List<WebResumeSkill> webResumeSkill;
    //荣誉
    private List<WebResumeHonor> webResumeHonor;
    // 证书
    private List<WebResumeCertificate> webResumeCertificate;

    public String getResumeTitle() {
        return resumeTitle;
    }

    public void setResumeTitle(String resumeTitle) {
        this.resumeTitle = resumeTitle;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public WebProfile getWebProfile() {
        return webProfile;
    }

    public void setWebProfile(WebProfile webProfile) {
        this.webProfile = webProfile;
    }

    public List<WebResumeEducation> getWebResumeEducation() {
        return webResumeEducation;
    }

    public void setWebResumeEducation(List<WebResumeEducation> webResumeEducation) {
        this.webResumeEducation = webResumeEducation;
    }

    public List<WebResumeWorkExp> getWebResumeWorkExp() {
        return webResumeWorkExp;
    }

    public void setWebResumeWorkExp(List<WebResumeWorkExp> webResumeWorkExp) {
        this.webResumeWorkExp = webResumeWorkExp;
    }

    public List<WebResumeProjectExp> getWebResumeProjectExp() {
        return webResumeProjectExp;
    }

    public void setWebResumeProjectExp(List<WebResumeProjectExp> webResumeProjectExp) {
        this.webResumeProjectExp = webResumeProjectExp;
    }

    public List<WebResumeSkill> getWebResumeSkill() {
        return webResumeSkill;
    }

    public void setWebResumeSkill(List<WebResumeSkill> webResumeSkill) {
        this.webResumeSkill = webResumeSkill;
    }

    public List<WebResumeHonor> getWebResumeHonor() {
        return webResumeHonor;
    }

    public void setWebResumeHonor(List<WebResumeHonor> webResumeHonor) {
        this.webResumeHonor = webResumeHonor;
    }

    public List<WebResumeCertificate> getWebResumeCertificate() {
        return webResumeCertificate;
    }

    public void setWebResumeCertificate(List<WebResumeCertificate> webResumeCertificate) {
        this.webResumeCertificate = webResumeCertificate;
    }


}
