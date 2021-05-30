package cn.edu.shu.xj.ser.controller.notice;


import cn.edu.shu.xj.ser.entity.Ass;
import cn.edu.shu.xj.ser.entity.Notice;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.response.Result;
import cn.edu.shu.xj.ser.service.impl.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "系统公告")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @ApiOperation(value = "查询系统公告")
    @GetMapping("/findSystemNotice")
    public Result findSystemNotice(){
        Long noticeId = Long.valueOf(1);
        Notice notice = noticeService.getByNoticeId(noticeId);
        String systemNotice = notice.getNoticeContent();
        return Result.ok().data("notice",systemNotice);
    }

    @ApiOperation(value = "修改系统公告")
    @PostMapping("/editSystemNotice")
    public Result editSystemNotice(@RequestParam(required = true)String notice){
        noticeService.editNotice(notice);
        Long noticeId = Long.valueOf(1);
        Notice notice1 = noticeService.getByNoticeId(noticeId);
        String systemNotice = notice1.getNoticeContent();
        return Result.ok().data("notice",systemNotice);
    }



}
