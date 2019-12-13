package cn.zhd.springboot.mapper;


import cn.zhd.springboot.entity.Directory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DirectoryMapper {
    @Select("SELECT directory_content FROM kb_directory WHERE directory_id = #{directoryId}")
    String getDirectory(Integer directoryId);
    @Update("UPDATE kb_directory SET directory_content = #{directoryContent} WHERE directory_id = #{directoryId}")
    boolean saveDirectory(Directory directory);
}
