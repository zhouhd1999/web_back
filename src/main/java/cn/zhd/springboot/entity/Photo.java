package cn.zhd.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    Integer photoId;

    Integer photoTagId;

    String photoUrl;

    String photoCategory;
}
