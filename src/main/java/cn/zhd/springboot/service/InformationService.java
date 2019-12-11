package cn.zhd.springboot.service;

import cn.zhd.springboot.entity.Information;

public interface InformationService {

    Information getInformationByUserAccount(String userAccount);

    void updateInformation(Information information);

    void insertInformationByUserAccount(String userAccount);
}
