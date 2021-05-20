package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActivityMapper extends BaseMapper<Activity> {

    Integer countActivityById(Long assId);

    List<Activity> getActivityByAssId(Integer Myvalue,Integer size,Long assId);

}
