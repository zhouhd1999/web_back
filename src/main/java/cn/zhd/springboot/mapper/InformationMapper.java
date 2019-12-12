package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.Information;
import cn.zhd.springboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InformationMapper {

    @Select("SELECT * FROM information WHERE user_id=#{userId}")
    Information getInformationByUserId(Integer userId);

    @Update("UPDATE information SET in_age=#{inAge},in_phone_number=#{inPhoneNumber},in_profession=#{inProfession},in_introduction=#{inIntroduction} WHERE user_id=#{userId}")
    void updateInformation(Information information);

    @Insert("INSERT INTO information (user_id) VALUES(#{userId}) ")
    void insertInformationByUserId(Integer userId);
}
