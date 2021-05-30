package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.MemberAss;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IMemberAssService extends IService<MemberAss> {


    /**
     * 删除社员社团关联表信息
     * @param assId
     */
    void deleteAssByAssId(Long assId);
}
