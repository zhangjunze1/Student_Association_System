package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.MemberAss;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.mapper.MemberAssMapper;
import cn.edu.shu.xj.ser.mapper.UserMapper;
import cn.edu.shu.xj.ser.service.IMemberAssService;
import cn.edu.shu.xj.ser.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User findUserById(Long userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public User findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    @Override
    public User findUserByNumber(String userNumber) {
        return userMapper.findUserByNumber(userNumber);
    }

    @Override
    public void userRegister(String userName, String userTrueName, String userPwd, Integer userAuthority, Integer userScore, String userNumber, String userGender, String userPosition, String userPhone) {
        userMapper.userRegister(userName, userTrueName, userPwd, userAuthority, userScore, userNumber, userGender, userPosition, userPhone);
    }
}
