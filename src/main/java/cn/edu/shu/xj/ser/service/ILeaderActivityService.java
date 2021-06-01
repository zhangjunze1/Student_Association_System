package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.LeaderActivity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ILeaderActivityService extends IService<LeaderActivity> {

    /**
     * 新增社长活动联结表记录
     * @param userId
     * @param activityId
     */
    void addNewLeaderActivity(Long userId,Long activityId);

    /**
     * 获取社长活动记录
     * @param activityId
     * @return
     */
    LeaderActivity getleaderActivityByActivityId(Long activityId);

    /**
     * 删除社长活动联结表
     * @param activityId
     */
    void deleteleaderActivity(Long activityId);
}
