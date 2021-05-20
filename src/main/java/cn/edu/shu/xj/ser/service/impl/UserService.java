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

import java.util.List;

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

    @Override
    public List<User> findAuthorityAndCount() {
        return userMapper.findAuthorityAndCount();
    }

    @Override
    public Integer findUserListTotal(String userTrueName, String assName, String position) {
        return userMapper.findUserListTotal(userTrueName, assName, position);
    }

    @Override
    public Integer findUserListTotalWithNoAss(String userTrueName, String position) {
        return userMapper.findUserListTotalWithNoAss(userTrueName, position);
    }

    @Override
    public List<User> queryUserList(String userTrueName, String assName, String position, Integer Myvalue, Integer size) {
        return userMapper.queryUserList(userTrueName, assName, position, Myvalue, size);
    }

    @Override
    public List<User> queryUserListWithNoAss(String userTrueName, String position, Integer Myvalue, Integer size) {
        return userMapper.queryUserListWithNoAss(userTrueName, position, Myvalue, size);
    }

    @Override
    public void editUserMessage(Long userId, String pwd,String name, String gender, String phone, String signature) {
        userMapper.editUserMessage(userId,pwd, name, gender, phone, signature);
    }
}
