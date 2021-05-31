package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.MemberAss;
import cn.edu.shu.xj.ser.entity.UserActivity;
import cn.edu.shu.xj.ser.mapper.MemberAssMapper;
import cn.edu.shu.xj.ser.mapper.UserActivityMapper;
import cn.edu.shu.xj.ser.service.IMemberAssService;
import cn.edu.shu.xj.ser.service.IUserActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userActivityService")
public class UserActivityService extends ServiceImpl<UserActivityMapper, UserActivity> implements IUserActivityService {

    @Autowired
    UserActivityMapper userActivityMapper;


    @Override
    public void deleteAllByUserId(Long userId) {
        userActivityMapper.deleteAllByUserId(userId);
    }

    @Override
    public Integer countPartMemberByActivityId(Long activityId) {
        return userActivityMapper.countPartMemberByActivityId(activityId);
    }

    @Override
    public UserActivity findUserActivity(Long activityId, Long userId) {
        return userActivityMapper.findUserActivity(activityId, userId);
    }

    @Override
    public void addNewUserActivity(Long activityId, Long userId) {
        userActivityMapper.addNewUserActivity(activityId, userId);
    }

    @Override
    public void agreeUserActivity(Long activityId, Long userId) {
        userActivityMapper.agreeUserActivity(activityId, userId);
    }

    @Override
    public void notagreeUserActivity(Long activityId, Long userId) {
        userActivityMapper.notagreeUserActivity(activityId, userId);
    }
}
