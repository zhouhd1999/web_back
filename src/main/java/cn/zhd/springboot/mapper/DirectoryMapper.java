package cn.zhd.springboot.mapper;


import cn.zhd.springboot.entity.Directory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DirectoryMapper {
    @Select("SELECT * FROM kb_directory WHERE directory_id = #{directoryId}")
    Directory getDirectory(Integer directoryId);

    @Update("UPDATE kb_directory SET directory_content = #{directoryContent},count_id=#{countId} WHERE directory_id = #{directoryId}")
    boolean saveDirectory(Directory directory);
    @Insert("INSERT INTO kb_directory(directory_id) VALUES(#{userId})")
    boolean insertDirectory(Integer userId);

}
