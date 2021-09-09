package net.canway.demos.demo.service.impl;

import net.canway.demos.demo.daos.DepBaseDao;
import net.canway.demos.demo.pojos.DepBean;
import net.canway.demos.demo.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepServiceImpl implements DepService {

    @Autowired
    private DepBaseDao depBaseDao;

    @Override
    public List<DepBean> list() {
        return depBaseDao.list();
    }

    @Override
    public DepBean getDepById(Integer depId) {
        return depBaseDao.getDepById(depId);
    }

    @Override
    public boolean update(DepBean depBean) {
        return depBaseDao.update(depBean);
    }

    @Override
    public boolean add(DepBean depBean) {
        return depBaseDao.add(depBean);
    }

    @Override
    public boolean delete(Integer depId) {
        return depBaseDao.delete(depId);
    }
}
