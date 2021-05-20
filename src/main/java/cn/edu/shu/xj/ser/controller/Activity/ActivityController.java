package cn.edu.shu.xj.ser.controller.Activity;

import cn.edu.shu.xj.ser.entity.Activity;
import cn.edu.shu.xj.ser.entity.Ass;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.mapper.ActivityMapper;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "活动接口")
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

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

}
