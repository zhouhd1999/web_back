package cn.zhd.springboot.util;

import cn.zhd.springboot.entity.*;
import cn.zhd.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SetClassUtil {
    @Autowired
    //private InformationService informationService;
    private UserService userService;
    @Autowired
    private TagService tagService;

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
            String nickname= setClassUtil.userService.getNicknameByUserId(articles.get(i).getUserId());
            String tagName = setClassUtil.tagService.getTagNameByTagId(articles.get(i).getTagId());
            tallArticle.setNickname(nickname);
            tallArticle.setTagName(tagName);
            allArticle.add(tallArticle);
        }
        return allArticle;
    }
}
