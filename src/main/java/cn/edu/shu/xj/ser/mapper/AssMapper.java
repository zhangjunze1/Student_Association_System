package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Activity;
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

    Ass getAssByLeaderId(Long userId);

    Integer countQuery(String assName ,String assState);

    List<Ass> getAssListQueryPage(Integer Myvalue,Integer size, String assName ,String assState);

    List<Ass> findActivityAndApplyCount();

    void agreeStateChange(Long assId);

    void notAgreeDeleteAss(Long assId);

    void changeAssLeader(Long assId,String userTrueName);

    void deleteAss(Long assId);

    void editNotice(Long assId,String notice);
}
