package cn.edu.shu.xj.ser.controller.user;

import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.TokenService;
import cn.edu.shu.xj.ser.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @ApiOperation(value = "注册用户")
    @PostMapping("/userRegister")
    public Result userRegister(@RequestParam("name")String userName,
                               @RequestParam("true_name")String userTrueName,
                               @RequestParam("pwd")String userPwd,
                               @RequestParam("repwd")String userRepwd,
                               @RequestParam("phone")String userPhone,
                               @RequestParam("number")String userNumber,
                               @RequestParam("gender")String userGender
    ){
        User user = new User();
        user = userService.findUserByNumber(userNumber);
        if (!userPwd.equals(userRepwd)){
            throw new BusinessException(ResultCode.USER_PWD_DIFFERENT.getCode(),
                    ResultCode.USER_PWD_DIFFERENT.getMessage());
        }
        if (userGender==""){
            throw new BusinessException(ResultCode.USER_GENDER_NULL.getCode(),
                    ResultCode.USER_GENDER_NULL.getMessage());
        }
        if (user != null){
            throw new BusinessException(ResultCode.USER_REGISTER_REPEAT.getCode(),
                    ResultCode.USER_REGISTER_REPEAT.getMessage());
        }
        String user_position = "社员";
        userService.userRegister(userName,userTrueName,userPwd,0,0,userNumber,userGender,user_position,userPhone);
        User nowUser = null;
        nowUser = userService.findUserByNumber(userNumber);
        System.out.println(nowUser);
        if (nowUser==null){
            throw new BusinessException(ResultCode.ERROR_USER_REGISTER.getCode(),
                    ResultCode.ERROR_USER_REGISTER.getMessage());
        }else
            return Result.ok().data("user",nowUser);
    }


    @ApiOperation(value = "登录用户")
    @PostMapping("/userLogin")
    public Result userLogin(@RequestParam("number") String userNumber,
                            @RequestParam("password") String userPwd){
        User user = userService.findUserByNumber(userNumber);
        if (user==null){
            throw new BusinessException(ResultCode.NO_USER.getCode(),
                    ResultCode.NO_USER.getMessage());
        }
        String password = user.getUserPwd();
        if(!password.equals(userPwd)){
            throw new BusinessException(ResultCode.ERROR_PWD.getCode(),
                    ResultCode.ERROR_PWD.getMessage());
        }
        if(password.equals(userPwd)){
            String token = tokenService.getToken(user);
            return Result.ok().data("user",user).data("token",token);
        }else {
            return Result.error();
        }
    }


    @ApiOperation(value = "查找对应权限的人数")
    @GetMapping("/findAuthorityAndCount")
    public Result findAuthorityAndCount(){
        List<User> AuthorityAndCount = userService.findAuthorityAndCount();
        if (AuthorityAndCount.size()==0){
            throw new BusinessException(ResultCode.NO_USER_AUTHORITY.getCode(),
                    ResultCode.NO_USER_AUTHORITY.getMessage());
        }
        return Result.ok().data("AuthorityAndCount",AuthorityAndCount);
    }


    @ApiOperation(value = "条件查询用户列表")
    @GetMapping("/findqueryUserList")
    public Result findqueryUserList(@RequestParam(required = true,defaultValue = "1")Integer current,
                                    @RequestParam(required = true,defaultValue = "10")Integer size,
                                    @RequestParam(required = true)String userTrueName,
                                    @RequestParam(required = true)String assName,
                                    @RequestParam(required = true)String position){
        //对用户进行分页，泛型中注入的就是用户实体类
        Integer Myvalue;
        Integer Total;
        List<User> userList=null;
        if (!assName.equals("")){
            Total = userService.findUserListTotal(userTrueName,assName,position);
            Myvalue= (current-1)*size;
            userList = userService.queryUserList(userTrueName,assName,position,Myvalue,size);
        }else {
            Total = userService.findUserListTotalWithNoAss(userTrueName,position);
            Myvalue = (current-1)*size;
            userList = userService.queryUserListWithNoAss(userTrueName,position,Myvalue,size);
        }
        return Result.ok().data("total",Total).data("userList",userList);
    }

    @ApiOperation(value = "修改个人信息")
    @PostMapping("/editUserMessage")
    public Result editUserMessage(@RequestParam(required = true)Long userId,
                                  @RequestParam(required = true)String pwd,
                                  @RequestParam(required = true)String name,
                                  @RequestParam(required = true)String gender,
                                  @RequestParam(required = true)String phone,
                                  @RequestParam(required = true)String signature){
        userService.editUserMessage(userId,pwd,name,gender,phone,signature);
        User user = userService.findUserById(userId);
        return Result.ok().data("user",user);
    }

    @ApiOperation(value = "获取社长所在社团的所有成员的信息")
    @GetMapping("/findAssMember")
    public Result findAssMember(@RequestParam(required = true,defaultValue = "1")Integer current,
                                @RequestParam(required = true,defaultValue = "10")Integer size,
                                @RequestParam(required = true)Long assId,
                                @RequestParam(required = true)String trueName,
                                @RequestParam(required = true)String number,
                                @RequestParam(required = true)String memberAssState){
        Integer Myvalue =  (current-1)*size;
        Integer Total = userService.getTotalMemberByAssId(assId,trueName,number,memberAssState);
        List<User> userList = userService.getAllMemberByAssId(Myvalue,size,assId,trueName,number,memberAssState);
        return Result.ok().data("userList",userList).data("total",Total);
    }

}
