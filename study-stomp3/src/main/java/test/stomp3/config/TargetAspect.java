package test.stomp3.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Component
@Slf4j
public class TargetAspect {

    @Before("@annotation(check)")
    public void changeDataSource(JoinPoint point, Check check) throws Throwable {
        System.out.println(point);
    }


}
