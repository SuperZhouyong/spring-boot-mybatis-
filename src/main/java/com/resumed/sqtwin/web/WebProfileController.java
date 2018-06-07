package com.resumed.sqtwin.web;
import com.resumed.sqtwin.configurer.DS;
import com.resumed.sqtwin.configurer.DataSourceContextHolder;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebProfile;
import com.resumed.sqtwin.service.WebProfileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/04/16.
*/
@RestController
@RequestMapping("/web/profile")
public class WebProfileController {
    @Resource
    private WebProfileService webProfileService;

    @PostMapping("/add")
    public Result add(WebProfile webProfile) {
        webProfileService.save(webProfile);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webProfileService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebProfile webProfile) {
        webProfileService.update(webProfile);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebProfile webProfile = webProfileService.findById(id);
        return ResultGenerator.genSuccessResult(webProfile);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebProfile> list = webProfileService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @DS(DataSourceContextHolder.One)
    @GetMapping("/UpdateCondition")
    public Result UpdateCondition(String gid){
        WebProfile webProfile = new WebProfile();
        webProfile.setRid("2222");
        webProfile.setAvatarUrl("zzzzzzzzzz");
        Condition condition = new Condition(WebProfile.class);
        condition.createCriteria().andCondition("gid = "+gid);
//        condition.setOrderByClause("");
       return ResultGenerator.genSuccessResult(webProfileService.findBy("rid","RD21748541517118734"));

//        return ResultGenerator.genSuccessResult(webProfileService.UpdateByConditionSelective(webProfile,condition));
    }

}
