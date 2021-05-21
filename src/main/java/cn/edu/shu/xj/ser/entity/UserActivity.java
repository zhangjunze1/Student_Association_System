package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户与活动关系表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_activity")
public class UserActivity {
    @TableId
    // 用户和活动关系编号
    private Long userActivityId;
    // 活动编号
    private Long activityId;
    // 用户编号
    private Long userId;
    // 该关系状态（申请中，已通过）
    private String userActivityState;
}
