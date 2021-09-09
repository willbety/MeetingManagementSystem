package net.canway.demos.demo.daos;

import com.example.demo.tables.TUser;
import com.example.demo.tables.records.TUserRecord;
import io.swagger.models.auth.In;
import net.canway.demos.demo.pojos.UserBean;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.net.www.protocol.http.HttpURLConnection;

import java.util.List;

@Repository
public class UserBaseDao {
    @Autowired
    private DSLContext context;

    /**
     * 获取用户列表
     * @return
     */
    public List<UserBean>  list(){
        Result<TUserRecord>  records = context.selectFrom(TUser.T_USER).fetch();
        return  DaoUtils.recordToList(records,UserBean.class);
    }

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    public  UserBean getUserByID(Integer id){
        TUserRecord  tUserRecord = context.selectFrom(TUser.T_USER)
                .where(TUser.T_USER.USER_ID.eq(id)).fetchOne();
        return DaoUtils.recordToBean(tUserRecord,UserBean.class);

    }

    /**
     * 根据ID获取用户信息
     * @param name
     * @return
     */
    public  UserBean getUserByUserName(String name){
        TUserRecord  tUserRecord = context.selectFrom(TUser.T_USER)
                .where(TUser.T_USER.USER_NAME.eq(name)).fetchOne();
        return DaoUtils.recordToBean(tUserRecord,UserBean.class);

    }

    /**
     * 根据ID更新用户信息
     * @param user
     * @return
     */
    public boolean  updateUser(UserBean user){
        int execute = context.update(TUser.T_USER)
                .set(TUser.T_USER.USER_AGE,user.getAge())
                .set(TUser.T_USER.USER_EMAIL,user.getEmail())
                .set(TUser.T_USER.USER_ID,user.getId())
                .set(TUser.T_USER.USER_PASSWORD,user.getPassword())
                .set(TUser.T_USER.USER_PHONE,user.getPhone())
                .set(TUser.T_USER.USER_ROLE,user.getRole())
                .set(TUser.T_USER.USER_SEX,user.getSex())
                .set(TUser.T_USER.USER_NAME,user.getUserName())
                .where(TUser.T_USER.USER_ID.eq(user.getId()))
                .execute();
        return execute>0;
    }

    public  boolean add(UserBean user){
        int execute = context.insertInto(TUser.T_USER,TUser.T_USER.USER_NAME,TUser.T_USER.USER_ID,TUser.T_USER.USER_AGE,
                TUser.T_USER.USER_EMAIL,TUser.T_USER.USER_PASSWORD,TUser.T_USER.USER_PHONE,TUser.T_USER.USER_SEX,TUser.T_USER.USER_ROLE)
                .values(user.getUserName(),user.getId(),user.getAge(),user.getEmail(),user.getPassword(),user.getPhone(),
                        user.getSex(),user.getRole())
                .execute();
        return execute>0;
        }

    public boolean delete(Integer id){
        int execute = context.delete(TUser.T_USER).where(TUser.T_USER.USER_ID.eq(id)).execute();
        return execute>0;

    }


}
