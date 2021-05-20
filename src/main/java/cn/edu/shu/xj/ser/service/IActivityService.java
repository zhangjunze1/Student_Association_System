package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IActivityService extends IService<Activity> {

    /**
     * 根据社团id获取活动数量
     * @param assId
     * @return
     */
    Integer countActivityById(Long assId);

    /**
     * 根据社团id获取活动 分页
     * @param Myvalue
     * @param size
     * @param assId
     * @return
     */
    List<Activity> getActivityByAssId(Integer Myvalue, Integer size, Long assId);

}
