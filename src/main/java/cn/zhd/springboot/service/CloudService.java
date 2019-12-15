package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Directory;
import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
    Boolean getUpload(MultipartFile file, Directory directory);

}
