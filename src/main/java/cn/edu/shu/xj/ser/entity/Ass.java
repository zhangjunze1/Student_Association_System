package cn.edu.shu.xj.ser.entity;

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
    private Long ass_id;
    // 社团名字
    private String ass_name;
    // 社团所在教室
    private String ass_positon;
    // 社团经费
    private String ass_capital;
    // 社团指导老师
    private String ass_teacher;
}
