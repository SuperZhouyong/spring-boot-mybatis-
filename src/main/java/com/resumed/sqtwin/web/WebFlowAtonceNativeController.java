package com.resumed.sqtwin.web;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebFlowAtonceNative;
import com.resumed.sqtwin.service.WebFlowAtonceNativeService;
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
@RequestMapping("/web/flow/atonce/native")
public class WebFlowAtonceNativeController {
    @Resource
    private WebFlowAtonceNativeService webFlowAtonceNativeService;

    @PostMapping("/add")
    public Result add(WebFlowAtonceNative webFlowAtonceNative) {
        webFlowAtonceNativeService.save(webFlowAtonceNative);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webFlowAtonceNativeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebFlowAtonceNative webFlowAtonceNative) {
        webFlowAtonceNativeService.update(webFlowAtonceNative);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebFlowAtonceNative webFlowAtonceNative = webFlowAtonceNativeService.findById(id);
        return ResultGenerator.genSuccessResult(webFlowAtonceNative);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebFlowAtonceNative> list = webFlowAtonceNativeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
