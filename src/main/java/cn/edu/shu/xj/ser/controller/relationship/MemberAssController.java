package cn.edu.shu.xj.ser.controller.relationship;


import cn.edu.shu.xj.ser.entity.MemberAss;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.handler.BusinessException;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.response.ResultCode;
import cn.edu.shu.xj.ser.service.impl.MemberAssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户、社团关系接口")
@RestController
@RequestMapping("/memberAss")
public class MemberAssController {

    @Autowired
    MemberAssService memberAssService;

    @ApiOperation(value = "申请社团报名")
    @PostMapping("/addApplyForAss")
    public Result addApplyForAss(@RequestParam(required = true)Long assId,
                                 @RequestParam(required = true)Long userId){

        MemberAss memberAss = memberAssService.getMemberAss(assId,userId);
        if (memberAss!=null){
            if (memberAss.getMemberAssState().equals("申请中")){
                throw new BusinessException(ResultCode.USER_ALREADY_APPLY.getCode(), // 3026
                        ResultCode.USER_ALREADY_APPLY.getMessage());
            } else{
                throw new BusinessException(ResultCode.USER_ALREADY_IN_ASS.getCode(), // 3027
                        ResultCode.USER_ALREADY_IN_ASS.getMessage());
            }
        }
        memberAssService.addMemberAss(assId,userId);
        return Result.ok();
    }

    @ApiOperation(value = "社长同意他人加入社团")
    @PostMapping("/agreeApplyForMyAss")
    public Result agreeApplyForMyAss(@RequestParam(required = true)Long assId,
                                 @RequestParam(required = true)Long userId){
        memberAssService.editMemberAss(assId,userId);
        return Result.ok();
    }

    @ApiOperation(value = "社长拒绝他人加入社团")
    @PostMapping("/notagreeApplyForMyAss")
    public Result notagreeApplyForMyAss(@RequestParam(required = true)Long assId,
                                     @RequestParam(required = true)Long userId){
        memberAssService.editNotAgreeMemberAss(assId,userId);
        return Result.ok();
    }

    @ApiOperation(value = "社长删除社员")
    @PostMapping("/deleteMemberFromAss")
    public Result deleteMemberFromAss(@RequestParam(required = true)Long assId,
                                        @RequestParam(required = true)Long userId){
        memberAssService.deleteMemberFromAss(assId,userId);
        return Result.ok();
    }


}
