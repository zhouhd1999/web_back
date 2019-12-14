package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.UserArticleAttitude;
public interface UserArticleAttitudeService {
    //根据userId 和 articleId 查看对文章的态度
    UserArticleAttitude getUserAttitude(Integer userId, Integer articleId);
    //根据userId 和 articleId 增加对文章的态度
    boolean insertUserAttitude(Integer userId,Integer articleId,Integer attitude);
    //根据userId 和 articleId 删除对文章的态度
    boolean deleteUserAttitude(Integer userId,Integer articleId);
    boolean upadateUserAttitude(Integer userId,Integer articleId,Integer attitude);
}
