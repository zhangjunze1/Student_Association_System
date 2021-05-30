package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.UserActivity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface UserActivityMapper extends BaseMapper<UserActivity> {

    void deleteAllByUserId(Long userId);

}
