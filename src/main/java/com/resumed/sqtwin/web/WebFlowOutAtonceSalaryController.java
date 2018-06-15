package com.resumed.sqtwin.web;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebFlowOutAtonceSalary;
import com.resumed.sqtwin.service.WebFlowOutAtonceSalaryService;
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
@RequestMapping("/web/flow/out/atonce/salary")
public class WebFlowOutAtonceSalaryController {
    @Resource
    private WebFlowOutAtonceSalaryService webFlowOutAtonceSalaryService;

    @PostMapping("/add")
    public Result add(WebFlowOutAtonceSalary webFlowOutAtonceSalary) {
        webFlowOutAtonceSalaryService.save(webFlowOutAtonceSalary);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webFlowOutAtonceSalaryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebFlowOutAtonceSalary webFlowOutAtonceSalary) {
        webFlowOutAtonceSalaryService.update(webFlowOutAtonceSalary);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebFlowOutAtonceSalary webFlowOutAtonceSalary = webFlowOutAtonceSalaryService.findById(id);
        return ResultGenerator.genSuccessResult(webFlowOutAtonceSalary);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebFlowOutAtonceSalary> list = webFlowOutAtonceSalaryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
