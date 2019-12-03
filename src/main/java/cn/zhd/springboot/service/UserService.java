package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getUserByUserId(String userId);

    void insertUser(User user);

   // void updateUser(User user);
}
