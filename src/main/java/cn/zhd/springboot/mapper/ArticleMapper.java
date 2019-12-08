package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    //获得全部的文章
    @Select("SELECT * FROM article")
    List<Article> getArticleByAll();
    //获得标题内有指定字符串的文章（搜索功能）
    @Select("SELECT * FROM article WHERE a_name LIKE '%#{name}%'")
    List<Article> getArticleByName(String name);
    //获得指定日期的文章（按日期划分）
    @Select("SELECT * FROM article WHERE DATE_FORMAT(a_date_time,'%Y-%m-%d') = '#{datetime}'")
    List<Article> getArticleByDateTime(String datetime);
    //获得某类标签的文章（分类功能）
    @Select("SELECT * FROM article WHERE t_id = #{tid}")
    List<Article> getArticleByTag(int tid);
    //获得按照点击数排序的文章
    @Select("SELECT * FROM article ORDER BY a_hits desc")
    List<Article> getArticleByHits();
    //获得按照赞排序的文章
    @Select("SELECT * FROM article ORDER BY a_like desc")
    List<Article> getArticleByLike();

                            //    Integer aid;        //文章ID
                            //    Integer aStatus;    //文章状态 {1、审核中，0、审核通过，2、审核失败}
                            //    Integer uid;        //文章发布人ID
                            //    Integer tid;        //文章标签ID
                            //    Integer deId;       //文章评论区id
                            //    String aContent;    //文章内容
                            //    String dateTime;    //文章发布时间
                            //    Integer aLick;      //文章赞数
                            //    Integer aHate;      //文章踩数
                            //    Integer aHits;      //文章点击数
                            //    String aName;       //文章名
    //增加文章
    @Insert("INSERT INTO article(uid,t_id,a_state, a_content,a_describe,a_date_time,a_name)VALUES(#{uid},#{tId},#{aState},#{aContent},#{aDescribe},#{aDateTime},#{aName})")
    int insertArticle(Article article);
    //删除文章
    @Delete("DELETE FROM article WHERE a_id = #{aId}")
    int deleteArticle(Integer aId);
    //修改文章
    @Update("UPDATE article SET t_id = #{tId},a_name = #{aName}, a_content = #{aContent} WHERE a_id = #{aId}")
    int updateArticle(Article article);

}
