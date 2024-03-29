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

    @Override
    public String getTagNameByTagId(Integer tagId) {
        return tagMapper.getTagNameByTagId(tagId);
    }

    @Override
    public boolean insertTag(String tagName,Integer tagType) {
        return tagMapper.insertTag(tagName,tagType);
    }

    @Override
    public boolean updateTag(String tagName, Integer tagId) {
        return tagMapper.updateTag(tagName,tagId);
    }

    @Override
    public boolean deleteTag(Integer tagId) {
        return tagMapper.deleteTag(tagId);
    }
}
