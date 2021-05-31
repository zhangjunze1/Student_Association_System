package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.UserActivity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface UserActivityMapper extends BaseMapper<UserActivity> {

    void deleteAllByUserId(Long userId);

    Integer countPartMemberByActivityId(Long activityId);

    UserActivity findUserActivity(Long activityId,Long userId);

    void addNewUserActivity(Long activityId,Long userId);

    void agreeUserActivity(Long activityId,Long userId);

    void notagreeUserActivity(Long activityId,Long userId);
}
