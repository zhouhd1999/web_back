package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;

@Data //生成getter,setter等函数
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor //生成无参构造函数

public class User {

    Integer userId;

    String userAccount;

    String userPassword;

    String userNickname;

    Integer userPermission;
}
