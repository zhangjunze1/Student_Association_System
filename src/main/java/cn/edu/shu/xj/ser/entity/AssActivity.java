package cn.edu.shu.xj.ser.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 社团和活动的关系图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("ass_activity")
public class AssActivity {
    @TableId
    // 社团和活动关系编号
    private Long ass_activity_id;
    // 活动编号
    private Long activity_id;
    // 社团编号
    private Long ass_id;
}
