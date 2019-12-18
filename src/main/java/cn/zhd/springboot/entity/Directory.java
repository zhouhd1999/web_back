package cn.zhd.springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class
Directory {
    Integer  directoryId;       //目录ID 其实就是user_id
    String directoryContent;    //目录结构内容
    Integer countId;
}
