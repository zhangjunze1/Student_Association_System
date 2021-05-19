package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {

    User findUserById(Long user_id);

    User findUserByName(String user_name);

    void userRegister(String name,String true_name,String pwd,Integer authority,Integer score,String number,String gender,String position,String phone);

}
