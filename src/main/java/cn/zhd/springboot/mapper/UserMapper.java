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

    @Select("SELECT * FROM user WHERE user_id=#{userId}")
    User getUserByUserId(String userId);

    @Insert("INSERT INTO user(user_id,password,nickname,permission)VALUES(#{userId},#{password},#{nickname},#{permission})")
    void insertUser(User user);

//    @Update("UPDATE user SET nickname=#{nickname} WHERE user_id=#{userId}")
//    void updateUser(User user);
}
