package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.UserArticleAttitude;
import cn.zhd.springboot.mapper.UserArticleAttitudeMapper;
import cn.zhd.springboot.service.UserArticleAttitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserArticleAttitudeServiceImpI implements UserArticleAttitudeService {
    private final UserArticleAttitudeMapper userArticleAttitudeMapper;
    @Autowired
    public UserArticleAttitudeServiceImpI(UserArticleAttitudeMapper userArticleAttitudeMapper)
    {
        this.userArticleAttitudeMapper = userArticleAttitudeMapper;
    }

    @Override
    public UserArticleAttitude getUserAttitude(Integer userId, Integer articleId) {
        return userArticleAttitudeMapper.getUserAttitude(userId,articleId);
    }

    @Override
    public boolean insertUserAttitude(Integer userId, Integer articleId, Integer attitude) {
        return userArticleAttitudeMapper.insertUserAttitude(userId,articleId,attitude);
    }

    @Override
    public boolean deleteUserAttitude(Integer userId, Integer articleId) {
        return userArticleAttitudeMapper.deleteUserAttitude(userId,articleId);
    }

    @Override
    public boolean updateUserAttitude(Integer userId, Integer articleId, Integer attitude) {
        return userArticleAttitudeMapper.updateUserAttitude(userId,articleId,attitude);
    }

    @Override
    public List<Integer> getUserLikeArticleId(Integer userId, Integer userAttitude) {
        return userArticleAttitudeMapper.getUserLikeArticleId(userId,userAttitude);
    }


}
