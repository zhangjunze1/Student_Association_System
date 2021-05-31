package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.MemberAss;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IMemberAssService extends IService<MemberAss> {


    /**
     * 删除社员社团关联表信息
     * @param assId
     */
    void deleteAssByAssId(Long assId);

    /**
     * 删除社员社团关联信息
     * @param userId
     */
    void deleteAllByUserId(Long userId);

    /**
     * 获取社员社团联结表信息
     * @param assId
     * @param userId
     * @return
     */
    MemberAss getMemberAss(Long assId,Long userId);

    /**
     * 增加一条社员社团联结表信息
     * @param assId
     * @param userId
     */
    void addMemberAss(Long assId,Long userId);

    /**
     * 社长通过他人申请本社团
     * @param assId
     * @param userId
     */
    void editMemberAss(Long assId,Long userId);

    /**
     * 社长拒绝他人申请本社团
     * @param assId
     * @param userId
     */
    void editNotAgreeMemberAss(Long assId,Long userId);

    /**
     * 社长删除社员
     * @param assId
     * @param userId
     */
    void deleteMemberFromAss(Long assId,Long userId);
}
