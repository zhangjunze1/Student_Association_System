package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Ass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AssMapper extends BaseMapper<Ass> {

    List<Ass> getAssList();

    List<Ass> getAssListPage(Integer Myvalue,Integer size);

    Integer countByMyId(Long userId);

    List<Ass> getMyAssListPage(Integer Myvalue,Integer size,Long userId);

    Ass findSameNameAss(String name);

    Ass findSameLeaderAss(String name);

    void applynewAss(String name,String position,Integer funds,String teacher,String leaderName);
}
