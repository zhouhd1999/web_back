package cn.zhd.springboot.api;


import cn.zhd.springboot.entity.Information;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.Impl.InformationServiceImpl;
import cn.zhd.springboot.service.InformationService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/information")
@RestController
public class InformationApi {

    private final InformationService informationService;

    @Autowired
    public InformationApi(InformationService informationService) {
        this.informationService = informationService;
    }

    @RequestMapping("/get_information_by_user_id")
    public Msg<Object> getInformationByUserId(Integer userId){
        Information information = informationService.getInformationByUserId(userId);
        if(information!=null){
            return ResultUtil.success(information);
        }else{
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }


    @RequestMapping("/update_head")
    public Msg<Object> updateHead(MultipartFile file, Integer userId)
    {
        if(informationService.updateHead(userId,file))
        {
            return ResultUtil.success();
        }
        else{
            return ResultUtil.error(ResultEnum.ALL_ERROR);
        }
    }
    @RequestMapping("/update_information")
    public Msg<Object> updateInformation(Information information){
        informationService.updateInformation(information);
        return ResultUtil.success();
    }
}
