package cn.edu.shu.xj.ser.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 社长（发起人）与活动 一对一
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("leader_activity")
public class LeaderActivity {
    @TableId
    // 发起人和活动关系编号
    private Long leaderActivityId;
    // 发起人编号
    private Long userId;
    // 活动编号
    private Long activityId;

}
