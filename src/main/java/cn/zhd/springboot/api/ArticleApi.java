package cn.zhd.springboot.api;

import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.ArticleService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import org.apache.catalina.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/article")
@RestController
public class ArticleApi {

    private  final ArticleService articleService;

    @Autowired
    public ArticleApi(ArticleService articleService)
    {
        this.articleService = articleService;
    }
    
    @RequestMapping("/get_article")
    public Msg<Object> getArticle()
    {
        List<Article> articles = articleService.getArticleByAll();
        return ResultUtil.success(articles);
    }

    @RequestMapping("/insert_article")
    public Msg<Object> insertArticle(Article article){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        article.setArticleDateTime(time);
        if(articleService.insertArticle(article)){
            return ResultUtil.success();
        }else {
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/delete_article")
    public Msg<Object> deleteArticle(Integer articleId){
        if(articleService.deleteArticle(articleId)){
            return ResultUtil.success();
        }else {
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/update_article")
    public Msg<Object> updateArticle(Article article){
        if(articleService.updateArticle(article)){
            return ResultUtil.success();
        }else {
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/get_article_by_like")
    public Msg<Object> getArticleByLike(){
        return ResultUtil.success(articleService.getArticleByLike());
    }

    @RequestMapping("/like_article")
    public Msg<Object> likeArticle(Integer articleId){
        if (articleService.likeArticle(articleId)){
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/get_article_by_article_id")
    public Msg<Object> getArticleByArticleId(Integer articleId){
        return ResultUtil.success(articleService.getArticleByArticleId(articleId));
    }
}
