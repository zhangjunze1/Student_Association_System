package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 社团
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("ass")
public class Ass {

    @TableId
    private Long assId;
    // 社团名字
    private String assName;
    // 社团所在教室
    private String assPositon;
    // 社团经费
    private String assCapital;
    // 社团指导老师
    private String assTeacher;
    // 社团公告
    private String assNotice;
    // 社团状态 （申请中，已通过）
    private String assState;
    // 社团社长
    private String assLeader;

    // 社团成员与社团的关系（申请中，已通过）
    @TableField(exist = false)
    private String memberAssState;
    // 社团社长编号
    @TableField(exist = false)
    private String userTrueName;
}
