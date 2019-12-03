package cn.zhd.springboot.mapper;


import cn.zhd.springboot.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    @Select("SELECT * FROM comment WHERE comment_area_id=#{commentAreaId} ORDER BY comment_id DESC")
    List <Comment> getCommentByCommentAreaId(Integer commentAreaId);

    @Insert("INSERT INTO comment(reviewer_name,content,date_time,comment_area_id)VALUES(#{reviewerName},#{content},#{dateTime},#{commentAreaId})")
    void insertComment(Comment comment);
}
