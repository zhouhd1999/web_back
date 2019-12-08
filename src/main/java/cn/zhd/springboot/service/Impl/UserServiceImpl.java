package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.User;
import cn.zhd.springboot.mapper.InformationMapper;
import cn.zhd.springboot.mapper.UserMapper;
import cn.zhd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final InformationMapper informationMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, InformationMapper informationMapper){this.userMapper=userMapper;
        this.informationMapper = informationMapper;
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User loginByUserId(String userId,String password){
        User user = userMapper.getUserByUserId(userId);
        if (password.equals(user.getPassword())){
            user.setPassword("******");
            return user;
        }else {
            return null;
        }
    }

    @Override
    public User getUserByUserId(String userId) {
        User user = userMapper.getUserByUserId(userId);
        return user;
    }


    @Override
    public boolean insertUser(User user){
        if(userMapper.getUserByUserId(user.getUserId())==null){
            userMapper.insertUser(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void updateUser(User user) { userMapper.updateUser(user); }
}
