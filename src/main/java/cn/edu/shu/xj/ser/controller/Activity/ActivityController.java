package cn.edu.shu.xj.ser.controller.Activity;

import cn.edu.shu.xj.ser.entity.Activity;
import cn.edu.shu.xj.ser.entity.Ass;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.mapper.ActivityMapper;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.ActivityService;
import cn.edu.shu.xj.ser.service.impl.AssActivityService;
import cn.edu.shu.xj.ser.service.impl.LeaderActivityService;
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


}
