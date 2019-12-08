package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    Integer aId;        //文章ID
    Integer uid;        //文章发布人ID
    Integer tId;        //文章标签ID
    Integer aState;    //文章状态值
    String aContent;    //文章内容
    String aDateTime;    //文章发布时间
    Integer aLick;      //文章赞数
    Integer aHate;      //文章踩数
    Integer aHits;      //文章点击数
    String aDescribe;   //文章描述
    String aName;       //文章名
}
