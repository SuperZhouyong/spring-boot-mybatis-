package com.resumed.sqtwin.web;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebFlowAtonceSalary;
import com.resumed.sqtwin.service.WebFlowAtonceSalaryService;
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
@RequestMapping("/web/flow/atonce/salary")
public class WebFlowAtonceSalaryController {
    @Resource
    private WebFlowAtonceSalaryService webFlowAtonceSalaryService;

    @PostMapping("/add")
    public Result add(WebFlowAtonceSalary webFlowAtonceSalary) {
        webFlowAtonceSalaryService.save(webFlowAtonceSalary);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webFlowAtonceSalaryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebFlowAtonceSalary webFlowAtonceSalary) {
        webFlowAtonceSalaryService.update(webFlowAtonceSalary);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebFlowAtonceSalary webFlowAtonceSalary = webFlowAtonceSalaryService.findById(id);
        return ResultGenerator.genSuccessResult(webFlowAtonceSalary);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebFlowAtonceSalary> list = webFlowAtonceSalaryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
