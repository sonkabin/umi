package com.sjm.service.impl;

import com.sjm.dao.UserMapper;
import com.sjm.domain.User;
import com.sjm.domain.UserExample;
import com.sjm.service.UserService;
import com.sjm.util.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        user.setCreateTime(new Date());
        userMapper.insert(user);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int findUser(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if(users == null || users.size() == 0){
            throw new AuthenticationException("用户名或密码错误");
        }
        User user = users.get(0);
        if(user.getUserId() != 1){
            throw new AuthenticationException("您没有权限登录");
        }
        return user.getUserId();
    }
}
