package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.LeaderActivity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface LeaderActivityMapper extends BaseMapper<LeaderActivity> {

    void addNewLeaderActivity(Long userId,Long activityId);

}
