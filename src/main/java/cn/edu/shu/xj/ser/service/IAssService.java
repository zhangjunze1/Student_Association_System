package cn.edu.shu.xj.ser.service;


import cn.edu.shu.xj.ser.entity.Ass;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IAssService  extends IService<Ass> {

    /**
     * 获取所有社团列表
     * @return
     */
    List<Ass> getAssList();

    /**
     * 获取社团列表分页
     * @param Myvalue
     * @param size
     * @return
     */
    List<Ass> getAssListPage(Integer Myvalue,Integer size);

    /**
     * 获取我的社团分页查询 总数
     * @param userId
     * @return
     */
    Integer countByMyId(Long userId);

    /**
     * 获取我的社团分页查询
     * @param Myvalue
     * @param size
     * @param userId
     * @return
     */
    List<Ass> getMyAssListPage(Integer Myvalue,Integer size,Long userId);

    /**
     * 有无社团名字重复
     * @param name
     * @return
     */
    Ass findSameNameAss(String name);

    /**
     * 查找是否连续两次申请社团
     * @param name
     * @return
     */
    Ass findSameLeaderAss(String name);

    /**
     * 申请新的社团
     * @param name
     * @param position
     * @param funds
     * @param teacher
     * @param leaderName
     */
    void applynewAss(String name,String position,Integer funds,String teacher,String leaderName);
}
