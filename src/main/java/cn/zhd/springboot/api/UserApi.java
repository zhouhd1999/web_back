package cn.zhd.springboot.api;

import cn.zhd.springboot.entity.User;
import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.service.InformationService;
import cn.zhd.springboot.service.UserService;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserApi {

    private final UserService userService;

    private final InformationService informationService;

    @Autowired
    public UserApi(UserService userService, InformationService informationService) {
        this.userService=userService;
        this.informationService = informationService;
    }

    @RequestMapping("/get_all")
    public List<User> getAll(){
        return userService.getAll();
    }


    @RequestMapping("/login")
    public Msg<Object> login(String UserId,String password){
        User user = userService.loginByUserId(UserId,password);
        if (user!=null){
            return ResultUtil.success(user);
        }else{
            return ResultUtil.error(ResultEnum.PASS_ERROR);
        }
    }

//    @RequestMapping("/getUserMessage")
//    public Msg<Object> getUserMessage(String userId){
//        User user = userService.getUserByUserId(userId);
//        if(userService.getUserByUserId(user.getUserId())!=null){
//            return ResultUtil.success(user);
//        }else{
//            return ResultUtil.error(ResultEnum.ACCOUNT_EXIST);
//        }
//    }

    @RequestMapping("/insert_user")
    public Msg<Object> insertUser(User user){
        if (userService.insertUser(user)){
            Integer uid=userService.getUserByUserId(user.getUserId().toString()).getUserId();
            informationService.insertInformationByUid(uid);
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.ACCOUNT_EXIST);
        }
    }

    @RequestMapping("/update_user")
    public Msg<Object> updateUser(User user){
        userService.updateUser(user);
        return ResultUtil.success();
    }
}
