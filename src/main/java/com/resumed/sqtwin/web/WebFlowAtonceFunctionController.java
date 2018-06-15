package com.resumed.sqtwin.web;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebFlowAtonceFunction;
import com.resumed.sqtwin.service.WebFlowAtonceFunctionService;
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
@RequestMapping("/web/flow/atonce/function")
public class WebFlowAtonceFunctionController {
    @Resource
    private WebFlowAtonceFunctionService webFlowAtonceFunctionService;

    @PostMapping("/add")
    public Result add(WebFlowAtonceFunction webFlowAtonceFunction) {
        webFlowAtonceFunctionService.save(webFlowAtonceFunction);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webFlowAtonceFunctionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebFlowAtonceFunction webFlowAtonceFunction) {
        webFlowAtonceFunctionService.update(webFlowAtonceFunction);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebFlowAtonceFunction webFlowAtonceFunction = webFlowAtonceFunctionService.findById(id);
        return ResultGenerator.genSuccessResult(webFlowAtonceFunction);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebFlowAtonceFunction> list = webFlowAtonceFunctionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
