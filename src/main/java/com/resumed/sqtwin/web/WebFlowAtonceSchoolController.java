package com.resumed.sqtwin.web;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebFlowAtonceSchool;
import com.resumed.sqtwin.service.WebFlowAtonceSchoolService;
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
@RequestMapping("/web/flow/atonce/school")
public class WebFlowAtonceSchoolController {
    @Resource
    private WebFlowAtonceSchoolService webFlowAtonceSchoolService;

    @PostMapping("/add")
    public Result add(WebFlowAtonceSchool webFlowAtonceSchool) {
        webFlowAtonceSchoolService.save(webFlowAtonceSchool);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webFlowAtonceSchoolService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebFlowAtonceSchool webFlowAtonceSchool) {
        webFlowAtonceSchoolService.update(webFlowAtonceSchool);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebFlowAtonceSchool webFlowAtonceSchool = webFlowAtonceSchoolService.findById(id);
        return ResultGenerator.genSuccessResult(webFlowAtonceSchool);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebFlowAtonceSchool> list = webFlowAtonceSchoolService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
