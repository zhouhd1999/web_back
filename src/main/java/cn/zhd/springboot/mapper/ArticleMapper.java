package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

    //增加文章
    //删除文章
    //修改文章
    //
}
