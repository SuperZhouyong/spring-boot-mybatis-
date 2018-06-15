package com.resumed.sqtwin.web;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebFlowOutAtonceNativecityid;
import com.resumed.sqtwin.service.WebFlowOutAtonceNativecityidService;
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
@RequestMapping("/web/flow/out/atonce/nativecityid")
public class WebFlowOutAtonceNativecityidController {
    @Resource
    private WebFlowOutAtonceNativecityidService webFlowOutAtonceNativecityidService;

    @PostMapping("/add")
    public Result add(WebFlowOutAtonceNativecityid webFlowOutAtonceNativecityid) {
        webFlowOutAtonceNativecityidService.save(webFlowOutAtonceNativecityid);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        webFlowOutAtonceNativecityidService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WebFlowOutAtonceNativecityid webFlowOutAtonceNativecityid) {
        webFlowOutAtonceNativecityidService.update(webFlowOutAtonceNativecityid);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WebFlowOutAtonceNativecityid webFlowOutAtonceNativecityid = webFlowOutAtonceNativecityidService.findById(id);
        return ResultGenerator.genSuccessResult(webFlowOutAtonceNativecityid);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebFlowOutAtonceNativecityid> list = webFlowOutAtonceNativecityidService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
