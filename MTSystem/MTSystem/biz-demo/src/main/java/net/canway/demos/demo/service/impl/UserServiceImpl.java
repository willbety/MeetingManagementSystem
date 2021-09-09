package net.canway.demos.demo.service.impl;

import net.canway.demos.demo.daos.UserBaseDao;
import net.canway.demos.demo.pojos.UserBean;
import net.canway.demos.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBaseDao userBaseDao;

    @Override
    public List<UserBean> list() {
        return userBaseDao.list();
    }

    @Override
    public UserBean getUserById(Integer userId) {
        return userBaseDao.getUserByID(userId);
    }

    public UserBean getUserByUserName(String name){return  userBaseDao.getUserByUserName(name);}

    @Override
    public Boolean update(UserBean user) {
        return userBaseDao.updateUser(user);
    }

    @Override
    public Boolean add(UserBean user) {
        return userBaseDao.add(user);
    }

    @Override
    public Boolean delete(Integer id) {
        return userBaseDao.delete(id);
    }
}
