package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    Integer articleId;        //文章ID
    Integer userId;        //文章发布人ID
    Integer tagId;        //文章标签ID
    Integer articleState;    //文章状态值
    String articleContent;    //文章内容
    String articleDateTime;    //文章发布时间
    Integer articleLike;      //文章赞数
    Integer articleHate;      //文章踩数
    Integer articleClickNum;      //文章点击数
    String articleDescribe;   //文章描述
    String articleName;       //文章名
}
