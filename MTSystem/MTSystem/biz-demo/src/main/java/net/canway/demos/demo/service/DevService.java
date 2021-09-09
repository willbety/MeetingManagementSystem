package net.canway.demos.demo.service;

import net.canway.demos.demo.pojos.*;

import java.util.List;

public interface DevService {
    public List<UserSbBean> getUserDevByUserId(Integer userId);

    public List<SbBean> like(String devName);

    public List<SbBean> orderBy(String string1,String string2);

    public  List<GroupByClass> groupByDevName();

    public  List<GroupByUser> groupBy();
}
