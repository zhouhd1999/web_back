package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.entity.Comment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleService {
    List<Article> getArticleByAll();
    //获得标题内有指定字符串的文章（搜索功能）
    List<Article> getArticleByName(String name);
    //获得指定日期的文章（按日期划分）
    List<Article> getArticleByDateTime(String datetime);
    //获得某类标签的文章（分类功能）
   List<Article> getArticleByTag(int tid);
    //获得按照点击数排序的文章
    List<Article> getArticleByHits();
    //获得按照赞排序的文章
    List<Article> getArticleByLike();
     //增加文章
     boolean insertArticle(Article article);
    //删除文章
     boolean deleteArticle(Integer a_id);
     //修改文章
     boolean updateArticle(Article article);
}
