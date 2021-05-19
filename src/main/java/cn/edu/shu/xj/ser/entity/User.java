package cn.edu.shu.xj.ser.entity;


import com.baomidou.mybatisplus.annotation.TableField;
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
    private Long userId;
    // 用户网名
    private String userName;
    // 用户真实姓名
    private String userTrueName;
    // 用户密码
    private String userPwd;
    // 用户权限 2成员 1社长 0管理员
    private Integer userAuthority;
    // 用户积分值
    private Integer userScore;
    // 用户学号
    private String userNumber;
    // 用户性别 (男/女)
    private String userGender;
    // 用户职位(社长、副社长、成员)
    private String userPosition;
    // token
    private String userToken;
    // 用户头像
    private String userPic;
    // 用户电话
    private String userPhone;

    @TableField(exist = false)
    private Integer userCount;
}
