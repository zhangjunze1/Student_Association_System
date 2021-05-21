package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 成员 社团关系
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("member_ass")
public class MemberAss {
    @TableId
    // 成员和社团关系编号
    private Long memberAssId;
    // 成员编号
    private Long userId;
    // 社团编号
    private Long assId;
    // 该关系状态（申请中，已通过）
    private String memberAssState;
}
