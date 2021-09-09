package net.canway.demos.demo.daos;

import com.example.demo.tables.TDevice;

import com.example.demo.tables.TUser;
import com.example.demo.tables.TUserDev;

import com.example.demo.tables.records.TDeviceRecord;

import com.example.demo.tables.records.TUserDevRecord;
import com.example.demo.tables.records.TUserRecord;

import net.canway.demos.demo.pojos.*;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.format.DecimalStyle;
import java.util.List;

@Repository
public class DevBaseDao {

    @Autowired
    private DSLContext context;

    /**
     * 根据用户Id获取所有设备
     * @param userId
     * @return
     */


    public List<UserSbBean> getUserDevByUserId(Integer userId){
        Result<TUserDevRecord> fetch = context.selectFrom(TUserDev.T_USER_DEV)
                .where(TUserDev.T_USER_DEV.USER_ID.eq(userId)).fetch();

        return DaoUtils.recordToList(fetch, UserSbBean.class);
    }

    /**
     * 模糊查询设备
     * @param devName
     * @return
     */
    // like

    public List<SbBean> like(String devName){
        Result<TDeviceRecord> fetch = context.selectFrom(TDevice.T_DEVICE)
                .where(TDevice.T_DEVICE.DEV_NAME.like("%" + devName + "%"))
                .fetch();
        return DaoUtils.recordToList(fetch, SbBean.class);
    }

    /**
     * 排序
     * @param string1
     * @param string2
     * @return
     */
    // orderby

    public List<SbBean> orderBy(String string1,String string2){
        Result<TDeviceRecord> fetch = context.selectFrom(TDevice.T_DEVICE)
                .where(TDevice.T_DEVICE.DEV_NAME.eq(string1).or(TDevice.T_DEVICE.DEV_NAME.eq(string2)))
                .orderBy(TDevice.T_DEVICE.DEV_ID.desc())
                .fetch();
        return DaoUtils.recordToList(fetch, SbBean.class);
    }

    // groupBy

    /**
     * 设备分组查询
     * @return
     */
    public List<GroupByClass> groupByDevName(){
        Result<Record2<String,Integer>> result1 = context.select(
                TDevice.T_DEVICE.DEV_NAME,
                DSL.count().as("count")
        )
                .from(TDevice.T_DEVICE)
                .groupBy(TDevice.T_DEVICE.DEV_NAME)
                .fetch();



        return result1.map(it -> new GroupByClass()
                .setName(it.get("DEV_NAME", String.class))
                .setCount(it.get("count", Integer.class)));

    }

    /**
     * 用户分组排序
     * @return
     */
    public List<GroupByUser> groupBy(){
        Result<Record2<Integer,BigDecimal>> result = context.select(
                DSL.count().as("count"),
                DSL.sum(TUser.T_USER.USER_AGE).as("age")
        )
                .from(TUser.T_USER)
                .groupBy(TUser.T_USER.USER_SEX)
                .fetch();

        return result.map(it -> new GroupByUser()
                .setCount(it.get("count",Integer.class))
                .setAge(it.get("age",Double.class)));

    }

}
