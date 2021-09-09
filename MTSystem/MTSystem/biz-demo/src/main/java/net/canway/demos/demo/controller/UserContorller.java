package net.canway.demos.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.canway.demos.demo.pojos.DepBean;
import net.canway.demos.demo.pojos.UserBean;
import net.canway.demos.demo.service.DepService;
import net.canway.demos.demo.service.UserService;
import org.jooq.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "USER_MANAGE",description = "管理用户信息")
public class UserContorller {
    @Autowired
    private UserService userService;

/**
    @RequestMapping("/login")
    public String doLogin( @RequestBody User user, Map<String, Object> map, HttpSession session) {
        if (user != null &) {

            if(user.getName() ==  userService.getUserByUserName(user.getName()).getUserName() && user.getPassword == userService.get)
            session.setAttribute("loginUser", user);
            log.info("登陆成功，用户名：" + user.getUserName());
            //防止重复提交使用重定向
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            log.error("登陆失败");
            return "login";
        }
    }
*/

    @GetMapping
    @ApiOperation("获取用户列表")
    public List<UserBean> list() {
        return userService.list();
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "获取用户信息")
    public UserBean getDepName(
            @PathVariable
            @ApiParam(value = "用户ID", required = true)
                    Integer userId) {

        return userService.getUserById(userId);
    }

    @PutMapping
    @ApiOperation("更新用户信息")
    public Boolean update(
            @RequestBody
            @ApiParam("用户信息")
                    UserBean userBean
    ) {
        return userService.update(userBean);
    }

    @PostMapping
    @ApiOperation("添加用户信息")
    public Boolean add(
            @RequestBody
            @ApiParam("用户信息")
                    UserBean userBean) {
        return userService.add(userBean);
    }

    @DeleteMapping("/{userId}")
    @ApiOperation("通过用户ID删除用户信息")
    public Boolean delete(
            @PathVariable
            @ApiParam(value = "用户信息", required = true)
                    int userId) {
        return userService.delete(userId);
    }

}
