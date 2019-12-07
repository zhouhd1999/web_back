package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Information;

public interface InformationService {

    Information getInformationByUid(Integer uid);

    void updateInformation(Information information);

    void insertInformationByUid(Integer uid);
}
