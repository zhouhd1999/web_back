package cn.zhd.springboot.mapper;


import cn.zhd.springboot.entity.UserArticleAttitude;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserArticleAttitudeMapper {
    //根据userId 和 articleId 查看对文章的态度
    @Select("SELECT * FROM user_article_attitude WHERE user_id = #{userId} AND article_id = #{articleId};")
    public UserArticleAttitude getUserAttitude(Integer userId,Integer articleId);
    @Select("SELECT article_id FROM user_article_attitude WHERE user_id = #{userId} AND user_attitude = #{userAttitude}")
    public List<Integer> getUserLikeArticleId(Integer userId, Integer userAttitude);
    //根据userId 和 articleId 增加对文章的态度
    @Insert("INSERT INTO user_article_attitude VALUES(#{userId},#{articleId},#{attitude})")
    public boolean insertUserAttitude(Integer userId,Integer articleId,Integer attitude);
    //根据userId 和 articleId 删除对文章的态度
    @Delete("DELETE FROM user_article_attitude WHERE user_id = #{userId} and article_id = #{articleId}")
    public boolean deleteUserAttitude(Integer userId,Integer articleId);
    @Update("UPDATE user_article_attitude SET user_attitude = #{attitude} WHERE user_id= #{userId} AND article_id = #{articleId}")
    public boolean updateUserAttitude(Integer userId,Integer articleId,Integer attitude);


}
