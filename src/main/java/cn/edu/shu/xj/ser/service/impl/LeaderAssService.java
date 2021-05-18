package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.LeaderAss;
import cn.edu.shu.xj.ser.mapper.LeaderAssMapper;
import cn.edu.shu.xj.ser.service.ILeaderAssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("leadAssService")
public class LeaderAssService extends ServiceImpl<LeaderAssMapper, LeaderAss> implements ILeaderAssService {

    @Autowired
    LeaderAssMapper leaderAssMapper;
}
