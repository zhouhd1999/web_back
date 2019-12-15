package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTag();
    boolean insertTag(String tagName);
    boolean updateTag(String tagName,Integer tagId);
}
