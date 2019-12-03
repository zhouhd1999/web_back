package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    Integer commentId;
    Integer commentAreaId;
    String reviewerName;
    String content;
    String dateTime;
}
