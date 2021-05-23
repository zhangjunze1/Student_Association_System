package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.AssActivity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface AssActivityMapper extends BaseMapper<AssActivity> {

    void addNewAssActivity(Long assId,Long activityId);
}
