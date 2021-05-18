package cn.edu.shu.xj.ser.controller.Ass;

import cn.edu.shu.xj.ser.service.impl.AssService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "社团接口")
@RestController
@RequestMapping("/ass")
public class AssController {

    @Autowired
    AssService assService;


}
