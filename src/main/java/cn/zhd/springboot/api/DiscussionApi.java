package cn.zhd.springboot.api;

import cn.zhd.springboot.entity.Discussion;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.DiscussionService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019/12/10.
 */
@RequestMapping("/discussion")
@RestController

public class DiscussionApi {
    private final DiscussionService discussionService;

    @Autowired
    public DiscussionApi(DiscussionService discussionService){this.discussionService = discussionService;}

    @RequestMapping("/get_discussion")
    public Msg<Object> getDiscussion(Integer articleId){
        List<Discussion> discussion = discussionService.getDiscussionByAid(articleId);
        return ResultUtil.success(discussion);
    }

    @RequestMapping("/submit_discussion")
    public Msg<Object> submitDiscussion(Discussion discussion){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        discussion.setDiscussionDateTime(time);
        if(discussionService.insertDiscussion(discussion)){
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/delete_discussion")
    public Msg<Object>DeleteDiscussion(Integer discussionId){
        if(discussionService.deleteDiscussion(discussionId)){
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }
}
