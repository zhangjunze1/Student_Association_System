package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface NoticeMapper  extends BaseMapper<Notice> {
    Notice getByNoticeId(Long noticeId);

    void editNotice(String notice);
}
