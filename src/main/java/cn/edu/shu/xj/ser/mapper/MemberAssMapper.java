package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.MemberAss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface MemberAssMapper extends BaseMapper<MemberAss> {

    void deleteAssByAssId(Long assId);

    void deleteAllByUserId(Long userId);
}
