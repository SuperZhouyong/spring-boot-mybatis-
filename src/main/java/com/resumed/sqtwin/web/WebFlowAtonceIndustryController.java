package com.resumed.sqtwin.web;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebFlowAtonceIndustry;
import com.resumed.sqtwin.service.WebFlowAtonceIndustryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/15.
*/
@RestController
@RequestMapping("/web/flow/atonce/industry")
public class WebFlowAtonceIndustryController {
    @Resource
    private WebFlowAtonceIndustryService webFlowAtonceIndustryService;

    @PostMapping("/add")
    public Result add(WebFlowAtonceIndustry webFlowAtonceIndustry) {
        webFlowAtonceIndustryService.save(webFlowAtonceIndustry);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webFlowAtonceIndustryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebFlowAtonceIndustry webFlowAtonceIndustry) {
        webFlowAtonceIndustryService.update(webFlowAtonceIndustry);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebFlowAtonceIndustry webFlowAtonceIndustry = webFlowAtonceIndustryService.findById(id);
        return ResultGenerator.genSuccessResult(webFlowAtonceIndustry);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebFlowAtonceIndustry> list = webFlowAtonceIndustryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
