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

    @Select("SELECT * FROM user WHERE userId=#{userId}")
    User getUserByUserId(String userId);

    @Insert("INSERT INTO user(userId,password,nickName,permission,tell)VALUES(#{userId},#{password},#{nickName},#{permission},#{tell})")
    void insertUser(User user);

    @Update("UPDATE user SET nickName=#{nickName},tell=#{tell},introduction=#{introduction} WHERE userId=#{userId}")
    void updateUser(User user);
}
