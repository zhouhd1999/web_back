package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

    @Mapper
    @Repository
    public interface ArticleMapper {
    //获得全部的文章
    @Select("SELECT * FROM article ORDER BY article_date_time DESC")
    List<Article> getArticleByAll();

    //按id搜索文章
    @Select("SELECT * FROM article where user_id = #{userId} ORDER BY article_date_time DESC")
  //  @Select("SELECT * FROM article, `user`,tag WHERE article_id = 2")
    List<Article> getArticleByUserId(Integer userId);

    //获得标题内有指定字符串的文章（搜索功能）
    @Select("SELECT * FROM article WHERE article_name LIKE '%#{articleName}%'")
    List<Article> getArticleByName(String articleName);

    //获得指定日期的文章（按日期划分）
    @Select("SELECT * FROM article WHERE DATE_FORMAT(article_date_time,'%Y-%m-%d') = '#{articleDateTime}'")
    List<Article> getArticleByDateTime(String articleDateTime);

    //获得某类标签的文章（分类功能）
    @Select("SELECT * FROM article WHERE tag_id = #{tagId} ORDER BY article_date_time DESC")
    List<Article> getArticleByTag(int tagId);

    //获得按照点击数排序的文章
    @Select("SELECT * FROM article ORDER BY article_click_num desc")
    List<Article> getArticleByClick();

    //获得按照赞排序的5条文章
    @Select("SELECT * FROM article ORDER BY article_like desc LIMIT 5")
    List<Article> getArticleByLike();

    @Select("SELECT * FROM article WHERE article_state = #{state}")
    List<Article> getArticleByState(Integer state);




    @Select("SELECT * FROM article WHERE article_id = #{articleId}")
    Article getArticleByArticleId(Integer articleId);

    @Insert("INSERT INTO article(user_id,tag_id,article_state, article_content,article_describe,article_date_time,article_name,article_preview_img)VALUES(#{userId},#{tagId},#{articleState},#{articleContent},#{articleDescribe},#{articleDateTime},#{articleName},#{articlePreviewImg})")
    int insertArticle(Article article);
    //删除文章
    @Delete("DELETE FROM article WHERE article_id = #{articleId}")
    int deleteArticle(Integer articleId);
    //修改文章
    @Update("UPDATE article SET tag_id = #{tagId},article_name = #{articleName},article_date_time = #{articleDateTime} ,article_content = #{articleContent} WHERE article_id = #{articleId}")
    int updateArticle(Article article);

    //文章的赞数+1
    @Update("UPDATE article SET article_like = article_like + 1 WHERE article_id = #{articleId}")
    int likeArticle(Integer articleId);
    //根据article_id 更改state的值。
    @Update("UPDATE article SET article_state = #{articleState} WHERE article_id = #{articleId}")
    boolean updateArticleState(Integer articleState, Integer articleId);

    //根据tag_id 更改 static的值
    @Update("UPDATE article SET article_state = #{state} WHERE tag_id = #{tagId}")
    boolean updateArticleStateByTag(Integer state,Integer tagId);

    //标签被删除后，标签下的文章自动归入未归档类中。
    @Update("UPDATE article SET tag_id = 0 WHERE tag_id = #{tagId}")
    boolean updateArticleTagByTag(Integer tagId);


    @Select("SELECT * FROM `article` ,tag where `article`.tag_id = tag.tag_id and tag_type = #{tagType}")
    List<Article>  getArticleByTagType(Integer tagType);







    }
