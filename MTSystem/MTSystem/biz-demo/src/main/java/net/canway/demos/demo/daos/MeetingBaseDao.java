package net.canway.demos.demo.daos;

import com.example.demo.tables.TMeeting;
import com.example.demo.tables.TMeetroom;
import com.example.demo.tables.records.TMeetingRecord;
import net.canway.demos.demo.pojos.MeetingBean;
import net.canway.demos.demo.utils.MyResult;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeetingBaseDao {
    @Autowired
    private DSLContext context;

    public MyResult<List> list(){
        Result<TMeetingRecord>  records = context.selectFrom(TMeeting.T_MEETING).fetch();
        List<MeetingBean> meetingBeanResult = DaoUtils.recordToList(records,MeetingBean.class);
        return new MyResult<List> (meetingBeanResult,200,"Success");
    }

    //查询
    public MyResult<MeetingBean>  getMeetingByName(String name){
        TMeetingRecord  record  =  context.selectFrom(TMeeting.T_MEETING)
                .where(TMeeting.T_MEETING.MEET_NAME.eq(name)).fetchOne();
        MeetingBean  bean  = DaoUtils.recordToBean(record,MeetingBean.class);
        return new MyResult<MeetingBean>(bean,200,"Success");
    }

    public MyResult<Boolean> updateMeeting(MeetingBean meetingBean,int up){


        int execute1 = 1;
        int execute2 = 1;

        //up:判断会议室是否进行了修改
        //up == 1 时 代表会议室名字被修改，需要修改会议室状态
        //execute1 释放会议室
        //execute2 获取会议室
        //execute3 更改会议信息
        if (up == 1){
            //当前会议室名字获取
            Record1<String> tMeetingRecord2 = context.select(TMeeting.T_MEETING.MEETROOM_NAME).from(TMeeting.T_MEETING)
                    .where(TMeeting.T_MEETING.ID.eq(meetingBean.getId())).fetchOne();
            String meetroomName =  tMeetingRecord2.get(TMeeting.T_MEETING.MEETROOM_NAME);
            //释放当前会议室
            execute1 = context.update(TMeetroom.T_MEETROOM).set(TMeetroom.T_MEETROOM.ROOM_STATE,true)
                    .where(TMeetroom.T_MEETROOM.ROOM_NAME
                            .eq(meetroomName)).execute();
            //获取会议室
            execute2 = context.update(TMeetroom.T_MEETROOM)
                    .set(TMeetroom.T_MEETROOM.ROOM_STATE,false)
                    .where(TMeetroom.T_MEETROOM.ROOM_NAME.eq(meetingBean.getMeetroomName())).execute();
        }

        int execute3 = context.update(TMeeting.T_MEETING)
                .set(TMeeting.T_MEETING.ID,meetingBean.getId())
                .set(TMeeting.T_MEETING.MEET_DEV,meetingBean.getMeetDev())
                .set(TMeeting.T_MEETING.MEET_DUE,meetingBean.getMeetDue())
                .set(TMeeting.T_MEETING.MEET_NAME,meetingBean.getMeetName())
                .set(TMeeting.T_MEETING.MEETROOM_NAME,meetingBean.getMeetroomName())
                .set(TMeeting.T_MEETING.MEET_START,meetingBean.getMeetStart())
                .set(TMeeting.T_MEETING.MEET_END,meetingBean.getMeetEnd())
                .where(TMeeting.T_MEETING.ID.eq(meetingBean.getId()))
                .execute();



        boolean result = execute1 > 0 && execute2 > 0 && execute3 > 0;
        return  new MyResult<Boolean>(result,200,"Success");
    }

    public  MyResult<Boolean> add(MeetingBean meetingBean){
        int execute1 = context.insertInto(TMeeting.T_MEETING,TMeeting.T_MEETING.ID,TMeeting.T_MEETING.MEET_DEV,
                TMeeting.T_MEETING.MEET_DUE,
                TMeeting.T_MEETING.MEET_NAME,
                TMeeting.T_MEETING.MEETROOM_NAME,
                TMeeting.T_MEETING.MEET_START,
                TMeeting.T_MEETING.MEET_END)
                .values(meetingBean.getId(),meetingBean.getMeetDev(),meetingBean.getMeetDue(),
                        meetingBean.getMeetName(),meetingBean.getMeetroomName(),
                        meetingBean.getMeetStart(),meetingBean.getMeetEnd()).execute();
        //execute2 ：更新会议室状态
        int execute2 = context.update(TMeetroom.T_MEETROOM).set(TMeetroom.T_MEETROOM.ROOM_STATE,
                false).where(TMeetroom.T_MEETROOM.ROOM_NAME.eq(meetingBean.getMeetroomName())).execute();
        boolean  result = execute1>0 && execute2>0;
        return  new MyResult<Boolean>(result,200,"Success");
    }

    public  MyResult<Boolean> delete(MeetingBean meetingBean){

        int execute = context.delete(TMeeting.T_MEETING)
                .where(TMeeting.T_MEETING.ID.eq(meetingBean.getId())).execute();

        boolean  result = execute>0;
        return  new MyResult<Boolean>(result,200,"Success");
    }

}
