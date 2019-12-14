package cn.zhd.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    SYSTEM_ERROR(-1,"system error"),

    ACCOUNT_EXIST(2,"account exist"),

    PASS_ERROR(1,"password error"),

    Cloud_GET_ERROR(100,"Cloud get error"),

    Cloud_SAVE_ERROR(101,"Cloud save error"),

    ATTITUDE_INSERT_ERROR(201,"attitude insert error"),

    ATTITUDE_UPDATE_ERROR(202,"attitude update error"),
//
    ATTITUDE_DELETE_ERROR(203,"attitude delete error"),

    ATTITUDE_DATABASE_ERROR(203,"DATABASE  error"),

    SUCCESS(0,"success"),

    ;

    private Integer code;

    private String message;


}
