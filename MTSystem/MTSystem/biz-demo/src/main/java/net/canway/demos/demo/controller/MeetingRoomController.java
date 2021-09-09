package net.canway.demos.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.canway.demos.demo.pojos.MeetroomBean;
import net.canway.demos.demo.service.MeetingRoomService;
import net.canway.demos.demo.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@Api(tags = "MEETRINGRROOM_MANAGE",description = "会议室管理")
public class MeetingRoomController {
    @Autowired
    private MeetingRoomService meetingRoomService;

    @GetMapping("/list")
    @ApiOperation("获取所有会议室")
    public MyResult<List> roomList(){
        return meetingRoomService.roomList();
    }

    @PostMapping("/search")
    @ApiOperation("查询会议室")
    public  MyResult<MeetroomBean> getRoomByName(@RequestParam @ApiParam("会议室名称") String name){
        return meetingRoomService.getRoomByName(name);
    }

    @PostMapping("/add")
    @ApiOperation("添加会议室")
    public  MyResult<Boolean> add(@RequestBody @ApiParam MeetroomBean meetroomBean){
        return meetingRoomService.add(meetroomBean);
    }

    @GetMapping("/update")
    @ApiOperation("更新会议室信息")
    public  MyResult<Boolean> update(@RequestBody @ApiParam(value = "会议室信息") MeetroomBean meetroomBean){
        return meetingRoomService.update(meetroomBean);
    }

    @DeleteMapping
    @ApiOperation("删除会议室")
    public MyResult<Boolean> delete(@RequestBody @ApiParam(value = "会议室信息",required = true) MeetroomBean meetroomBean){
        return meetingRoomService.delete(meetroomBean);

    }


}
