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

    @Select("SELECT * FROM information WHERE uid=#{uid}")
    Information getInformationByUserId(Integer uid);

    @Update("UPDATE information SET in_age=#{inAge},in_phone_number=#{inPhoneNumber},in_profession=#{inProfession},in_introduction=#{inIntroduction} WHERE uid=#{uid}")
    void updateInformation(Information information);

    @Insert("INSERT INTO information (uid) VALUES(#{uid}) ")
    void insertInformationByUserId(Integer uid);
}
