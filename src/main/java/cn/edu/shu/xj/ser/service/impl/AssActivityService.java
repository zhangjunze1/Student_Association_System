package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Activity;
import cn.edu.shu.xj.ser.entity.AssActivity;
import cn.edu.shu.xj.ser.mapper.ActivityMapper;
import cn.edu.shu.xj.ser.mapper.AssActivityMapper;
import cn.edu.shu.xj.ser.service.IActivityService;
import cn.edu.shu.xj.ser.service.IAssActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
