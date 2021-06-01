package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IActivityService extends IService<Activity> {

    /**
     * 根据社团id获取活动数量
     * @param assId
     * @return
     */
    Integer countActivityById(Long assId);

    /**
     * 根据社团id获取活动 分页
     * @param Myvalue
     * @param size
     * @param assId
     * @return
     */
    List<Activity> getActivityByAssId(Integer Myvalue, Integer size, Long assId);

    /**
     * 获取我的活动记录的数量
     * @param userId
     * @return
     */
    Integer countActivityByUserId(Long userId);

    /**
     * 获取我的活动记录
     * @param Myvalue
     * @param size
     * @param userId
     * @return
     */
    List<Activity> getActivityByUserId(Integer Myvalue,Integer size,Long userId);

    /**
     * 增加新活动
     * @param activitySub
     * @param activityContent
     * @param activityScore
     * @param activityStartTime
     * @param activityFinishTime
     * @param imageUrl
     * @param userTrueName
     */
    void addNew(String activitySub,String activityContent,String activityScore,String activityStartTime,String activityFinishTime,String imageUrl,String userTrueName);

    /**
     * 获取最近一次添加的活动编号
     * @return
     */
    Long activityMaxId();

    /**
     * 管理员界面获取条件分页查询活动的数量
     * @param assName
     * @param activityState
     * @return
     */
    Integer findApplyActivityCount(String assName,String activityState);

    /**
     * 管理员界面获取条件分页查询活动
     * @param Myvalue
     * @param size
     * @param assName
     * @param activityState
     * @return
     */
    List<Activity> findApplyActivity(Integer Myvalue,Integer size,String assName,String activityState);

    /**
     * 审批通过活动
     * @param activityId
     */
    void passActivity(Long activityId);

    /**
     * 审批拒绝活动
     * @param activityId
     */
    void notpassActivity(Long activityId);

    /**
     * 活动报名截至
     * @param activityId
     */
    void endActivityApply(Long activityId);

    /**
     * 活动结束
     * @param activityId
     */
    void endActivity(Long activityId);

    /**
     * 活动后期结语
     * @param activityId
     * @param activityEndContent
     * @param imageUrl
     */
    void addEndContent(Long activityId,String activityEndContent,String imageUrl);

    /**
     * 获取活动By活动ID
     * @param activityId
     * @return
     */
    Activity getActivityByActivityId(Long activityId);

    /**
     * 删除活动
     * @param activityId
     */
    void deleteActivity(Long activityId);
}
