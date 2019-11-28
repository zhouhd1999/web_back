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
    @Select("SELECT * FROM comment WHERE commentAreaId=#{commentAreaId}")
    List <Comment> getCommentByCommentAreaId(Integer commentAreaId);

    @Insert("INSERT INTO comment(reviewerName,content,datetime,commentAreaId)VALUES(#{reviewerName},#{content},#{datetime},#{commentAreaId})")
    void insertComment(Comment comment);
}
