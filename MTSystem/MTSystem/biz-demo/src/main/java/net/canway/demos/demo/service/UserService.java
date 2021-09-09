package net.canway.demos.demo.service;

import net.canway.demos.demo.pojos.DepBean;
import net.canway.demos.demo.pojos.UserBean;

import java.util.List;

public interface UserService {

    List<UserBean>  list();

    UserBean getUserById(Integer depId);

    UserBean getUserByUserName(String name);

    Boolean update(UserBean user);

    Boolean add(UserBean user);

    Boolean delete(Integer id);



}
