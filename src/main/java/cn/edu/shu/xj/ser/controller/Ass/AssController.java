package cn.edu.shu.xj.ser.controller.Ass;

import cn.edu.shu.xj.ser.entity.Ass;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.ActivityService;
import cn.edu.shu.xj.ser.service.impl.AssService;
import cn.edu.shu.xj.ser.service.impl.LeaderAssService;
import cn.edu.shu.xj.ser.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "社团接口")
@RestController
@RequestMapping("/ass")
public class AssController {

    @Autowired
    AssService assService;

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @Autowired
    LeaderAssService leaderAssService;

    @ApiOperation(value = "获取系统数据（系统成员+社团数量+活动数量）")
    @GetMapping("/findsystemData")
    public Result findsystemData(){
        Integer activityNum = activityService.count();
        Integer assNum = assService.count();
        Integer memberNum = userService.count();
        return Result.ok().data("memberNum",memberNum).data("assNum",assNum).data("activityNum",activityNum);
    }

    @ApiOperation(value = "获取社团列表")
    @GetMapping("/findAssList")
    public Result findAssList(){
        List<Ass> asses = assService.getAssList();
        return Result.ok().data("Ass",asses);
    }

    @ApiOperation(value = "获取社团列表分页查询")
    @GetMapping("/findAssListPage")
    public Result findAssListPage(@RequestParam(required = true,defaultValue = "1")Integer current,
                                  @RequestParam(required = true,defaultValue = "10")Integer size){
        Integer Myvalue = (current-1)*size;
        Integer Total = assService.count();
        List<Ass> asses = assService.getAssListPage(Myvalue,size);
        return Result.ok().data("Ass",asses).data("total",Total);
    }

    @ApiOperation(value = "获取我的社团列表分页查询")
    @GetMapping("/findMyAssListPage")
    public Result findMyAssListPage(@RequestParam(required = true,defaultValue = "1")Integer current,
                                  @RequestParam(required = true,defaultValue = "10")Integer size,
                                  @RequestParam(required = true)Long userId){
        Integer Myvalue = (current-1)*size;
        Integer Total = assService.countByMyId(userId);
        if( Total == 0){
            throw new BusinessException(ResultCode.MY_ASS_IS_EMPTY.getCode(),
                    ResultCode.MY_ASS_IS_EMPTY.getMessage());
        }
        List<Ass> asses = assService.getMyAssListPage(Myvalue,size,userId);
        Integer i = 0;
        if (i!=Total){
            User user = userService.getLeaderByAssId(asses.get(i).getAssId());
            asses.get(i).setUserTrueName(user.getUserTrueName());
        }
        return Result.ok().data("total",Total).data("myAssList",asses);
    }


    @ApiOperation(value = "申请新的社团")
    @PostMapping("/applyNewAss")
    public Result applyNewAss(@RequestParam(required = true)String name,
                              @RequestParam(required = true)String position,
                              @RequestParam(required = true)Integer funds,
                              @RequestParam(required = true)String teacher,
                              @RequestParam(required = true)Long userId){
        // 获取一样名字的社团
        Ass ass = assService.findSameNameAss(name);
        User user = userService.findUserById(userId);
        // 连续两次申请社团
        Ass ass1 = assService.findSameLeaderAss(user.getUserTrueName());

        if (ass!=null){
            throw new BusinessException(ResultCode.ASS_NAME_REPEAT.getCode(),
                    ResultCode.ASS_NAME_REPEAT.getMessage());
        }
        if (ass1!=null){
            throw new BusinessException(ResultCode.MEMBER_ALREADY_APPLY_ASS.getCode(),
                    ResultCode.MEMBER_ALREADY_APPLY_ASS.getMessage());
        }
        assService.applynewAss(name,position,funds,teacher,user.getUserTrueName());
        return Result.ok();
    }


}
