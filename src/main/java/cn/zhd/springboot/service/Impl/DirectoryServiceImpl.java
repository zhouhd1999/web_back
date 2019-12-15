package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.Directory;
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
    public Directory getDirectory(Integer directoryId) {
        return directoryMapper.getDirectory(directoryId);
    }

    @Override
    public boolean saveDirectory(Directory directory) {
        return  directoryMapper.saveDirectory(directory);
    }
}
