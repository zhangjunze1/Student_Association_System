package cn.edu.shu.xj.ser.service;


import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserService extends IService<User> {

    /**
     * 根据user_id查找User实体类
     * @param user_id
     * @return
     */
    User findUserById(Long user_id);

    /**
     * 根据用户名查找User
     * @param user_name
     * @return
     */
    User findUserByName(String user_name);

    /**
     * 用户注册
     * @param name
     * @param true_name
     * @param pwd
     * @param authority
     * @param score
     * @param number
     * @param gender
     * @param position
     * @param phone
     * @return
     */
    void userRegister(String name,String true_name,String pwd,Integer authority,Integer score,String number,String gender,String position,String phone);

}
