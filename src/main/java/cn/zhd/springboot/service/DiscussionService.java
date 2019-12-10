package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Discussion;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/12/9.
 */
public interface DiscussionService {
    List<Discussion> getDiscussionByAid(Integer aId);

    boolean insertDiscussion(Discussion discussion);
}
