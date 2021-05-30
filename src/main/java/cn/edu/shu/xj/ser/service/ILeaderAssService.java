package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.LeaderAss;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ILeaderAssService extends IService<LeaderAss> {

    /**
     * 增加社长社团记录
     * @param assId
     * @param userId
     */
    void addLeaderAss(Long assId,Long userId);

    /**
     * 获取社长社团信息记录
     * @param assId
     * @return
     */
    LeaderAss getLeaderAss(Long assId);

    /**
     * 更改联结表信息
     * @param olduserId
     * @param newuserId
     */
    void changeUserId(Long olduserId,Long newuserId);

    /**
     * 删除社长社团联结表信息
     * @param assId
     */
    void deleteAssByAssId(Long assId);
}
