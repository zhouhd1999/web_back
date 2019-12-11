package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discussion {
    Integer userId;
    String discussionDateTime;
    String discussionContent;
    Integer discussionId;
    Integer articleId;
}
