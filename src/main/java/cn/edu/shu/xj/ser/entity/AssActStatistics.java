package cn.edu.shu.xj.ser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssActStatistics {
    private String assName;
    private String state;
    private int cnt;
}
