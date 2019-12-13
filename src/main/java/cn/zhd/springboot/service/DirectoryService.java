package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Directory;

public interface DirectoryService {

    String getDirectory(Integer directoryId);
    boolean saveDirectory(Directory directory);
}
