package cn.edu.shu.xj.ser.controller.Ass;

import cn.edu.shu.xj.ser.entity.Ass;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.service.impl.ActivityService;
import cn.edu.shu.xj.ser.service.impl.AssService;
import cn.edu.shu.xj.ser.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
