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
    //获得标题内有指定字符串的文章（搜索功能）
    @Select("SELECT * FROM article WHERE article_name LIKE '%#{articleName}%'")
    List<Article> getArticleByName(String articleName);
    //获得指定日期的文章（按日期划分）
    @Select("SELECT * FROM article WHERE DATE_FORMAT(article_date_time,'%Y-%m-%d') = '#{articleDateTime}'")
    List<Article> getArticleByDateTime(String articleDateTime);
    //获得某类标签的文章（分类功能）
    @Select("SELECT * FROM article WHERE tag_id = #{tagId}")
    List<Article> getArticleByTag(int tagId);
    //获得按照点击数排序的文章
    @Select("SELECT * FROM article ORDER BY article_click_num desc")
    List<Article> getArticleByClick();
    //获得按照赞排序的5条文章
    @Select("SELECT * FROM article ORDER BY article_like desc LIMIT 5")
    List<Article> getArticleByLike();

    @Insert("INSERT INTO article(user_id,tag_id,article_state, article_content,article_describe,article_date_time,article_name)VALUES(#{userId},#{tagId},#{articleState},#{articleContent},#{articleDescribe},#{articleDateTime},#{articleName})")
    int insertArticle(Article article);
    //删除文章
    @Delete("DELETE FROM article WHERE article_id = #{articleId}")
    int deleteArticle(Integer articleId);
    //修改文章
    @Update("UPDATE article SET tag_id = #{tagId},article_name = #{articleName}, article_content = #{articleContent} WHERE article_id = #{articleId}")
    int updateArticle(Article article);

    //文章带赞数+1
    @Update(("UPDATE article SET article_like = article_like + 1 WHERE article_id = #{articleId}"))
    int likeArticle(Integer articleId);

    @Select("SELECT * FROM article WHERE article_id = #{articleId}")
    Article getArticleByArticleId(Integer articleId);
}
