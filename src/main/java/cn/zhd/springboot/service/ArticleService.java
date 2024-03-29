package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.entity.Comment;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
//
public interface ArticleService {
    List<Article> getArticleByAll();

    //按用户id获取所有文章
    List<Article>getArticleByUserId(Integer userId);

    //获得标题内有指定字符串的文章（搜索功能）
    List<Article> getArticleByName(String articleName);

    //获得指定日期的文章（按日期划分）
    List<Article> getArticleByDateTime(String articleDateTime);

    //获得某类标签的文章（分类功能）
    List<Article> getArticleByTag(int tagId);

    //获得按照点击数排序的文章
    List<Article> getArticleByClick();

    //获得按照赞排序的文章
    List<Article> getArticleByLike();

    public List<Article> getArticleByState(Integer state);

     //增加文章
    boolean insertArticle(Article article);

    //删除文章
    boolean deleteArticle(Integer articleId);
     //修改文章
    boolean updateArticle(Article article);

    boolean likeArticle(Integer articleId);

    boolean hateArticle(Integer articleId);
    boolean likeArticle1(Integer articleId);

    boolean hateArticle1(Integer articleId);


    Article getArticleByArticleId(Integer articleId);

    boolean updateArticleState(Integer articleState, Integer articleId);

    // 根据标签更新文章
    boolean updateArticleStateByTag(Integer state,Integer tagId);

    boolean updateArticleTagByTag(Integer tagId);

    boolean insertArticlePreviewImg(MultipartFile file);

    List<Article>getArticleByTagType(Integer tagType);

}
