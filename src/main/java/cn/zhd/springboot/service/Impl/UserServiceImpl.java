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
    public UserServiceImpl(UserMapper userMapper, InformationMapper informationMapper){
        this.userMapper=userMapper;
        this.informationMapper = informationMapper;
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User loginByUserAccount(String userAccount,String password){
        User user = userMapper.getUserByUserAccount(userAccount);
        System.out.println(user);
        if (password.equals(user.getUserPassword())){
            user.setUserPassword("******");
            return user;
        }else {
            return null;
        }
    }

    @Override
    public User getUserByUserAccount(String userAccount) {
        return userMapper.getUserByUserAccount(userAccount);
    }


    @Override
    public boolean insertUser(User user){
        if(userMapper.getUserByUserAccount(user.getUserAccount())==null){
            userMapper.insertUser(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void updateUser(User user) { userMapper.updateUser(user); }
}
