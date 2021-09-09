package net.canway.demos.demo.service.impl;

import net.canway.demos.demo.daos.MeetingRoomBaseDao;
import net.canway.demos.demo.pojos.MeetroomBean;
import net.canway.demos.demo.service.MeetingRoomService;
import net.canway.demos.demo.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    private MeetingRoomBaseDao meetingRoomBaseDao;
//未完成
    @Override
    public List<String> roomNameList() {
        return null;
    }

    @Override
    public MyResult<List>roomList() {
        return meetingRoomBaseDao.list();
    }

    @Override
    public MyResult<MeetroomBean> getRoomByName(String name) {
        return meetingRoomBaseDao.getMeetingroomByName(name);
    }

    @Override
    public MyResult<Boolean>  add(MeetroomBean meetroomBean) {
        return meetingRoomBaseDao.add(meetroomBean);
    }

    @Override
    public MyResult<Boolean>  delete(MeetroomBean meetroomBean) {
        return meetingRoomBaseDao.delete(meetroomBean);
    }

    @Override
    public MyResult<Boolean>  update(MeetroomBean meetroomBean) {
        return meetingRoomBaseDao.updateMeetingRoom(meetroomBean);
    }
}
