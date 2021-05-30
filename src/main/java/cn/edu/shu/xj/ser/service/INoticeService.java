package cn.edu.shu.xj.ser.service;


import cn.edu.shu.xj.ser.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

public interface INoticeService extends IService<Notice> {

    /**
     * 获取公告
     * @param noticeId
     * @return
     */
    Notice getByNoticeId(Long noticeId);

    /**
     * 修改公告
     * @param notice
     */
    void editNotice(String notice);
}
