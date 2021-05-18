package cn.edu.shu.xj.ser.controller.relationship;


import cn.edu.shu.xj.ser.service.impl.LeaderActivityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "社长、社团关系接口")
@RestController
@RequestMapping("/leaderAss")
public class LeaderAssController {

    @Autowired
    LeaderActivityService leaderActivityService;

}
