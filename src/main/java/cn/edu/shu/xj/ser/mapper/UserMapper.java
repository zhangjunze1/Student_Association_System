package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends BaseMapper<User> {

    User findUserById(Long userId);

    User findUserByName(String userName);

    User findUserByNumber(String userNumber);

    void userRegister(String userName,String userTrueName,String userPwd,Integer userAuthority,Integer userScore,String userNumber,String userGender,String userPosition,String userPhone);

    List<User> findAuthorityAndCount();

    Integer findUserListTotal(String userTrueName,String assName,String position);

    Integer findUserListTotalWithNoAss(String userTrueName,String position);

    List<User> queryUserList(String userTrueName,String assName,String position, Integer Myvalue,Integer size);

    List<User> queryUserListWithNoAss(String userTrueName,String position, Integer Myvalue,Integer size);


}
