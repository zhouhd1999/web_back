package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.Comment;
import cn.zhd.springboot.mapper.CommentMapper;
import cn.zhd.springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    @Override
    public List<Comment> getCommentByCommentAreaId(Integer commentAreaId) {
        return commentMapper.getCommentByCommentAreaId(commentAreaId);
    }

    @Override
    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    @Override
    public boolean deleteComment(Integer commentId){
        return commentMapper.deleteComment(commentId)!= 0;
    }
}
