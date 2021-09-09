package net.canway.demos.demo.daos;



import com.example.demo.tables.TDepment;

import com.example.demo.tables.records.TDepmentRecord;
import net.canway.demos.demo.pojos.DepBean;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.temporal.Temporal;
import java.util.List;

@Repository
public class DepBaseDao {
    @Autowired
    private DSLContext context;

    /**
     * 获取当前所有部门
     */
    //select * from  T_DEP
    public List<DepBean> list() {
        Result<TDepmentRecord> result = context.selectFrom(TDepment.T_DEPMENT).fetch();
        return DaoUtils.recordToList(result,DepBean.class);
    }

    /**
     * 通过Id获取部门信息
     * @param depId
     * @return
     */
    public DepBean getDepById(Integer depId) {
        TDepmentRecord tDepRecordresult = context.selectFrom(TDepment.T_DEPMENT)
                .where(TDepment.T_DEPMENT.DEP_ID.eq(depId))
                .fetchOne();
        return DaoUtils.recordToBean(tDepRecordresult,DepBean.class);
    }

    /**
     * 更新部门信息
     * @param depBean
     * @return
     */
    public boolean update(DepBean depBean) {
        int execute = context.update(TDepment.T_DEPMENT)
                .set(TDepment.T_DEPMENT.DEP_NAME, depBean.getDepName())
                .where(TDepment.T_DEPMENT.DEP_ID.eq(depBean.getId()))
                .execute();
        return execute>0;
    }

    /**
     * 添加部门
     * @param depBean
     * @return
     */
    public boolean add(DepBean depBean) {
        int execute = context.insertInto(TDepment.T_DEPMENT,TDepment.T_DEPMENT.DEP_ID,TDepment.T_DEPMENT.DEP_NAME,TDepment.T_DEPMENT.DEP_COUNT)
                .values(depBean.getId(),depBean.getDepName(),depBean.getDepCount())
                .execute();
        return execute>0;
    }

    /**
     * 删除部门
     * @param depId
     * @return
     */
    public boolean delete(Integer depId) {
        int execute  = context.delete(TDepment.T_DEPMENT)
                .where(TDepment.T_DEPMENT.DEP_ID.eq(depId))
                .execute();
        return  execute > 0;
    }

}
