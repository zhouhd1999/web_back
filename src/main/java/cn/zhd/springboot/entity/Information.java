package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    Integer userId;

    Integer infoAge;

    String infoPhoneNumber;

    String infoProfession;

    String infoIntroduction;

    String infoHeadUrl;
}