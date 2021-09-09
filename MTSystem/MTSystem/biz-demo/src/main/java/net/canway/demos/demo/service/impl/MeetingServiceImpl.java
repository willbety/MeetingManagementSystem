package net.canway.demos.demo.service.impl;

import net.canway.demos.demo.daos.MeetingBaseDao;
import net.canway.demos.demo.pojos.MeetingBean;
import net.canway.demos.demo.service.MeetingService;
import net.canway.demos.demo.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingBaseDao meetingBaseDao;

    @Override
    public MyResult<List> list(){
        return meetingBaseDao.list();
    }

    @Override
    public MyResult<MeetingBean> getMeetingByName(String name) {
        return meetingBaseDao.getMeetingByName(name);
    }

    @Override
    public MyResult<Boolean> updateMeeting(MeetingBean meetingBean,int up)
    {
        return meetingBaseDao.updateMeeting(meetingBean,up);
    }

    @Override
    public MyResult<Boolean> add(MeetingBean meetingBean) {

        return meetingBaseDao.add(meetingBean);
    }

    @Override
    public MyResult<Boolean> delete(MeetingBean meetingBean) {
        return meetingBaseDao.delete(meetingBean);
    }
}
