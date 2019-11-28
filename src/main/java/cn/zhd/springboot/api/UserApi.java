package cn.zhd.springboot.api;

import cn.zhd.springboot.entity.User;
import cn.zhd.springboot.enums.ResultEnum;
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

    @Autowired
    public UserApi(UserService userService) {
        this.userService=userService;
    }

    @RequestMapping("/get_all")
    public List<User> getAll(){
        return userService.getAll();
    }


    @RequestMapping("/Login")
    public Msg<Object> Login(String name,String pass){
        User user = userService.getUserByUserId(name);
        if (pass.equals(user.getPassword())){
            return ResultUtil.success(user);
        }else {
            return ResultUtil.error(ResultEnum.PASS_ERROR);
        }
    }


    @RequestMapping("/insertUser")
    public Msg<Object> insertUser(User user){
        //先判断账号是否存在
        if(userService.getUserByUserId(user.getUserId())==null){
            userService.insertUser(user);
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.ACCOUNT_EXIST);
        }
    }
}
