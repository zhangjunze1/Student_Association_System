package cn.edu.shu.xj.ser.controller.relationship;

import cn.edu.shu.xj.ser.entity.AssActStatistics;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.service.impl.AssActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "社团活动关系接口")
@RestController
@RequestMapping("/assActivity")
public class AssActivityController {

    @Autowired
    AssActivityService assActivityService;


    @ApiOperation(value = "获取各个社团各个状态的活动的统计")
    @GetMapping("/assActStatistics")
    public Result findApplyActivity(){
        List<AssActStatistics> res = assActivityService.statisticAssAct();
        return Result.ok().data("assact",res);
    }
}
