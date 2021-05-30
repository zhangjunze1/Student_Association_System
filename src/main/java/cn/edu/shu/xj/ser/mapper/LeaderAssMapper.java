package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.LeaderAss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface LeaderAssMapper extends BaseMapper<LeaderAss> {

    void addLeaderAss(Long assId,Long userId);

    LeaderAss getLeaderAss(Long assId);

    void changeUserId(Long olduserId,Long newuserId);

    void deleteAssByAssId(Long assId);
}
