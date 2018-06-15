package com.resumed.sqtwin.web;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebFlowOutAtonceIndustryid;
import com.resumed.sqtwin.service.WebFlowOutAtonceIndustryidService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/14.
*/
@RestController
@RequestMapping("/web/flow/out/atonce/industryid")
public class WebFlowOutAtonceIndustryidController {
    @Resource
    private WebFlowOutAtonceIndustryidService webFlowOutAtonceIndustryidService;

    @PostMapping("/add")
    public Result add(WebFlowOutAtonceIndustryid webFlowOutAtonceIndustryid) {
        webFlowOutAtonceIndustryidService.save(webFlowOutAtonceIndustryid);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webFlowOutAtonceIndustryidService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebFlowOutAtonceIndustryid webFlowOutAtonceIndustryid) {
        webFlowOutAtonceIndustryidService.update(webFlowOutAtonceIndustryid);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebFlowOutAtonceIndustryid webFlowOutAtonceIndustryid = webFlowOutAtonceIndustryidService.findById(id);
        return ResultGenerator.genSuccessResult(webFlowOutAtonceIndustryid);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebFlowOutAtonceIndustryid> list = webFlowOutAtonceIndustryidService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
