package com.resumed.sqtwin.model.responseban;

import java.util.List;

/**
 * @auther Super
 * @data 2018/4/17 0017
 * @time 下午 16:39
 */
public class filterResponse {
    //个人信息模块
    private PersonalInfo personalInfo;
    //教育经历模块
    private EducationExp educationExp;
    // 工作经历模块
    private WorkExp workExp;
    // 擅长技能模块
    private GoodSkill goodSkill;

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public EducationExp getEducationExp() {
        return educationExp;
    }

    public void setEducationExp(EducationExp educationExp) {
        this.educationExp = educationExp;
    }

    public WorkExp getWorkExp() {
        return workExp;
    }

    public void setWorkExp(WorkExp workExp) {
        this.workExp = workExp;
    }

    public GoodSkill getGoodSkill() {
        return goodSkill;
    }

    public void setGoodSkill(GoodSkill goodSkill) {
        this.goodSkill = goodSkill;
    }



    public static class PersonalInfo {
        // 工作状态
        private List<Bean> work;

        //期望月薪
        private List<Bean> salary;


        //婚姻状态
        private List<Bean> marriage;

        public List<Bean> getWork() {
            return work;
        }

        public void setWork(List<Bean> work) {
            this.work = work;
        }

        public List<Bean> getSalary() {
            return salary;
        }

        public void setSalary(List<Bean> salary) {
            this.salary = salary;
        }

        public List<Bean> getMarriage() {
            return marriage;
        }

        public void setMarriage(List<Bean> marriage) {
            this.marriage = marriage;
        }
    }

    public static class EducationExp {
        //学历信息
        private List<Bean> education;

        public List<Bean> getEducation() {
            return education;
        }

        public void setEducation(List<Bean> education) {
            this.education = education;
        }
    }

    public static class WorkExp {
        //企业规模
        private List<Bean> enterpriseScale;
        //企业性质
        private List<Bean> enterpriseNature;
        //期望月薪
        private List<Bean> salaryWork;

        public List<Bean> getEnterpriseScale() {
            return enterpriseScale;
        }

        public void setEnterpriseScale(List<Bean> enterpriseScale) {
            this.enterpriseScale = enterpriseScale;
        }

        public List<Bean> getEnterpriseNature() {
            return enterpriseNature;
        }

        public void setEnterpriseNature(List<Bean> enterpriseNature) {
            this.enterpriseNature = enterpriseNature;
        }

        public List<Bean> getSalaryWork() {
            return salaryWork;
        }

        public void setSalaryWork(List<Bean> salaryWork) {
            this.salaryWork = salaryWork;
        }
    }

    public static class GoodSkill {
        //熟练度 技能
        private List<Bean> proficiency;

        public List<Bean> getProficiency() {
            return proficiency;
        }

        public void setProficiency(List<Bean> proficiency) {
            this.proficiency = proficiency;
        }
    }
}
