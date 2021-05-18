package cn.edu.shu.xj.ser.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 社长 社团关系
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("leader_ass")
public class LeaderAss {
    @TableId
    // 关系编号
    private Long leader_ass_id;
    // 社团编号
    private Long ass_id;
    // 社长编号
    private Long user_id;
}
