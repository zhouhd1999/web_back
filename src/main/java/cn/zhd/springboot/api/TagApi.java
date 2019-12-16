package cn.zhd.springboot.api;

import cn.zhd.springboot.entity.Article;
import cn.zhd.springboot.entity.Tag;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.ArticleService;
import cn.zhd.springboot.service.TagService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/tag")
@RestController
public class TagApi {

    private final TagService tagService;
    private final ArticleService articleService;
    @Autowired
    public TagApi(TagService tagService, ArticleService articleService) {
        this.tagService = tagService;
        this.articleService = articleService;
    }

    //对得到的属性进行判断 type为0的是生活类标签，type为1是技术类标签。
    @RequestMapping("/get_all_tag")
    public Msg<Object> getAllTag(){
        return ResultUtil.success(tagService.getAllTag());
    }
    @RequestMapping("/insert_tag")
    public Msg<Object>  insertTag(String tagName)
    {
        if(tagService.insertTag(tagName))
        {
            return ResultUtil.success();
        }
        else{
            return ResultUtil.error(ResultEnum.TAG_INSET_ERROR);
        }
    }
    @RequestMapping("/update_tag")
    public Msg<Object> updateTag(String tagName,Integer tagId)
    {
        if(tagService.updateTag(tagName,tagId))
        {
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.TAG_UPDATE_ERROR);
        }
    }
    @RequestMapping("/delete_tag")
    public Msg<Object> deleteTag(Integer tagId)
    {
        if(tagService.deleteTag(tagId))
        {
            if(articleService.updateArticleStateByTag(0,tagId))
            {
                return ResultUtil.success();
            }
            else{
                return ResultUtil.error(ResultEnum.ARTICLE_UPDATE_ERROR);
            }
        }
        else{
            return ResultUtil.error(ResultEnum.TAG_DELETE_ERROR);
        }
    }

}
