package net.canway.demos.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import net.canway.demos.demo.pojos.MeetingBean;
import net.canway.demos.demo.service.MeetingService;
import net.canway.demos.demo.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meeting")
@Api(tags = "MEETRING_MANAGE",description = "会议管理")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @GetMapping("/list")
    public MyResult<List> List(){
        return meetingService.list();
    }

    @GetMapping("/search")
    @ApiOperation("查询会议")
    public MyResult<MeetingBean> getByName(@RequestParam @ApiParam("会议室名称") String name){
        return meetingService.getMeetingByName(name);
    }

    @PostMapping("/add")
    @ApiOperation("添加会议")
    public MyResult<Boolean> add(@RequestBody @ApiParam MeetingBean meetingBean){
        return meetingService.add(meetingBean);
    }

    @DeleteMapping
    @ApiOperation("删除会议")
    public MyResult<Boolean> delete(@RequestBody @ApiParam(value = "会议信息",required = true) MeetingBean meetingBean){
        return meetingService.delete(meetingBean);

    }


    @GetMapping("/update")
    @ApiOperation("更新会议信息")
    public MyResult<Boolean> update(@RequestBody @ApiParam(value = "会议信息") MeetingBean meetingBean){
        int up = 0;
        return meetingService.updateMeeting(meetingBean,up);
    }

}
