package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {

    Integer uid;

    Integer inAge;

    String inPhoneNumber;

    String inProfession;

    String inIntroduction;
}
