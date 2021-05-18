package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


/**
 * 活动
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("activity")
public class Activity {
    @TableId
    private Long activity_id;
    // 活动主题
    private String activity_sub;
    // 活动内容
    private String activity_content;
    // 活动图片url
    private String activity_url;
    // 活动开始时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp activity_start_time;
    // 活动结束时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp activity_finish_time;
    // 活动状态(审核中、已通过)
    private String activity_state;
    // 本次活动分值
    private String activity_score;
    // 活动发起人
    private String activity_leader_name;
}
