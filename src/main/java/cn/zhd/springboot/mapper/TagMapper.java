package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {

    @Select("SELECT * FROM tag")
    List<Tag> getAllTag();
}
