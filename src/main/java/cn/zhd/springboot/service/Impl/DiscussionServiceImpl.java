package cn.zhd.springboot.service.Impl;
import cn.zhd.springboot.entity.Discussion;
import cn.zhd.springboot.mapper.DiscussionMapper;
import cn.zhd.springboot.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * Created by Enzo Cotter on 2019/12/9.
 */
public class DiscussionServiceImpl implements DiscussionService {
    private  final DiscussionMapper discussionMapper;

    @Autowired
    public DiscussionServiceImpl(DiscussionMapper discussionMapper){this.discussionMapper = discussionMapper;}

    @Override
    public List<Discussion>getDiscussionByAid(Integer articleId){
        return discussionMapper.getDiscussionByAid(articleId);
    }
    @Override
    public boolean insertDiscussion(Discussion discussion){return(discussionMapper.insertDiscussion(discussion));}
    @Override
    public boolean deleteDiscussion(Integer discussionId){return (discussionMapper.deleteDiscussion(discussionId));}
}
