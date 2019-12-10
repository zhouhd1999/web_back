package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.Discussion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/12/9.
 */
@Mapper
@Repository
public interface DiscussionMapper {
    @Select("SELECT * FROM discussion WHERE a_id = #{aId} ORDER BY uid DESC")
    List<Discussion>getDiscussionByAid(Integer aId);

    @Insert("INSERT INTO discussion(uid,di_content,di_date_time,a_id)VALUES(#{uid},#{diContent},#{diDateTime},#{aId})")
    boolean insertDiscussion(Discussion discussion);
}
