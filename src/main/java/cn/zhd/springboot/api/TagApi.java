package cn.zhd.springboot.api;

import cn.zhd.springboot.service.TagService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tag")
@RestController
public class TagApi {

    private final TagService tagService;

    @Autowired
    public TagApi(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping("/get_all_tag")
    public Msg<Object> getAllTag(){
        return ResultUtil.success(tagService.getAllTag());
    }
}
