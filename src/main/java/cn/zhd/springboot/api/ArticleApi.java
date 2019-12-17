package cn.zhd.springboot.api;

import cn.zhd.springboot.entity.AllArticle;
import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.entity.Information;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.ArticleService;
import cn.zhd.springboot.service.InformationService;
import cn.zhd.springboot.service.UserArticleAttitudeService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import cn.zhd.springboot.util.SetClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/article")
@RestController
public class ArticleApi {

    private final ArticleService articleService;
    private final UserArticleAttitudeService userArticleAttitudeService;

    @Autowired
    public ArticleApi(ArticleService articleService, UserArticleAttitudeService userArticleAttitudeService, InformationService informationService)
    {
        this.articleService = articleService;
        this.userArticleAttitudeService = userArticleAttitudeService;
    }

    @RequestMapping("/get_article")
    public Msg<Object> getArticle()
    {
        List<Article> articles = articleService.getArticleByAll();
        List<AllArticle> allArticle = SetClassUtil.getAllArticle(articles);
        return ResultUtil.success(allArticle);
    }

    @RequestMapping("/get_articleByUserId")
    public Msg<Object>getArticleByUserId(Integer userId){
        List<Article> articles = articleService.getArticleByUserId(userId);
        List<AllArticle> allArticle = SetClassUtil.getAllArticle(articles);
        return ResultUtil.success(allArticle);
    }

    @RequestMapping("/get_article_by_state")
    public Msg<Object>getArticleByState(Integer state)
    {
        List<Article> articles = articleService.getArticleByState(state);
        List<AllArticle> allArticle = SetClassUtil.getAllArticle(articles);
        return ResultUtil.success(allArticle);
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
    @RequestMapping("/update_article_state")
    public Msg<Object> updateArticleState(Integer state, Integer article){
        if(articleService.updateArticleState(state,article)){
            return ResultUtil.success();
        }else {
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/update_article_State_By_Tag")
    public Msg<Object> updateArticleStateByTag(Integer state,Integer tagId){
        if(articleService.updateArticleStateByTag(state,tagId)) {
            return ResultUtil.success();
        }
        else{
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


    @RequestMapping("/get_like_article")
    public Msg<Object> getLikeArticle(Integer userId)
    {
        List<Integer>articleId = userArticleAttitudeService.getUserLikeArticleId(userId,1);
        List<Article> article = new ArrayList<>();
        Article t_article;
        for(int i=0; i<articleId.size(); i++)
        {
            t_article = articleService.getArticleByArticleId(articleId.get(i));
            t_article.setArticleContent(" ");
            article.add(t_article);
        }
        List<AllArticle> allArticles = SetClassUtil.getAllArticle(article);
        return ResultUtil.success(allArticles);
    }

    @RequestMapping("/get_article_by_tag_id")
        public Msg<Object> getArticleByTagId(Integer tagId){
        List<Article> articles = articleService.getArticleByTag(tagId);
        List<AllArticle> allArticle = SetClassUtil.getAllArticle(articles);
        return ResultUtil.success(allArticle);
    }

    @RequestMapping("/insert_article_preview_img")
    public Msg<Object> insertArticlePreviewImg(MultipartFile file)
    {
        if(articleService.insertArticlePreviewImg(file))
        {
            return ResultUtil.success();
        }
        else{
            return ResultUtil.error(ResultEnum.ALL_ERROR);
        }
    }

    @RequestMapping("/get_article_by_tag_type")
    public Msg<Object> getArticleByTagType(Integer tagType){
        List<Article>articles = articleService.getArticleByTagType(tagType);
        List<AllArticle> allArticle = SetClassUtil.getAllArticle(articles);
        return ResultUtil.success(allArticle);
    }


}
