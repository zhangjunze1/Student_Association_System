package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {

    User findUserById(Long userId);

    User findUserByName(String userName);

    User findUserByNumber(String userNumber);

    void userRegister(String userName,String userTrueName,String userPwd,Integer userAuthority,Integer userScore,String userNumber,String userGender,String userPosition,String userPhone);

}
