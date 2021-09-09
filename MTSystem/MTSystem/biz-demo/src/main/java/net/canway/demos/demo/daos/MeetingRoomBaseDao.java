package net.canway.demos.demo.daos;

import com.example.demo.tables.TMeeting;
import com.example.demo.tables.TMeetroom;
import com.example.demo.tables.records.TMeetingRecord;
import com.example.demo.tables.records.TMeetroomRecord;
import net.canway.demos.demo.pojos.MeetingBean;
import net.canway.demos.demo.pojos.MeetroomBean;
import net.canway.demos.demo.utils.MyResult;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeetingRoomBaseDao {
    @Autowired
    private DSLContext context;

    /**
     * 查询所有会议室
     * @return 会议室列表
     */
    public MyResult<List> list(){
        Result<TMeetroomRecord> records = context.selectFrom(TMeetroom.T_MEETROOM).fetch();
        List<MeetroomBean> meetingroomBeanResult = DaoUtils.recordToList(records,MeetroomBean.class);
        return new MyResult<List>(meetingroomBeanResult, 200, "Success");
    }

    /**
     * 根据会议室名称查询会议室信息
     * @param name
     * @return 会议室信息
     */
    public MyResult<MeetroomBean>  getMeetingroomByName(String name){
        TMeetroomRecord  record  =  context.selectFrom(TMeetroom.T_MEETROOM)
                .where(TMeetroom.T_MEETROOM.ROOM_NAME.eq(name)).fetchOne();
        MeetroomBean  bean  = DaoUtils.recordToBean(record,MeetroomBean.class);
        return new MyResult<MeetroomBean>(bean,200,"Success");
    }

    /**
     * 更新会议室信息
     * @param meetroomBean
     * @return 更改结果
     */
    public MyResult<Boolean> updateMeetingRoom(MeetroomBean meetroomBean){
        int execute = context.update(TMeetroom.T_MEETROOM)
                .set(TMeetroom.T_MEETROOM.ID,meetroomBean.getId())
                .set(TMeetroom.T_MEETROOM.ROOM_NAME,meetroomBean.getRoomName())
                .set(TMeetroom.T_MEETROOM.ROOM_STATE,meetroomBean.getRoomState())
                .set(TMeetroom.T_MEETROOM.ROOT_SIZE,meetroomBean.getRootSize())
                .where(TMeetroom.T_MEETROOM.ID.eq(meetroomBean.getId()))
                .execute();
        boolean  result = execute>0;
        return  new MyResult<Boolean>(result,200,"Success");
    }

    /**
     * 添加会议室
     * @param meetroomBean
     * @return  更改结果
     */
    public  MyResult<Boolean> add(MeetroomBean meetroomBean){
        int execute = context.insertInto(TMeetroom.T_MEETROOM,TMeetroom.T_MEETROOM.ID,
                TMeetroom.T_MEETROOM.ROOM_NAME,
                TMeetroom.T_MEETROOM.ROOM_STATE,
                TMeetroom.T_MEETROOM.ROOT_SIZE)
                .values(meetroomBean.getId(),meetroomBean.getRoomName(),
                        meetroomBean.getRoomState(),
                        meetroomBean.getRootSize()).execute();

        boolean  result = execute>0;
        return  new MyResult<Boolean>(result,200,"Success");
    }

    /**
     * 删除会议室
     * @param meetroomBean
     * @return 删除结果
     */
    public  MyResult<Boolean> delete(MeetroomBean meetroomBean){

        int execute = context.delete(TMeetroom.T_MEETROOM)
                .where(TMeetroom.T_MEETROOM.ID.eq(meetroomBean.getId())).execute();

        boolean  result = execute>0;
        return  new MyResult<Boolean>(result,200,"Success");
    }
}
