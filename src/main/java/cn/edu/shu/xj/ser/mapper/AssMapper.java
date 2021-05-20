package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Ass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AssMapper extends BaseMapper<Ass> {

    List<Ass> getAssList();

    List<Ass> getAssListPage(Integer Myvalue,Integer size);
}
