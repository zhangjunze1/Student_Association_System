package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.MemberAss;
import cn.edu.shu.xj.ser.entity.Notice;
import cn.edu.shu.xj.ser.mapper.MemberAssMapper;
import cn.edu.shu.xj.ser.mapper.NoticeMapper;
import cn.edu.shu.xj.ser.service.IMemberAssService;
import cn.edu.shu.xj.ser.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeService extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Autowired
    NoticeMapper noticeMapperl;

    @Override
    public Notice getByNoticeId(Long noticeId) {
        return noticeMapperl.getByNoticeId(noticeId);
    }

    @Override
    public void editNotice(String notice) {
        noticeMapperl.editNotice(notice);
    }
}
