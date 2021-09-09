package net.canway.demos.demo.service;

import net.canway.demos.demo.pojos.MeetingBean;
import net.canway.demos.demo.pojos.MeetroomBean;
import net.canway.demos.demo.utils.MyResult;
import org.jooq.Record1;
import org.jooq.Result;

import javax.swing.*;
import java.util.List;

public interface MeetingRoomService {

    public List<String> roomNameList();

    public MyResult<List> roomList();

    public  MyResult<MeetroomBean> getRoomByName(String name);

    public  MyResult<Boolean> add(MeetroomBean meetroomBean);

    public MyResult<Boolean>  delete(MeetroomBean meetroomBean);

    public  MyResult<Boolean>  update(MeetroomBean meetroomBean);

}
