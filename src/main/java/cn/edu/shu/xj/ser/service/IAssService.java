package cn.edu.shu.xj.ser.service;


import cn.edu.shu.xj.ser.entity.Activity;
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

    /**
     * 获取社长的社团信息
     * @param userId
     * @return
     */
    Ass getAssByLeaderId(Long userId);

    /**
     * 分页条件查询 社团的总数
     * @param assName
     * @param assState
     * @return
     */
    Integer countQuery(String assName ,String assState);

    /**
     * 分页条件查询社团
     * @param Myvalue
     * @param size
     * @param assName
     * @param assState
     * @return
     */
    List<Ass> getAssListQueryPage(Integer Myvalue,Integer size, String assName ,String assState);

    /**
     * 获取正在审核中的活动及其数量
     * @return
     */
    List<Ass> findActivityAndApplyCount();

    /**
     * 通过申请中的社团 改变状态
     * @param assId
     */
    void agreeStateChange(Long assId);

    /**
     * 不通过申请中的社团
     * @param assId
     */
    void notAgreeDeleteAss(Long assId);

    /**
     * 更换社团中 社长姓名
     * @param assId
     * @param userTrueName
     */
    void changeAssLeader(Long assId,String userTrueName);

    /**
     * 删除社团
     * @param assId
     */
    void deleteAss(Long assId);
}
