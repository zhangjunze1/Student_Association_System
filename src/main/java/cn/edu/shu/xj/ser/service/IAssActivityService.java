package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.AssActivity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IAssActivityService extends IService<AssActivity> {

    /**
     * 增加活动与社团关系
     * @param assId
     * @param activityId
     */
    void addNewAssActivity(Long assId,Long activityId);

    /**
     * 删除社团时清除联结活动信息
     * @param assId
     */
    void deleteAssByAssId(Long assId);

    /**
     * 审批通过 社团活动联结表信息更改
     * @param activityId
     */
    void passActivity(Long activityId);

    /**
     * 审批不通过 社团活动联结表信息删除
     * @param activityId
     */
    void notpassActivity(Long activityId);

    /**
     * 活动社团联结表的删除
     * @param activityId
     */
    void deleteAssByActivityId(Long activityId);
}
