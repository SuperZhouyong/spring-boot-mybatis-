package com.resumed.sqtwin.web;

import com.alibaba.fastjson.JSON;
import com.resumed.sqtwin.configurer.DS;
import com.resumed.sqtwin.configurer.DataSourceContextHolder;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.*;
import com.resumed.sqtwin.model.bean.YearBean;
import com.resumed.sqtwin.model.responseban.*;
import com.resumed.sqtwin.service.*;
import com.resumed.sqtwin.utils.*;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.time.chrono.MinguoChronology;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * Created by CodeGenerator on 2018/04/19.
 */
@RestController
@RequestMapping("/resume/diagnosis")
public class ResumeDiagnosisController {
    //个人信息
    @Resource
    private WebProfileService webProfileService;
    // 教育状态
    @Resource
    private WebResumeEducationService webResumeEducationService;
    //公司
    @Resource
    private WebResumeWorkExpService webResumeWorkExpService;
    //项目
    @Resource
    private WebResumeProjectExpService webResumeProjectExpService;
    //荣誉
    @Resource
    private WebResumeHonorService webResumeHonorService;
    //技能
    @Resource
    private WebResumeSkillService webResumeSkillService;
    //证书
    @Resource
    private WebResumeCertificateService webResumeCertificateService;
    //个人描述自述
    @Resource
    private WebResumeEvalService webResumeEvalService;
    //rid的库
    @Resource
    private WebRidService webRidService;
    //保存多份数据库
    @Resource
    private WebResumeService webResumeService;

    // 专业
    @Resource
    private WebMajorService webMajorService;
    // 过期专业
    @Resource
    private WebMajorExService webMajorExService;
    // 提示话语
    @Resource
    private WebMsgMapService webMsgMapService;

    @Resource
    private WebDiagnoseResumeListService webDiagnoseResumeListService;

    @Resource
    private SysJobTplService sysJobTplService;


    // 查询职业的年份
    @Resource
    private WebTplLowestYearService webTplLowestYearService;

    // 分享的数据库
   /* @Resource
    private WebElectronicResumeService webElectronicResumeService;*/

    @Value("${zhenduan.url}")
    public String ZDceshi;

    private final Logger logger = LoggerFactory.getLogger(ResumeDiagnosisController.class);

    /*@DS(DataSourceContextHolder.One)
    @PostMapping("/resultInfo")
    public Integer getre() {

        return getIntegerSysJobTpl();
    }*/

    private Integer getIntegerSysJobTpl(String postionId) {
        try {
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("postionId", postionId);
            Request build = new Request
                    .Builder()
                    .url(AppConstant.AppOffice + "/resume/diagnosis" + "/resultRe")
                    .post(builder.build())
                    .build();
            Response execute = ApiUtil.getApi().newCall(build).execute();
            if (execute.isSuccessful()) {
                String string = null;

                string = execute.body().string();
                return Integer.parseInt(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }


        return -1;
    }

    @DS(DataSourceContextHolder.One)
    @GetMapping("/ceshi")
    public Result getInfo(@RequestParam String rid) {
        Condition condition = new Condition(WebResumeWorkExp.class);
        condition.createCriteria().andCondition("rid = '" + rid + "'");
        List<WebResumeWorkExp> byCondition = webResumeWorkExpService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(byCondition);
    }


    @DS(DataSourceContextHolder.Two)
    @PostMapping("/resultRe")
    public int getrezzz(@RequestParam("postionId") String postionId) {
//        List<SysJobTpl> all = sysJobTplService.findAll();
        Condition condition = new Condition(SysJobTpl.class);
        condition.createCriteria().andCondition("job_tpl_id = " + postionId);
        List<SysJobTpl> byCondition = sysJobTplService.findByCondition(condition);
        if (byCondition != null && byCondition.size() != 0) {
            return byCondition.get(0).getMerge();
        }
        return -1;
    }

    /**
     * @param gid         用户Id
     * @param rid         简历Id
     * @param industryId  行业Id
     * @param postionName 职位名字
     * @param postionId   职位Id 工作经验
     * @return
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/results")
    public Result resumeResult(@RequestParam Integer gid, @RequestParam String rid, @RequestParam(defaultValue = "-1", required = false) Integer industryId, @RequestParam(defaultValue = "") String postionName, @RequestParam(required = false, defaultValue = "-1") Integer postionId, @RequestParam("KeyId") Integer KeyId) {
        if (gid == null || StringUtils.isEmpty(rid))
            return ResultGenerator.genFailResult("检查输入信息");
//        String stringRid = new AppConstanController().getStringRid();
        String stringRid = getStringRid();

        // 查看本简历是否已经诊断过了
        Condition conditionResume = new Condition(WebResume.class);
        conditionResume.createCriteria().andCondition("gid = '" + gid + "' and status =  8 and prid = '" + rid + "'");
        List<WebResume> byConditionResume = webResumeService.findByCondition(conditionResume);
        Boolean isHave = byConditionResume == null || byConditionResume.size() == 0;
        // 无论多次诊断还是单次诊断


        //获取到自述
        Condition conditionEval = new Condition(WebResumeEval.class);
        conditionEval.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeEval> byConditionEval = webResumeEvalService.findByCondition(conditionEval);


        // 查询个人信息
        Condition condition = new Condition(WebProfile.class);
        condition.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebProfile> byConditionProfile = webProfileService.findByCondition(condition);
        if (byConditionEval != null && byConditionEval.size() != 0 && byConditionProfile != null && byConditionProfile.size() != 0)
            byConditionProfile.get(0).setDescribe(byConditionEval.get(0).getContent() + "");


        //教育证明
        Condition conditionEducation = new Condition(WebResumeEducation.class);
        conditionEducation.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
//        webResumeEducationService.UpdateByConditionSelective(updateResume.getWebResumeEducation(), conditionEducation);
        List<WebResumeEducation> byConditionEducation = webResumeEducationService.findByCondition(conditionEducation);


        // 工作经验
        Condition conditionWorkExp = new Condition(WebResumeWorkExp.class);
        conditionWorkExp.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeWorkExp> byConditionWorkexp = webResumeWorkExpService.findByCondition(conditionWorkExp);


        //项目
        Condition conditionProject = new Condition(WebResumeProjectExp.class);
        conditionProject.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeProjectExp> byConditionProject = webResumeProjectExpService.findByCondition(conditionProject);


        //技能
        Condition conditionSkill = new Condition(WebResumeSkill.class);
        conditionSkill.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeSkill> byConditionSkill = webResumeSkillService.findByCondition(conditionSkill);


        // 荣誉
        Condition conditionHonor = new Condition(WebResumeHonor.class);
        conditionHonor.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeHonor> byConditionHonor = webResumeHonorService.findByCondition(conditionHonor);


        // 证书
        Condition conditionCer = new Condition(WebResumeCertificate.class);
        conditionCer.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeCertificate> byConditionCer = webResumeCertificateService.findByCondition(conditionCer);

        // 保存一份简历
        SaveStatus8(gid, rid, stringRid, isHave, byConditionResume, byConditionEval, byConditionProfile, byConditionEducation, byConditionWorkexp, byConditionProject, byConditionSkill, byConditionHonor, byConditionCer);


        // 访问志平的接口 需要简历状态为8的简历
        FutureTask<AlgBean> algBeanFutureTask = null;
        if (postionId != -1) {
            Callable<AlgBean> algBeanCallable = () -> {

                Request request = new Request.Builder().url(ZDceshi + "/" + stringRid + "/" + postionId + "/" + industryId + "/" + KeyId).build();
                Response response = ApiUtil.getApi().newCall(request).execute();
                if (response.isSuccessful()) {
                    return (AlgBean) JSON.parse(response.body().string());
                }
                return null;
            };
            algBeanFutureTask = new FutureTask<>(algBeanCallable);
            new Thread(algBeanFutureTask).start();
        }

        ResumeDiagnosisBean resumeDiagnosisBean = new ResumeDiagnosisBean();
        //个人信息
        UserInfo userInfo = new UserInfo();
        DiagnosisWebProfile(byConditionProfile, userInfo);
        resumeDiagnosisBean.setUserInfo(userInfo);
        // 教育信息
        EducationInfo educationInfo = new EducationInfo();
        DiagnososEducatin(byConditionEducation, educationInfo);
        resumeDiagnosisBean.setEducationInfo(educationInfo);
        //工作就经验
        WorkExpInfo workExpInfo = new WorkExpInfo();
        DiagnosisWork(byConditionWorkexp, workExpInfo);
        resumeDiagnosisBean.setWorkExpInfo(workExpInfo);
        //证书
        CerInfo cerInfo = new CerInfo();
        DiagnososCer(byConditionCer, cerInfo);
        resumeDiagnosisBean.setCertificateInfo(cerInfo);
        //项目经历
        ProjectExpInfo projectExpInfo = new ProjectExpInfo();
        DiagnosisProject(byConditionProject, projectExpInfo);
        resumeDiagnosisBean.setProjectExpInfo(projectExpInfo);
        //擅长技能
        SkillInfo skillInfo = new SkillInfo();
        DiagnosisSkill(byConditionSkill, skillInfo);
        resumeDiagnosisBean.setSkillInfo(skillInfo);
        //荣誉奖励
        HonorInfo honorInfo = new HonorInfo();
        DiagnosisHonor(byConditionHonor, honorInfo, byConditionEducation);
        resumeDiagnosisBean.setHonorInfo(honorInfo);
        //自述
        SelfDesc selfDesc = new SelfDesc();
        DiagnosisSelfDesc(byConditionEval, selfDesc);
        resumeDiagnosisBean.setSelfDesc(selfDesc);

        if (algBeanFutureTask != null && algBeanFutureTask.isDone()) {
            logger.info("ResumeDiagnosisController" + "当前任务测试完毕");
        } else if (algBeanFutureTask != null && !algBeanFutureTask.isDone()) {
            logger.info("ResumeDiagnosisController" + "当前任务测试完毕---未完成");
        }

        /*Condition conditionSys = new Condition(SysJobTpl.class);
        conditionSys.createCriteria().andCondition("")*/
        AlgBean algBean = null;
        if (algBeanFutureTask != null) {
            try {
                algBean = algBeanFutureTask.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }


        // 根据志平处理的方式将结果返回
        if (algBean != null) {
            //职位所需证书
            List<AlgBean.DataBean.CertListBean> certList = algBean.getData().getCertList();
            if (certList != null && certList.size() != 0) {
                String cername = null;
                for (int i = 0; i < certList.size(); i++) {
                    if (i != certList.size() - 1) {
                        cername += certList.get(i).getName() + "、";
                    } else {
                        cername += certList.get(i).getName();
                    }
                }
                if (!StringUtils.isEmpty(cername)) {
                    resumeDiagnosisBean.getCertificateInfo().getAllDesc().add(postionName + "该职位需要" + cername + ",如已获得，请填写。");
                }
            }
            //第一、三、六、七段工作经历中存在与目标职位相关度高的经历，请重点描述。（如已重点描述可忽略此提示）
            // 工作经历中的经历与该职位相关度高的段数
            List<AlgBean.DataBean.HighRelItemsBean> highRelItems = algBean.getData().getHighRelItems();
            ArrayList<String> strings1 = new ArrayList<>();
            for (AlgBean.DataBean.HighRelItemsBean highBean : highRelItems) {
                strings1.add(returnOneTwoThree(webResumeWorkExpService.findBy("work_exp_id", highBean.getWorkExpId()).getRank()));
            }
            String s1 = returnString(strings1);
            if (!StringUtils.isEmpty(s1)) {
                resumeDiagnosisBean.getWorkExpInfo().getAllDesc().add("第" + s1 + "段工作经历中存在与目标职位相关度高的经历，请重点描述。（如已重点描述可忽略此提示）");
            }


            //是程序无法识别的工作经历，返回的值是 工作经历表中的主键，如果该项不为空，那 scoreItem  肯定是空对象
            List<AlgBean.DataBean.NoMergeItemsBean> noMergeItems = algBean.getData().getNoMergeItems();
            ArrayList<String> strings = new ArrayList<>();
            for (AlgBean.DataBean.NoMergeItemsBean NoBean : noMergeItems) {
                strings.add(returnOneTwoThree(webResumeWorkExpService.findBy("work_exp_id", NoBean.getWorkExpId()).getRank()));
            }
            String s = returnString(strings);
            if (!StringUtils.isEmpty(s)) {
                resumeDiagnosisBean.getWorkExpInfo().getAllDesc().add("我们对您的简历中第" + s + "段工作经历无法识别，暂时无法计算匹配度。");
            }


            //工作经历中的经验经历与该职位无关段数
            List<AlgBean.DataBean.NoRelItemsBean> noRelItems = algBean.getData().getNoRelItems();
            ArrayList<String> strings2 = new ArrayList<>();
            for (AlgBean.DataBean.NoRelItemsBean NoRelBean : noRelItems) {
                strings2.add(returnOneTwoThree(webResumeWorkExpService.findBy("work_exp_id", NoRelBean.getWorkExpId()).getRank()));
            }
            String s2 = returnString(strings2);
            if (!StringUtils.isEmpty(s2)) {
                resumeDiagnosisBean.getWorkExpInfo().getAllDesc().add("第" + s + "段工作经历与意向职位无关，适当弱化。");
            }

            //为匹配度和雷达图各个指标的分数 (显示在页面上的数据向下取整)：
            AlgBean.DataBean.ScoreItemBean scoreItem = algBean.getData().getScoreItem();
            resumeDiagnosisBean.setScoreItem(scoreItem);
            //职位所需技能
            List<AlgBean.DataBean.SkillListBean> skillList = algBean.getData().getSkillList();
            if (skillList != null && skillList.size() != 0) {
                String skillname = null;
                for (int i = 0; i < skillList.size(); i++) {
                    if (i != certList.size() - 1) {
                        skillname += skillList.get(i).getName() + "、";
                    } else {
                        skillname += skillList.get(i).getName();
                    }
                }
                if (!StringUtils.isEmpty(skillname)) {
                    resumeDiagnosisBean.getSkillInfo().getAllDesc().add(postionName + "该职位需要" + skillname + ",如已获得，请填写。");
                }
            }

        }
        //稍后删除
        AlgBean.DataBean.ScoreItemBean scoreItem = new AlgBean.DataBean.ScoreItemBean();
        scoreItem.setPicDesc("反射的是通过简历体现出的个人对图中各项指标单独的满足程度");
        scoreItem.setMatchDesc("反映的是简历整体与意向职位的满足程度，计算时会考虑例如个人意愿、工作经验符合程度等多种因素");
        resumeDiagnosisBean.setScoreItem(scoreItem);
        Integer integerSysJobTpl = null;
        if (postionId != -1) {
            integerSysJobTpl = getIntegerSysJobTpl(String.valueOf(postionId));
        }
        WebDiagnoseResumeList webDiagnoseResumeList = new WebDiagnoseResumeList();
        webDiagnoseResumeList.setGid(gid);
        webDiagnoseResumeList.setRid(stringRid);
        webDiagnoseResumeList.setCreateat(new Date());
        webDiagnoseResumeList.setIntensionIndustry(industryId);
        webDiagnoseResumeList.setIntensionFunctionName(postionName);
        webDiagnoseResumeList.setIntensionFunctionId(postionId);
        webDiagnoseResumeList.setIsMerge((byte) (integerSysJobTpl != null ? integerSysJobTpl : -1));
        webDiagnoseResumeList.setIsAssociateJob((byte) (postionId > 0 ? 1 : 0));
        webDiagnoseResumeListService.save(webDiagnoseResumeList);

        // 修正数据
//        一，工作经验
        WorkExpInfo workExpInfo1 = resumeDiagnosisBean.getWorkExpInfo();
        for (Bean mBean : workExpInfo1.getStartEndTime()) {

            addList(workExpInfo1.getRankLisk(), mBean);
//            workExpInfo1.getRankLisk().add(mBean.getId());
        }
        for (Bean mBean : workExpInfo1.getCompanyName()) {
            addList(workExpInfo1.getRankLisk(), mBean);
        }
        for (Bean mBean : workExpInfo1.getPostionName()) {
            addList(workExpInfo1.getRankLisk(), mBean);
        }
        for (Bean mBean : workExpInfo1.getWorkDesc()) {
            addList(workExpInfo1.getRankLisk(), mBean);
        }

        /*
        *   //起止时间
    private List<Bean> startEndDate;
    // 学校名字
    private List<Bean> schoolName;
    //专业名字
    private List<Bean> majorName;*/
        //教育经验
        EducationInfo educationInfo1 = resumeDiagnosisBean.getEducationInfo();
        for (Bean mBean : educationInfo1.getStartEndDate()) {

            addList(educationInfo1.getRankLisk(), mBean);
        }
        for (Bean mBean : educationInfo1.getSchoolName()) {
            addList(educationInfo1.getRankLisk(), mBean);
        }
        for (Bean mBean : educationInfo1.getMajorName()) {
            addList(educationInfo1.getRankLisk(), mBean);
        }
        /*
        *    //起止时间
    private List<Bean> startEndTime ;
    //项目名称
    private List<Bean> projectName ;
    //职位描述
    private List<Bean> postionDesc ;*/
        // 项目经验
        ProjectExpInfo projectExpInfo1 = resumeDiagnosisBean.getProjectExpInfo();
        for (Bean mBean : projectExpInfo1.getStartEndTime()) {
            addList(projectExpInfo1.getRankLisk(), mBean);

        }
        for (Bean mBean : projectExpInfo1.getProjectName()) {
            addList(projectExpInfo1.getRankLisk(), mBean);
        }
        for (Bean mBean : projectExpInfo1.getPostionDesc()) {
            addList(projectExpInfo1.getRankLisk(), mBean);
        }
        // 证书
        /*
        *    //获取时间
    private List<Bean> obtainTime;
    // 证书名字
    private List<Bean> cerName;
        * */
        CerInfo certificateInfo = resumeDiagnosisBean.getCertificateInfo();
        for (Bean mBean : certificateInfo.getObtainTime()) {
            addList(certificateInfo.getRankLisk(), mBean);

        }
        for (Bean mBean : certificateInfo.getCerName()) {
            addList(certificateInfo.getRankLisk(), mBean);
        }
/*
*     //获取时间
    private List<Bean> obtainTime;
    //授予单位
    private List<Bean> awardedUnit;
    //奖项名称
    private List<Bean> honorName;
*/
        // 荣誉
        HonorInfo honorInfo1 = resumeDiagnosisBean.getHonorInfo();
        for (Bean mBean : honorInfo1.getObtainTime()) {
            addList(honorInfo1.getRankLisk(), mBean);

        }
        for (Bean mBean : honorInfo1.getAwardedUnit()) {
            addList(honorInfo1.getRankLisk(), mBean);
        }
        for (Bean mBean : honorInfo1.getHonorName()) {
            addList(honorInfo1.getRankLisk(), mBean);
        }
        /*
        *    // 技能名称
    private List<Bean> skillName ;

    // 综合
    private List<String> allDesc ;
    //熟练度
    private List<Bean> skillDegree ;
        * */
        //技能
        SkillInfo skillInfo1 = resumeDiagnosisBean.getSkillInfo();
        for (Bean mBean : skillInfo1.getSkillName()) {
            addList(skillInfo1.getRankLisk(), mBean);
        }
        for (Bean mBean : skillInfo1.getSkillDegree()) {
            addList(skillInfo1.getRankLisk(), mBean);
        }


        return ResultGenerator.genSuccessResult(resumeDiagnosisBean);
    }

    private void addList(List<Integer> mList, Bean mBean) {
        if (!mList.contains(mBean.getId())) {
            mList.add(mBean.getId());
        }
    }

    private void DiagnosisSelfDesc(List<WebResumeEval> byConditionEval, SelfDesc selfDesc) {
        selfDesc.setAllDesc(new ArrayList());
        selfDesc.setSelfDetail(new ArrayList<>());

        if (byConditionEval == null || byConditionEval.size() == 0) {
            return;
        }

        if (byConditionEval.size() == 0) {
            selfDesc.getAllDesc().add("请添加自述。");
            return;
        }

        WebResumeEval webResumeEval = byConditionEval.get(0);
        if (StringUtils.isEmpty(webResumeEval.getContent()) || !RegexUtils.isUsername(webResumeEval.getContent())) {
            selfDesc.getSelfDetail().add("内容无效，请修改。");
        }
        if (!StringUtils.isEmpty(webResumeEval.getContent()) && webResumeEval.getContent().length() < 150) {
            selfDesc.getSelfDetail().add("自述可更加清晰完整，建议不少于150字。");
        }
        if (!StringUtils.isEmpty(webResumeEval.getContent()) && webResumeEval.getContent().length() > 500) {
            selfDesc.getSelfDetail().add("自述可更加简洁精练，建议不超过500字。");
        }

    }

    private void DiagnosisHonor(List<WebResumeHonor> byConditionHonor, HonorInfo honorInfo, List<WebResumeEducation> byConditionEducation) {
        honorInfo.setAllDesc(new ArrayList<>());
        honorInfo.setAwardedUnit(new ArrayList<>());
        honorInfo.setHonorName(new ArrayList<>());
        honorInfo.setObtainTime(new ArrayList<>());

        if (byConditionHonor == null || byConditionHonor.size() == 0) {
            return;
        }


        Collections.sort(byConditionHonor, (o1, o2) -> {
            //>0 正序 <0 反序
            return o1.getRank() == null ? 0 : o1.getRank() - o2.getRank() == 0 ? 0 : o2.getRank();
        });
        ArrayList<String> strings = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> strings2 = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings3 = new ArrayList<>();
        for (int i = 0; i < byConditionHonor.size() - 1; i++) {

            for (int j = i + 1; j < byConditionHonor.size(); j++) {
                if (byConditionHonor.get(i).equals(byConditionHonor.get(j))) {
                    boolean isAdd = false;
                    int z = 0;
                    for (String s : map.values()) {
                        if (s.contains((returnOneTwoThree(byConditionHonor.get(i).getRank())) + "与" + returnOneTwoThree(byConditionHonor.get(j).getRank()))) {
                            isAdd = true;
                        }
                    }
                    if (!isAdd)

                        map.put(returnOneTwoThree(byConditionHonor.get(i).getRank()), map.get(returnOneTwoThree(byConditionHonor.get(i).getRank())) == null ? (returnOneTwoThree(byConditionHonor.get(i).getRank()) + "与" + returnOneTwoThree(byConditionHonor.get(j).getRank())) : "与" + returnOneTwoThree(byConditionHonor.get(j).getRank()));
                }


            }

        }
        for (String s : map.values()) {
            strings.add(s);
        }
        // 完全相同的荣誉
        String s7 = returnString(strings);
        if (!StringUtils.isEmpty(s7))
            honorInfo.getAllDesc().add("第" + s7 + "荣誉奖励重复，请修改。");


        for (int i = 0; i < byConditionHonor.size(); i++) {
            WebResumeHonor webResumeHonor = byConditionHonor.get(i);
            WebResumeHonor webResumeHonor1 = null;
            if (i + 1 < byConditionHonor.size())
                webResumeHonor1 = byConditionHonor.get(i + 1);
            if (byConditionHonor.get(i).getHonorTime() == null) {

                strings1.add(returnOneTwoThree(webResumeHonor.getRank()));

                honorInfo.getHonorName().add(new Bean(webResumeHonor.getRank(), "荣誉奖励请填写获得时间。"));
            }

            if (webResumeHonor1 != null) {
                if ((webResumeHonor.getHonorTime().getTime() - webResumeHonor1.getHonorTime().getTime()) > 0) {
                    Bean bean = new Bean(-1, "荣誉奖励建议最新的放在最上面，按时间顺序排列。");
                    if (!honorInfo.getObtainTime().contains(bean))
                        honorInfo.getObtainTime().add(bean);
                    break;
                }
            }
            if (StringUtils.isEmpty(webResumeHonor.getHonorName())) {
                strings2.add(returnOneTwoThree(webResumeHonor.getRank()));
                honorInfo.getHonorName().add(new Bean(webResumeHonor.getRank(), "荣誉奖励请填写奖项名称"));
            }

            for (WebResumeEducation webResumeEducation : byConditionEducation) {
                if (!StringUtils.isEmpty(webResumeHonor.getOrgName()) && !StringUtils.isEmpty(webResumeEducation.getSchoolName()) && webResumeHonor.getOrgName().equals(webResumeEducation.getSchoolName())) {
                    if (webResumeHonor.getHonorTime() != null && webResumeEducation.getStartTime() != null && webResumeEducation.getEndTime() != null) {
                        if (webResumeHonor.getHonorTime().getTime() < webResumeEducation.getStartTime().getTime() || webResumeEducation.getEndTime().getTime() < webResumeHonor.getHonorTime().getTime()) {
                            strings3.add(returnOneTwoThree(webResumeHonor.getRank()));
                            honorInfo.getObtainTime().add(new Bean(webResumeHonor.getRank(), "荣誉的获得时间与教育经历中的在校时间不符，请确认或修改。"));
                        }
                    }
                }
            }

        }

        String s = returnString(strings1);
    /*    if (StringUtils.isEmpty(s))
            honorInfo.getHonorName().add("第" + s + "个荣誉奖励请填写获得时间。");*/

        String s1 = returnString(strings2);
      /*  if (StringUtils.isEmpty(s1))
            honorInfo.getHonorName().add("第" + s1 + "个荣誉奖励请填写奖项名称");*/

        String s2 = returnString(strings3);
     /*   if (!StringUtils.isEmpty(s2))
            honorInfo.getObtainTime().add("第" + s2 + "个荣誉的获得时间与教育经历中的在校时间不符，请确认或修改。");*/

    }

    private void DiagnosisSkill(List<WebResumeSkill> byConditionSkill, SkillInfo skillInfo) {
        skillInfo.setAllDesc(new ArrayList<>());
        skillInfo.setSkillDegree(new ArrayList<>());
        skillInfo.setSkillName(new ArrayList<>());
        if (byConditionSkill == null || byConditionSkill.size() == 0) {
            return;
        }


        Collections.sort(byConditionSkill, (o1, o2) -> {
            //>0 正序 <0 反序
            return o1.getRank() == null ? 0 : o1.getRank() - o2.getRank() == 0 ? 0 : o2.getRank();
        });
//         存放多段完全相同的技能
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> map1 = new HashMap<>();
        for (int i = 0; i < byConditionSkill.size() - 1; i++) {

            for (int j = i + 1; j < byConditionSkill.size(); j++) {
                if (byConditionSkill.get(i).equals(byConditionSkill.get(j))) {

                    int v = 0;
                    boolean isAdd = false;
                    for (String s : map.values()) {
                        if (s.contains((returnOneTwoThree(byConditionSkill.get(i).getRank())) + "与" + returnOneTwoThree(byConditionSkill.get(j).getRank()))) {
                            isAdd = true;
                        }
                    }
                    if (!isAdd)

                        map.put(returnOneTwoThree(byConditionSkill.get(i).getRank()), map.get(returnOneTwoThree(byConditionSkill.get(i).getRank())) == null ? (returnOneTwoThree(byConditionSkill.get(i).getRank()) + "与" + returnOneTwoThree(byConditionSkill.get(j).getRank())) : "与" + returnOneTwoThree(byConditionSkill.get(j).getRank()));
                }


            }

        }
        for (String s : map.values()) {
            strings.add(s);
        }
        // 完全相同的工作经验
        String s7 = returnString(strings);
        if (!StringUtils.isEmpty(s7))
            skillInfo.getSkillName().add(new Bean(-1, "第" + s7 + "个技能重复，请修改。"));


        // 志平映射职位相关

    }

    /**
     * @param byConditionProject
     * @param projectExpInfo
     */
    private void DiagnosisProject(List<WebResumeProjectExp> byConditionProject, ProjectExpInfo projectExpInfo) {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();
        ArrayList<String> strings3 = new ArrayList<>();
        projectExpInfo.setAllDesc(new ArrayList<>());
        projectExpInfo.setPostionDesc(new ArrayList<>());
        projectExpInfo.setProjectName(new ArrayList<>());
        projectExpInfo.setStartEndTime(new ArrayList<>());
        if (byConditionProject == null || byConditionProject.size() == 0) {
            return;
        }
        Collections.sort(byConditionProject, (o1, o2) -> {
            //>0 正序 <0 反序
            return o1.getRank() == null ? 0 : o1.getRank() - o2.getRank() == 0 ? 0 : o2.getRank();
        });


        // 存放多段完全相同的工作经验经验
        HashMap<String, String> map = new HashMap<>();
//        HashMap<String, String> map1 = new HashMap<>();
        ArrayList<String> stringCH = new ArrayList<>();
        for (int i = 0; i < byConditionProject.size() - 1; i++) {

            for (int j = i + 1; j < byConditionProject.size(); j++) {
                if (byConditionProject.get(i).equals(byConditionProject.get(j))) {
                    boolean isAdd = false;
                    for (String s : map.values()) {
                        if (s.contains((returnOneTwoThree(byConditionProject.get(i).getRank())) + "与" + returnOneTwoThree(byConditionProject.get(j).getRank()))) {
                            isAdd = true;
                        }
                    }
                    if (!isAdd)
                        map.put(returnOneTwoThree(byConditionProject.get(i).getRank()), map.get(returnOneTwoThree(byConditionProject.get(i).getRank())) == null ? (returnOneTwoThree(byConditionProject.get(i).getRank()) + "与" + returnOneTwoThree(byConditionProject.get(j).getRank())) : "与" + returnOneTwoThree(byConditionProject.get(j).getRank()));
                }
               /* if (byConditionProject.get(i).getEndTime().getTime() > byConditionProject.get(j).getBeginTime().getTime()) {
                    map1.put(returnOneTwoThree(byConditionProject.get(i).getRank()), map.get(returnOneTwoThree(byConditionProject.get(i).getRank())) == null ? (returnOneTwoThree(byConditionProject.get(i).getRank()) + "与" + returnOneTwoThree(byConditionProject.get(j).getRank())) : "与" + returnOneTwoThree(byConditionProject.get(j).getRank()));
                }*/
                WebResumeProjectExp webResumeProjectExp = byConditionProject.get(i);
                WebResumeProjectExp webResumeProjectExp1 = byConditionProject.get(j);
                Date startTime = webResumeProjectExp.getBeginTime();
                Date endTime = webResumeProjectExp.getEndTime();
                Date endTime1 = webResumeProjectExp1.getEndTime();
                Date startTime1 = webResumeProjectExp1.getBeginTime();
                // 第一个至今
                boolean isOneToNew = false;
                if (startTime != null && endTime == null) {
                    isOneToNew = true;
                }
                // 第二个至今
                boolean isTwoToNew = false;
                if (startTime1 != null && endTime1 == null) {
                    isTwoToNew = true;
                }
                if (!isOneToNew && isTwoToNew) {
//                    if (endTime.getTime() > startTime1.getTime() && startTime.getTime() < endTime1.getTime()) {
                    if (endTime.getTime() > startTime1.getTime()) {
                        // 重合
                        UpdateCHProject(stringCH, webResumeProjectExp, webResumeProjectExp1);

                    }
                } else if (isOneToNew && isTwoToNew) {
                    // 肯定重合
                    UpdateCHProject(stringCH, webResumeProjectExp, webResumeProjectExp1);
                } else if (isOneToNew) {
                    if (startTime.getTime() < endTime1.getTime()) {
                        UpdateCHProject(stringCH, webResumeProjectExp, webResumeProjectExp1);

                    }
                } else {
                    // if (!isOneToNew && !isTwoToNew)
                    if (endTime.getTime() > startTime1.getTime() && startTime.getTime() < endTime1.getTime()) {
                        UpdateCHProject(stringCH, webResumeProjectExp, webResumeProjectExp1);
                    }
                }

            }

        }
        for (String s : map.values()) {
            strings.add(s);
        }
        // 完全相同的工作经验
        String s7 = returnString(strings);
        if (!StringUtils.isEmpty(s7))
            projectExpInfo.getAllDesc().add("第" + s7 + "段段项目经历重复，请修改。");

       /* for (String s : map1.values()) {
            strings1.add(s);
        }*/
        // 时间重叠
        String s8 = returnString(stringCH);
        if (!StringUtils.isEmpty(s8))
            projectExpInfo.getStartEndTime().add(new Bean(-1, "第" + s8 + "段项目的起止时间重叠，请确认或修改。（如确认无误或已修改可忽略此提示"));

        for (int j = 0; j < byConditionProject.size(); j++) {
            WebResumeProjectExp webResumeProjectExp = byConditionProject.get(j);
            WebResumeProjectExp webResumeProjectExp1 = null;
            if (j + 1 < byConditionProject.size())
                webResumeProjectExp1 = byConditionProject.get(j + 1);
            // 未按时间先后排序
            if (webResumeProjectExp1 != null) {
                if ((webResumeProjectExp.getBeginTime().getTime() - webResumeProjectExp1.getBeginTime().getTime()) > 0) {
                    Bean bean = new Bean(-1, "项目经历建议最新的放在最上面，按时间顺序排列。");
                    if (!projectExpInfo.getStartEndTime().contains(bean))
                        projectExpInfo.getStartEndTime().add(bean);
                    break;
                }


            }
            String content = webResumeProjectExp.getContent();
            if (!StringUtils.isEmpty(content) && content.length() < 50) {
                strings2.add(returnOneTwoThree(webResumeProjectExp.getRank()));
                projectExpInfo.getPostionDesc().add(new Bean(webResumeProjectExp.getRank(), "第" + webResumeProjectExp.getRank() + "段项目经历的项目描述可更加清晰完整，建议不少于50字。"));
            }
            if (!StringUtils.isEmpty(content) && content.length() > 500) {
                strings3.add(returnOneTwoThree(webResumeProjectExp.getRank()));
                projectExpInfo.getPostionDesc().add(new Bean(webResumeProjectExp.getRank(), "第" + webResumeProjectExp.getRank() + "段项目经历的项目描述可更加简洁精练，建议不超过500字。"));
            }
          /*  String jobName = webResumeProjectExp.getJobName();
            if (!StringUtils.isEmpty(jobName)&&)*/
        }
        String s2 = returnString(strings2);
       /* if (!StringUtils.isEmpty(s2))
            projectExpInfo.getPostionDesc().add("第" + s2 + "段项目经历的项目描述可更加清晰完整，建议不少于50字。");*/
        String s3 = returnString(strings3);
      /*  if (!StringUtils.isEmpty(s3))
            projectExpInfo.getPostionDesc().add("第" + s3 + "段项目经历的项目描述可更加简洁精练，建议不超过500字。");*/
    }


    /**
     * @param byConditionWorkexp
     * @param workExpInfo
     */
    private void DiagnosisWork(List<WebResumeWorkExp> byConditionWorkexp, WorkExpInfo workExpInfo) {
        workExpInfo.setStartEndTime(new ArrayList<>());
        workExpInfo.setAllDesc(new ArrayList<>());
        workExpInfo.setCompanyName(new ArrayList<>());
        workExpInfo.setPostionName(new ArrayList<>());
        workExpInfo.setWorkDesc(new ArrayList<>());


        if (byConditionWorkexp == null || byConditionWorkexp.size() == 0) {
            return;
        }
        Collections.sort(byConditionWorkexp, (o1, o2) -> {
            //>0 正序 <0 反序
            return o1.getRank() == null ? 0 : o1.getRank() - o2.getRank() == 0 ? 0 : o2.getRank();
        });

        ArrayList<String> strings5 = new ArrayList<>();
//        ArrayList<String> strings6 = new ArrayList<>();


        //
        ArrayList<String> strings7 = new ArrayList<>();

        // 存放多段完全相同的工作经验经验
        HashMap<String, String> map = new HashMap<>();
//        HashMap<String, String> map1 = new HashMap<>();
        ArrayList<String> stringCH = new ArrayList<>();
        for (int i = 0; i < byConditionWorkexp.size() - 1; i++) {
            for (int j = i + 1; j < byConditionWorkexp.size(); j++) {
                if (byConditionWorkexp.get(i).equals(byConditionWorkexp.get(j))) {
                    boolean isAdd = false;
                    for (String s : map.values()) {
                        if (s.contains((returnOneTwoThree(byConditionWorkexp.get(i).getRank())) + "与" + returnOneTwoThree(byConditionWorkexp.get(j).getRank()))) {
                            isAdd = true;
                        }
                    }
                    if (!isAdd)
                        map.put(returnOneTwoThree(byConditionWorkexp.get(i).getRank()), map.get(returnOneTwoThree(byConditionWorkexp.get(i).getRank())) == null ? (returnOneTwoThree(byConditionWorkexp.get(i).getRank())) + "与" + returnOneTwoThree(byConditionWorkexp.get(j).getRank()) : "与" + returnOneTwoThree(byConditionWorkexp.get(j).getRank()));
                }
               /* if (byConditionWorkexp.get(i).getEndTime().getTime() > byConditionWorkexp.get(j).getStartTime().getTime() && byConditionWorkexp.get(i).getStartTime().getTime() < byConditionWorkexp.get(j).getEndTime().getTime()) {
                    map1.put(returnOneTwoThree(byConditionWorkexp.get(i).getRank()), map.get(returnOneTwoThree(byConditionWorkexp.get(i).getRank())) == null ? (returnOneTwoThree(byConditionWorkexp.get(i).getRank())) + "与" + returnOneTwoThree(byConditionWorkexp.get(j).getRank()) : "与" + returnOneTwoThree(byConditionWorkexp.get(j).getRank()));
                }*/
                WebResumeWorkExp webResumeWorkExp = byConditionWorkexp.get(i);
                WebResumeWorkExp webResumeWorkExp1 = byConditionWorkexp.get(j);
                Date startTime = webResumeWorkExp.getStartTime();
                Date endTime = webResumeWorkExp.getEndTime();
                Date endTime1 = webResumeWorkExp1.getEndTime();
                Date startTime1 = webResumeWorkExp1.getStartTime();
                // 第一个至今
                boolean isOneToNew = false;
                if (startTime != null && endTime == null) {
                    isOneToNew = true;
                }
                // 第二个至今
                boolean isTwoToNew = false;
                if (startTime1 != null && endTime1 == null) {
                    isTwoToNew = true;
                }
                if (!isOneToNew && isTwoToNew) {
                    if (endTime.getTime() > startTime1.getTime()) {
                        // 重合
                        UpdateCH(stringCH, webResumeWorkExp, webResumeWorkExp1);

                    }
                } else if (isOneToNew && isTwoToNew) {
                    // 肯定重合
                    UpdateCH(stringCH, webResumeWorkExp, webResumeWorkExp1);
                } else if (isOneToNew) {
                    if (startTime.getTime() <= endTime1.getTime()) {
                        UpdateCH(stringCH, webResumeWorkExp, webResumeWorkExp1);

                    }
                } else {
                    //if (!isOneToNew && !isTwoToNew)
                    if (endTime.getTime() > startTime1.getTime() && startTime.getTime() < endTime1.getTime()) {
                        UpdateCH(stringCH, webResumeWorkExp, webResumeWorkExp1);
                    }
                }


            }

        }


        for (String s : map.values()) {
            strings5.add(s);
        }


        // 完全相同的工作经验
        String s7 = returnString(strings5);
        if (!StringUtils.isEmpty(s7))
            workExpInfo.getAllDesc().add("第" + s7 + "段工作经验时间，公司名称，职位名称相同");

      /*  for (String s : map1.values()) {
            strings6.add(s);
        }*/
        // 时间重叠
        String s8 = returnString(stringCH);
        if (!StringUtils.isEmpty(s8))
            workExpInfo.getStartEndTime().add(new Bean(-1, "第" + s8 + "段工作经历的起止时间重叠，请确认或修改。（如确认无误或已修改可忽略此提示"));

        long minTime = 0;
        long maxTime = 0;
        boolean isPostionOne = false;
        boolean isPostionTwo = false;

        List<WebTplLowestYear> all = webTplLowestYearService.findAll();
        ArrayList<YearBean> beans = new ArrayList<>();
        for (int j = 0; j < byConditionWorkexp.size(); j++) {


            WebResumeWorkExp webResumeWorkExp = byConditionWorkexp.get(j);
            WebResumeWorkExp webResumeWorkExp1 = null;
            if (j + 1 < byConditionWorkexp.size())
                webResumeWorkExp1 = byConditionWorkexp.get(j + 1);
            if (j == 0) {
                minTime = webResumeWorkExp.getStartTime().getTime();
            }
            if (!StringUtils.isEmpty(webResumeWorkExp.getJobTitle()) && PublicKetUtils.haveContins(webResumeWorkExp.getJobTitle(), AppConstant.postionOne))
                isPostionOne = true;
            if (!StringUtils.isEmpty(webResumeWorkExp.getJobTitle()) && PublicKetUtils.haveContins(webResumeWorkExp.getJobTitle(), AppConstant.postionTwo))
                isPostionTwo = true;
            // 未按时间先后排序
            if (webResumeWorkExp1 != null) {
                if ((webResumeWorkExp.getStartTime().getTime() - webResumeWorkExp1.getStartTime().getTime()) > 0) {
                    Bean bean = new Bean(-1, "工作经历建议最新的放在最上面，按时间顺序排列。");
                    if (!workExpInfo.getStartEndTime().contains(bean))
                        workExpInfo.getStartEndTime().add(bean);

                    break;
                }


            }
            Date endTime = webResumeWorkExp.getEndTime() == null ? new Date() : webResumeWorkExp.getEndTime();
            Date startTime = webResumeWorkExp.getStartTime();
            if (((endTime.getTime() - startTime.getTime()) / 2592000000L) < 3) {
                strings7.add(returnOneTwoThree(webResumeWorkExp.getRank()));
                workExpInfo.getStartEndTime().add(new Bean(webResumeWorkExp.getRank(), "第" + webResumeWorkExp.getRank() + "段工作经历不超过三个月，不建议添加。如是实习或兼职请注明。"));
            }
            if (endTime.getTime() > maxTime)
                maxTime = endTime.getTime();
            if (startTime.getTime() < minTime)
                minTime = startTime.getTime();
            if (!StringUtils.isEmpty(webResumeWorkExp.getJobTitle())) {

                for (WebTplLowestYear webTplLowestYear : all) {
                    if (webResumeWorkExp.getJobTitle().contains(webTplLowestYear.getHead() + webTplLowestYear.getTail()) || (webTplLowestYear.getHead() + webTplLowestYear.getTail()).contains(webResumeWorkExp.getJobTitle())) {
//                        beans.add(new Bean(webTplLowestYear.getLowestYear(), webResumeWorkExp.getJobTitle()));
                        beans.add(new YearBean(j, webTplLowestYear.getLowestYear(), webResumeWorkExp.getJobTitle(), endTime.getTime()));
                    }
                }
            }
            if (StringUtils.isEmpty(webResumeWorkExp.getWorkResp())) {
                workExpInfo.getWorkDesc().add(new Bean(webResumeWorkExp.getRank(), "工作经历请填写工作描述。"));
            }
            if (!StringUtils.isEmpty(webResumeWorkExp.getWorkResp()) && webResumeWorkExp.getWorkResp().length() < 50) {
                workExpInfo.getWorkDesc().add(new Bean(webResumeWorkExp.getRank(), "工作经历的工作描述可更加清晰完整，建议不少于50字。"));
            }
            if (!StringUtils.isEmpty(webResumeWorkExp.getWorkResp()) && webResumeWorkExp.getWorkResp().length() > 500) {
                workExpInfo.getWorkDesc().add(new Bean(webResumeWorkExp.getRank(), "工作经历的工作描述可更加简洁精练，建议不超过500字。"));
            }

        }
        // 工作时长
        String s = returnString(strings7);
       /* if (!StringUtils.isEmpty())
        List<WebTplLowestYear> all = webTplLowestYearService.findAll();
        for (WebTplLowestYear webTplLowestYear : all){

        }*/
        for (YearBean mYearBean : beans) {
            if ((mYearBean.getEndYear() - minTime) / 31536000000L < mYearBean.getYear() && !workExpInfo.getAllDesc().contains("每段工作的起止时间和职位名称是否填写正确，请确认。（如确认无误可忽略此提示）")) {
                workExpInfo.getAllDesc().add("每段工作的起止时间和职位名称是否填写正确，请确认。（如确认无误可忽略此提示）");
            }
        }

     /*   if ((isPostionOne && ((maxTime - minTime) / 31536000000L) < 1) || (isPostionTwo && ((maxTime - minTime) / 31536000000L) < 2)) {
            workExpInfo.getAllDesc().add("每段工作的起止时间和职位名称是否填写正确，请确认。（如确认无误可忽略此提示）");
        }*/


    }

    private void UpdateCHProject(ArrayList<String> stringCH, WebResumeProjectExp webResumeWorkExp, WebResumeProjectExp webResumeWorkExp1) {
        if (stringCH.size() != 0) {
            for (int m = 0; m < stringCH.size(); m++) {
                String sCH = stringCH.get(m);
                if (sCH.contains(returnOneTwoThree(webResumeWorkExp.getRank())) && !sCH.contains(returnOneTwoThree(webResumeWorkExp1.getRank()))) {
                    stringCH.set(m, sCH + "与" + returnOneTwoThree(webResumeWorkExp1.getRank()));
                } else if (!sCH.contains(returnOneTwoThree(webResumeWorkExp.getRank())) && sCH.contains(returnOneTwoThree(webResumeWorkExp1.getRank()))) {
                    stringCH.set(m, sCH + "与" + returnOneTwoThree(webResumeWorkExp.getRank()));
                } else if (!sCH.contains(returnOneTwoThree(webResumeWorkExp.getRank())) && !sCH.contains(returnOneTwoThree(webResumeWorkExp1.getRank()))) {
                    stringCH.add((returnOneTwoThree(webResumeWorkExp.getRank())) + "与" + returnOneTwoThree(webResumeWorkExp1.getRank()));
                }
            }
        } else {
            stringCH.add((returnOneTwoThree(webResumeWorkExp.getRank())) + "与" + returnOneTwoThree(webResumeWorkExp1.getRank()));
        }
    }

    private void UpdateCH(ArrayList<String> stringCH, WebResumeWorkExp webResumeWorkExp, WebResumeWorkExp webResumeWorkExp1) {
        if (stringCH.size() != 0) {
            for (int m = 0; m < stringCH.size(); m++) {
                String sCH = stringCH.get(m);
                if (sCH.contains(returnOneTwoThree(webResumeWorkExp.getRank())) && !sCH.contains(returnOneTwoThree(webResumeWorkExp1.getRank()))) {
                    stringCH.set(m, sCH + "与" + returnOneTwoThree(webResumeWorkExp1.getRank()));
                } else if (!sCH.contains(returnOneTwoThree(webResumeWorkExp.getRank())) && sCH.contains(returnOneTwoThree(webResumeWorkExp1.getRank()))) {
                    stringCH.set(m, sCH + "与" + returnOneTwoThree(webResumeWorkExp.getRank()));
                } else if (!sCH.contains(returnOneTwoThree(webResumeWorkExp.getRank())) && !sCH.contains(returnOneTwoThree(webResumeWorkExp1.getRank()))) {
                    stringCH.add((returnOneTwoThree(webResumeWorkExp.getRank())) + "与" + returnOneTwoThree(webResumeWorkExp1.getRank()));
                }
            }
        } else {
            stringCH.add((returnOneTwoThree(webResumeWorkExp.getRank())) + "与" + returnOneTwoThree(webResumeWorkExp1.getRank()));
        }
    }

    private void UpdateCHEd(ArrayList<String> stringCH, WebResumeEducation webResumeWorkExp, WebResumeEducation webResumeWorkExp1) {
        if (stringCH.size() != 0) {
            for (int m = 0; m < stringCH.size(); m++) {
                String sCH = stringCH.get(m);
                if (sCH.contains(returnOneTwoThree(webResumeWorkExp.getRank())) && !sCH.contains(returnOneTwoThree(webResumeWorkExp1.getRank()))) {
                    stringCH.set(m, sCH + "与" + returnOneTwoThree(webResumeWorkExp1.getRank()));
                } else if (!sCH.contains(returnOneTwoThree(webResumeWorkExp.getRank())) && sCH.contains(returnOneTwoThree(webResumeWorkExp1.getRank()))) {
                    stringCH.set(m, sCH + "与" + returnOneTwoThree(webResumeWorkExp.getRank()));
                } else if (!sCH.contains(returnOneTwoThree(webResumeWorkExp.getRank())) && !sCH.contains(returnOneTwoThree(webResumeWorkExp1.getRank()))) {
                    stringCH.add((returnOneTwoThree(webResumeWorkExp.getRank())) + "与" + returnOneTwoThree(webResumeWorkExp1.getRank()));
                }
            }
        } else {
            stringCH.add((returnOneTwoThree(webResumeWorkExp.getRank())) + "与" + returnOneTwoThree(webResumeWorkExp1.getRank()));
        }
    }

    private void DiagnososCer(List<WebResumeCertificate> byConditionCer, CerInfo cerInfo) {
        cerInfo.setCerName(new ArrayList<>());
        cerInfo.setAllDesc(new ArrayList<>());
        cerInfo.setObtainTime(new ArrayList<>());
        if (byConditionCer == null || byConditionCer.size() == 0) {
            return;
        }

        Collections.sort(byConditionCer, (o1, o2) -> {
            //>0 正序 <0 反序
            return o1.getRank() == null ? 0 : o1.getRank() - o2.getRank() == 0 ? 0 : o2.getRank();
        });
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();
        ArrayList<String> strings3 = new ArrayList<>();
        ArrayList<String> strings4 = new ArrayList<>();
        ArrayList<String> strings5 = new ArrayList<>();
//        ArrayList<String> strings6 = new ArrayList<>();
//        ArrayList<String> strings7 = new ArrayList<>();
//        ArrayList<String> strings8 = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < byConditionCer.size() - 1; i++) {
            for (int j = i + 1; j < byConditionCer.size(); j++) {
                insertMap(byConditionCer, map, i, j);
            }

        }

        for (String s : map.values()) {
            strings.add(s);
        }
        String s7 = returnString(strings);
        if (!StringUtils.isEmpty(s7))
            cerInfo.getAllDesc().add("第" + s7 + "证书的名称和获得时间完全相同");
        // 不会存在没有填证书名字的证书
        for (WebResumeCertificate webResumeCertificate : byConditionCer) {
            String certificateName = webResumeCertificate.getCertificateName();
            //或者证书时间
            Date gettime = webResumeCertificate.getGettime();
            if (StringUtils.isEmpty(certificateName)) {
                strings1.add(returnOneTwoThree(webResumeCertificate.getRank()));
                cerInfo.getCerName().add(new Bean(webResumeCertificate.getRank(), "证书名称未填写"));
            }
            if (gettime == null) {
                strings2.add(returnOneTwoThree(webResumeCertificate.getRank()));
                cerInfo.getObtainTime().add(new Bean(webResumeCertificate.getRank(), "证书获得时间未填写"));
            }

            if (!RegexUtils.isUsername(certificateName)) {
                strings3.add(returnOneTwoThree(webResumeCertificate.getRank()));
                cerInfo.getCerName().add(new Bean(webResumeCertificate.getRank(), "证书名称无效，请修改。"));
            }

            if (certificateName.length() < 2) {
                strings4.add(returnOneTwoThree(webResumeCertificate.getRank()));
                cerInfo.getCerName().add(new Bean(webResumeCertificate.getRank(), "证书的名称过短（小于2个字符），建议补全。"));
            }

            if (certificateName.length() > 20) {
                strings5.add(returnOneTwoThree(webResumeCertificate.getRank()));
                cerInfo.getCerName().add(new Bean(webResumeCertificate.getRank(), "证书的名称过长（大于20个字符），建议精简"));
            }

        }
        /* String s = returnString(strings1);
         *//*  if (!StringUtils.isEmpty(s))
            cerInfo.getCerName().add(s + "证书名称未填写");*//*
        String s1 = returnString(strings2);
       *//* if (!StringUtils.isEmpty(s1))
            cerInfo.getObtainTime().add(s1 + "证书获得时间未填写");*//*
        String s2 = returnString(strings3);
    *//*    if (!StringUtils.isEmpty(s2))
            cerInfo.getCerName().add("第" + s2 + "份证书名称无效，请修改。");*//*
        String s3 = returnString(strings4);
      *//*  if (!StringUtils.isEmpty(s3))
            cerInfo.getCerName().add("第" + s3 + "份证书的名称过短（小于2个字符），建议补全。");*//*
        String s4 = returnString(strings5);
        *//*if (!StringUtils.isEmpty(s4))
            cerInfo.getCerName().add("第" + s4 + "份证书的名称过长（大于20个字符），建议精简");*//*

         */
    }

    private void insertMap(List<WebResumeCertificate> byConditionCer, HashMap<String, String> map, int i, int j) {
        if (byConditionCer.get(i).equals(byConditionCer.get(j))) {
            boolean isAdd = false;
            for (String s : map.values()) {
                if (s.contains((returnOneTwoThree(byConditionCer.get(i).getRank())) + "与" + returnOneTwoThree(byConditionCer.get(j).getRank()))) {
                    isAdd = true;
                }
            }
            if (!isAdd)
                map.put(returnOneTwoThree(byConditionCer.get(i).getRank()), map.get(returnOneTwoThree(byConditionCer.get(i).getRank())) == null ? (returnOneTwoThree(byConditionCer.get(i).getRank()) + "、" + returnOneTwoThree(byConditionCer.get(j).getRank())) : "、" + returnOneTwoThree(byConditionCer.get(j).getRank()));
        }
    }

    private void DiagnososEducatin(List<WebResumeEducation> byConditionEducation, EducationInfo educationInfo) {

        educationInfo.setAllDesc(new ArrayList<>());
        educationInfo.setMajorName(new ArrayList<>());
        educationInfo.setSchoolName(new ArrayList<>());
        educationInfo.setStartEndDate(new ArrayList<>());
        if (byConditionEducation == null || byConditionEducation.size() == 0) {
            return;
        }


        if (byConditionEducation != null && byConditionEducation.size() != 0) {
            Collections.sort(byConditionEducation, (o1, o2) -> {
                //>0 正序 <0 反序
                return o1.getRank() == null ? 0 : o1.getRank() - o2.getRank() == 0 ? 0 : o2.getRank();
            });
//            Condition condition = new Condition(WebMsgMap.class);
//            condition.createCriteria().andCondition("module_id = 2 and status = 1");
//            List<WebMsgMap> byConditionMsg = webMsgMapService.findByCondition(condition);
            ArrayList<String> strings = new ArrayList<>();
            ArrayList<String> strings1 = new ArrayList<>();
            ArrayList<String> strings2 = new ArrayList<>();
            ArrayList<String> strings3 = new ArrayList<>();
            ArrayList<String> strings4 = new ArrayList<>();
            ArrayList<String> strings5 = new ArrayList<>();
            ArrayList<String> strings6 = new ArrayList<>();
            ArrayList<String> strings7 = new ArrayList<>();
            ArrayList<String> strings8 = new ArrayList<>();
            HashMap<String, String> map = new HashMap<>();
            ArrayList<String> stringCH = new ArrayList<>();
//            ArrayList<String> strings8 = new ArrayList<>();
//            for (WebMsgMap webMsgMap : byConditionMsg) {
            for (int i = 0; i < byConditionEducation.size() - 1; i++) {
                for (int j = i + 1; j < byConditionEducation.size(); j++) {
                  /*  if (byConditionEducation.get(i).equals(j)) {
                        map.put(returnOneTwoThree(i), map.get(returnOneTwoThree(i)) == null ? "" : "、" + returnOneTwoThree(j));
                    }*/
                    if (byConditionEducation.get(i).equals(byConditionEducation.get(j))) {
                        boolean isAdd = false;
                        int z = 0;
                        for (String s : map.values()) {
                            if (s.contains((returnOneTwoThree(byConditionEducation.get(i).getRank())) + "与" + returnOneTwoThree(byConditionEducation.get(j).getRank()))) {
                                isAdd = true;
                            }
                        }
                        if (!isAdd)
                            map.put(returnOneTwoThree(byConditionEducation.get(i).getRank()), map.get(returnOneTwoThree(byConditionEducation.get(i).getRank())) == null ? (returnOneTwoThree(byConditionEducation.get(i).getRank()) + "、" + returnOneTwoThree(byConditionEducation.get(j).getRank())) : "、" + returnOneTwoThree(byConditionEducation.get(j).getRank()));
                    }

                    WebResumeEducation webResumeEducation = byConditionEducation.get(i);
                    WebResumeEducation webResumeEducation1 = byConditionEducation.get(j);
                    Date startTime = webResumeEducation.getStartTime();
                    Date endTime = webResumeEducation.getEndTime();
                    Date endTime1 = webResumeEducation1.getEndTime();
                    Date startTime1 = webResumeEducation1.getStartTime();
                    // 第一个至今
                    boolean isOneToNew = false;
                    if (startTime != null && endTime == null) {
                        isOneToNew = true;
                    }
                    // 第二个至今
                    boolean isTwoToNew = false;
                    if (startTime1 != null && endTime1 == null) {
                        isTwoToNew = true;
                    }
                    if (!isOneToNew && isTwoToNew) {
                        if (endTime.getTime() > startTime1.getTime()) {
                            // 重合
                            UpdateCHEd(stringCH, webResumeEducation, webResumeEducation1);

                        }
                    } else if (isOneToNew && isTwoToNew) {
                        // 肯定重合
                        UpdateCHEd(stringCH, webResumeEducation, webResumeEducation1);
                    } else if (isOneToNew) {
                        if (startTime.getTime() <= endTime1.getTime()) {
                            UpdateCHEd(stringCH, webResumeEducation, webResumeEducation1);

                        }
                    } else {
                        //if (!isOneToNew && !isTwoToNew)
                        if (endTime.getTime() > startTime1.getTime() && startTime.getTime() < endTime1.getTime()) {
                            UpdateCHEd(stringCH, webResumeEducation, webResumeEducation1);
                        }
                    }


                }

            }

            for (String s : map.values()) {
                strings.add(s);
            }
            String s7 = returnString(strings);
            if (!StringUtils.isEmpty(s7))
                educationInfo.getAllDesc().add("第" + s7 + "段教育经历重复，建议修改。");


            // 时间重叠
            String s8 = returnString(stringCH);
            if (!StringUtils.isEmpty(s8))
                educationInfo.getStartEndDate().add(new Bean(-1, "第" + s8 + "段教育经历的就读时间存在部分重合,请确认或修改。（如确认无误或已修改可忽略此提示"));

            for (int j = 0; j < byConditionEducation.size(); j++) {


                WebResumeEducation webResumeEducation = byConditionEducation.get(j);

                String schoolName = webResumeEducation.getSchoolName();
                String majorName = webResumeEducation.getMajorName();
//                    if (webMsgMap.getItemName().equals("起止时间"))
                WebResumeEducation webResumeEducation1 = null;
                if (j + 1 < byConditionEducation.size())
                    webResumeEducation1 = byConditionEducation.get(j + 1);
                if (webResumeEducation1 != null) {
                    if ((webResumeEducation.getStartTime().getTime() - webResumeEducation1.getStartTime().getTime()) > 0) {
                        Bean bean = new Bean(-1, "教育经历建议最新的放在最上面，按时间顺序排列。");
                        if (!educationInfo.getStartEndDate().contains(bean)) {
                            educationInfo.getStartEndDate().add(bean);
                            break;
                        }
                    }
                  /*  if ((webResumeEducation.getEndTime().getTime() < webResumeEducation1.getStartTime().getTime())) {
                        Bean bean = new Bean(-1, "教育经历的就读时间存在部分重合，请确认或修改。（如确认无误或已修改可忽略此提示）");
                        if (!educationInfo.getStartEndDate().contains(bean)) {
                            educationInfo.getStartEndDate().add(bean);
                            break;
                        }
                    }*/

                }
                if ((webResumeEducation.getEndTime() != null && webResumeEducation.getStartTime() != null) && (webResumeEducation.getEndTime().getTime() - webResumeEducation.getStartTime().getTime()) < 0) {
                    strings7.add(returnOneTwoThree(webResumeEducation.getRank()));
                    educationInfo.getStartEndDate().add(new Bean(webResumeEducation.getRank(), "第" + webResumeEducation.getRank() + "段教育经历的起始时间晚于结束时间，请修改。"));
                }


                if (!RegexUtils.isUsername(schoolName)) {
                    strings1.add(returnOneTwoThree(webResumeEducation.getRank()));
                    educationInfo.getSchoolName().add(new Bean(webResumeEducation.getRank(), "第" + webResumeEducation.getRank() + "段教育经历的学校名称无效，请修改。"));
                }

                if (schoolName.length() < 2) {
                    strings2.add(returnOneTwoThree(webResumeEducation.getRank()));
                    educationInfo.getSchoolName().add(new Bean(webResumeEducation.getRank(), "第" + webResumeEducation.getRank() + "段教育经历的学校名称过短（小于2个字符），请填写学校最新全称。"));
                }

                if (schoolName.length() > 30) {
                    strings3.add(returnOneTwoThree(webResumeEducation.getRank()));
                    educationInfo.getSchoolName().add(new Bean(webResumeEducation.getRank(), "第" + webResumeEducation.getRank() + "段教育经历的学校名称过长（大于30个字符），请填写学校最新全称。"));
                }

                if (!RegexUtils.isUsername(majorName)) {
                    strings4.add(returnOneTwoThree(webResumeEducation.getRank()));
                    educationInfo.getMajorName().add(new Bean(webResumeEducation.getRank(), "第" + webResumeEducation.getRank() + "段教育经历的专业名称无效，请修改。"));
                }

                if (majorName.length() < 2) {
                    strings5.add(returnOneTwoThree(webResumeEducation.getRank()));
                    educationInfo.getMajorName().add(new Bean(webResumeEducation.getRank(), "第" + webResumeEducation.getRank() + "段教育经历的专业名称过短（小于2个字符），请填写专业全称。"));
                }

                if (majorName.length() > 20) {
                    strings6.add(returnOneTwoThree(webResumeEducation.getRank()));
                    educationInfo.getMajorName().add(new Bean(webResumeEducation.getRank(), "第" + webResumeEducation.getRank() + "段教育经历的专业名称过长（大于20个字符），请填写专业全称。"));
                }

                // 综合
                if (webResumeEducation.getMajorId() != null && webResumeEducation.getMajorId() != -1) {
                    if (!educationInfo.getAllDesc().contains("根据简历中的教育经历，为您推荐了所学专业的就业分析报告"))
                        educationInfo.getAllDesc().add("根据简历中的教育经历，为您推荐了所学专业的就业分析报告");
                }
                if (webResumeEducation.getDegree() == 3 && (Integer.parseInt(DataUtil.dfDateYear.get().format(webResumeEducation.getEndTime())) - Integer.parseInt(DataUtil.dfDateYear.get().format(webResumeEducation.getStartTime())) < 4))
                    educationInfo.getAllDesc().add(webResumeEducation.getSchoolName() + "就读时长与学历不符，请仔细核查。如无误建议特殊说明。");

            }

            String s = returnString(strings1);
            String s1 = returnString(strings2);
            String s2 = returnString(strings3);
          /*  if (!StringUtils.isEmpty(s))
                educationInfo.getSchoolName().add("第" + s + "段教育经历的学校名称无效，请修改。");*/
          /*  if (!StringUtils.isEmpty(s1))
                educationInfo.getSchoolName().add("第" + s1 + "段教育经历的学校名称过短（小于2个字符），请填写学校最新全称。");*/
         /*   if (!StringUtils.isEmpty(s2))
                educationInfo.getSchoolName().add("第" + s2 + "段教育经历的学校名称过长（大于30个字符），请填写学校最新全称。");*/
            String s3 = returnString(strings4);
            String s4 = returnString(strings5);
            String s5 = returnString(strings6);
          /*  if (!StringUtils.isEmpty(s3))
                educationInfo.getMajorName().add("第" + s + "段教育经历的专业名称无效，请修改。");*/
           /* if (!StringUtils.isEmpty(s4))
                educationInfo.getMajorName().add("第" + s4 + "段教育经历的专业名称过短（小于2个字符），请填写专业全称。");*/
           /* if (!StringUtils.isEmpty(s5))
                educationInfo.getMajorName().add("第" + s5 + "段教育经历的专业名称过长（大于20个字符），请填写专业全称。");*/
            String s6 = returnString(strings7);
           /* if (!StringUtils.isEmpty(s6))
                educationInfo.getStartEndDate().add("第" + s6 + "段教育经历的起始时间晚于结束时间，请修改。");*/

        }


    }

    private String returnString(ArrayList<String> strings1) {
        String hh = "";
        if (strings1.size() != 0) {

            for (int i = 0; i < strings1.size(); i++) {
                if (i == strings1.size() - 1)
                    hh += strings1.get(i);
                else
                    hh += strings1.get(i) + "、";
            }

        }
        return hh;
    }

//    }

    private String returnOneTwoThree(int i) {
        String name = null;
        switch (i) {
            case 1:
                name = "一";
                break;
            case 2:
                name = "二";
                break;
            case 3:
                name = "三";
                break;
            case 4:
                name = "四";
                break;
            case 5:
                name = "五";
                break;
            case 6:
                name = "六";
                break;

        }

        return name;
    }

    // 个人信息的返回
    private void DiagnosisWebProfile(List<WebProfile> byConditionProfile, UserInfo userInfo) {
        userInfo.setAdressDetail(new ArrayList<>());
        userInfo.setAllDesc(new ArrayList<>());
        userInfo.setBirthday(new ArrayList<>());
        userInfo.setEmilNum(new ArrayList<>());
        userInfo.setName(new ArrayList<>());
        userInfo.setPhoneNum(new ArrayList<>());
        userInfo.setPhotoDesc(new ArrayList<>());
        if (byConditionProfile == null || byConditionProfile.size() == 0) {
            return;
        }

//        userInfo.setIntentionCity(new ArrayList<>());

        if (byConditionProfile != null && byConditionProfile.size() != 0) {
            Condition condition = new Condition(WebMsgMap.class);
            condition.createCriteria().andCondition("module_id = 1 and status = 1");
            List<WebMsgMap> byConditionMsg = webMsgMapService.findByCondition(condition);


            WebProfile webProfile = byConditionProfile.get(0);
            String realName = webProfile.getRealName().trim();

            Date birthday = webProfile.getBirthday();
            String format = DataUtil.dfDateYear.get().format(new Date());
            String format1 = null;
            if (birthday != null) {
                format1 = DataUtil.dfDateYear.get().format(birthday);
            }
            String phone = webProfile.getPhone();
            String email = webProfile.getEmail();
            String address = webProfile.getAddress();
            String avatarUrl = webProfile.getAvatarUrl();
//           String intentioncity = webProfile.getIntentioncity();
            String householdCityName = webProfile.getHouseholdCityName();
            String cityName = webProfile.getCityName();
            Byte workStatus = webProfile.getWorkStatus();
            Byte marital = webProfile.getMarital();
            Integer salaryStart = webProfile.getSalaryStart();
            Integer salaryEnd = webProfile.getSalaryEnd();
            Byte salaryDiscuss = webProfile.getSalaryDiscuss();

            getSalaryStatus(salaryStart, salaryEnd, salaryDiscuss);
            if (!StringUtils.isEmpty(realName) && (realName.length() < 2 || realName.length() > 15 || realName.matches("[a-zA-Z]+"))) {
                userInfo.getName().add("建议填写真实、完整姓名，有利于给HR留下更好的印象。");
            }
            if (!StringUtils.isEmpty(format1) && ((Integer.parseInt(format) - Integer.parseInt(format1)) < 16)) {
                userInfo.getBirthday().add("年龄太小（小于16岁），请核查是否正确。");
            }
            if (!StringUtils.isEmpty(format1) && ((Integer.parseInt(format) - Integer.parseInt(format1)) > 100)) {
                userInfo.getBirthday().add("年龄太大（大于100岁），请核查是否正确。");
            }
            if (!StringUtils.isEmpty(phone) && (phone.length() != 11 || !RegexUtils.isMobileExact(phone))) {
                userInfo.getPhoneNum().add("请填写有效手机号码，方便HR电话联系你。");
            }
            if (!StringUtils.isEmpty(email) && !RegexUtils.isEmail(email)) {
                userInfo.getEmilNum().add("请填写有效邮箱，方便HR邮件联系你。");
            }
            if (!StringUtils.isEmpty(address) && !RegexUtils.isUsername(address)) {
                userInfo.getAdressDetail().add("请填写有效的地址信息。");
            }
            if (!StringUtils.isEmpty(address) && !RegexUtils.isUsername(address) && address.length() < 2) {
                userInfo.getAdressDetail().add("填写的住址信息过短（小于2个字符），建议补全。");
            }
            if (!StringUtils.isEmpty(address) && !RegexUtils.isUsername(address) && address.length() > 50) {
                userInfo.getAdressDetail().add("填写的住址信息过长（大于50个字符），建议精简。");
            }
            if (StringUtils.isEmpty(avatarUrl)) {
                userInfo.getPhotoDesc().add("建议上传个人免冠照片，帮助HR快速建立第一形象。");
            }
          /*  if ((getSalaryStatus(salaryStart, salaryEnd, salaryDiscuss) || StringUtils.isEmpty(householdCityName) || StringUtils.isEmpty(cityName) || workStatus == null) || StringUtils.isEmpty(address)) {
                userInfo.getAllDesc().add("请添加意向城市/照片/居住地/户籍地/期望月薪/婚姻状态/详细住址");
            }*/
            StringBuilder pb = new StringBuilder();
            pb.append("请添加");

            if (getSalaryStatus(salaryStart, salaryEnd, salaryDiscuss)) {
                pb.append("期望月薪/");
            }
            if (StringUtils.isEmpty(householdCityName)) {
                pb.append("户籍地/");
            }
            if (StringUtils.isEmpty(cityName)) {
                pb.append("居住地/");
            }
            if (workStatus == null) {
                pb.append("工作状态/");
            }
            if (StringUtils.isEmpty(address)) {
                pb.append("详细地址/");
            }
            if (marital == null || marital == 0) {
                pb.append("婚姻状态/");
            }
            if (pb.toString().length() != 3)
                userInfo.getAllDesc().add(pb.toString().substring(0, pb.toString().length() - 1));


           /* if (getSalaryStatus(salaryStart, salaryEnd, salaryDiscuss))
                userInfo.get*/


        }


    }

    /**
     * @param salaryStart
     * @param salaryEnd
     * @param salaryDiscuss
     * @return true 为没有填写   false 为填写完毕
     */
    private Boolean getSalaryStatus(Integer salaryStart, Integer salaryEnd, Byte salaryDiscuss) {
        if (salaryStart == null && salaryEnd == null && salaryDiscuss == null)
            return true;
        else
            return false;
    }


    /**
     * @param gid
     * @param rid
     * @param stringRid
     * @param isHave
     * @param byConditionResume
     * @param byConditionEval
     * @param byConditionProfile
     * @param byConditionEducation
     * @param byConditionWork
     * @param byConditionProject
     * @param byConditionSkill
     * @param byConditionHonor
     * @param byConditionCer
     */
    private void SaveStatus8(Integer gid, String rid, String stringRid, Boolean isHave, List<WebResume> byConditionResume, List<WebResumeEval> byConditionEval, List<WebProfile> byConditionProfile, List<WebResumeEducation> byConditionEducation, List<WebResumeWorkExp> byConditionWork, List<WebResumeProjectExp> byConditionProject, List<WebResumeSkill> byConditionSkill, List<WebResumeHonor> byConditionHonor, List<WebResumeCertificate> byConditionCer) {
// true 代表了 第一次诊断   false 代表了第二次诊断
        String prid = "";

        // 修改
        if (!isHave) {
            prid = byConditionResume.get(0).getRid();
            deleteResume(gid, prid);

        }

        // 个人信息
//        WebProfile webProfile = webProfileService.findBy("rid", rid);
        if (byConditionProfile != null && byConditionProfile.size() != 0) {
            WebProfile webProfile = byConditionProfile.get(0);
            if (webProfile != null) {
                webProfile.setId(null);
                webProfile.setRid(stringRid);
//            webProfile.setRealName(reTitle);
                webProfileService.save(webProfile);
            }
        }


//        webProfileService.UpdateByConditionSelective(updateResume.getWebProfile(), conditionProfile);
        //教育证明
      /*  Condition conditionEducation = new Condition(WebResumeEducation.class);
        conditionEducation.createCriteria().andCondition("rid = '" + rid + "'");
        List<WebResumeEducation> byConditionEducation = webResumeEducationService.findByCondition(conditionEducation);*/
        for (WebResumeEducation webResumeEducation : byConditionEducation) {
            if (webResumeEducation != null) {
                webResumeEducation.setId(null);
                webResumeEducation.setRid(stringRid);
                webResumeEducationService.save(webResumeEducation);
            }
        }


        // 工作经验    // 查状态为1的工作经验
       /* Condition conditionWorkExp = new Condition(WebResumeWorkExp.class);
        conditionWorkExp.createCriteria().andCondition("rid = '" + rid + "'");
        List<WebResumeWorkExp> byConditionWork = webResumeWorkExpService.findByCondition(conditionWorkExp);*/
        // 已经诊断过了
        if (!isHave) {

            // 工作经验  //查询状态为 8对应的工作经验

            Condition conditionWorkP = new Condition(WebResumeWorkExp.class);
            conditionWorkP.createCriteria().andCondition("rid = '" + prid + "'");
            List<WebResumeWorkExp> byConditionWorkP = webResumeWorkExpService.findByCondition(conditionWorkP);
            // 状态为8 的工作经验为外臣
            for (WebResumeWorkExp webResumeWorkP : byConditionWorkP) {
                for (WebResumeWorkExp webResumeWorkExp : byConditionWork) {
                    if (webResumeWorkP.getIndustryId() != null && !StringUtils.isEmpty(webResumeWorkP.getJobTitle()) && webResumeWorkP.getTplId() != null && webResumeWorkP.getIndustryId() == webResumeWorkExp.getIndustryId() && webResumeWorkP.getJobTitle().equals(webResumeWorkExp.getJobTitle()) && webResumeWorkP.getTplId() > 0) {
                        webResumeWorkExp.setTplId(webResumeWorkP.getTplId());
                    }

                }
            }

            webResumeWorkExpService.deleteByCondition(conditionWorkP);

        }


        for (WebResumeWorkExp webResumeWorkExp : byConditionWork) {
            if (webResumeWorkExp != null) {
                webResumeWorkExp.setWorkExpId(null);
                webResumeWorkExp.setRid(stringRid);
                webResumeWorkExpService.save(webResumeWorkExp);
            }
        }

        //项目
      /*  Condition conditionProject = new Condition(WebResumeProjectExp.class);
        conditionProject.createCriteria().andCondition("rid = '" + rid + "'");
        List<WebResumeProjectExp> byConditionProject = webResumeProjectExpService.findByCondition(conditionProject);*/
        for (WebResumeProjectExp webResumeProjectExp : byConditionProject) {
            if (webResumeProjectExp != null) {
                webResumeProjectExp.setId(null);
                webResumeProjectExp.setRid(stringRid);
                webResumeProjectExpService.save(webResumeProjectExp);
            }
        }
        // 荣誉
       /* Condition conditionHonor = new Condition(WebResumeHonor.class);
        conditionHonor.createCriteria().andCondition("rid = '" + rid + "'");
        List<WebResumeHonor> byConditionHonor = webResumeHonorService.findByCondition(conditionHonor);*/
        for (WebResumeHonor webResumeHonor : byConditionHonor) {
            if (webResumeHonor != null) {
                webResumeHonor.setId(null);
                webResumeHonor.setRid(stringRid);
                webResumeHonorService.save(webResumeHonor);
            }
        }

        //技能
       /* Condition conditionSkill = new Condition(WebResumeSkill.class);
        conditionSkill.createCriteria().andCondition("rid = '" + rid + "'");
        List<WebResumeSkill> byConditionSkill = webResumeSkillService.findByCondition(conditionSkill);*/
        for (WebResumeSkill webResumeSkill : byConditionSkill) {
            if (webResumeSkill != null) {
                webResumeSkill.setResumeSkillId(null);
                webResumeSkill.setRid(stringRid);
                webResumeSkillService.save(webResumeSkill);
            }
        }


        // 证书
    /*    Condition conditionCer = new Condition(WebResumeCertificate.class);
        conditionCer.createCriteria().andCondition("rid = '" + rid + "'");
        List<WebResumeCertificate> byConditionCer = webResumeCertificateService.findByCondition(conditionCer);*/
        for (WebResumeCertificate webResumeCertificate : byConditionCer) {
            if (webResumeCertificate != null) {
                webResumeCertificate.setRid(stringRid);
                webResumeCertificate.setId(null);
                webResumeCertificateService.save(webResumeCertificate);
            }
        }

        // 自述
//        Condition conditionEval = new Condition(WebResumeEval.class);
//        conditionEval.createCriteria().andCondition("rid = '" + rid + "'");
//        WebResumeEval webResumeEval = webResumeEvalService.findBy("rid", rid);
        if (byConditionEval != null && byConditionEval.size() != 0) {
            WebResumeEval webResumeEval = byConditionEval.get(0);
            if (webResumeEval != null) {
                webResumeEval.setId(null);
                webResumeEval.setRid(stringRid);
                webResumeEvalService.save(webResumeEval);
            }

        }


        WebResume webResumeOld = webResumeService.findBy("rid", rid);

        WebResume webResume = new WebResume();
        webResume.setResumeTitle(StringUtils.isEmpty(webResumeOld.getResumeTitle()) ? "" : webResumeOld.getResumeTitle());
        webResume.setGid(gid);
        webResume.setRid(stringRid);
        webResume.setPrid(rid);
        webResume.setCreatetime(new Date());
        webResume.setUpdatetime(new Date());
        webResume.setStatus(8);
        webResumeService.save(webResume);
    }

    // 刪除status 为 8的表
    private void deleteResume(Integer gid, String rid) {
        // 个人信息
        Condition conditionProfile = new Condition(WebProfile.class);
        conditionProfile.createCriteria().andCondition("rid = '" + rid + "'");
        webProfileService.deleteByCondition(conditionProfile);
        //教育证明
        Condition conditionEducation = new Condition(WebResumeEducation.class);
        conditionEducation.createCriteria().andCondition("rid = '" + rid + "'");
        webResumeEducationService.deleteByCondition(conditionEducation);
       /* // 工作经验
        Condition conditionWorkExp = new Condition(WebResumeWorkExp.class);
        conditionWorkExp.createCriteria().andCondition("rid = '" + rid + "'");
        webResumeWorkExpService.deleteByCondition(conditionWorkExp);*/
        //项目
        Condition conditionProject = new Condition(WebResumeProjectExp.class);
        conditionProject.createCriteria().andCondition("rid = '" + rid + "'");
        webResumeProjectExpService.deleteByCondition(conditionProject);
        // 荣誉
        Condition conditionHonor = new Condition(WebResumeHonor.class);
        conditionHonor.createCriteria().andCondition("rid = '" + rid + "'");
        webResumeHonorService.deleteByCondition(conditionHonor);
        //技能
        Condition conditionSkill = new Condition(WebResumeSkill.class);
        conditionSkill.createCriteria().andCondition("rid = '" + rid + "'");
        webResumeSkillService.deleteByCondition(conditionSkill);
        // 证书
        Condition conditionCer = new Condition(WebResumeCertificate.class);
        conditionCer.createCriteria().andCondition("rid = '" + rid + "'");
        webResumeCertificateService.deleteByCondition(conditionCer);
        // 自述
        Condition conditionEval = new Condition(WebResumeEval.class);
        conditionEval.createCriteria().andCondition("rid = '" + rid + "'");
        webResumeEvalService.deleteByCondition(conditionEval);

    }

    public String getStringRid() {
        String rid;
        rid = "RD" + RandomUtils.nextInt(1000000, 9999999) + System.currentTimeMillis() / 1000;
          /*  RD+ 1000000到9999999的随机数+时间戳
            插入并查询web_rid表，若不存在，则插入，否则重新生成一次再次查询*/
        WebRid mWebRid = webRidService.findBy("rid", rid);

        while (mWebRid != null) {
            rid = "RD" + RandomUtils.nextInt(1000000, 9999999) + System.currentTimeMillis() / 1000;
            mWebRid = webRidService.findBy("rid", rid);

        }
        return rid;
    }

}