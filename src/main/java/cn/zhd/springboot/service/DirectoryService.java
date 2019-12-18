package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Directory;

public interface DirectoryService {

    Directory getDirectory(Integer directoryId);
    boolean saveDirectory(Directory directory);

    boolean insertDirectory(Integer userId);
}
