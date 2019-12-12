package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.mapper.DirectoryMapper;
import cn.zhd.springboot.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryServiceImpl implements DirectoryService {
    private final DirectoryMapper directoryMapper;
    @Autowired
    public DirectoryServiceImpl(DirectoryMapper directoryMapper)
    {
        this.directoryMapper = directoryMapper;
    }
    @Override
    public String getDirectory(Integer directoryId) {
        return directoryMapper.getDirectory(directoryId);
    }

    @Override
    public boolean saveDirectory(String content, Integer directoryId) {
        return  directoryMapper.saveDirectory(content,directoryId);
    }
}
