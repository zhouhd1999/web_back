package cn.zhd.springboot.util;

import lombok.Data;

@Data
public class Msg<T> {

    /*错误码*/
    private Integer code;

    /*提示信息 */
    private String message;

    /*具体内容*/
    private  T data;
}
