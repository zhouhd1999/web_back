package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTag();
    String getTagNameByTagId(Integer tagId);

    boolean insertTag(String tagName);
    boolean updateTag(String tagName,Integer tagId);
    boolean deleteTag(Integer tagId);

}
