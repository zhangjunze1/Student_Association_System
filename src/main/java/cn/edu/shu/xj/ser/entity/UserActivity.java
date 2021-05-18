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
    private Long user_activity_id;
    // 活动编号
    private Long activity_id;
    // 用户编号
    private Long user_id;
}
