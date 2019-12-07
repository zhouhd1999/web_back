package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User loginByUserId(String userId,String password);

    User getUserByUserId(String userId);

    boolean insertUser(User user);

    void updateUser(User user);
}
