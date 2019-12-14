package cn.zhd.springboot.api;

import cn.zhd.springboot.entity.UserArticleAttitude;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.UserArticleAttitudeService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

@RequestMapping("/attitude")
@RestController
public class UserArticleAttitudeApi {
    private final UserArticleAttitudeService userArticleAttitudeService;
    @Autowired
    public UserArticleAttitudeApi(UserArticleAttitudeService userArticleAttitudeService)
    {
        this.userArticleAttitudeService = userArticleAttitudeService;
    }
    @RequestMapping("/get_attitude")
    public Msg<Object> getUserAttitude(Integer userId, Integer articleId)
    {
        if(userArticleAttitudeService.getUserAttitude(userId,articleId) == null)
        {
            UserArticleAttitude userArticleAttitude = new UserArticleAttitude(userId,articleId,0);
            return ResultUtil.success(userArticleAttitude);
        }
        else
        {
            return ResultUtil.success(userArticleAttitudeService.getUserAttitude(userId,articleId));
        }
    }
    //当前状况， currentAttitude，0代表未赞，未踩，1代表赞，不踩，-1代表不赞，踩
    //期望改变， futureAttitude， 0代表取消状态，1代表赞，-1代表踩
    @RequestMapping("/click_attitude")
    public Msg<Object> updateUserAttitude(Integer userId,Integer articleId, Integer currentAttitude,Integer futureAttitude)
    {
        try{
            if(currentAttitude == 0) //当前值为0，说明数据库中没有这个数据，要直接进行插入操作
            {
                if(!userArticleAttitudeService.insertUserAttitude(userId,articleId,futureAttitude))
                {
                    return ResultUtil.error(ResultEnum.ATTITUDE_INSERT_ERROR);
                }
            }
            else
            {
                if(futureAttitude == 0)//期望值为0，直接删除这个数据
                {
                    if(!userArticleAttitudeService.deleteUserAttitude(userId,articleId))
                    {
                        return ResultUtil.error(ResultEnum.ATTITUDE_DELETE_ERROR);
                    }
                }
                else//否则就进行更新。
                {
                    if(!userArticleAttitudeService.upadateUserAttitude(userId,articleId,futureAttitude))
                    {
                        return ResultUtil.error(ResultEnum.ATTITUDE_UPDATE_ERROR);
                    }
                }
            }
        }catch (Exception e)
        {
            return ResultUtil.error(ResultEnum.ATTITUDE_DATABASE_ERROR);
        }
        return ResultUtil.success();
    }
}
