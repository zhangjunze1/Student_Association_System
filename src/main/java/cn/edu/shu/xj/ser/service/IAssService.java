package cn.edu.shu.xj.ser.service;


import cn.edu.shu.xj.ser.entity.Ass;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IAssService  extends IService<Ass> {

    /**
     * 获取所有社团列表
     * @return
     */
    List<Ass> getAssList();

}
