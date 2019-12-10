package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discussion {
    Integer uid;
    String diDateTime;
    String diContent;
    Integer diId;
    Integer aId;
}
