package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.UserActivity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserActivityService extends IService<UserActivity> {

    /**
     * 删除用户时删除他的活动记录
     * @param userId
     */
    void deleteAllByUserId(Long userId);
}
