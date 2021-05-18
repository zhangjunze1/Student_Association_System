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

}
