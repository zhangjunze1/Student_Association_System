package cn.edu.shu.xj.ser.controller.Ass;

import cn.edu.shu.xj.ser.entity.Activity;
import cn.edu.shu.xj.ser.entity.Ass;
import cn.edu.shu.xj.ser.entity.LeaderAss;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.*;
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

    @Autowired
    MemberAssService memberAssService;

    @Autowired
    AssActivityService assActivityService;

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

    @ApiOperation(value = "获取社团列表分页条件查询")
    @GetMapping("/findAssListQueryPage")
    public Result findAssListQueryPage(@RequestParam(required = true,defaultValue = "1")Integer current,
                                        @RequestParam(required = true,defaultValue = "10")Integer size,
                                       @RequestParam(required = true)String assName,
                                       @RequestParam(required = true)String assState){
        Integer Myvalue = (current-1)*size;
        Integer Total = assService.countQuery(assName,assState);
        List<Ass> asses = assService.getAssListQueryPage(Myvalue,size,assName,assState);
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

    @ApiOperation(value = "管理员注册新的社团")
    @PostMapping("/applyNewAssByAdmin")
    public Result applyNewAssByAdmin(@RequestParam(required = true)String name,
                              @RequestParam(required = true)String position,
                              @RequestParam(required = true)Integer funds,
                              @RequestParam(required = true)String teacher,
                              @RequestParam(required = true)String userNum){
        // 获取一样名字的社团
        Ass ass = assService.findSameNameAss(name);
        User user = userService.findUserByNumber(userNum);
        // 不存在该学号的用户
        if (user==null){
            throw new BusinessException(ResultCode.NO_USER_NUMBER.getCode(), // 3025
                    ResultCode.NO_USER_NUMBER.getMessage());
        }

        // 已不是社员
        if (user.getUserAuthority()!=0){
            throw new BusinessException(ResultCode.USER_IS_LEADER.getCode(), // 3024
                    ResultCode.USER_IS_LEADER.getMessage());
        }

        // 该名字的社团名字重复
        if (ass!=null){
            throw new BusinessException(ResultCode.ASS_NAME_REPEAT.getCode(), // 3022
                    ResultCode.ASS_NAME_REPEAT.getMessage());
        }

        assService.applynewAss(name,position,funds,teacher,user.getUserTrueName());
        Long userId = user.getUserId();

        Ass assnow =assService.findSameNameAss(name);
        Long assId = assnow.getAssId();
        // 通过申请
        // 增加联结表 信息
        leaderAssService.addLeaderAss(assId,userId);
        // 改变社团状态
        assService.agreeStateChange(assId);
        // 改变user状态变成社长
        userService.agreeAutorityChange(userId);
        return Result.ok();
    }

    @ApiOperation(value = "获取社长的社团信息")
    @GetMapping("/findLeaderAss")
    public Result findLeaderAss(@RequestParam(required = true)Long userId){
        Ass ass = assService.getAssByLeaderId(userId);

        return Result.ok().data("ass",ass);
    }

    @ApiOperation(value = "获取正在审核中的活动及其数量")
    @GetMapping("/findActivityAndApplyCount")
    public Result findActivityAndApplyCount(){
        List<Ass> applyActivities = assService.findActivityAndApplyCount();
        return Result.ok().data("applyActivities",applyActivities);
    }

    @ApiOperation(value = "同意某人的社团申请")
    @PostMapping("/agreeAssApply")
    public Result agreeAssApply(@RequestParam(required = true)Long assId,
                                @RequestParam(required = true)String LeaderName){
        User leader = userService.findUserByTrueName(LeaderName);
        Long userId = Long.valueOf(0);
        if (leader!=null){
            userId = leader.getUserId();
        }

        // 增加联结表 信息
        leaderAssService.addLeaderAss(assId,userId);
        // 改变社团状态
        assService.agreeStateChange(assId);
        // 改变user状态变成社长
        userService.agreeAutorityChange(userId);

        return Result.ok();
    }

    @ApiOperation(value = "不同意某人的社团申请")
    @PostMapping("/notAgreeAssApply")
    public Result notAgreeAssApply(@RequestParam(required = true)Long assId,
                                @RequestParam(required = true)String LeaderName){

        assService.notAgreeDeleteAss(assId);
        return Result.ok();
    }

    @ApiOperation(value = "更换社长")
    @PostMapping("/ChangeLeaderByNumber")
    public Result ChangeLeaderByNumber(@RequestParam(required = true)Long assId,
                                   @RequestParam(required = true)String newNumber){
        // 获取联结表信息
        LeaderAss leaderAss = leaderAssService.getLeaderAss(assId);
        // 原来社长的id
        Long olduserId = leaderAss.getUserId();
        // 新社长的信息
        User newuser = userService.findUserByNumber(newNumber);
        if (newuser==null){
            throw new BusinessException(ResultCode.NO_USER_NUMBER.getCode(), // 3025
                    ResultCode.NO_USER_NUMBER.getMessage());
        }

        // 已不是社员
        if (newuser.getUserAuthority()!=0){
            throw new BusinessException(ResultCode.USER_IS_LEADER.getCode(), // 3024
                    ResultCode.USER_IS_LEADER.getMessage());
        }

        // 旧社长的信息
        User olduser = userService.findUserById(olduserId);

        // 修改社团ass_leader
        String userTrueName = newuser.getUserTrueName();
        assService.changeAssLeader(assId,userTrueName);

        // 修改Leader的权限
        userService.changeAuthority(olduserId,0,"社员");
        userService.changeAuthority(newuser.getUserId(),1,"社长");

        // 联结表信息更改
        leaderAssService.changeUserId(olduserId,newuser.getUserId());

        return Result.ok();
    }

    @ApiOperation(value = "删除社团")
    @PostMapping("/deleteThisAss")
    public Result deleteThisAss(@RequestParam(required = true)Long assId){

        // 删除社团前 社长撤职
        Ass ass = assService.getById(assId);
        String leaderName = ass.getAssLeader();
        User user = userService.findUserByTrueName(leaderName);
        userService.changeAuthority(user.getUserId(),0,"社员");


        leaderAssService.deleteAssByAssId(assId);

        memberAssService.deleteAssByAssId(assId);

        assActivityService.deleteAssByAssId(assId);

        assService.deleteAss(assId);


        return Result.ok();
    }

    @ApiOperation(value = "更改公告")
    @PostMapping("/editAssNotice")
    public Result editAssNotice(@RequestParam(required = true)Long assId,
                                @RequestParam(required = true)String notice){
        assService.editNotice(assId,notice);
        return Result.ok();
    }




}
