package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.AssActStatistics;
import cn.edu.shu.xj.ser.entity.AssActivity;
import cn.edu.shu.xj.ser.mapper.AssActivityMapper;
import cn.edu.shu.xj.ser.service.IAssActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("assActivityService")
public class AssActivityService extends ServiceImpl<AssActivityMapper, AssActivity> implements IAssActivityService {

    @Autowired
    AssActivityMapper assActivityMapper;

    @Override
    public void addNewAssActivity(Long assId, Long activityId) {
        assActivityMapper.addNewAssActivity(assId, activityId);
    }

    @Override
    public void deleteAssByAssId(Long assId) {
        assActivityMapper.deleteAssByAssId(assId);
    }

    @Override
    public void passActivity(Long activityId) {
        assActivityMapper.passActivity(activityId);
    }

    @Override
    public void notpassActivity(Long activityId) {
        assActivityMapper.notpassActivity(activityId);
    }

    @Override
    public void deleteAssByActivityId(Long activityId) {
        assActivityMapper.deleteAssByActivityId(activityId);
    }

    @Override
    public List<AssActStatistics> statisticAssAct() {
        return assActivityMapper.statisticAssAct();
    }
}
