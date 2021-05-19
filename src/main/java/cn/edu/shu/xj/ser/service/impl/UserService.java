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
    public User findUserById(Long user_id) {
        return userMapper.findUserById(user_id);
    }

    @Override
    public User findUserByName(String user_name) {
        return userMapper.findUserByName(user_name);
    }

    @Override
    public void userRegister(String name, String true_name, String pwd, Integer authority, Integer score, String number, String gender, String position, String phone) {
        userMapper.userRegister(name, true_name, pwd, authority, score, number, gender, position, phone);
    }
}
