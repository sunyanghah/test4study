package test.study.statemachine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import test.study.statemachine.entity.Order;

/**
 * @author sunYang
 * @date 2023/5/24 10:16
 */
public interface OrderService extends IService<Order> {
    Order create(Order order);

    Order pay(Long id);

    Order deliver(Long id);

    Order receive(Long id);
}
