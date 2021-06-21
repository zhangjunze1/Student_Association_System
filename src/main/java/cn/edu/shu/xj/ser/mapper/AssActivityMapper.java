package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.AssActStatistics;
import cn.edu.shu.xj.ser.entity.AssActivity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AssActivityMapper extends BaseMapper<AssActivity> {

    void addNewAssActivity(Long assId,Long activityId);

    void deleteAssByAssId(Long assId);

    void passActivity(Long activityId);

    void notpassActivity(Long activityId);

    void deleteAssByActivityId(Long activityId);

    List<AssActStatistics> statisticAssAct();

}
