package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Activity;
import cn.edu.shu.xj.ser.entity.LeaderActivity;
import cn.edu.shu.xj.ser.mapper.ActivityMapper;
import cn.edu.shu.xj.ser.mapper.LeaderActivityMapper;
import cn.edu.shu.xj.ser.service.IActivityService;
import cn.edu.shu.xj.ser.service.ILeaderActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("leaderActivityService")
public class LeaderActivityService extends ServiceImpl<LeaderActivityMapper, LeaderActivity> implements ILeaderActivityService {

    @Autowired
    LeaderActivityMapper leaderActivityMapper;

    @Override
    public void addNewLeaderActivity(Long userId, Long activityId) {
        leaderActivityMapper.addNewLeaderActivity(userId, activityId);
    }
}
