package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Discussion;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/12/9.
 */
public interface DiscussionService {
    //获取评论
    List<Discussion> getDiscussionByAid(Integer articleId);

    //增加评论
    boolean insertDiscussion(Discussion discussion);

    //删除评论
    boolean deleteDiscussion(Integer discussionId);

}
