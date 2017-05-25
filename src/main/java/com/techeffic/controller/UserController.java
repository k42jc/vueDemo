package com.techeffic.controller;

import com.techeffic.entity.User;
import com.techeffic.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 提供restful api处理用户逻辑
 * Created by liaoxudong on 2017/5/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> users(){
        logger.debug("获取所有用户信息");
        return userService.getUsers();
    }

    /**
     * 可以使用 /user/id.json or /user/id.xml的请求格式分别得到json/xml格式数据
     * 需要三个条件(否则会报【HTTP ERROR 406】)：
     * 1.mvc-servlet.xml配置了json/xml转换或直接使用<mvc:annotation-driven/>标签
     * 2.maven依赖中有jackson(spring的内部json/xml实现)
     * 3.如果是.xml格式，还需要在对应的实体类中使用【javax.xml.bind.annotation】对应的注解
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteUserById(@PathVariable(value = "id") Integer id) {
        return userService.deleteUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public int addUser(User user){
        return userService.addUserOne(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public int updateUser(User user){
        return userService.updateUserOne(user);
    }
}
