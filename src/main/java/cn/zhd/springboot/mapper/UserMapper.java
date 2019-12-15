package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user WHERE user_account=#{userAccount}")
    User getUserByUserAccount(String userAccount);

    @Insert("INSERT INTO user(user_account,user_password,user_nickname,user_permission)VALUES(#{userAccount},#{userPassword},#{userNickname},#{userPermission})")
    void insertUser(User user);

    @Update("UPDATE user SET user_nickname=#{userNickname} WHERE user_account=#{userAccount}")
    void updateUser(User user);

    @Update("UPDATE user SET user_permission = #{userPermission} WHERE user_account = #{userAccount}")
    boolean updateUserPermission(User user);
}
