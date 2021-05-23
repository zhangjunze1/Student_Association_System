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
}
