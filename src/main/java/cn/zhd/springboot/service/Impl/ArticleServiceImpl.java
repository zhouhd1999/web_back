package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.mapper.ArticleMapper;
import cn.zhd.springboot.service.ArticleService;
import cn.zhd.springboot.util.FileSaveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;


    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper)
    {
        this.articleMapper = articleMapper;
    }

    @Override
    public List<Article> getArticleByAll() {
        return articleMapper.getArticleByAll();
    }

    @Override
    public List<Article>getArticleByUserId(Integer userId){
        return articleMapper.getArticleByUserId(userId);
    }

    @Override
    public List<Article> getArticleByName(String articleName) {
        return articleMapper.getArticleByName(articleName);
    }

    @Override
    public List<Article> getArticleByDateTime(String articleDateTime) {
        return articleMapper.getArticleByDateTime(articleDateTime);
    }

    @Override
    public List<Article> getArticleByTag(int tagId) {
        return articleMapper.getArticleByTag(tagId);
    }

    @Override
    public List<Article> getArticleByState(Integer state){return articleMapper.getArticleByState(state);}

    @Override
    public List<Article> getArticleByClick() {
        return articleMapper.getArticleByClick();
    }

    @Override
    public List<Article> getArticleByLike() {
        return articleMapper.getArticleByLike();
    }

    @Override
    public boolean insertArticle(Article article) {
        return articleMapper.insertArticle(article) != 0 ;
    }

    @Override
    public boolean deleteArticle(Integer articleId) {
        return articleMapper.deleteArticle(articleId) != 0;
    }

    @Override
    public boolean updateArticle(Article article) {
        return articleMapper.updateArticle(article) != 0;
    }

    @Override
    public boolean likeArticle(Integer articleId) {
        return articleMapper.likeArticle(articleId) != 0;
    }

    @Override
    public boolean hateArticle(Integer articleId) {
        return articleMapper.hateArticle(articleId)!=0;
    }

    @Override
    public boolean likeArticle1(Integer articleId) {
        return articleMapper.likeArticle1(articleId)!=0;
    }

    @Override
    public boolean hateArticle1(Integer articleId) {
        return articleMapper.hateArticle1(articleId)!=0;
    }

    @Override
    public Article getArticleByArticleId(Integer articleId) {
        return articleMapper.getArticleByArticleId(articleId);
    }

    @Override
    public boolean updateArticleState(Integer articleState, Integer articleId) {
        return articleMapper.updateArticleState(articleState,articleId);
    }

    @Override
    public boolean updateArticleStateByTag(Integer state, Integer tagId) {
        return articleMapper.updateArticleStateByTag(state,tagId);
    }

    @Override
    public boolean updateArticleTagByTag(Integer tagId) {
        return articleMapper.updateArticleTagByTag(tagId);
    }

    @Override
    public boolean insertArticlePreviewImg(MultipartFile file){
        String url = "D:/Web/second/src/assets/article_img/";
        return FileSaveUtil.filesave(file,url);
    }

    @Override
    public List<Article>getArticleByTagType(Integer tagType){
        return articleMapper.getArticleByTagType(tagType);
    }

}
