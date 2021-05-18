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
    private Long member_ass_id;
    // 成员编号
    private Long user_id;
    // 社团编号
    private Long ass_id;

}
