package cn.edu.shu.xj.ser.controller.user;

import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "注册用户")
    @PostMapping("/userRegister")
    public Result userRegister(@RequestParam("name")String name,
                               @RequestParam("true_name")String true_name,
                               @RequestParam("pwd")String pwd,
                               @RequestParam("repwd")String repwd,
                               @RequestParam("phone")String phone,
                               @RequestParam("number")String number,
                               @RequestParam("gender")String gender
    ){
        User user = new User();
        user = userService.findUserByName(name);
        if (!pwd.equals(repwd)){
            throw new BusinessException(ResultCode.USER_PWD_DIFFERENT.getCode(),
                    ResultCode.USER_PWD_DIFFERENT.getMessage());
        }
        if (gender==null){
            throw new BusinessException(ResultCode.USER_GENDER_NULL.getCode(),
                    ResultCode.USER_GENDER_NULL.getMessage());
        }
        if (user != null){
            throw new BusinessException(ResultCode.USER_REGISTER_REPEAT.getCode(),
                    ResultCode.USER_REGISTER_REPEAT.getMessage());
        }
        String position = "成员";
        userService.userRegister(name,true_name,pwd,0,0,number,gender,position,phone);
        User nowUser = new User();
        nowUser = userService.findUserByName(name);
        if (nowUser==null){
            throw new BusinessException(ResultCode.ERROR_USER_REGISTER.getCode(),
                    ResultCode.ERROR_USER_REGISTER.getMessage());
        }else
            return Result.ok().data("user",user);
    }

}
