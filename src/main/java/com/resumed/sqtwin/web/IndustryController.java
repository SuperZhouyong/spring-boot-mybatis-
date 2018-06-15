package com.resumed.sqtwin.web;

import com.alibaba.fastjson.JSON;
import com.resumed.sqtwin.configurer.DS;
import com.resumed.sqtwin.configurer.DataSourceContextHolder;
import com.resumed.sqtwin.configurer.RedisTempOne;
import com.resumed.sqtwin.configurer.RedisTempTwo;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.*;
import com.resumed.sqtwin.model.responseban.*;
import com.resumed.sqtwin.service.*;
import com.resumed.sqtwin.utils.AppConstant;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @auther Super
 * @data 2018/4/18 0018
 * @time 下午 17:35
 */
@RestController
@RequestMapping("/web/industry")
public class IndustryController {
    @Resource
    private WebIndustryService webIndustryService;
    @Resource
    private WebRegionService webRegionService;
    @Resource
    private WebSchoolService webSchoolService;
    @Resource
    private WebMajorService webMajorService;
    @Resource
    private WebCompanyListService webCompanyListService;
    @Resource
    private WebSkillService webSkillService;
    @Resource
    private WebCertificateService webCertificateService;
    // 行业Id
    @Resource
    private SysJobIndustryTplService sysJobIndustryTplService;
    @Resource
    private SysJobTplService sysJobTplService;

    @Resource
    private WebResumeWorkExpService webResumeWorkExpService;

    @Resource
    private WebTplVisitNumService webTplVisitNumService;

    @Resource
    private RedisTempTwo redisTempTwo;

    @Resource
    private RedisTempOne redisTempOne;

    private final Logger logger = LoggerFactory.getLogger(IndustryController.class);

    @DS(DataSourceContextHolder.One)
    @PostMapping("/postionDesc")
    public Result getPostionDesc(@RequestParam(name = "tplId") Integer tplID, HttpServletRequest httpServletRequest) throws IOException {
      /*  Condition condition = new Condition(WebResumeWorkExp.class);
        condition.createCriteria().andCondition("rid  = " + rid);
        List<WebResumeWorkExp> byCondition = webResumeWorkExpService.findByCondition(condition);*/
        String id = httpServletRequest.getSession().getId();

        if (redisTempOne.get("sessionId") == null) {
            redisTempOne.set("sessionId", httpServletRequest.getSession().getId(), 216000l);
            String s = selectDate(tplID, id);
            logger.info("     ssssssss   " + s);
            if (StringUtils.isEmpty(s)) {
                return ResultGenerator.genFailResult("暂无此职业描述");
            }
            return ResultGenerator.genSuccessResult(JSON.toJSON(s));
        } else {
            Condition condition = new Condition(WebTplVisitNum.class);
            condition.createCriteria().andCondition("host = '" + id + "'");
            List<WebTplVisitNum> byCondition = webTplVisitNumService.findByCondition(condition);
            if (byCondition.size() < 50) {
                String s = selectDate(tplID, id);
                if (StringUtils.isEmpty(s)) {
                    return ResultGenerator.genFailResult("暂无此职业描述");
                }
                return ResultGenerator.genSuccessResult(JSON.parse(s));
            } else {
                return ResultGenerator.genFailResult("查看已达上限---------" + id);
            }
        }

    }

    public String unescapeJava(String str) throws IOException {
        Writer out = new StringWriter();
        if (str != null) {
            int sz = str.length();
            StringBuilder unicode = new StringBuilder(4);
            boolean hadSlash = false;
            boolean inUnicode = false;

            for (int i = 0; i < sz; ++i) {
                char ch = str.charAt(i);
                if (inUnicode) {
                    unicode.append(ch);
                    if (unicode.length() == 4) {
                        try {
                            int nfe = Integer.parseInt(unicode.toString(), 16);
                            out.write((char) nfe);
                            unicode.setLength(0);
                            inUnicode = false;
                            hadSlash = false;
                        } catch (NumberFormatException var9) {
                        }
                    }
                } else if (hadSlash) {
                    hadSlash = false;
                    switch (ch) {
                        case '\"':
                            out.write(34);
                            break;
                        case '\'':
                            out.write(39);
                            break;
                        case '\\':
                            out.write(92);
                            break;
                        case 'b':
                            out.write(8);
                            break;
                        case 'f':
                            out.write(12);
                            break;
                        case 'n':
                            out.write(10);
                            break;
                        case 'r':
                            out.write(13);
                            break;
                        case 't':
                            out.write(9);
                            break;
                        case 'u':
                            inUnicode = true;
                            break;
                        default:
                            out.write(ch);
                    }
                } else if (ch == 92) {
                    hadSlash = true;
                } else {
                    out.write(ch);
                }
            }

            if (hadSlash) {
                out.write(92);
            }

        }
        return out.toString();
    }

    private String selectDate(@RequestParam(name = "tplId") Integer tplID, String id) {
        WebTplVisitNum webTplVisitNum = new WebTplVisitNum();
        webTplVisitNum.setAt(new Date());
        webTplVisitNum.setHost(id);
        webTplVisitNum.setTplid(tplID);
        webTplVisitNum.setNum((byte) 1);
        webTplVisitNumService.save(webTplVisitNum);

        return (String) redisTempTwo.get("TplInfo_id_" + String.valueOf(tplID));
    }


    //, @RequestParam(required = false) String postionName
    @DS(DataSourceContextHolder.Two)
    @PostMapping("/reminder")
    public Result getschoolreminder(@RequestParam String name, @RequestParam(defaultValue = "0") Integer type, @RequestParam(required = false, defaultValue = "0") Integer industryId) {
        if (StringUtils.isEmpty(name))
            return ResultGenerator.genFailResult("请输入内容");
        Condition condition;
        ArrayList<Bean> beans = new ArrayList<>();
        switch (type) {
            // 学校名称
            case 1:
                condition = new Condition(WebSchool.class);
                condition.createCriteria().andCondition("cn_name like '%" + name + "%'");
                condition.setOrderByClause("cn_name desc");
                List<WebSchool> byCondition = webSchoolService.findByCondition(condition);
                for (WebSchool webSchool : byCondition) {
                    beans.add(new Bean(webSchool.getSchoolid(), webSchool.getCnName()));
                }
                break;
            //专业名称
            case 2:
                condition = new Condition(WebMajor.class);
                condition.createCriteria().andCondition("name like '%" + name + "%'");
                condition.setOrderByClause("name desc");
                List<WebMajor> byConditionmajor = webMajorService.findByCondition(condition);
                for (WebMajor webMajor : byConditionmajor) {
                    Bean bean = new Bean(webMajor.getMajorid(), webMajor.getName());
                    if (!beans.contains(bean))
                        beans.add(bean);
                }
                break;
            //公司名称
            case 3:
            case 6:
                condition = new Condition(WebCompanyList.class);
                condition.createCriteria().andCondition("cn_name like '%" + name + "%'");
                condition.setOrderByClause("cn_name desc");
                List<WebCompanyList> byConditionCompany = webCompanyListService.findByCondition(condition);
                for (WebCompanyList webCompanyList : byConditionCompany) {
                    Bean bean = new Bean(webCompanyList.getCompanyid(), webCompanyList.getCnName());
                    if (!beans.contains(bean))
                        beans.add(bean);
                }
                break;
            //技能
            case 4:
                condition = new Condition(WebSkill.class);
                condition.createCriteria().andCondition("name like '%" + name + "%'");
                condition.setOrderByClause("name desc");
                List<WebSkill> byConditionSkill = webSkillService.findByCondition(condition);
                for (WebSkill webSkill : byConditionSkill) {
                    beans.add(new Bean(webSkill.getId(), webSkill.getName()));
                }
                break;
            //证书
            case 5:
                condition = new Condition(WebCertificate.class);
                condition.createCriteria().andCondition("name like '%" + name + "%'");
                condition.setOrderByClause("name desc");
                List<WebCertificate> byConditionCer = webCertificateService.findByCondition(condition);
                for (WebCertificate webCertificate : byConditionCer) {
                    beans.add(new Bean(webCertificate.getId(), webCertificate.getName()));
                }
                break;
            //职位名称(工作格式)
            case 7:
                // 意向职位
            case 8:
//                List<SysJobIndustryTpl> byConditionIndustrty ;
                if (StringUtils.isEmpty(name))
                    return ResultGenerator.genFailResult("请输入有效的职位名称");
                if (industryId == 0) {
                    return ResultGenerator.genFailResult("请先选择行业类型");
                }
                Condition conditionIndustry = new Condition(SysJobIndustryTpl.class);
                conditionIndustry.createCriteria().andCondition("industryId = " + industryId);
                List<SysJobIndustryTpl> byConditionIndustrty = sysJobIndustryTplService.findByCondition(conditionIndustry);
                /*if (industryId != 0) {


                } else {
                    byConditionIndustrty = sysJobIndustryTplService.findAll();
                }*/
//                    return ResultGenerator.genFailResult("请先选择行业");


                // 有搜索关键字的职位
                Condition conditionJob = new Condition(SysJobTpl.class);
                if (type == 7)
                    conditionJob.createCriteria().andCondition("name like '%" + name + "%' and " + "merge = 1");
                if (type == 8)
                    conditionJob.createCriteria().andCondition("name like '%" + name + "%'");
                List<SysJobTpl> byConditionJob = sysJobTplService.findByCondition(conditionJob);

                for (SysJobTpl sysJobTpl : byConditionJob) {
                    SysJobIndustryTpl sysJobIndustryTpl = new SysJobIndustryTpl();
                    sysJobIndustryTpl.setJobTplId(sysJobTpl.getJobTplId());
                    if (byConditionIndustrty.contains(sysJobIndustryTpl)) {
                        beans.add(new Bean(sysJobTpl.getJobTplId(), sysJobTpl.getName()));
                    }
                }


                // 意向职位
//            case 8:
               /* if (StringUtils.isEmpty(postionName))
                    return ResultGenerator.genFailResult("请输入有效的职位名称");
                // 行业下的全部职位
                Condition conditionIndustry = new Condition(SysJobIndustryTpl.class);
                conditionIndustry.createCriteria().andCondition("industryId = " + industryId);
                List<SysJobIndustryTpl> byConditionIndustrty = sysJobIndustryTplService.findByCondition(conditionIndustry);

                // 有搜索关键字的职位
                Condition conditionJob = new Condition(SysJobTpl.class);
                conditionJob.createCriteria().andCondition("name like '%" + postionName + "%'");
                List<SysJobTpl> byConditionJob = sysJobTplService.findByCondition(conditionJob);

                for (SysJobTpl sysJobTpl : byConditionJob) {
                    SysJobIndustryTpl sysJobIndustryTpl = new SysJobIndustryTpl();
                    sysJobIndustryTpl.setJobTplId(sysJobTpl.getJobTplId());
                    if (byConditionIndustrty.contains(sysJobIndustryTpl)) {
                        beans.add(new Bean(sysJobTpl.getJobTplId(), sysJobTpl.getName()));
                    }
                }
*/

//                break;


        }

        return ResultGenerator.genSuccessResult(new ResultList().setmList(beans));
    }


    @DS(DataSourceContextHolder.Two)
    @PostMapping("/industryfilter")
    public Result getindustry() {
        List<WebIndustry> all = webIndustryService.findAll();
        industryResponse industryResponse = new industryResponse();
        industryResponse.setIndustriesList(all);
        return ResultGenerator.genSuccessResult(industryResponse);
    }

    @DS(DataSourceContextHolder.Two)
    @PostMapping("/household")
    public Result gethousehold() {
        householdResponse householdResponse = new householdResponse();
        Condition condition = new Condition(WebRegion.class);
        condition.createCriteria().andCondition("grade = 1");
        ArrayList<householdResponse.householdCity> beans = new ArrayList<>();
        ArrayList<Bean> hotCity = new ArrayList<>();
        List<WebRegion> byCondition = webRegionService.findByCondition(condition);

        Condition conditionHot = new Condition(WebRegion.class);
        conditionHot.createCriteria().andCondition("grade = 2");
        List<WebRegion> byConditionHot = webRegionService.findByCondition(conditionHot);
        for (WebRegion webRegion : byCondition) {

            Condition conditionCityList = new Condition(WebRegion.class);
            conditionCityList.createCriteria().andCondition("parent_id = " + webRegion.getId());
            ArrayList<Bean> beansCity = new ArrayList<>();
            List<WebRegion> byConditionList = webRegionService.findByCondition(conditionCityList);
            for (WebRegion mCity : byConditionList) {
                beansCity.add(new Bean(mCity.getId(), mCity.getName()));
            }
            beans.add(new householdResponse.householdCity(webRegion.getId(), webRegion.getName(), beansCity));
        }
        for (WebRegion webRegion : byConditionHot) {
            if (Arrays.asList(AppConstant.HouseName).contains(webRegion.getName()))
                hotCity.add(new Bean(webRegion.getId(), webRegion.getName()));

        }

        householdResponse.setHouseholdCity(beans);
        householdResponse.setHotCity(hotCity);
        return ResultGenerator.genSuccessResult(householdResponse);
    }


    @DS(DataSourceContextHolder.One)
    @PostMapping("/filter")
    public Result getManyFilter() {
        filterResponse filterResponse = new filterResponse();
        filterResponse.PersonalInfo personalInfo = new filterResponse.PersonalInfo();
        filterResponse.WorkExp workExp = new filterResponse.WorkExp();
        filterResponse.EducationExp educationExp = new filterResponse.EducationExp();
        filterResponse.GoodSkill goodSkill = new filterResponse.GoodSkill();

        filterResponse.setEducationExp(educationExp);
        filterResponse.setGoodSkill(goodSkill);
        filterResponse.setWorkExp(workExp);
        filterResponse.setPersonalInfo(personalInfo);
        // 工作状态
        List<com.resumed.sqtwin.model.responseban.Bean> work = new ArrayList<>();
        for (int i = 1; i <= AppConstant.WorkStatus.length; i++) {
            work.add(new Bean(i, AppConstant.WorkStatus[i - 1]));
        }

        personalInfo.setWork(work);
        // 薪资幅度
        ArrayList<Bean> beans = new ArrayList<>();
        List<Bean> salary = new ArrayList<>();
        for (int j = 0; j < AppConstant.SalaryNum.length; j++) {
            if (j == 0)
                salary.add(new Bean(11, AppConstant.SalaryNum[j]));
            else {
                salary.add(new Bean(j, AppConstant.SalaryNum[j]));
                beans.add(new Bean(j, AppConstant.SalaryNum[j]));
            }
        }
        personalInfo.setSalary(salary);

//        beans.addAll(salary);
//        beans.remove(0);
//        boolean b = new ArrayList<Bean>().addAll(salary);
        workExp.setSalaryWork(beans);
        //婚姻状态
        ArrayList<Bean> marrStatus = new ArrayList<>();
        for (int i = 1; i <= AppConstant.marrayStatus.length; i++) {
            marrStatus.add(new Bean(i, AppConstant.marrayStatus[i - 1]));
        }
        personalInfo.setMarriage(marrStatus);

        //学历信息
        ArrayList<Bean> education = new ArrayList<>();
        education.add(new Bean(0, AppConstant.educationSttus[0]));
        education.add(new Bean(2, AppConstant.educationSttus[1]));
        education.add(new Bean(3, AppConstant.educationSttus[2]));
        education.add(new Bean(4, AppConstant.educationSttus[3]));
        educationExp.setEducation(education);
        //技能熟练度
        ArrayList<Bean> skill = new ArrayList<>();
        skill.add(new Bean(1, AppConstant.skillLevel[0]));
        skill.add(new Bean(2, AppConstant.skillLevel[1]));
        skill.add(new Bean(3, AppConstant.skillLevel[2]));
        skill.add(new Bean(4, AppConstant.skillLevel[3]));

        goodSkill.setProficiency(skill);
        // 企业性质
        ArrayList<Bean> EnterpriseNature = new ArrayList<>();
        for (int z = 0; z < AppConstant.EnterpriseNature.length; z++) {
            EnterpriseNature.add(new Bean(z, AppConstant.EnterpriseNature[z]));
        }
        workExp.setEnterpriseNature(EnterpriseNature);
        // 企业规模
        ArrayList<Bean> EnterpriScale = new ArrayList<>();
        for (int z = 0; z < AppConstant.enterpriseScale.length; z++) {
            EnterpriScale.add(new Bean(z, AppConstant.enterpriseScale[z]));

        }
        workExp.setEnterpriseScale(EnterpriScale);


        return ResultGenerator.genSuccessResult(filterResponse);
    }

    /*
     * 教育经历 ： 学校 专业
     * */
    @DS(DataSourceContextHolder.Two)
    @PostMapping("/schoollist")
    public Result getSchoolList() {

        return ResultGenerator.genFailResult("");
    }
}
