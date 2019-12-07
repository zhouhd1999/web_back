package cn.zhd.springboot.service.Impl;

import cn.zhd.springboot.entity.Information;
import cn.zhd.springboot.mapper.InformationMapper;
import cn.zhd.springboot.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {

    private final InformationMapper informationMapper;

    @Autowired
    public InformationServiceImpl(InformationMapper informationMapper) {
        this.informationMapper = informationMapper;
    }

    @Override
    public Information getInformationByUid(Integer uid) {
        return informationMapper.getInformationByUid(uid);
    }

    @Override
    public void updateInformation(Information information) {
        informationMapper.updateInformation(information);
    }

    @Override
    public void insertInformationByUid(Integer uid) {
        informationMapper.insertInformationByUid(uid);
    }
}
