package com.resumed.sqtwin.web;

import com.resumed.sqtwin.configurer.DS;
import com.resumed.sqtwin.configurer.DataSourceContextHolder;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.*;
import com.resumed.sqtwin.model.requestbean.UpdateResume;
import com.resumed.sqtwin.model.responseban.*;
import com.resumed.sqtwin.service.*;
import com.resumed.sqtwin.utils.AppConstant;
import com.resumed.sqtwin.utils.DataUtil;
import com.resumed.sqtwin.utils.FtpUpdateUtil;
import com.resumed.sqtwin.utils.ImageUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther Super
 * @data 2018/4/16 0016
 * @time 下午 19:19
 */
@RestController
@RequestMapping("/resume/alter")
public class AppConstanController {
    @Value("${img.location}")
    private String location;
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
    // 用户细节 用来处理图片
    @Resource
    private WebUserDetailService webUserDetailService;
    // 分享的数据库
    @Resource
    private WebElectronicResumeService webElectronicResumeService;
    @Resource
    private WebUserService webUserService;

    //1新建 9历史  8诊断 99删除
    private final Logger logger = LoggerFactory.getLogger(AppConstanController.class);

    /**
     * @param gid
     * @param rid
     * @return 简历分享
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/shareResume")
    public Result shareResume(@RequestParam(defaultValue = "0", value = "gid") Integer gid, @RequestParam("rid") String rid, @RequestParam() Boolean showPhone, @RequestParam Boolean showName) {
        if (gid == 0 || StringUtils.isEmpty(rid))
            return ResultGenerator.genFailResult("请检查数据的有效性");
        Condition condition = new Condition(WebElectronicResume.class);
        condition.createCriteria().andCondition(" gid =  " + gid + " and rid = '" + rid + "'");
        List<WebElectronicResume> byCondition = webElectronicResumeService.findByCondition(condition);
        if (byCondition != null && byCondition.size() != 0)
            return ResultGenerator.genSuccessResult(new ResultList().setmList(AppConstant.shareUrl + byCondition.get(0).getShare()));

        //rid + 100-999
        String shareID = DigestUtils.md5Hex(rid + RandomUtils.nextInt(100, 999));
        WebElectronicResume webElectronicResume = new WebElectronicResume();
        webElectronicResume.setCreateat(new Date());
        webElectronicResume.setGid(gid);
        webElectronicResume.setRid(rid);
        webElectronicResume.setShare(shareID);
        webElectronicResume.setShowname((byte) (showName ? 1 : 2));
        webElectronicResume.setShowphone((byte) (showPhone ? 1 : 2));
        webElectronicResume.setStatus((byte) 1);
        webElectronicResumeService.save(webElectronicResume);

        return ResultGenerator.genSuccessResult(AppConstant.shareUrl + shareID);
    }

    /**
     * @param gid
     * @param rid
     * @return 简历删除接口
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/deleteResume")
    public Result deleteResume(@RequestParam(defaultValue = "0", value = "gid") Integer gid, @RequestParam("rid") String rid) {
        if (gid == 0) {
            return ResultGenerator.genFailResult("你不是有效操作用户");
        }

        // 个人信息
        Condition conditionProfile = new Condition(WebProfile.class);
        conditionProfile.createCriteria().andCondition("rid = '" + rid + "'");
        webProfileService.deleteByCondition(conditionProfile);
        //教育证明
        Condition conditionEducation = new Condition(WebResumeEducation.class);
        conditionEducation.createCriteria().andCondition("rid = '" + rid + "'");
        webResumeEducationService.deleteByCondition(conditionEducation);
        // 工作经验
        Condition conditionWorkExp = new Condition(WebResumeWorkExp.class);
        conditionWorkExp.createCriteria().andCondition("rid = '" + rid + "'");
        webResumeWorkExpService.deleteByCondition(conditionWorkExp);
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

        // 修改简历信息的 status
        Condition condition = new Condition(WebResume.class);
        condition.createCriteria().andCondition("gid = '" + gid + "' and status =  1 and rid = '" + rid + "'");
        WebResume webResume = new WebResume();
        webResume.setStatus(99);
        webResumeService.UpdateByConditionSelective(webResume, condition);

        // 修改分享的数据库
        Condition onditionElect = new Condition(WebElectronicResume.class);
        onditionElect.createCriteria().andCondition(" gid =  " + gid + " and rid = '" + rid + "'");
        WebElectronicResume webElectronicResume = new WebElectronicResume();
        webElectronicResume.setStatus((byte) 99);
        webElectronicResumeService.UpdateByConditionSelective(webElectronicResume, conditionEducation);


        return ResultGenerator.genSuccessResult();
    }

    @DS(DataSourceContextHolder.One)
    @PostMapping("/resumeicon")
    public Result getResumeIcon(@RequestParam(defaultValue = "0", value = "gid") Integer gid) {
        WebUserDetail webUserDetail = webUserDetailService.findBy("gid", gid);
        RegistResponse registResponse = new RegistResponse();
        if (webUserDetail == null || gid == 0) {
            registResponse.setIconImage(AppConstant.AppOffice + "/web/user/userImage");
        } else
            registResponse.setIconImage(webUserDetail.getHeadImg());


        return ResultGenerator.genSuccessResult(registResponse);
    }


    /**
     * @param gid
     * @return 获取默认的个人信息
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/resumeinfo")
    public Result getSumenInfo(@RequestParam(defaultValue = "0", value = "gid") Integer gid) {
        if (StringUtils.isEmpty(String.valueOf(gid)))
            return ResultGenerator.genFailResult("请输入有效gid");
        WebUserDetail webUserDetail = webUserDetailService.findBy("gid", gid);
        if (webUserDetail == null)
            return ResultGenerator.genSuccessResult();

        if (webUserDetail.getBirthday() != null)
            webUserDetail.setBirthdata(DataUtil.dfDate.get().format(webUserDetail.getBirthday()));

        WebUser webUser = webUserService.findBy("gid", gid);
        if (webUser != null)
            webUserDetail.setPhoneNum(webUser.getPhone());

        Byte workStatus = webUserDetail.getWorkStatus();
        Byte marital = webUserDetail.getMarital();
        if (workStatus != null && workStatus > 0)
            webUserDetail.setWorkStatusName(AppConstant.WorkStatus[workStatus - 1]);
        if (marital != null && marital > 0)
            webUserDetail.setMaritalName(AppConstant.marrayStatus[marital - 1]);


        return ResultGenerator.genSuccessResult(webUserDetail);
    }

    /**
     * @param gid
     * @param rid
     * @param reTitle
     * @return 简历另存为
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/resumesaveas")
    public Result getSaveAs(@RequestParam Integer gid, @RequestParam String rid, @RequestParam String reTitle) {
        if (StringUtils.isEmpty(reTitle))
            return ResultGenerator.genFailResult("请检查所保存简历的名字");

        UpdaeResumeResponse updaeResumeResponse = new UpdaeResumeResponse();
        Condition condition = new Condition(WebResume.class);
        condition.createCriteria().andCondition("gid = " + gid + " and status =  1");
        List<WebResume> byCondition = webResumeService.findByCondition(condition);
        if (byCondition != null && byCondition.size() >= 10 && !StringUtils.isEmpty(rid)) {
            updaeResumeResponse.setCanAdd(false);
            // 超出上限的时候直接另存为false
            return ResultGenerator.genSuccessResult(updaeResumeResponse);
        } else {
            updaeResumeResponse.setCanAdd(true);
            if (byCondition != null && byCondition.size() != 0) {
                for (WebResume webResume : byCondition) {
                    if (reTitle.equals(webResume.getResumeTitle()))
                        return ResultGenerator.genFailResult("已存在同名简历");

                }

            }

        }


        // 新的rid
        String stringRid = getStringRid();
        // 个人信息
        Condition conditionProfile = new Condition(WebProfile.class);
        conditionProfile.createCriteria().andCondition("rid = '" + rid + "'");

//        List<WebProfile> byCondition = webProfileService.findByCondition(conditionProfile);
        WebProfile webProfile = webProfileService.findBy("rid", rid);
        if (webProfile != null) {
            webProfile.setId(null);
            webProfile.setRid(stringRid);
            webProfile.setRealName(reTitle);
            webProfileService.save(webProfile);
        }

//        webProfileService.UpdateByConditionSelective(updateResume.getWebProfile(), conditionProfile);
        //教育证明
        Condition conditionEducation = new Condition(WebResumeEducation.class);
        conditionEducation.createCriteria().andCondition("rid = '" + rid + "'");
//        webResumeEducationService.UpdateByConditionSelective(updateResume.getWebResumeEducation(), conditionEducation);
//        WebResumeEducation webResumeEducation = webResumeEducationService.findBy("rid", rid);
        List<WebResumeEducation> byConditionEducation = webResumeEducationService.findByCondition(conditionEducation);
        for (WebResumeEducation webResumeEducation : byConditionEducation) {
            if (webResumeEducation != null) {
                webResumeEducation.setId(null);
                webResumeEducation.setRid(stringRid);
                webResumeEducationService.save(webResumeEducation);
            }
        }


        // 工作经验
        Condition conditionWorkExp = new Condition(WebResumeWorkExp.class);
        conditionWorkExp.createCriteria().andCondition("rid = '" + rid + "'");
//        webResumeWorkExpService.UpdateByConditionSelective(updateResume.getWebResumeWorkExp(), conditionWorkExp);
//        webResumeWorkExpService.deleteByCondition(conditionWorkExp);
        List<WebResumeWorkExp> byConditionWork = webResumeWorkExpService.findByCondition(conditionWorkExp);
        for (WebResumeWorkExp webResumeWorkExp : byConditionWork) {
            if (webResumeWorkExp != null) {
                webResumeWorkExp.setWorkExpId(null);
                webResumeWorkExp.setRid(stringRid);
                webResumeWorkExpService.save(webResumeWorkExp);
            }
        }

//        WebResumeWorkExp webResumeWorkExp = webResumeWorkExpService.findBy("rid", rid);


        //项目
        //项目
        Condition conditionProject = new Condition(WebResumeProjectExp.class);
        conditionProject.createCriteria().andCondition("rid = '" + rid + "'");
        List<WebResumeProjectExp> byConditionProject = webResumeProjectExpService.findByCondition(conditionProject);
        for (WebResumeProjectExp webResumeProjectExp : byConditionProject) {
            if (webResumeProjectExp != null) {
                webResumeProjectExp.setId(null);
                webResumeProjectExp.setRid(stringRid);
                webResumeProjectExpService.save(webResumeProjectExp);
            }
        }
//        WebResumeProjectExp webResumeProjectExp = webResumeProjectExpService.findBy("rid", rid);


//        webResumeProjectExpService.deleteByCondition(conditionProject);
        // 荣誉
        Condition conditionHonor = new Condition(WebResumeHonor.class);
        conditionHonor.createCriteria().andCondition("rid = '" + rid + "'");
        List<WebResumeHonor> byConditionHonor = webResumeHonorService.findByCondition(conditionHonor);
        for (WebResumeHonor webResumeHonor : byConditionHonor) {
            if (webResumeHonor != null) {
                webResumeHonor.setId(null);
                webResumeHonor.setRid(stringRid);
                webResumeHonorService.save(webResumeHonor);
            }
        }

//        webResumeHonorService.deleteByCondition(conditionHonor);
//        WebResumeHonor webResumeHonor = webResumeHonorService.findBy("rid", rid);


        //技能
        Condition conditionSkill = new Condition(WebResumeSkill.class);
        conditionSkill.createCriteria().andCondition("rid = '" + rid + "'");
//        webResumeSkillService.deleteByCondition(conditionSkill);
//        WebResumeSkill webResumeSkill = webResumeSkillService.findBy("rid", rid);
        List<WebResumeSkill> byConditionSkill = webResumeSkillService.findByCondition(conditionSkill);
        for (WebResumeSkill webResumeSkill : byConditionSkill) {
            if (webResumeSkill != null) {
                webResumeSkill.setResumeSkillId(null);
                webResumeSkill.setRid(stringRid);
                webResumeSkillService.save(webResumeSkill);
            }
        }


        // 证书
        Condition conditionCer = new Condition(WebResumeCertificate.class);
        conditionCer.createCriteria().andCondition("rid = '" + rid + "'");
//        webResumeCertificateService.deleteByCondition(conditionCer);
//        WebResumeCertificate webResumeCertificate = webResumeCertificateService.findBy("rid", rid);
        List<WebResumeCertificate> byConditionCer = webResumeCertificateService.findByCondition(conditionCer);
        for (WebResumeCertificate webResumeCertificate : byConditionCer) {
            if (webResumeCertificate != null) {
                webResumeCertificate.setRid(stringRid);
                webResumeCertificate.setId(null);
                webResumeCertificateService.save(webResumeCertificate);
            }
        }

        // 自述
        Condition conditionEval = new Condition(WebResumeEval.class);
        conditionEval.createCriteria().andCondition("rid = '" + rid + "'");
        WebResumeEval webResumeEval = webResumeEvalService.findBy("rid", rid);
        if (webResumeEval != null) {
            webResumeEval.setId(null);
            webResumeEval.setRid(stringRid);
            webResumeEvalService.save(webResumeEval);
        }

        WebResume webResume = new WebResume();
        webResume.setResumeTitle(reTitle);
        webResume.setGid(gid);
        webResume.setRid(stringRid);
        webResume.setCreatetime(new Date());
        webResume.setUpdatetime(new Date());
        webResume.setStatus(1);
        webResumeService.save(webResume);
//        WebResumeEval webResumeEval = new WebResumeEval();
//        webResumeEval.setContent(updateResume.getWebProfile().getDescribe());

//        ForChildSave(updateResume, gid, rid);


        updaeResumeResponse.setDataTime(DataUtil.getTimestamp());
        updaeResumeResponse.setRid(stringRid);
        return ResultGenerator.genSuccessResult(updaeResumeResponse);
    }

    /**
     * @param gid
     * @return 简历列表
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/resumeList")
    public Result getResumeList(@RequestParam(defaultValue = "0") Integer gid) {
        if (gid == 0) {
            return ResultGenerator.genFailResult("登陆");
        }
        Condition condition = new Condition(WebResume.class);
        condition.createCriteria().andCondition("gid = '" + gid + "' and status =  1");
        // 降序
        condition.setOrderByClause("createTime desc ");
        List<WebResume> byCondition = webResumeService.findByCondition(condition);
        ResultList resultList = new ResultList();
        ArrayList<resumeListResponse> resumeListBeans = new ArrayList<>();
        for (WebResume webResume : byCondition) {
            resumeListBeans.add(new resumeListResponse(webResume.getRid(), webResume.getResumeTitle(), DataUtil.getTimestampParsetoString(webResume.getCreatetime())));
        }
        return ResultGenerator.genSuccessResult(resultList.setmList(resumeListBeans));
    }

    /**
     * @param majorName
     * @param degree
     * @return 检测专业Id 是否存在，再工作经历中去获取
     */
    @DS(DataSourceContextHolder.Two)
    @PostMapping("/checkMajorId")
    public Result checkMajorId(@RequestParam String majorName, @RequestParam Integer degree) {
        Condition condition = new Condition(WebMajor.class);
        condition.createCriteria().andCondition("name = '" + majorName + "' and " + "degree = " + degree);
        List<WebMajor> byCondition = webMajorService.findByCondition(condition);
        if (byCondition == null || byCondition.size() == 0) {
            Condition conditionEx = new Condition(WebMajorEx.class);
            conditionEx.createCriteria().andCondition("name = '" + majorName + "' and " + "degree = " + degree);
            List<WebMajorEx> byConditionEx = webMajorExService.findByCondition(conditionEx);
            if (byConditionEx == null || byConditionEx.size() == 0) {
                // 传-1；
                return ResultGenerator.genSuccessResult(new ResultList().setmList(-1));
            } else {
                return ResultGenerator.genSuccessResult(new ResultList().setmList(byConditionEx.get(0).getId()));

            }
        }
        {
            return ResultGenerator.genSuccessResult(new ResultList().setmList(byCondition.get(0).getMajorid()));
        }


    }

    /**
     * @param multipartFile
     * @param gid
     * @param rid
     * @return 上传图片
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/updateImage")
    public Result updateImage(@RequestParam("iconImage") MultipartFile multipartFile, @RequestParam String gid, @RequestParam(required = false) String rid) {
        return UpdateImage(multipartFile, gid, rid);


    }

    private Result UpdateImage(MultipartFile multipartFile, @RequestParam String gid, String rid) {
        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename()) || StringUtils.isBlank(gid))
            return ResultGenerator.genFailResult("请检车上传文件的格式");
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
            return ResultGenerator.genFailResult("文件contentType错误");
        }
        String root_fileName = multipartFile.getOriginalFilename();
        logger.info("上传图片：name={},type={}", root_fileName, contentType);
        //处理图片
//        String return_path = "/s";
        String filePath = location;
        logger.info("图片保存路径={}", filePath);
        String file_name = null;
//        String s = StringUtils.isBlank(gid)?"":gid.trim() ;

        String Dictiry = "zd" + (StringUtils.isBlank(gid) ? "" : gid.trim()) + (StringUtils.isBlank(rid) ? "" : rid.trim());
        String newFileName = System.currentTimeMillis() + (StringUtils.isBlank(gid) ? "" : gid.trim()) + (StringUtils.isBlank(rid) ? "" : rid.trim());
        try {

            file_name = ImageUtil.saveImg(multipartFile, filePath, newFileName);

            logger.info("返回值：{}", file_name);

            boolean isUpdate = FtpUpdateUtil.uploadFile(newFileName, multipartFile.getInputStream(), Dictiry);

            String newFileHttpName = "http://" + AppConstant.FTP_ADDRESS + "/" + Dictiry + "/" + newFileName;

            if (isUpdate) {
                iconImageResponse iconImageResponse = new iconImageResponse();
                iconImageResponse.setIcon_image(newFileHttpName);

               /* Condition condition = new Condition(WebUserDetail.class);
                condition.createCriteria().andCondition("gid = " + gid);
                WebUserDetail webUserDetail = new WebUserDetail();
                webUserDetail.setHeadImg(newFileHttpName);
                webUserDetail.setHeadImgStatus((byte) 0);

                *//* WebUserDetail webUserDetail1By = webUserDetailService.findBy("gid", gid);*//*
                if (webUserDetailService.findBy("gid", gid) != null)
                    webUserDetailService.UpdateByConditionSelective(webUserDetail, condition);*/

//                webUserDetailService.UpdateIconImage(gid, newFileHttpName, new Date());


                return ResultGenerator.genSuccessResult(iconImageResponse);
            } else
                return ResultGenerator.genFailResult("上传失败");


        } catch (IOException e) {
            return ResultGenerator.genFailResult("上传失败");
        }
    }

    /**
     * @param updateResume "iconImage"
     * @return 保存Id  @RequestBody() UpdateResume updateResume
     * @throws ParseException
     */
    @DS(DataSourceContextHolder.One)
    @PostMapping("/saveResume")
    public Result SoveResume(@RequestPart("updateResume") UpdateResume updateResume, @RequestPart(required = false, value = "iconImage") MultipartFile multipartFile) throws ParseException {

        if (updateResume == null)
            return ResultGenerator.genFailResult("请输入未完成的信息");
       /* if (updateResume.getWebResumeEducation().size() == 0 || updateResume.getWebResumeWorkExp().size() == 0 || updateResume.getWebResumeProjectExp().size() == 0 || updateResume.getWebResumeHonor().size() == 0
                || updateResume.getWebResumeCertificate().size() == 0 || updateResume.getWebResumeSkill().size() == 0)
            return ResultGenerator.genFailResult("请输入未完成的信息");*/

        int gid = updateResume.getGid();
        // 空的代表为增加
        String rid = updateResume.getRid();
        UpdaeResumeResponse updaeResumeResponse = new UpdaeResumeResponse();
        Condition condition = new Condition(WebResume.class);
        condition.createCriteria().andCondition("gid = " + gid + " and status =  1");
        // 降序
        List<WebResume> byCondition = webResumeService.findByCondition(condition);
        if (byCondition != null && byCondition.size() >= 10 && StringUtils.isEmpty(rid)) {
            updaeResumeResponse.setCanAdd(false);
            return ResultGenerator.genSuccessResult(updaeResumeResponse);
        } else {
            updaeResumeResponse.setCanAdd(true);
        }


        String icon_image = null;
        if (multipartFile != null) {
            if (!(multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename()) || StringUtils.isBlank(String.valueOf(gid)))) {

                Result result = UpdateImage(multipartFile, String.valueOf(gid), rid);
                if (result.getCode() == 200) {
                    icon_image = ((iconImageResponse) result.getData()).getIcon_image();
                  /*  Condition condition = new Condition(WebProfile.class);
                    if (!StringUtils.isEmpty(rid)) {
                        condition.createCriteria().andCondition("rid = '" + rid + "' gid = " + gid);
                        WebProfile webProfile = new WebProfile();
                        webProfile.setAvatarUrl(icon_image);
                        webProfile.setAvatarStatus((byte) 0);
                        webProfileService.UpdateByConditionSelective(webProfile, condition);
                    }*/

                } else {
                    return ResultGenerator.genFailResult("图片上传失败");
                }
            }


        }
        if (!StringUtils.isEmpty(icon_image) && updateResume.getWebProfile() != null) {


            updateResume.getWebProfile().setAvatarStatus((byte) 0);
            updateResume.getWebProfile().setAvatarUrl(icon_image);

        }
        // 这是新增
        if (StringUtils.isEmpty(rid)) {
            // 同步保存第一次
            rid = SaveResumeData(updateResume, gid);

            insertUpdateUserdetail(updateResume, gid, icon_image);

            WebResume webResume = new WebResume();
            webResume.setGid(gid);
            webResume.setRid(rid);
            webResume.setCreatetime(new Date());
            webResume.setUpdatetime(new Date());
            webResume.setResumeTitle(updateResume.getResumeTitle());
            webResume.setStatus(1);

            webResumeService.save(webResume);
            updaeResumeResponse.setRid(rid);

            WebResume webResumeNine = new WebResume();
            webResumeNine.setPrid(rid);
            rid = SaveResumeData(updateResume, gid);
            webResumeNine.setGid(gid);
            webResumeNine.setRid(rid);
            webResumeNine.setCreatetime(new Date());
            webResumeNine.setUpdatetime(new Date());
            webResumeNine.setResumeTitle(updateResume.getResumeTitle());
            webResumeNine.setStatus(9);
            webResumeService.save(webResumeNine);
        } else {
            // 删除旧的简历，全部从新增加一份
            UpdateResumeData(updateResume, rid, gid);
            // 讲最新的个人信息同步到 个人详情界面
            insertUpdateUserdetail(updateResume, gid, icon_image);

            updaeResumeResponse.setRid(rid);
            WebResume webResumeNine = new WebResume();
            webResumeNine.setPrid(rid);
            // 在保存一份新的简历
            rid = SaveResumeData(updateResume, gid);
            webResumeNine.setGid(gid);
            webResumeNine.setRid(rid);
            webResumeNine.setCreatetime(new Date());
            webResumeNine.setUpdatetime(new Date());
            webResumeNine.setResumeTitle(updateResume.getResumeTitle());
            webResumeNine.setStatus(9);
            webResumeService.save(webResumeNine);
        }


        return ResultGenerator.genSuccessResult(updaeResumeResponse);
    }

    /**
     * 每次修改同步个人信息的数据
     *
     * @param updateResume
     * @param gid
     * @param icon_image
     */
    private void insertUpdateUserdetail(UpdateResume updateResume, int gid, String icon_image) {
        WebUserDetail webUserDetail = new WebUserDetail();
        WebProfile webProfile = updateResume.getWebProfile();
        if (!StringUtils.isEmpty(String.valueOf(updateResume.getGid())))
            webUserDetail.setGid(updateResume.getGid());
        if (!StringUtils.isEmpty(String.valueOf(webProfile.getRealName())))
            webUserDetail.setRealName(webProfile.getRealName());
        if (!StringUtils.isEmpty(icon_image)) {
            webUserDetail.setHeadImg(webProfile.getAvatarUrl());
            webUserDetail.setHeadImgStatus(webProfile.getAvatarStatus());
        }
        if (webProfile.getBirthday() != null)
            webUserDetail.setBirthday(webProfile.getBirthday());
        if (webProfile.getSex() != null)
            webUserDetail.setSex(webProfile.getSex());
        if (!StringUtils.isEmpty(String.valueOf(webProfile.getEmail())))
            webUserDetail.setEmail(webProfile.getEmail());
        if (!StringUtils.isEmpty(String.valueOf(webProfile.getCityName())))
            webUserDetail.setCityName(webProfile.getCityName());
        if (webProfile.getCityId() != null)
            webUserDetail.setCityId(webProfile.getCityId());
        if (webProfile.getMarital() != null)
            webUserDetail.setMarital(webProfile.getMarital());
        if (!StringUtils.isEmpty(String.valueOf(webProfile.getHouseholdCityName())))
            webUserDetail.setHouseholdCityName(webProfile.getHouseholdCityName());
        if (webProfile.getHouseholdCityId() != null)
            webUserDetail.setHouseholdCityId(webProfile.getHouseholdCityId());
        if (webProfile.getSalaryStart() != null)
            webUserDetail.setSalaryStart(webProfile.getSalaryStart());
        if (webProfile.getSalaryDiscuss() != null)
            webUserDetail.setSalaryDiscuss(webProfile.getSalaryDiscuss());
        if (webProfile.getSalaryEnd() != null)
            webUserDetail.setSalaryEnd(webProfile.getSalaryEnd());
        if (webProfile.getWorkStatus() != null)
            webUserDetail.setWorkStatus(webProfile.getWorkStatus());
        if (!StringUtils.isEmpty(String.valueOf(webProfile.getAddress())))
            webUserDetail.setAddress(webProfile.getAddress());

//        Condition condition1 = new Condition(WebResumeEval.class);
        if (!StringUtils.isEmpty(updateResume.getRid())) {
            WebResumeEval rid = webResumeEvalService.findBy("rid", updateResume.getRid());
            webUserDetail.setSelfDesc(StringUtils.isEmpty(rid.getContent()) ? "" : rid.getContent());
        }
//        if (webProfile.)
        webUserDetail.setCreateAt(new Date());
        webUserDetail.setUpdateAt(new Date());
        if (webUserDetailService.findBy("gid", gid) == null)
            webUserDetailService.save(webUserDetail);
        else {
            Condition condition = new Condition(WebUserDetail.class);
            condition.createCriteria().andCondition("gid = " + gid);
            webUserDetailService.UpdateByConditionSelective(webUserDetail, condition);

        }
    }

    // 当时跟后台逻辑一致，为了省事
    private void UpdateResumeData(UpdateResume updateResume, String rid, int gid) {
        // 个人信息
        Condition conditionProfile = new Condition(WebProfile.class);
        conditionProfile.createCriteria().andCondition("rid = '" + rid + "'");
        if (!StringUtils.isEmpty(updateResume.getWebProfile().getBirthdata())) {
            try {
                updateResume.getWebProfile().setBirthday(DataUtil.dfDate.get().parse(updateResume.getWebProfile().getBirthdata()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
//        webProfileService.deleteByCondition(conditionProfile)
        webProfileService.UpdateByConditionSelective(updateResume.getWebProfile(), conditionProfile);
        //教育证明
        Condition conditionEducation = new Condition(WebResumeEducation.class);
        conditionEducation.createCriteria().andCondition("rid = '" + rid + "'");
//        webResumeEducationService.UpdateByConditionSelective(updateResume.getWebResumeEducation(), conditionEducation);
        webResumeEducationService.deleteByCondition(conditionEducation);


        // 工作经验
        Condition conditionWorkExp = new Condition(WebResumeWorkExp.class);
        conditionWorkExp.createCriteria().andCondition("rid = '" + rid + "'");
//        webResumeWorkExpService.UpdateByConditionSelective(updateResume.getWebResumeWorkExp(), conditionWorkExp);
        webResumeWorkExpService.deleteByCondition(conditionWorkExp);


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
        WebResumeEval webResumeEval = new WebResumeEval();
        webResumeEval.setContent(updateResume.getWebProfile().getDescribe());

        ForChildSave(updateResume, gid, rid);

        webResumeEvalService.UpdateByConditionSelective(webResumeEval, conditionEval);
    }

    private String SaveResumeData(UpdateResume updateResume, int gid) {
        String rid = getStringRid();
        WebRid mWebRid;

        mWebRid = new WebRid();
        mWebRid.setRid(rid);
        webRidService.save(mWebRid);
        if (updateResume.getWebProfile() == null)
            updateResume.setWebProfile(new WebProfile());
        updateResume.getWebProfile().setId(null);
        try {
            if (!StringUtils.isEmpty(updateResume.getWebProfile().getBirthdata()))
                updateResume.getWebProfile().setBirthday(DataUtil.dfDate.get().parse(updateResume.getWebProfile().getBirthdata()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        updateResume.getWebProfile().setGid(gid);
        updateResume.getWebProfile().setRid(rid);


        webProfileService.save(updateResume.getWebProfile());


        ForChildSave(updateResume, gid, rid);

        WebResumeEval webResumeEval = new WebResumeEval();
        webResumeEval.setGid(gid);
        webResumeEval.setRid(rid);
        webResumeEval.setContent(updateResume.getWebProfile().getDescribe());
        webResumeEvalService.save(webResumeEval);
        return rid;
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

    private void ForChildSave(UpdateResume updateResume, int gid, String rid) {
        // 里面非空集合，只是size 为0；
        if (updateResume.getWebResumeEducation() == null)
            updateResume.setWebResumeEducation(new ArrayList<>());
        for (WebResumeEducation webResumeEducation : updateResume.getWebResumeEducation()) {
            webResumeEducation.setGid(gid);
            webResumeEducation.setRid(rid);
            // 学历Id
            Byte degree = webResumeEducation.getDegree();
            String majorName = webResumeEducation.getMajorName();

            try {
                if (!StringUtils.isEmpty(webResumeEducation.getEndTimeDay()))
                    webResumeEducation.setEndTime(DataUtil.dfDate.get().parse(webResumeEducation.getEndTimeDay()));
                if (!StringUtils.isEmpty(webResumeEducation.getStartTimeDay()))
                    webResumeEducation.setStartTime(DataUtil.dfDate.get().parse(webResumeEducation.getStartTimeDay()));
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        if (updateResume.getWebResumeEducation() != null && updateResume.getWebResumeEducation().size() != 0)
            webResumeEducationService.save(updateResume.getWebResumeEducation());

        if (updateResume.getWebResumeWorkExp() == null)
            updateResume.setWebResumeWorkExp(new ArrayList<>());
        for (WebResumeWorkExp webResumeWorkExp : updateResume.getWebResumeWorkExp()) {
            webResumeWorkExp.setGid(gid);
            webResumeWorkExp.setRid(rid);

            try {
                if (!StringUtils.isEmpty(webResumeWorkExp.getEndTimeDay())) {
                    webResumeWorkExp.setEndTime(DataUtil.dfDate.get().parse(webResumeWorkExp.getEndTimeDay()));
                }
                if (!StringUtils.isEmpty(webResumeWorkExp.getStartTimeDay()))
                    webResumeWorkExp.setStartTime(DataUtil.dfDate.get().parse(webResumeWorkExp.getStartTimeDay()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        if (updateResume.getWebResumeWorkExp() != null && updateResume.getWebResumeWorkExp().size() != 0)
            webResumeWorkExpService.save(updateResume.getWebResumeWorkExp());

        if (updateResume.getWebResumeProjectExp() == null)
            updateResume.setWebResumeProjectExp(new ArrayList<>());
        for (WebResumeProjectExp webResumeProjectExp : updateResume.getWebResumeProjectExp()) {
            webResumeProjectExp.setGid(gid);
            webResumeProjectExp.setRid(rid);
            try {
                if (!StringUtils.isEmpty(webResumeProjectExp.getEndTimeDay())) {
                    webResumeProjectExp.setEndTime(DataUtil.dfDate.get().parse(webResumeProjectExp.getEndTimeDay()));
                }
                if (!StringUtils.isEmpty(webResumeProjectExp.getBeginTimeDay())) {
                    webResumeProjectExp.setBeginTime(DataUtil.dfDate.get().parse(webResumeProjectExp.getBeginTimeDay()));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (updateResume.getWebResumeProjectExp() != null && updateResume.getWebResumeProjectExp().size() != 0)
            webResumeProjectExpService.save(updateResume.getWebResumeProjectExp());

        if (updateResume.getWebResumeSkill() == null)
            updateResume.setWebResumeSkill(new ArrayList<>());
        for (WebResumeSkill webResumeSkill : updateResume.getWebResumeSkill()) {
            webResumeSkill.setGid(gid);
            webResumeSkill.setRid(rid);
        }
        if (updateResume.getWebResumeSkill() != null && updateResume.getWebResumeSkill().size() != 0)
            webResumeSkillService.save(updateResume.getWebResumeSkill());

        if (updateResume.getWebResumeHonor() == null)
            updateResume.setWebResumeHonor(new ArrayList<>());
        for (WebResumeHonor webResumeHonor : updateResume.getWebResumeHonor()) {
            webResumeHonor.setGid(gid);
            webResumeHonor.setRid(rid);
            if (!StringUtils.isEmpty(webResumeHonor.getHonorTimeDay())) {
                try {
                    webResumeHonor.setHonorTime(DataUtil.dfDate.get().parse(webResumeHonor.getHonorTimeDay()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        if (updateResume.getWebResumeHonor() != null && updateResume.getWebResumeHonor().size() != 0)
            webResumeHonorService.save(updateResume.getWebResumeHonor());

        if (updateResume.getWebResumeCertificate() == null)
            updateResume.setWebResumeCertificate(new ArrayList<>());
        for (WebResumeCertificate webResumeCertificate : updateResume.getWebResumeCertificate()) {
            webResumeCertificate.setGid(gid);
            webResumeCertificate.setRid(rid);
            if (!StringUtils.isEmpty(webResumeCertificate.getGettimeDay())) {
                try {
                    webResumeCertificate.setGettime(DataUtil.dfDate.get().parse(webResumeCertificate.getGettimeDay()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        if (updateResume.getWebResumeCertificate() != null && updateResume.getWebResumeCertificate().size() != 0)
            webResumeCertificateService.save(updateResume.getWebResumeCertificate());
    }

    @DS(DataSourceContextHolder.One)
    @PostMapping("/Demo")
    public Result ceshi(@RequestParam String gid, @RequestParam String rid) {
        Condition conditionEducation = new Condition(WebResumeEducation.class);
        conditionEducation.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        WebResumeEducation webResumeEducation = new WebResumeEducation();
        try {
            webResumeEducation.setStartTime(DataUtil.dfDate.get().parse("2007-08-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        webResumeEducation.setStartTime(new Date());
        webResumeEducation.setEndTime(new Date());
        webResumeEducationService.UpdateByConditionSelective(webResumeEducation, conditionEducation);
//        WebResumeEducation webResumeEducation1 = webResumeEducationService.findByCondition(conditionEducation).get(0);
//        webResumeEducation.
        List<WebResumeEducation> byCondition = webResumeEducationService.findByCondition(conditionEducation);
//        Result result = ResultGenerator.genSuccessResult(byCondition);

        return ResultGenerator.genSuccessResult(byCondition);
    }

    @DS(DataSourceContextHolder.One)
    @PostMapping("/resumeTitle")
    public Result updateTitle(@RequestParam String gid, @RequestParam String rid, @RequestParam String reTitle) {
        if (StringUtils.isEmpty(reTitle))
            return ResultGenerator.genFailResult("请检查所保存简历的名字");

        Condition conditionRe = new Condition(WebResume.class);
        conditionRe.createCriteria().andCondition("gid = " + gid + " and status =  1");
        List<WebResume> byCondition = webResumeService.findByCondition(conditionRe);
        if (byCondition != null && byCondition.size() != 0) {
            for (WebResume webResume : byCondition) {
                if (reTitle.equals(webResume.getResumeTitle()))
                    return ResultGenerator.genFailResult("已存在同名简历");
            }
        }
        WebResume webResume = new WebResume();
        webResume.setResumeTitle(reTitle);
        Condition condition = new Condition(WebResume.class);
        condition.createCriteria().andCondition("gid = '" + gid + "' and  rid = '" + rid + "'");
        webResumeService.UpdateByConditionSelective(webResume, condition);
        return ResultGenerator.genSuccessResult();
    }


    @DS(DataSourceContextHolder.One)
    @PostMapping("/getresumendata")
    public Result getResumeData(@RequestParam String gid, @RequestParam String rid) {
        if (StringUtils.isEmpty(gid) || StringUtils.isEmpty(rid))
            return ResultGenerator.genFailResult("参数错误");
        resumeResponse resumeResponse = getResumeResponse(gid, rid);


        return ResultGenerator.genSuccessResult(resumeResponse);
    }

    public resumeResponse getResumeResponse(@RequestParam String gid, @RequestParam String rid) {
        resumeResponse resumeResponse = new resumeResponse();
        ArrayList<com.resumed.sqtwin.model.responseban.resumeResponse.ItemBean> itemBeans = new ArrayList<>();
        resumeResponse.setmResume(itemBeans);


        // 自述
        Condition conditionEval = new Condition(WebResumeEval.class);
        conditionEval.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeEval> byConditionEval = webResumeEvalService.findByCondition(conditionEval);


        // 查询个人信息
        Condition condition = new Condition(WebProfile.class);
        condition.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebProfile> byConditionProfile = webProfileService.findByCondition(condition);
//        if (byConditionEval != null && byConditionEval.size() != 0)
        if (byConditionEval != null && byConditionEval.size() != 0 && byConditionProfile != null && byConditionProfile.size() != 0) {
            byConditionProfile.get(0).setDescribe(byConditionEval.get(0).getContent() + "");
            Byte workStatus = byConditionProfile.get(0).getWorkStatus();
            Byte marital = byConditionProfile.get(0).getMarital();
            if (workStatus != null && workStatus > 0)
                byConditionProfile.get(0).setWorkStatusName(AppConstant.WorkStatus[workStatus - 1]);
            if (marital != null && marital > 0)
                byConditionProfile.get(0).setMaritalName(AppConstant.marrayStatus[marital - 1]);
        }
        com.resumed.sqtwin.model.responseban.resumeResponse.ItemBean itemBeanProfile = new resumeResponse.ItemBean();
        itemBeanProfile.setmList(byConditionProfile);
        itemBeanProfile.setTypeName("个人信息");
        itemBeanProfile.setTypeNum("1");
        itemBeans.add(itemBeanProfile);


        //教育证明
        Condition conditionEducation = new Condition(WebResumeEducation.class);
        conditionEducation.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
//        webResumeEducationService.UpdateByConditionSelective(updateResume.getWebResumeEducation(), conditionEducation);
        List<WebResumeEducation> byConditionEducation = webResumeEducationService.findByCondition(conditionEducation);
/*
*  education.add(new Bean(0, AppConstant.educationSttus[0]));
        education.add(new Bean(2, AppConstant.educationSttus[1]));
        education.add(new Bean(3, AppConstant.educationSttus[2]));
        education.add(new Bean(4, AppConstant.educationSttus[3]));
* */
        for (WebResumeEducation webResumeEducation : byConditionEducation) {
            Byte degree = webResumeEducation.getDegree();
            if (degree != null) {
                webResumeEducation.setDegreeName(degree == 0 ? AppConstant.educationSttus[0] : AppConstant.educationSttus[degree - 1]);

            }

        }

        com.resumed.sqtwin.model.responseban.resumeResponse.ItemBean itemBeanEducation = new resumeResponse.ItemBean();
        itemBeanEducation.setmList(byConditionEducation);
        itemBeanEducation.setTypeName("教育经历");
        itemBeanEducation.setTypeNum("2");
        itemBeans.add(itemBeanEducation);


        // 工作经验
        Condition conditionWorkExp = new Condition(WebResumeWorkExp.class);
        conditionWorkExp.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
//        webResumeWorkExpService.UpdateByConditionSelective(updateResume.getWebResumeWorkExp(), conditionWorkExp);
        List<WebResumeWorkExp> byConditionWorkexp = webResumeWorkExpService.findByCondition(conditionWorkExp);
        for (WebResumeWorkExp webResumeWorkExp : byConditionWorkexp) {
            Byte scaleId = webResumeWorkExp.getScaleId();
            Byte companyTypeId = webResumeWorkExp.getCompanyTypeId();
            if (scaleId != null) {
                webResumeWorkExp.setScaleIdName(AppConstant.enterpriseScale[scaleId]);
            }
            if (companyTypeId != null) {
                webResumeWorkExp.setCompanyTypeIdName(AppConstant.EnterpriseNature[companyTypeId]);
            }


        }
        com.resumed.sqtwin.model.responseban.resumeResponse.ItemBean itemBeanWorkExp = new resumeResponse.ItemBean();
        itemBeanWorkExp.setmList(byConditionWorkexp);
        itemBeanWorkExp.setTypeName("工作经历");
        itemBeanWorkExp.setTypeNum("3");
        itemBeans.add(itemBeanWorkExp);


        //项目
        Condition conditionProject = new Condition(WebResumeProjectExp.class);
        conditionProject.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeProjectExp> byConditionProject = webResumeProjectExpService.findByCondition(conditionProject);

        com.resumed.sqtwin.model.responseban.resumeResponse.ItemBean itemBeanProject = new resumeResponse.ItemBean();
        itemBeanProject.setmList(byConditionProject);
        itemBeanProject.setTypeName("项目经验");
        itemBeanProject.setTypeNum("4");
        itemBeans.add(itemBeanProject);


        //技能
        Condition conditionSkill = new Condition(WebResumeSkill.class);
        conditionSkill.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeSkill> byConditionSkill = webResumeSkillService.findByCondition(conditionSkill);
        for (WebResumeSkill webResumeSkill : byConditionSkill) {
            Byte level = webResumeSkill.getLevel();
            if (level != null) {
                webResumeSkill.setLevelName(AppConstant.skillLevel[level - 1]);
            }

        }
        com.resumed.sqtwin.model.responseban.resumeResponse.ItemBean itemBeanSkill = new resumeResponse.ItemBean();
        itemBeanSkill.setmList(byConditionSkill);
        itemBeanSkill.setTypeName("擅长技能");
        itemBeanSkill.setTypeNum("5");
        itemBeans.add(itemBeanSkill);


        // 荣誉
        Condition conditionHonor = new Condition(WebResumeHonor.class);
        conditionHonor.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeHonor> byConditionHonor = webResumeHonorService.findByCondition(conditionHonor);

        com.resumed.sqtwin.model.responseban.resumeResponse.ItemBean itemBeanHonor = new resumeResponse.ItemBean();
        itemBeanHonor.setmList(byConditionHonor);
        itemBeanHonor.setTypeName("荣誉");
        itemBeanHonor.setTypeNum("6");
        itemBeans.add(itemBeanHonor);

        // 证书
        Condition conditionCer = new Condition(WebResumeCertificate.class);
        conditionCer.createCriteria().andCondition("gid = '" + gid + "' and  rid =  '" + rid + "'");
        List<WebResumeCertificate> byConditionCer = webResumeCertificateService.findByCondition(conditionCer);

        com.resumed.sqtwin.model.responseban.resumeResponse.ItemBean itemBeanCer = new resumeResponse.ItemBean();
        itemBeanCer.setmList(byConditionCer);
        itemBeanCer.setTypeName("证书");
        itemBeanCer.setTypeNum("7");
        itemBeans.add(itemBeanCer);


        return resumeResponse;
    }


}
