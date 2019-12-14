package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.Discussion;
import org.apache.ibatis.annotations.Delete;
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
    @Select("SELECT * FROM discussion WHERE article_id = #{articleId} ORDER BY user_id DESC")
    List<Discussion>getDiscussionByAid(Integer articleId);

    @Insert("INSERT INTO discussion(user_id,discussion_content,discussion_date_time,article_id,replay_id,replay_user_id)VALUES(#{userId},#{discussionContent},#{discussionDateTime},#{articleId},#{replayId},#{replayUserId})")
    boolean insertDiscussion(Discussion discussion);

    @Delete("delete from discussion where discussion_id = #{discussionId}")
    boolean deleteDiscussion(Integer discussionId);
}
