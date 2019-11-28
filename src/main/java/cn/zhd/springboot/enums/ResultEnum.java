package cn.zhd.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    SYSTEM_ERROR(-1,"system error"),

    ACCOUNT_EXIST(2,"account exist"),

    PASS_ERROR(1,"password error"),

    SUCCESS(0,"success"),

    ;

    private Integer code;

    private String message;


}
