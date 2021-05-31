package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.UserActivity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserActivityService extends IService<UserActivity> {

    /**
     * 删除用户时删除他的活动记录
     * @param userId
     */
    void deleteAllByUserId(Long userId);

    /**
     * 获取某活动对应参与成员的总数
     * @param activityId
     * @return
     */
    Integer countPartMemberByActivityId(Long activityId);

    /**
     * 是否已经报名活动
     * @param activityId
     * @param userId
     * @return
     */
    UserActivity findUserActivity(Long activityId,Long userId);

    /**
     * 申请已有社团的某个报名中的活动
     * @param activityId
     * @param userId
     */
    void addNewUserActivity(Long activityId,Long userId);

    /**
     * 同意社员的活动请求
     * @param activityId
     * @param userId
     */
    void agreeUserActivity(Long activityId,Long userId);

    /**
     * 拒绝社员的活动请求
     * @param activityId
     * @param userId
     */
    void notagreeUserActivity(Long activityId,Long userId);
}
