package cn.zhd.springboot.util;

import cn.zhd.springboot.entity.AllArticle;
import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.entity.Information;
import cn.zhd.springboot.service.ArticleService;
import cn.zhd.springboot.service.InformationService;
import cn.zhd.springboot.service.UserArticleAttitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SetClassUtil {
    @Autowired
    private InformationService informationService;

    public static SetClassUtil setClassUtil;

    @PostConstruct
    public void init()
    {
        setClassUtil = this;
    }
    public static List<AllArticle> getAllArticle(List<Article> articles)
    {
        List<AllArticle> allArticle = new ArrayList<>();
        for(int i=0; i<articles.size(); i++)
        {
            AllArticle tallArticle = new AllArticle();
            tallArticle.setArticle(articles.get(i));
            Information information= setClassUtil.informationService.getInformationByUserId(articles.get(i).getUserId());
            tallArticle.setInformation(information);
            allArticle.add(tallArticle);
        }
        return allArticle;
    }
}
