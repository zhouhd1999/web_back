package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    String getNicknameByUserId(Integer userId);


    User loginByUserAccount(String userAccount,String password);

    User getUserByUserAccount(String userAccount);

    boolean insertUser(User user);

    void updateUser(User user);
    boolean updateUserPermission(User user);
}
