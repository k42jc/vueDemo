package com.techeffic.service;

import com.techeffic.dao.UserMapper;
import com.techeffic.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liaoxudong on 2017/5/24.
 */
@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUsers(){
        return userMapper.findAll();
    }

    public User getUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
}
