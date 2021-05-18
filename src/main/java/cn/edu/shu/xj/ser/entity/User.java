package cn.edu.shu.xj.ser.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId
    // 用户编号
    private Long user_id;
    // 用户网名
    private String user_name;
    // 用户真实姓名
    private String user_true_name;
    // 用户密码
    private String user_pwd;
    // 用户权限 2成员 1社长 0管理员
    private Integer user_authority;
    // 用户积分值
    private Integer user_score;
    // 用户学号
    private String user_number;
    // 用户性别 (男/女)
    private String user_gender;
    // 用户职位(社长、副社长、成员)
    private String user_position;
    // token
    private String user_token;
    // 用户头像
    private String user_pic;
}
