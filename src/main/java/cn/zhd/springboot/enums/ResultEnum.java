package cn.zhd.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    ALL_ERROR(-10,"emmmm"),

    SYSTEM_ERROR(-1,"system error"),

    ACCOUNT_EXIST(2,"account exist"),

    PASS_ERROR(1,"password error"),

    CLOUD_GET_ERROR(100,"Cloud get error"),

    CLOUD_SAVE_ERROR(101,"Cloud save error"),

    CLOUD_UPLOAD_ERROR(102,"Cloud update error"),



    ATTITUDE_INSERT_ERROR(201,"attitude insert error"),

    ATTITUDE_UPDATE_ERROR(202,"attitude update error"),
//
    ATTITUDE_DELETE_ERROR(203,"attitude delete error"),

    ATTITUDE_DATABASE_ERROR(203,"database  error"),

    USER_UPDATE_PERMISSION_ERROR(301,"user update permission error"),



    ARTICLE_UPDATE_STATIC_ERROR(401,"article update static error"),

    TAG_INSET_ERROR(501,"tag insert error"),

    TAG_UPDATE_ERROR(502,"tag update error"),

    TAG_DELETE_ERROR(503,"tag delete error"),


    ARTICLE_UPDATE_ERROR(601,"article update error"),
    ARTICLE_INSERT_ERROR(602,"article insert error"),
    ARTICLE_DELETE_ERROR(603,"article delete error"),


    SUCCESS(0,"success"),

    ;

    private Integer code;

    private String message;


}
