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
    private Long activityId;
    // 活动主题
    private String activitySub;
    // 活动内容
    private String activityContent;
    // 活动图片url
    private String activityUrl;
    // 活动开始时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp activityStartTime;
    // 活动结束时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp activityFinishTime;
    // 活动状态(审核中、报名中、活动结束)
    private String activityState;
    // 本次活动分值
    private String activityScore;
    // 活动发起人
    private String activityLeaderName;
    // 活动结束内容
    private String activityEndContent;
    // 活动结束图片url
    private String activityEndUrl;
}
