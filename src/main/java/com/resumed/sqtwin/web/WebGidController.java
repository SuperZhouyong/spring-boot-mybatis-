package com.resumed.sqtwin.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.resumed.sqtwin.configurer.DS;
import com.resumed.sqtwin.configurer.DataSourceContextHolder;
import com.resumed.sqtwin.core.Result;
import com.resumed.sqtwin.core.ResultGenerator;
import com.resumed.sqtwin.model.WebGid;
import com.resumed.sqtwin.service.WebGidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/04/09.
 */
@RestController
@RequestMapping("/web/gid")
public class WebGidController {
    private final Logger logger = LoggerFactory.getLogger(WebGidController.class);

    @Resource
    private WebGidService webGidService;



    @DS("one")
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WebGid> list = webGidService.findAll();

        logger.info("------------------------------------");
        logger.info("  " + list);

        PageInfo pageInfo = new PageInfo(list);

        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @DS(DataSourceContextHolder.One)
    @GetMapping("/addSove")
    public Result queryList(WebGid webGid) {

        return ResultGenerator.genSuccessResult(webGidService.queryList(webGid.getGid()));
    }

   /* @GetMapping("/addSovetwo")
    public Result queryListTwo(Integer gid) {

        return ResultGenerator.genSuccessResult(webGidService.InsertWebGid(n));
    }*/



}
