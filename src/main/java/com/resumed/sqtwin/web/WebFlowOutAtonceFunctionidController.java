package com.resumed.sqtwin.web;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebFlowOutAtonceFunctionid;
import com.resumed.sqtwin.service.WebFlowOutAtonceFunctionidService;
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
@RequestMapping("/web/flow/out/atonce/functionid")
public class WebFlowOutAtonceFunctionidController {
    @Resource
    private WebFlowOutAtonceFunctionidService webFlowOutAtonceFunctionidService;

    @PostMapping("/add")
    public Result add(WebFlowOutAtonceFunctionid webFlowOutAtonceFunctionid) {
        webFlowOutAtonceFunctionidService.save(webFlowOutAtonceFunctionid);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webFlowOutAtonceFunctionidService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebFlowOutAtonceFunctionid webFlowOutAtonceFunctionid) {
        webFlowOutAtonceFunctionidService.update(webFlowOutAtonceFunctionid);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebFlowOutAtonceFunctionid webFlowOutAtonceFunctionid = webFlowOutAtonceFunctionidService.findById(id);
        return ResultGenerator.genSuccessResult(webFlowOutAtonceFunctionid);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebFlowOutAtonceFunctionid> list = webFlowOutAtonceFunctionidService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
