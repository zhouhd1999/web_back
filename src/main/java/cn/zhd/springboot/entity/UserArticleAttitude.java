package cn.zhd.springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserArticleAttitude {
    Integer userId;
    Integer articleId;
    Integer userAttitude;

}
