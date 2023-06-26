package test.study.statemachine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import test.study.statemachine.entity.Order;

/**
 * @author sunYang
 * @date 2023/5/24 10:23
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
