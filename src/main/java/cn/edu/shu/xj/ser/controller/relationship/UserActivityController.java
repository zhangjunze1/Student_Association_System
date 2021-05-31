package cn.edu.shu.xj.ser.controller.relationship;

import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.entity.UserActivity;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.UserActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户活动关系接口")
@RestController
@RequestMapping("/userActivity")
public class UserActivityController {

    @Autowired
    UserActivityService userActivityService;

    @ApiOperation(value = "申请已有社团的某个报名中的活动")
    @PostMapping("/applyForActivity")
    public Result applyForActivity(@RequestParam(required = true)Long activityId,
                                   @RequestParam(required = true)Long userId){
        UserActivity userActivity = userActivityService.findUserActivity(activityId,userId);
        if (userActivity!=null){
            if (userActivity.getUserActivityState().equals("申请中")){
                throw new BusinessException(ResultCode.USER_ALREADY_APPLY_ACTIVITY.getCode(), // 3028
                        ResultCode.USER_ALREADY_APPLY_ACTIVITY.getMessage());
            } else {
                throw new BusinessException(ResultCode.USER_ALREADY_HAVE_ACTIVITY.getCode(), // 3029
                        ResultCode.USER_ALREADY_HAVE_ACTIVITY.getMessage());
            }
        }
        userActivityService.addNewUserActivity(activityId,userId);
        return Result.ok();
    }

    @ApiOperation(value = "同意社员的活动请求")
    @PostMapping("/agreeUserApplyActivity")
    public Result agreeUserApplyActivity(@RequestParam(required = true)Long activityId,
                                   @RequestParam(required = true)Long userId){
        userActivityService.agreeUserActivity(activityId,userId);
        return Result.ok();
    }


    @ApiOperation(value = "拒绝社员的活动请求//和删除社员与活动的活动记录")
    @PostMapping("/notagreeUserApplyActivity")
    public Result notagreeUserApplyActivity(@RequestParam(required = true)Long activityId,
                                         @RequestParam(required = true)Long userId){
        userActivityService.notagreeUserActivity(activityId,userId);
        return Result.ok();
    }


}
