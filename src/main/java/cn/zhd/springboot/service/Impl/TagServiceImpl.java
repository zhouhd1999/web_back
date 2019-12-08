package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.Tag;
import cn.zhd.springboot.mapper.TagMapper;
import cn.zhd.springboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;

    @Autowired
    public TagServiceImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }


    @Override
    public List<Tag> getAllTag() {
        return tagMapper.getAllTag();
    }
}
