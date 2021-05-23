package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Ass;
import cn.edu.shu.xj.ser.mapper.AssMapper;
import cn.edu.shu.xj.ser.service.IAssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("assService")
public class AssService extends ServiceImpl<AssMapper, Ass> implements IAssService {

    @Autowired
    AssMapper assMapper;

    @Override
    public List<Ass> getAssList() {
        return assMapper.getAssList();
    }

    @Override
    public List<Ass> getAssListPage(Integer Myvalue, Integer size) {
        return assMapper.getAssListPage(Myvalue, size);
    }

    @Override
    public Integer countByMyId(Long userId) {
        return assMapper.countByMyId(userId);
    }

    @Override
    public List<Ass> getMyAssListPage(Integer Myvalue, Integer size, Long userId) {
        return assMapper.getMyAssListPage(Myvalue, size, userId);
    }

    @Override
    public Ass findSameNameAss(String name) {
        return assMapper.findSameNameAss(name);
    }

    @Override
    public Ass findSameLeaderAss(String name) {
        return assMapper.findSameLeaderAss(name);
    }

    @Override
    public void applynewAss(String name, String position, Integer funds, String teacher,String leaderName) {
        assMapper.applynewAss(name, position, funds, teacher,leaderName);
    }

    @Override
    public Ass getAssByLeaderId(Long userId) {
        return assMapper.getAssByLeaderId(userId);
    }

    @Override
    public Integer countQuery(String assName, String assState) {
        return assMapper.countQuery(assName, assState);
    }

    @Override
    public List<Ass> getAssListQueryPage(Integer Myvalue, Integer size, String assName, String assState) {
        return assMapper.getAssListQueryPage(Myvalue, size, assName, assState);
    }
}
