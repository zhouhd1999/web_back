package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.Information;
import cn.zhd.springboot.mapper.InformationMapper;
import cn.zhd.springboot.service.InformationService;
import cn.zhd.springboot.util.FileSaveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class InformationServiceImpl implements InformationService {

    private final InformationMapper informationMapper;

    @Autowired
    public InformationServiceImpl(InformationMapper informationMapper) {
        this.informationMapper = informationMapper;
    }

    @Override
    public Information getInformationByUserId(Integer userId) {
        return informationMapper.getInformationByUserId(userId);
    }

    @Override
    public boolean updateHead(Integer userId, MultipartFile file) {
        String url = "D:/Web/second/src/assets/image";
        FileSaveUtil.filesave(file,url);
        String url1 = "'"+ url + file.getOriginalFilename() + "'";
        System.out.println(url1);
        return informationMapper.updateHead(userId,url1);
    }

    @Override
    public void updateInformation(Information information) {
        informationMapper.updateInformation(information);
    }

    @Override
    public void insertInformationByUserId(Integer userId) {
        informationMapper.insertInformationByUserId(userId);
    }
}
