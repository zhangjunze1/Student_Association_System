package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Ass;
import cn.edu.shu.xj.ser.mapper.AssMapper;
import cn.edu.shu.xj.ser.service.IAssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("assService")
public class AssService extends ServiceImpl<AssMapper, Ass> implements IAssService {

    @Autowired
    AssMapper assMapper;

}
