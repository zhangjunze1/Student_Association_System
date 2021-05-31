package cn.edu.shu.xj.ser.controller.Activity;

import cn.edu.shu.xj.ser.entity.Activity;
import cn.edu.shu.xj.ser.entity.Ass;
import cn.edu.shu.xj.ser.entity.LeaderActivity;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.mapper.ActivityMapper;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.ActivityService;
import cn.edu.shu.xj.ser.service.impl.AssActivityService;
import cn.edu.shu.xj.ser.service.impl.LeaderActivityService;
import cn.edu.shu.xj.ser.service.impl.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Api(tags = "活动接口")
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @Autowired
    AssActivityService assActivityService;

    @Autowired
    UserService userService;

    @Autowired
    LeaderActivityService leaderActivityService;

    @ApiOperation(value = "根据社团查询对应活动")
    @GetMapping("/findAssActivityPage")
    public Result findAssActivityPage(@RequestParam(required = true,defaultValue = "1")Integer current,
                                      @RequestParam(required = true,defaultValue = "10")Integer size,
                                      @RequestParam(required = true)Long assId){
        //对用户进行分页，泛型中注入的就是用户实体类
        Integer Myvalue = (current-1)*size;
        Integer Total = activityService.countActivityById(assId);
//        if( Total == 0){
//            throw new BusinessException(ResultCode.ASS_ACTIVITY_IS_EMPTY.getCode(),
//                    ResultCode.ASS_ACTIVITY_IS_EMPTY.getMessage());
//        }
        List<Activity> activities = activityService.getActivityByAssId(Myvalue,size,assId);
        return Result.ok().data("total",Total).data("activities",activities);
    }

    @ApiOperation(value = "根据我的Id查询我的活动记录")
    @GetMapping("/findMyActivityPage")
    public Result findMyActivityPage(@RequestParam(required = true,defaultValue = "1")Integer current,
                                      @RequestParam(required = true,defaultValue = "10")Integer size,
                                      @RequestParam(required = true)Long userId){
        //对用户进行分页，泛型中注入的就是用户实体类
        Integer Myvalue = (current-1)*size;
        Integer Total = activityService.countActivityByUserId(userId);
//        if( Total == 0){
//            throw new BusinessException(ResultCode.ASS_ACTIVITY_IS_EMPTY.getCode(),
//                    ResultCode.ASS_ACTIVITY_IS_EMPTY.getMessage());
//        }
        List<Activity> activities = activityService.getActivityByUserId(Myvalue,size,userId);
        return Result.ok().data("total",Total).data("activities",activities);
    }


    @ApiOperation(value = "新增活动申请")
    @PostMapping("/addNewActivity")
    public Result addNewActivity(@RequestParam(required = true)String activitySub,
                                 @RequestParam(required = true)String activityContent,
                                 @RequestParam(required = true)String activityScore,
                                 @RequestParam(required = true) @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")String activityFinishTime1,
                                 @RequestParam(required = true) @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")String activityFinishTime2,
                                 @RequestParam(required = true) @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")String activityStartTime1,
                                 @RequestParam(required = true) @JsonFormat(pattern = "HH:mm:ss",timezone="GMT+8")String activityStartTime2,
                                 @RequestParam(required = true)String imageUrl,
                                 @RequestParam(required = true)Long userId,
                                 @RequestParam(required = true)Long assId,
                                 @RequestParam(required = true)String userTrueName){
        String activityFinishTime = activityFinishTime1+" "+activityFinishTime2;
        String activityStartTime = activityStartTime1+" "+ activityStartTime2;

        System.out.println(activityFinishTime1);
        System.out.println(activityStartTime1);
        System.out.println(activityFinishTime2);
        System.out.println(activityStartTime2);
        activityService.addNew(activitySub,activityContent,activityScore,activityStartTime,activityFinishTime,imageUrl,userTrueName);
        Long activityId = activityService.activityMaxId();
        assActivityService.addNewAssActivity(assId,activityId);
        leaderActivityService.addNewLeaderActivity(userId,activityId);
        return Result.ok();
    }

    @ApiOperation(value = "管理员界面中获取条件分页查询活动")
    @GetMapping("/findApplyActivity")
    public Result findApplyActivity(@RequestParam(required = true,defaultValue = "1")Integer current,
                                    @RequestParam(required = true,defaultValue = "10")Integer size,
                                    @RequestParam(required = true)String assName,
                                    @RequestParam(required = true)String activityState){

        Integer Myvalue = (current-1)*size;
        Integer Total = activityService.findApplyActivityCount(assName,activityState);
        List<Activity> activities = activityService.findApplyActivity(Myvalue,size,assName,activityState);
        return Result.ok().data("total",Total).data("activities",activities);
    }

    @ApiOperation(value = "审批同意活动")
    @PostMapping("/agreeActivity")
    public Result agreeActivity(@RequestParam(required = true)Long activityId){

        activityService.passActivity(activityId);
        assActivityService.passActivity(activityId);
        return Result.ok();
    }

    @ApiOperation(value = "审批拒绝活动//或删除活动")
    @PostMapping("/notAgreeActivity")
    public Result notAgreeActivity(@RequestParam(required = true)Long activityId){

        activityService.notpassActivity(activityId);
        assActivityService.notpassActivity(activityId);
        return Result.ok();
    }

    @ApiOperation(value = "活动报名截至")
    @PostMapping("/endActivityApply")
    public Result endActivityApply(@RequestParam(required = true)Long activityId){
        // 转变状态至“报名结束”
        activityService.endActivityApply(activityId);
        return Result.ok();
    }

    @ApiOperation(value = "添加活动后期结语与图片")
    @PostMapping("/addEndActivity")
    public Result addEndActivity(@RequestParam(required = true)Long activityId,
                                 @RequestParam(required = true)String activityEndContent,
                                 @RequestParam(required = true)String imageUrl){
        // 添加后期活动结语与图片
        activityService.addEndContent(activityId,activityEndContent,imageUrl);
        // 转变状态 至“活动结束”
        activityService.endActivity(activityId);
        // 对所有社员和社长 积分
        Activity activity = activityService.getActivityByActivityId(activityId);
        Integer score = activity.getActivityScore();
        // 社员加分
        List<User> userList = userService.getUserByActivityId(activityId);
        for (int i=0;i<=userList.size()-1;i++){
            userService.addScore(userList.get(i).getUserId(),score);
        }
        // 社长加分
        LeaderActivity leaderActivity = leaderActivityService.getleaderActivityByActivityId(activityId);
        Long leaderId = leaderActivity.getUserId();
        userService.addScore(leaderId,score);

        return Result.ok();
    }


}
