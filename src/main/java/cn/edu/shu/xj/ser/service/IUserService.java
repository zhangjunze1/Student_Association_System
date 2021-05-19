package cn.edu.shu.xj.ser.service;


import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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

}
