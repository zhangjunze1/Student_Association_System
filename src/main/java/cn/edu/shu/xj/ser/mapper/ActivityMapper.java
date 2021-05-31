package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActivityMapper extends BaseMapper<Activity> {

    Integer countActivityById(Long assId);

    List<Activity> getActivityByAssId(Integer Myvalue,Integer size,Long assId);

    Integer countActivityByUserId(Long userId);

    List<Activity> getActivityByUserId(Integer Myvalue,Integer size,Long userId);

    void addNew(String activitySub,String activityContent,String activityScore,String activityStartTime,String activityFinishTime,String imageUrl,String userTrueName);

    Long activityMaxId();

    Integer findApplyActivityCount(String assName,String activityState);

    List<Activity> findApplyActivity(Integer Myvalue,Integer size,String assName,String activityState);

    void passActivity(Long activityId);

    void notpassActivity(Long activityId);

    void endActivityApply(Long activityId);

    void endActivity(Long activityId);

    Activity getActivityByActivityId(Long activityId);

    void addEndContent(Long activityId,String activityEndContent,String imageUrl);


}
