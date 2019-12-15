package cn.zhd.springboot.mapper;

import cn.zhd.springboot.entity.Resource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface ResourceMapper {

    @Insert("INSERT INTO resource VALUES(#{resourceId},#{resourceName},#{resourceUrl},#{resourceIntroduction})")
    public boolean insertResource(Resource resource);

}
