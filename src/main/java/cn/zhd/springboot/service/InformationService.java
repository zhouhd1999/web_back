package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Information;
import org.springframework.web.multipart.MultipartFile;

public interface InformationService {

    Information getInformationByUserId(Integer userId);

    public boolean updateHead(Integer userId, MultipartFile file);

    void updateInformation(Information information);

    void insertInformationByUserId(Integer userId);
}
