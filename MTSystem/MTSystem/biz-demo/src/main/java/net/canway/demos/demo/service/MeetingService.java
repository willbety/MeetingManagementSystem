package net.canway.demos.demo.service;

import net.canway.demos.demo.pojos.MeetingBean;
import net.canway.demos.demo.utils.MyResult;

import java.util.List;

public interface MeetingService {

    public MyResult<List> list();

    //查询
    public MyResult<MeetingBean> getMeetingByName(String name);

    public MyResult<Boolean> updateMeeting(MeetingBean meetingBean,int up);

    public MyResult<Boolean> add(MeetingBean meetingBean);

    public MyResult<Boolean> delete(MeetingBean meetingBean);

}
