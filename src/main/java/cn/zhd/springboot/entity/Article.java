package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    Integer aid;        //文章ID
    Integer uid;        //文章发布人ID
    Integer tid;        //文章标签ID
    Integer deId;       //文章评论区id
    String aContent;    //文章内容
    String dateTime;    //文章发布时间
    Integer aLick;      //文章赞数
    Integer aLate;      //文章踩数
    Integer aHits;      //文章点击数
    String aName;       //文章名
}
