package cn.zhd.springboot.util;

import cn.zhd.springboot.enums.ResultEnum;

public class ResultUtil {
    public static Msg<Object> success(Object object){
        Msg<Object> msg = new Msg<>();
        msg.setCode(ResultEnum.SUCCESS.getCode());
        msg.setMessage(ResultEnum.SUCCESS.getMessage());
        msg.setData(object);
        return msg;
    }

    public static Msg<Object> success(){return success(null);}

    public static Msg<Object> error(ResultEnum resultEnum){
        Msg<Object> msg = new Msg<>();
        msg.setCode(resultEnum.getCode());
        msg.setMessage(resultEnum.getMessage());
        return msg;
    }
}
