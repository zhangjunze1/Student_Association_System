package cn.edu.shu.xj.ser.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统公告
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("notice")
public class Notice {
    @TableId
    // 公告编号
    private Long noticeId;
    // 公告内容
    private String noticeContent;
    // 公告图片
    private String noticePic;

}
