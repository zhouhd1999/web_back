package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Enzo Cotter on 2019/12/9.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertising {
    Integer adId;        //广告ID
    String adContent;   //广告内容
    String adUrl;
}
