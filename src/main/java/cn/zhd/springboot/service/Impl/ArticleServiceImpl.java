package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.mapper.ArticleMapper;
import cn.zhd.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Article> getArticleByName(String name) {
        return articleMapper.getArticleByName(name);
    }

    @Override
    public List<Article> getArticleByDateTime(String datetime) {
        return articleMapper.getArticleByDateTime(datetime);
    }

    @Override
    public List<Article> getArticleByTag(int tid) {
        return articleMapper.getArticleByTag(tid);
    }

    @Override
    public List<Article> getArticleByHits() {
        return getArticleByHits();
    }

    @Override
    public List<Article> getArticleByLike() {
        return getArticleByLike();
    }


}
