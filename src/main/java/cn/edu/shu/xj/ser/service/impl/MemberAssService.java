package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.LeaderActivity;
import cn.edu.shu.xj.ser.entity.MemberAss;
import cn.edu.shu.xj.ser.mapper.LeaderActivityMapper;
import cn.edu.shu.xj.ser.mapper.MemberAssMapper;
import cn.edu.shu.xj.ser.service.ILeaderActivityService;
import cn.edu.shu.xj.ser.service.IMemberAssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberAssService")
public class MemberAssService extends ServiceImpl<MemberAssMapper, MemberAss> implements IMemberAssService {
    @Autowired
    MemberAssMapper memberAssMapper;

    @Override
    public void deleteAssByAssId(Long assId) {
        memberAssMapper.deleteAssByAssId(assId);
    }
}
