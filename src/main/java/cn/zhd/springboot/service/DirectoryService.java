package cn.zhd.springboot.service;

public interface DirectoryService {

    String getDirectory(Integer directoryId);
    boolean saveDirectory(String content, Integer directoryId);
}
