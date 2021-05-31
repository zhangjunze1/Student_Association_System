package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Activity;
import cn.edu.shu.xj.ser.mapper.ActivityMapper;
import cn.edu.shu.xj.ser.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("activityService")
public class ActivityService extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {
    @Autowired
    ActivityMapper activityMapper;

    @Override
    public Integer countActivityById(Long assId) {
        return activityMapper.countActivityById(assId);
    }

    @Override
    public List<Activity> getActivityByAssId(Integer Myvalue, Integer size, Long assId) {
        return activityMapper.getActivityByAssId(Myvalue, size, assId);
    }

    @Override
    public Integer countActivityByUserId(Long userId) {
        return activityMapper.countActivityByUserId(userId);
    }

    @Override
    public List<Activity> getActivityByUserId(Integer Myvalue, Integer size, Long userId) {
        return activityMapper.getActivityByUserId(Myvalue, size, userId);
    }

    @Override
    public void addNew(String activitySub, String activityContent, String activityScore, String activityStartTime, String activityFinishTime, String imageUrl, String userTrueName) {
        activityMapper.addNew(activitySub, activityContent, activityScore, activityStartTime, activityFinishTime, imageUrl, userTrueName);
    }

    @Override
    public Long activityMaxId() {
        return activityMapper.activityMaxId();
    }

    @Override
    public Integer findApplyActivityCount(String assName, String activityState) {
        return activityMapper.findApplyActivityCount(assName, activityState);
    }

    @Override
    public List<Activity> findApplyActivity(Integer Myvalue, Integer size, String assName, String activityState) {
        return activityMapper.findApplyActivity(Myvalue, size, assName, activityState);
    }

    @Override
    public void passActivity(Long activityId) {
        activityMapper.passActivity(activityId);
    }

    @Override
    public void notpassActivity(Long activityId) {
        activityMapper.notpassActivity(activityId);
    }

    @Override
    public void endActivityApply(Long activityId) {
        activityMapper.endActivityApply(activityId);
    }

    @Override
    public void endActivity(Long activityId) {
        activityMapper.endActivity(activityId);
    }

    @Override
    public void addEndContent(Long activityId, String activityEndContent, String imageUrl) {
         activityMapper.addEndContent(activityId, activityEndContent, imageUrl);
    }

    @Override
    public Activity getActivityByActivityId(Long activityId) {
        return activityMapper.getActivityByActivityId(activityId);
    }


}
