package com.resumed.sqtwin.web;

import com.resumed.sqtwin.configurer.*;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.*;
import com.resumed.sqtwin.model.responseban.*;
import com.resumed.sqtwin.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther Super
 * @data 2018/6/11 0011
 * @time 下午 15:40
 */
@RestController
@RequestMapping("/web/employmenhome")
public class EmploymentHomeController {

    //    private final Logger logger = LoggerFactory.getLogger(EmploymentHomeController.class);
    @Resource
    private WebReportHistoryService webReportHistoryService;


    @Resource
    private WebResumeWorkExpService webResumeWorkExpService;

    @Resource
    private WebResumeService webResumeService;

    @Resource
    private WebProfileService webProfileService;

    @Resource
    private WebDiagnoseResumeListService webDiagnoseResumeListService;

    @Resource
    private WebResumeProjectExpService webResumeProjectExpService;


    @Resource
    private WebDocJobDistributionService webDocJobDistributionService;

   /* @Resource
    private WebProfileService webProfileService;*/

    // 感兴趣
    @Resource
    private SysJobTplService sysJobTplService;

    @Resource
    private SysJobIndustryTplService sysJobIndustryTplService;
    private static final Logger logger = LoggerFactory.getLogger(EmploymentHomeController.class);
    /*    @Resource
        private DaITplService daITplService;*/
    @Resource
    private WebCertificateService webCertificateService;


    @Resource
    private DaDocMajorDistributionService daDocMajorDistributionService;


    @Resource
    private WebDocCityDistributionService webDocCityDistributionService;

    @Resource
    private WebDocJobhoppingTimeService webDocJobhoppingTimeService;

    @Resource
    private DaDocGenderDistributionService daDocGenderDistributionService;

    /*  @Resource
    private SysProflibFunctionService sysProflibFunctionService;*/

    /**
     * 查看报告剩余数量
     *
     * @param gid
     * @return
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/reportnum")
    public Result getReportNum(@RequestParam(value = "gid", required = false) Integer gid) {

        if (gid == null) {
            return ResultGenerator.genSuccessResult("您未登录，请登录使用");
        }
        Condition condition = new Condition(WebReportHistory.class);
        condition.createCriteria().andCondition("gid = '" + gid + "'");
        List<WebReportHistory> byCondition = webReportHistoryService.findByCondition(condition);
        return ResultGenerator.genSuccessResult("最多可查看15个报告 还可查看" + (15 - byCondition.size()) + "个报告");
    }

    /**
     * 行业维度列表
     *
     * @param gid
     * @return
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/Industrydimensionslist")
    public Result getIndustrydimensionslist(@RequestParam(value = "gid") Integer gid) {

        List<WebIndustryListBean> mListOne = webResumeWorkExpService.selectIndustryList(gid);

        List<WebIndustryListBean> mListTwo = webDiagnoseResumeListService.selecIndustryList(gid);

        mListTwo.addAll(mListOne);
        for (int i = 0; i < mListTwo.size() - 1; i++) {
            for (int j = mListTwo.size() - 1; j > i; j--) {
                if (mListTwo.get(j).equals(mListTwo.get(i)) || mListTwo.get(j).getId() == null || mListTwo.get(j).getId() < 1 || mListTwo.get(j).getId() == 39) {
                    mListTwo.remove(j);
                }
            }
        }

        return ResultGenerator.genSuccessResult(mListTwo);
    }

    /**
     * 行业维度是否可以点击
     */
    @PostMapping("/canlookIndustry")
    public Result getcanlookIndustry(@RequestParam(value = "industryId") Integer cityId) {
        // 发布职位排行
        List<WebDocJobDistrBean> webDocJobDistrBeans = webDocJobDistributionService.selecIndustryList(cityId, 1);
        if (webDocJobDistrBeans.size() == 0)
            return ResultGenerator.genFailResult("暂不可查看");
        //来源专业分布
        List<DaDocMajorDistribution> daDocMajorDistributions = daDocMajorDistributionService.selecTenDaDoc(cityId, 1);
        if (daDocMajorDistributions.size() == 0)
            return ResultGenerator.genFailResult("暂不可查看");
        // 就业地区分布
        List<WebDocCityDistribution> webDocCityDistributions = webDocCityDistributionService.selectEmployarea(cityId, 10);
        if (webDocCityDistributions.size() == 0)
            return ResultGenerator.genFailResult("暂不可查看");
        List<DaDocGenderDistribution> sexNum = daDocGenderDistributionService.getSexNum(cityId);
        if (sexNum.size() == 0)
            return ResultGenerator.genFailResult("暂不可查看");
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 发布职位排行
     *
     * @param gid
     * @param cityId
     * @return
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/Industrydimensionsrank")
    public Result getIndustrydimensionsrank(@RequestParam("gid") Integer gid, @RequestParam(value = "industryId", required = false) Integer cityId) {
        ArrayList<IndustryDimensionsRankBean> industryDimensionsRankBeans = new ArrayList<>();

        List<WebDocJobDistrBean> webDocJobDistrBeans = webDocJobDistributionService.selecIndustryList(cityId, 10);


        List<SysJobTpl> sysJobTpls = sysJobTplService.queryList(gid);


        // 感兴趣的还未增加
        for (WebDocJobDistrBean webDocJobDistrBean : webDocJobDistrBeans) {
            Boolean isInteresting = false;
            for (SysJobTpl sysJobTpl : sysJobTpls) {
                if (sysJobTpl.getJobTplId() != null && sysJobTpl.getJobTplId().equals(webDocJobDistrBean.getTplId())) {
                    isInteresting = true;
                    break;
                }
            }
            industryDimensionsRankBeans.add(new IndustryDimensionsRankBean(webDocJobDistrBean.getTplId(), webDocJobDistrBean.getTplName(), isInteresting, webDocJobDistrBean.getCount()));
        }

        return ResultGenerator.genSuccessResult(industryDimensionsRankBeans);
    }

    /**
     * 意向城市列表
     *
     * @param gid
     * @return
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/intentionCity")
    public Result getIntentionCity(@RequestParam("gid") Integer gid) {
        ArrayList<Bean> beans = new ArrayList<>();
        Condition webResumeCond = new Condition(WebResume.class);
        webResumeCond.createCriteria().andCondition("gid = " + gid + " and status = 1 ");
        List<WebResume> byWebResume = webResumeService.findByCondition(webResumeCond);
        for (WebResume webResume : byWebResume) {
            WebProfile webProfile = webProfileService.findBy("rid", webResume.getRid());
            if (webProfile != null && !StringUtils.isEmpty(webProfile.getIntentioncityid()) && !StringUtils.isEmpty(webProfile.getIntentioncity())) {
                String intentioncityid = webProfile.getIntentioncityid();
                String intentioncity = webProfile.getIntentioncity();
                String[] split = intentioncityid.split(",");
                String[] split1 = intentioncity.split(",");
                int i = 0;
                for (String s : split) {
                    beans.add(new Bean(Integer.parseInt(s), split1[i++]));

                }
            }
        }

        for (int i = 0; i < beans.size() - 1; i++) {
            for (int j = beans.size() - 1; j > i; j--) {
                if (beans.get(j).equals(beans.get(i)) || ((beans.get(j).getId() == beans.get(i).getId()))) {
                    beans.remove(j);
                }
            }
        }

        return ResultGenerator.genSuccessResult(beans);
    }

    /**
     * 来源专业分布排行
     *
     * @param
     * @return
     */
    @PostMapping("/specialtydistribution")
    public Result getspecialtyDistribution(@RequestParam("industryid") Integer industryid) {
        ArrayList<specialtydistributionBean> mList = new ArrayList<>();
        List<DaDocMajorDistribution> daDocMajorDistributions = daDocMajorDistributionService.selecTenDaDoc(industryid, 10);
        for (DaDocMajorDistribution daDocMajorDistribution : daDocMajorDistributions) {
            //(int) ((daDocMajorDistribution.getCount() / sum) * 100)
            mList.add(new specialtydistributionBean(daDocMajorDistribution.getMajorid(), daDocMajorDistribution.getMajorname(), daDocMajorDistribution.getCount()));
        }
        return ResultGenerator.genSuccessResult(mList);
    }

    /**
     * 就业地区分布排行
     *
     * @param
     * @return
     */
    @PostMapping("/employmentarea")
    public Result getemploymentarea(@RequestParam("industryid") Integer industryid) {
        ArrayList<specialtydistributionBean> mList = new ArrayList<>();

        List<WebDocCityDistribution> webDocCityDistributions = webDocCityDistributionService.selectEmployarea(industryid, 10);

        for (WebDocCityDistribution webDocCityDistribution : webDocCityDistributions) {
            mList.add(new specialtydistributionBean(webDocCityDistribution.getProvinceid(), webDocCityDistribution.getProvincename(), webDocCityDistribution.getCount()));
        }

        return ResultGenerator.genSuccessResult(mList);
    }

    /**
     * 跳槽频率
     *
     * @param
     * @return
     */
    @PostMapping("/hoppingfrequency")
    public Result gethoppingfrequency(@RequestParam("industryid") Integer industryid) {
        ArrayList<specialtydistributionBean> mList = new ArrayList<>();
        List<WebDocJobhoppingTime> webDocJobTimeList = webDocJobhoppingTimeService.getWebDocJobTimeList(industryid, 10);
        for (WebDocJobhoppingTime webDocJobhoppingTime : webDocJobTimeList) {
            mList.add(new specialtydistributionBean(webDocJobhoppingTime.getFunctionid(), webDocJobhoppingTime.getFunctionname(), webDocJobhoppingTime.getJobhoppingtime()));
        }
        return ResultGenerator.genSuccessResult(mList);
    }

    /**
     * @return 人才性别比例
     */
    @PostMapping("/sexnum")
    public Result getSexNum(@RequestParam("industryid") Integer industryid) {
        List<DaDocGenderDistribution> sexNum = daDocGenderDistributionService.getSexNum(industryid);
        ArrayList<Bean> beans = new ArrayList<>();
        for (DaDocGenderDistribution daDocGenderDistribution : sexNum) {
            beans.add(new Bean(daDocGenderDistribution.getSum(), daDocGenderDistribution.getGender() == 1 ? "男" : "女"));
        }
        return ResultGenerator.genSuccessResult(sexNum);
    }

    @Resource
    private RedisTempTwo redisTempTwo;

    /**
     * @return 职能列表也
     */
    @PostMapping("/postionlist")
    public Result getPostionList(@RequestParam("industryid") Integer industryid) {
//        Object bigTypeList_ = redisTempTwo.get("BigTypeList_");
        ArrayList<Bean> mList = new ArrayList<>();
        List<Object> bigtypes = redisTempTwo.lRange("BigTypeList_" + industryid, 0, -1);
        logger.info("TAG  logger" + ("BigTypeList_" + industryid));
        for (Object o : bigtypes) {
            String bigtypeId = String.valueOf(o);
            Object bName = redisTempTwo.get("BigType_Name_" + bigtypeId);
            if (bName == null)
                continue;
            List<Object> smalltypes = redisTempTwo.lRange("SmallTypeList_" + industryid + "_" + bigtypeId, 0, -1);
            if (smalltypes == null || smalltypes.size() == 0)
                continue;
            for (Object o2 : smalltypes) {
                String smalltypeId = String.valueOf(o2);
                Object sName = redisTempTwo.get("SmallType_Name_" + bigtypeId + "_" + smalltypeId);
                if (sName == null)
                    continue;
                List<Object> functions = redisTempTwo.lRange("FunctionList_" + industryid + "_" + bigtypeId + "_" + smalltypeId, 0, -1);
                if (functions == null || functions.size() == 0)
                    continue;
                Bean bean = new Bean(Integer.parseInt(smalltypeId), String.valueOf(sName));
                mList.add(bean);
            }

        }


        return ResultGenerator.genSuccessResult(mList);

    }

    /**
     * @param gid
     * @return 地区维度首页
     */
    @PostMapping("/Regionaldimensionhome")
    public Result getRegionaldimensionhome(@RequestParam("gid") Integer gid) {
        ArrayList<Bean> mList = new ArrayList<>();
        List<WebProfile> webProfiles = webProfileService.selectRegionalList(gid);
        for (WebProfile webProfile : webProfiles) {
            //110100,120100,310100
            String intentioncityid = webProfile.getIntentioncityid();
            String intentioncity = webProfile.getIntentioncity();
            String[] split = intentioncityid.split(",");
            String[] split1 = intentioncity.split(",");
            int i = 0;
            for (String s : split) {

                mList.add(new Bean(Integer.parseInt(s), split1[i++] + "地区就业大数据报告"));

            }

        }
        // 感兴趣的数据
//        List<SysJobTpl> sysJobTpls = sysJobTplService.queryList(gid);
        return ResultGenerator.genSuccessResult(mList);
    }

    @Resource
    private WebFlowOutAtonceWorkcityidService webFlowOutAtonceWorkcityidService;

    /**
     * @param cityId   省市ID
     * @param tplLevel 级别
     * @return 本地毕业生，离开后就业地区分布top10
     */
    @PostMapping("/regionlocaltop")
    public Result getRegionLocalStudentTop10(@RequestParam("cityId") Integer cityId, @RequestParam(value = "tplLevel", required = false) Integer tplLevel) {
        Double sumCount;
        List<WebFlowOutBean> webFlowOutBeans;
        if (tplLevel != null) {
            sumCount = webFlowOutAtonceWorkcityidService.selectNumCountOne(cityId, tplLevel);
            webFlowOutBeans = webFlowOutAtonceWorkcityidService.slectRevalueTwo(sumCount, cityId, tplLevel,10);
        } else {
            sumCount = webFlowOutAtonceWorkcityidService.selectNumCountTwo(cityId);
            webFlowOutBeans = webFlowOutAtonceWorkcityidService.selecRevalueOne(sumCount, cityId,10);
        }
        return ResultGenerator.genSuccessResult(webFlowOutBeans);
    }

    @Resource
    private WebFlowOutAtonceIndustryidService webFlowOutAtonceIndustryidService;


    /**
     * @param cityId
     * @return 本地毕业生————离开后就业行业分布top10
     */
    @PostMapping("/industrylocaltop")
    public Result getIndustylocalTop10(@RequestParam("cityId") Integer cityId, @RequestParam(value = "tplLevel", required = false) Integer tplLevel) {
        List<WebFlowOutAtonceIndustryBean> mList;
        if (tplLevel == null)
            mList = webFlowOutAtonceIndustryidService.selectIndustryLocaltop(cityId,10);
        else
            mList = webFlowOutAtonceIndustryidService.selectIndustryLocaltopTwo(cityId, tplLevel,10);
        return ResultGenerator.genSuccessResult(mList);
    }

    @Resource
    //web_flow_out_atonce_functionId
    private WebFlowOutAtonceFunctionidService webFlowOutAtonceFunctionidService;


    /**
     * @param cityId
     * @return 本地毕业生————离开后就业职能分布top10
     */
    @PostMapping("/postionlocaltop")
    public Result getPostionlocalTop10(@RequestParam("cityId") Integer cityId, @RequestParam(value = "tplLevel", required = false) Integer tplLevel) {
        List<WebFlowOutAtonceFunctionBean> mList;
        if (tplLevel == null)
            mList = webFlowOutAtonceFunctionidService.selectPostionLocaltop(cityId,10);
        else
            mList = webFlowOutAtonceFunctionidService.selectPostionLocaltopTwo(cityId, tplLevel,10);
        return ResultGenerator.genSuccessResult(mList);
    }

    //web_flow_out_atonce_salary
    @Resource
    private WebFlowOutAtonceSalaryService webFlowOutAtonceSalaryService;

    /**
     * @param cityId
     * @param year
     * @return 本地毕业生————离开后平均薪资状况
     */
    @PostMapping("/salarylocalstudent")
    public Result getsalarylocalstudent(@RequestParam("cityId") Integer cityId, @RequestParam("year") Integer year) {
        List<WebFlowSalaryBean> webFlowSalaryBeans = webFlowOutAtonceSalaryService.selectSalaryLocal(cityId, year);
        return ResultGenerator.genSuccessResult(webFlowSalaryBeans);
    }


    @Resource
    private WebFlowOutAtonceNativecityidService webFlowOutAtonceNativecityidService;

    /**
     * web_flow_out_atonce_nativeCityId
     *
     * @return 本地毕业生---离开人才籍贯分布
     */
    @PostMapping("/nativelocalplace")
    public Result getnativelocalplace(@RequestParam("cityId") Integer cityId, @RequestParam(value = "tplLevel", required = false) Integer tplLevel) {

        Integer sumNum;
        List<WebFlowOutAtonceNativecityidBean> webFlowOutAtonceNativecityidBeans;
        if (tplLevel != null) {
            sumNum = webFlowOutAtonceNativecityidService.slectSumNum(cityId);
            webFlowOutAtonceNativecityidBeans = webFlowOutAtonceNativecityidService.selectRevalueOne(sumNum, cityId,10);
        } else {
            sumNum = webFlowOutAtonceNativecityidService.slectSumNumTwo(cityId, tplLevel);
            webFlowOutAtonceNativecityidBeans = webFlowOutAtonceNativecityidService.selectRevalueTwo(sumNum, cityId, tplLevel,10);

        }

        return ResultGenerator.genSuccessResult(webFlowOutAtonceNativecityidBeans);
    }

    //web_flow_atonce_native
    @Resource
    WebFlowAtonceNativeService webFlowAtonceNativeService;

    /**
     * @param cityId
     * @param tplLevel
     * @return 外地毕业生————人才籍贯分布
     */
    @PostMapping("/nonlocalnativeplace")
    public Result getnativenonlocalplace(@RequestParam("cityId") Integer cityId, @RequestParam(value = "tplLevel", required = false) Integer tplLevel) {
        Integer sumNum;
        List<WebFlowAtonceNativeBean> WebFlowAtonceNativedBeans;
        if (tplLevel == null) {
            sumNum = webFlowAtonceNativeService.slectSumNum(cityId);


            WebFlowAtonceNativedBeans = webFlowAtonceNativeService.selectRevalueOne(sumNum, cityId,10);
        } else {
            sumNum = webFlowAtonceNativeService.slectSumNumTwo(cityId, tplLevel);
            WebFlowAtonceNativedBeans = webFlowAtonceNativeService.selectRevalueTwo(sumNum, cityId, tplLevel,10);

        }

        return ResultGenerator.genSuccessResult(WebFlowAtonceNativedBeans);
    }


    @Resource
    private WebFlowAtonceSchoolService webFlowAtonceSchoolService;

    /**
     * @param cityId
     * @param tplLevel
     * @return 外地毕业生————人才毕业院校地区分布top10  web_flow_atonce_school
     */
    @PostMapping("/nonlocalcollegestop")
    public Result getnonlocalcollegestop(@RequestParam("cityId") Integer cityId, @RequestParam(value = "tplLevel", required = false) Integer tplLevel) {
        Integer sumNum;
        List<WebFlowAtonceSchoolBean> WebFlowAtonceNativedBeans;
        if (tplLevel == null) {
            sumNum = webFlowAtonceSchoolService.slectSumNum(cityId);
            WebFlowAtonceNativedBeans = webFlowAtonceSchoolService.selectRevalueOne(sumNum, cityId,10);
        } else {
            sumNum = webFlowAtonceSchoolService.slectSumNumTwo(cityId, tplLevel);
            WebFlowAtonceNativedBeans = webFlowAtonceSchoolService.selectRevalueTwo(sumNum, cityId, tplLevel,10);

        }
        return ResultGenerator.genSuccessResult(WebFlowAtonceNativedBeans);

    }

    /**
     * @param cityId
     * @param tplLevel  web_flow_atonce_industry
     * @return 外地毕业生———————人才就业行业分布top10
     */
    @Resource
    private WebFlowAtonceIndustryService webFlowAtonceIndustryService;

    @PostMapping("/nonlocalcollegesindustrytop")
    public Result getnonlocalcollegesindustrytop(@RequestParam("cityId") Integer cityId, @RequestParam(value = "tplLevel", required = false) Integer tplLevel) {
        Integer sumNum;
        List<WebFlowAtonceIndustryBean> WebFlowAtonceNativedBeans;
        if (tplLevel == null) {
//            sumNum = webFlowAtonceIndustryService.slectSumNum(cityId);
            WebFlowAtonceNativedBeans = webFlowAtonceIndustryService.selectRevalueOne(10, cityId);
        } else {
//            sumNum = webFlowAtonceIndustryService.slectSumNumTwo(cityId, tplLevel);
            WebFlowAtonceNativedBeans = webFlowAtonceIndustryService.selectRevalueTwo(10, cityId, tplLevel);

        }
        return ResultGenerator.genSuccessResult(WebFlowAtonceNativedBeans);

    }

    /**
     * @param cityId
     * @param tplLevel  web_flow_atonce_industry
     * @return 外地毕业生———————人才就业职能分布top10  web_flow_atonce_function
     */
    @Resource
    private WebFlowAtonceFunctionService webFlowAtonceFunctionService;

    @PostMapping("/nonlocalcollegespostiontop")
    public Result getnonlocalcollegespostion(@RequestParam("cityId") Integer cityId, @RequestParam(value = "tplLevel", required = false) Integer tplLevel) {
        List<WebFlowAtonceFunctionBean> WebFlowAtonceNativedBeans;
        if (tplLevel == null) {
            WebFlowAtonceNativedBeans = webFlowAtonceFunctionService.selectRevalueOne(10, cityId);
        } else {
            WebFlowAtonceNativedBeans = webFlowAtonceFunctionService.selectRevalueTwo(10, cityId, tplLevel);

        }
        return ResultGenerator.genSuccessResult(WebFlowAtonceNativedBeans);

    }
    /**
     * @param cityId
     * @param tplLevel  web_flow_atonce_salary
     * @return 外地毕业生———————外地毕业生————平均薪资状况  web_flow_atonce_salary
     */
    @Resource
    private WebFlowAtonceSalaryService webFlowAtonceSalaryService;
    @PostMapping("/nonlocalcollegespostiontop")
    public Result getnonlocalcollegespostiontop(@RequestParam("cityId") Integer cityId, @RequestParam(value = "tplLevel", required = false) Integer tplLevel) {
        List<WebFlowAtonceSalaryBean> webFlowAtonceSalaryBeans;
        if (tplLevel == null) {
//            webFlowAtonceSalaryBeans = webFlowAtonceSalaryService.selectRevalueOne(10, cityId);
        } else {
//            webFlowAtonceSalaryBeans = webFlowAtonceSalaryService.selectRevalueTwo(10, cityId, tplLevel);

        }
        return ResultGenerator.genSuccessResult();

    }

}
