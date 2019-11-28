package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.User;
import cn.zhd.springboot.mapper.UserMapper;
import cn.zhd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){this.userMapper=userMapper;}

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getUserByUserId(String userId){
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public  void insertUser(User user){
        userMapper.insertUser(user);
    }
}
