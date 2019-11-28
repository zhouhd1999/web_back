package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentByCommentAreaId(Integer commentAreaId);

    void insertComment(Comment comment);
}
