package net.canway.demos.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.canway.demos.demo.pojos.*;
import net.canway.demos.demo.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dev")
@Api(tags = "DEV_MANAGR",description = "设备管理")
public class DevController {

    @Autowired
    private DevService devService;

    @GetMapping("/{userId}")
    @ApiOperation("获取用户设备列表")
    public List<UserSbBean>  getUserDevByUserId(@PathVariable
                                                 @ApiParam(value = "用户Id",required = true)
                                                 Integer userId){
        return devService.getUserDevByUserId(userId);
    }

    @GetMapping("/like")
    @ApiOperation("模糊查询接口")
    public List<SbBean> like(@RequestParam @ApiParam("设备名称") String devName){
        return devService.like(devName);
    }

    @GetMapping("/orderby")
    @ApiOperation("查询排序")
    public List<SbBean> orderBy(@RequestParam @ApiParam String string1,@RequestParam @ApiParam String string2)
    {
        return devService.orderBy(string1,string2);
    }
    @GetMapping("/groupbydev")
    @ApiOperation("设备分组查询")
    public List<GroupByClass> groupByDevName(){
        return  devService.groupByDevName();
    }

    @GetMapping("/groupbyusersex")
    @ApiOperation("性别分组查询")
    public List<GroupByUser> groupBy(){
        return devService.groupBy();
    }

}
