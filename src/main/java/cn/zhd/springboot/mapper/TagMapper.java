package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.Tag;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {

    @Select("SELECT * FROM tag")
    List<Tag> getAllTag();
    @Select("SELECT tag_name FROM tag WHERE tag_id = #{tagId}")
    String getTagNameByTagId(Integer tagId);
    @Insert("INSERT INTO tag(tag_name,tag_type) VALUES(#{tagName},#{tagType})")
    Boolean insertTag(String tagName, Integer tagType);
    @Update("UPDATE tag SET tag_name = #{tagName} WHERE tag_id = #{tagId}")
    Boolean updateTag(String tagName,Integer tagId);
    @Delete("DELETE FROM tag WHERE tag_id = #{tagId}")
    Boolean deleteTag(Integer tagId);
}
