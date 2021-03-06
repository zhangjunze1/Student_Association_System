package cn.edu.shu.xj.ser.service;


import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IUserService extends IService<User> {

    /**
     * 根据user_id查找User实体类
     * @param userId
     * @return
     */
    User findUserById(Long userId);

    /**
     * 根据用户名查找User
     * @param userName
     * @return
     */
    User findUserByName(String userName);

    /**
     * 根据学号查找User
     * @param userNumber
     * @return
     */
    User findUserByNumber(String userNumber);

    /**
     * 用户注册
     * @param userName
     * @param userTrueName
     * @param userPwd
     * @param userAuthority
     * @param userScore
     * @param userNumber
     * @param userGender
     * @param userPosition
     * @param userPhone
     */
    void userRegister(String userName,String userTrueName,String userPwd,Integer userAuthority,Integer userScore,String userNumber,String userGender,String userPosition,String userPhone);

    /**
     * 查找对应权限的人数
     * @return
     */
    List<User> findAuthorityAndCount();

    /**
     * 查询满足条件的用户数目
     * @param userTrueName
     * @param assName
     * @param position
     * @return
     */
    Integer findUserListTotal(String userTrueName,String assName,String position);

    /**
     * 查询满足条件 无社团的用户数目
     * @param userTrueName
     * @param position
     * @return
     */
    Integer findUserListTotalWithNoAss(String userTrueName,String position);

    /**
     * 条件分页查询 用户的信息
     * @param userTrueName
     * @param assName
     * @param position
     * @param Myvalue
     * @param size
     * @return
     */
    List<User> queryUserList(String userTrueName,String assName,String position, Integer Myvalue,Integer size);

    /**
     * 条件分页查询 无社团的用户数目
     * @param userTrueName
     * @param position
     * @param Myvalue
     * @param size
     * @return
     */
    List<User> queryUserListWithNoAss(String userTrueName,String position, Integer Myvalue,Integer size);

    /**
     * 修改个人信息
     * @param userId
     * @param pwd
     * @param name
     * @param gender
     * @param phone
     * @param signature
     */
    void editUserMessage(Long userId,String pwd,String name ,String gender,String phone,String signature);

    /**
     * 获取社长By社团编号
     * @param assId
     * @return
     */
    User getLeaderByAssId(Long assId);

    /**
     * 获取社团对应所有社员的数量
     * @param assId
     * @param trueName
     * @param number
     * @param memberAssState
     * @return
     */
    Integer getTotalMemberByAssId(Long assId,String trueName,String number,String memberAssState);


    /**
     * 获取社团对应所有社员信息
     * @param Myvalue
     * @param size
     * @param assId
     * @param trueName
     * @param number
     * @param memberAssState
     * @return
     */
    List<User> getAllMemberByAssId(Integer Myvalue,Integer size, Long assId,String trueName,String number,String memberAssState);

    /**
     * 改变用户状态变成社长
     * @param userId
     */
    void agreeAutorityChange(Long userId);

    /**
     * 获取userBy真实名字
     * @param userTrueName
     * @return
     */
    User findUserByTrueName(String userTrueName);

    /**
     * 更改权限
     * @param userId
     * @param userAuthority
     * @param userPosition
     */
    void changeAuthority(Long userId,Integer userAuthority,String userPosition);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Long userId);

    /**
     * 获取活动的用户列表
     * @param activityId
     * @return
     */
    List<User> getUserByActivityId(Long activityId);

    /**
     * 获取某活动对应参与的成员
     * @param Myvalue
     * @param size
     * @param activityId
     * @return
     */
    List<User> getPartMemberByActivityId(Integer Myvalue,Integer size,Long activityId);

    /**
     * 增加分值
     * @param userId
     * @param score
     */
    void addScore(Long userId,Integer score);

    /**
     * 查询分值排行榜
     */
    List<User> getUserRank();
}
