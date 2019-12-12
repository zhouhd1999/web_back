package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Information;

public interface InformationService {

    Information getInformationByUserId(Integer userId);

    void updateInformation(Information information);

    void insertInformationByUserId(Integer userId);
}
