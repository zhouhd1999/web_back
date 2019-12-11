package cn.zhd.springboot.api;


import cn.zhd.springboot.entity.Information;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.Impl.InformationServiceImpl;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/information")
@RestController
public class InformationApi {

    private final InformationServiceImpl informationServiceImpl;

    @Autowired
    public InformationApi(InformationServiceImpl informationServiceImpl) {
        this.informationServiceImpl = informationServiceImpl;
    }

    @RequestMapping("/get_information_by_user_id")
    public Msg<Object> getInformationByUserId(Integer userId){
        Information information = informationServiceImpl.getInformationByUserId(userId);
        if(information!=null){
            return ResultUtil.success(information);
        }else{
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/update_information")
    public Msg<Object> updateInformation(Information information){
        informationServiceImpl.updateInformation(information);
        return ResultUtil.success();
    }
}
