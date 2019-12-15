package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.Directory;
import cn.zhd.springboot.service.CloudService;
import cn.zhd.springboot.service.DirectoryService;
import cn.zhd.springboot.service.DiscussionService;
import cn.zhd.springboot.util.FileSaveUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudServiceImpI implements CloudService {
    private final DirectoryService directoryService;
    @Autowired
    public CloudServiceImpI(DirectoryService discussionService)
    {
        this.directoryService = (DirectoryService) discussionService;
    }
    @Override
    public Boolean getUpload(MultipartFile file, Directory directory)
    {
//        if (!directoryService.saveDirectory(directory))
//        {
//            return false;
//        }

        String path = "E:/fileUpload/";
        if(!FileSaveUtil.filesave(file,path))
        {
            return false;
        }
        return true;
    }

}
