package net.canway.demos.demo.service.impl;

import net.canway.demos.demo.daos.DevBaseDao;
import net.canway.demos.demo.pojos.*;
import net.canway.demos.demo.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevServiceImpl implements DevService {

    @Autowired
    private DevBaseDao devBaseDao;

    @Override
    public List<UserSbBean> getUserDevByUserId(Integer userId) {
        return devBaseDao.getUserDevByUserId(userId);
    }

    @Override
    public List<SbBean> like(String devName) {
        return devBaseDao.like(devName);
    }

    @Override
    public List<SbBean> orderBy(String string1, String string2) {
        return devBaseDao.orderBy(string1,string2);
    }

    @Override
    public List<GroupByClass> groupByDevName() {
        return devBaseDao.groupByDevName();
    }

    @Override
    public List<GroupByUser> groupBy() {
        return devBaseDao.groupBy();
    }
}
