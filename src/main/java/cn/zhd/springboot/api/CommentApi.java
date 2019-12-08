package cn.zhd.springboot.api;

import cn.zhd.springboot.entity.Comment;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.CommentService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/comment")
@RestController
public class CommentApi {

    private final CommentService commentService;

    @Autowired
    public CommentApi(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("/get_comment")
    public Msg<Object> GetComment(Integer commentAreaId){
        List<Comment> comment=commentService.getCommentByCommentAreaId(commentAreaId);
        return ResultUtil.success(comment);
    }

    @RequestMapping("/submit_comment")
    public Msg<Object> SubmitComment(Comment comment){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        comment.setDateTime(time);
        commentService.insertComment(comment);
        return ResultUtil.success();
    }
}
