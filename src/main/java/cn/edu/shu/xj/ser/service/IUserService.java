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
}
