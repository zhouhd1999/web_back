package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    Integer resourceId;
    String resourceName;
    String resourceUrl;
    String resourceIntroduction;
}
