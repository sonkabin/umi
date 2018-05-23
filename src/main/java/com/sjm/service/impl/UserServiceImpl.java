package com.sjm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.dao.UserMapper;
import com.sjm.domain.User;
import com.sjm.domain.UserExample;
import com.sjm.service.UserService;
import com.sjm.util.AuthenticationException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        user.setCreateTime(new Date());
        userMapper.insert(user);
    }

    @Override
    public List<User> getUsers(String username,String email) {
    	UserExample example = new UserExample();
    	example.createCriteria().andUsernameLike("%" + username + "%").andEmailLike("%" + email + "%");
        return userMapper.selectByExample(example);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
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

	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updatePwd(String oldPwd, String newPwd, int userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		if(user.getPassword() != oldPwd) {
			throw new AuthenticationException("密码错误");
		}
		user.setPassword(newPwd);
		userMapper.updateByPrimaryKeySelective(user);
	}
}
