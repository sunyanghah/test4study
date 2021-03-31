package test.study.spring1.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2020/5/16.
 * @author dell
 */
@Aspect
@Component
@Slf4j
public class TestServiceExtendAop {

    @Pointcut("execution(* test.study.spring1.service.*Service.*(..))")
    private void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){

        long start = System.currentTimeMillis();
        Object rt = null;
        try {
            rt = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间："+(end - start));
        return rt;
    }

}
