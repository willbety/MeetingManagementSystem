package net.canway.demos.demo.daos;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class DaoUtils {

    public static <R,T> T recordToBean(R record, Class<T> clazz){

        try {
            T userBean = null;
            userBean = clazz.newInstance();
            if(null ==record){
                return userBean;
            }
            BeanUtils.copyProperties(record,userBean);
            return userBean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <R,T> List<T> recordToList(List<R> record, Class<T> clazz){
        return record.stream().map(it -> recordToBean(it,clazz)).collect(Collectors.toList());
    }
}
